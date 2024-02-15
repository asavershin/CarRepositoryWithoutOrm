package asavershin.car.services;

//import asavershin.car.repositories.PersonRepository;
import asavershin.car.dto.person.PersonFilter;
import asavershin.car.entities.PersonEntity;
import asavershin.car.handlers.localexceptions.EntityNotFoundException;
import asavershin.car.repositories.CarRepository;
import asavershin.car.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
    private final CarRepository carRepository;

    public PersonEntity createPerson(PersonEntity person){
        return personRepository.insert(person);
    }

    @Transactional
    public PersonEntity updatePerson(PersonEntity person) throws EntityNotFoundException {
        return personRepository.insert(personRepository.update(person));
    }

    @Transactional
    public void deleteById(Long personId) throws EntityNotFoundException {
        var deletePersonFlag = personRepository.delete(personId);
        if(!deletePersonFlag){
            throw new EntityNotFoundException("Человека с id " + personId + " не найдено");
        }
    }

    public PersonEntity findById(Long id) throws EntityNotFoundException {
        return personRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Человека с id " + id + " не найдено"));
    }

    public List<PersonEntity> findPeopleWithCarsFromCountryAndAmount(PersonFilter filter) {
        return personRepository.findPeopleWithCarsFromCountryAndAmount(filter);
    }

    @Transactional
    public PersonEntity createPersonWithCars(PersonEntity person){
        var newPerson = personRepository.insert(person);
        person.getPersonCars().forEach(c -> c.setCarPerson(newPerson));
        newPerson.setPersonCars(carRepository.insertAll(person.getPersonCars()));
        return newPerson;
    }
}
