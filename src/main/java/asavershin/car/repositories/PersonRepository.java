package asavershin.car.repositories;


import asavershin.car.entities.PersonEntity;
import asavershin.car.repositories.filters.PeopleFilterByCarsAmountAndCarsCountry;

public interface PersonRepository extends CrudRepository<PersonEntity, Long>, PeopleFilterByCarsAmountAndCarsCountry {
    boolean existsById(Long id);
}
