package asavershin.car.repositories.filters;

import asavershin.car.dto.person.PersonFilter;
import asavershin.car.entities.PersonEntity;

import java.util.List;

public interface PeopleFilterByCarsAmountAndCarsCountry {
    public List<PersonEntity> findPeopleWithCarsFromCountryAndAmount(PersonFilter personFilter);
}
