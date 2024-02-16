package asavershin.car.repositories;


import asavershin.car.entities.CarEntity;
import asavershin.car.repositories.filters.CarFilter;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends CrudRepository<CarEntity, Long>, CarFilter {

    boolean existsByEvp(Long carEvp);

    List<CarEntity> findCarByPersonId(Long personId);

    Optional<CarEntity> findCarByEvp(Long evp);
}
