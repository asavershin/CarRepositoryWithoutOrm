package asavershin.car.repositories;


import asavershin.car.entities.CarEntity;

public interface CarRepository extends CrudRepository<CarEntity, Long>{

    boolean existsByEvp(Long carEvp);
}
