package asavershin.car.services;

import asavershin.car.entities.AutoserviceEntity;
import asavershin.car.entities.CarEntity;
import asavershin.car.entities.PersonEntity;
import asavershin.car.handlers.localexceptions.DuplicateEvpException;
import asavershin.car.handlers.localexceptions.EntityNotFoundException;
import asavershin.car.repositories.AutoserviceRepository;
import asavershin.car.repositories.CarRepository;
import asavershin.car.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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
    public CarEntity updateCar(long id, String color, Long personId, Long autoserviceId) throws EntityNotFoundException {
        autoserviceRepository.findById(autoserviceId)
                .orElseThrow(() -> new EntityNotFoundException("Autoservice not found: "+ autoserviceId));

        personRepository.findById(personId)
                .orElseThrow(() -> new EntityNotFoundException("Person not found: "+ personId));


        return carRepository.update(
                CarEntity.builder()
                        .carColor(color)
                        .carPerson(PersonEntity.builder().personId(personId).build())
                        .carAutoservice(AutoserviceEntity.builder().autoserviceId(autoserviceId).build())
                        .build()
        );
    }

    @Transactional
    public void deleteCar(Long id) {

    }

    public Car getCarById(Long id) {
        Car car = carRepository.findCarById(id);
        if (car == null) {
            throw new NotFoundException("Машина с id " + id + " не найдена");
        }
        return car;
    }

    public Page<Car> filterCarsByAgeCountryAndColor(int pageNumber, int pageSize, Predicate predicate) {
        return carRepository.findAll(predicate, PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Order.desc("createdAt"))));
    }

    public List<Car> findCarsByPersonId(Long personId) {
        if(!personRepository.existsById(personId)){
            throw new NotFoundException("Человека с id " + personId + " не существует");
        }
        return carRepository.findCarByOwnerId(personId);
    }

    public Car findCarByEvp(Long evp) {
        Car car = carRepository.findCarByEvp(evp);
        if(car == null){
            throw new NotFoundException("Машина с evp "+evp+" не найдена");
        }
        return car;
    }

    public List<Car> findAll(){
        return carRepository.findAll();
    }
}
