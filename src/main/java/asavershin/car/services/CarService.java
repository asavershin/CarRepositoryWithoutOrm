package asavershin.car.services;

import asavershin.car.dto.Page;
import asavershin.car.entities.AutoserviceEntity;
import asavershin.car.entities.CarEntity;
import asavershin.car.entities.PersonEntity;
import asavershin.car.handlers.localexceptions.DuplicateEvpException;
import asavershin.car.handlers.localexceptions.EntityNotFoundException;
import asavershin.car.repositories.AutoserviceRepository;
import asavershin.car.repositories.CarRepository;
import asavershin.car.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.jooq.Condition;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final PersonRepository personRepository;
    private final AutoserviceRepository autoserviceRepository;

    @Transactional
    public CarEntity createCar(CarEntity car){
        if (carRepository.existsByEvp(car.getCarEvp())) {
            throw new DuplicateEvpException("Такой EVP "+ car.getCarEvp() + " уже есть");
        }
        return carRepository.insert(car);
    }

    @Transactional
    public CarEntity updateCar(Long id, String color, Long personId, Long autoserviceId) throws EntityNotFoundException {
        autoserviceRepository.findById(autoserviceId)
                .orElseThrow(() -> new EntityNotFoundException("Autoservice not found: "+ autoserviceId));

        personRepository.findById(personId)
                .orElseThrow(() -> new EntityNotFoundException("Person not found: "+ personId));


        return carRepository.update(
                CarEntity.builder()
                        .carId(id)
                        .carColor(color)
                        .carPerson(PersonEntity.builder().personId(personId).build())
                        .carAutoservice(AutoserviceEntity.builder().autoserviceId(autoserviceId).build())
                        .build()
        );
    }

    @Transactional
    public void deleteCar(Long id) throws EntityNotFoundException {
        if(!carRepository.delete(id)){
            throw new EntityNotFoundException("Car not found: "+ id);
        }
    }

    public CarEntity getCarById(Long id) throws EntityNotFoundException {
        return carRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Car not found: " + id));
    }

    public Page<CarEntity> filterCarsByAgeCountryAndColor(int pageNumber, int pageSize, Condition condition) throws SQLException {
        return carRepository.findAllByAgeColorCountry(condition, pageNumber, pageSize);
    }

    public List<CarEntity> findCarsByPersonId(Long personId) throws EntityNotFoundException {
        if(!personRepository.existsById(personId)){
            throw new EntityNotFoundException("person not found:  " + personId);
        }
        return carRepository.findCarByPersonId(personId);
    }

    public CarEntity findCarByEvp(Long evp) throws EntityNotFoundException {
        return carRepository.findCarByEvp(evp).orElseThrow(() -> new EntityNotFoundException("Car not found: " + evp));
    }
}
