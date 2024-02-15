package asavershin.car.repositories;


import asavershin.car.handlers.localexceptions.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T, K> {

    Integer SUCCESS_CODE = 1;

    T insert(T t);
    List<T> insertAll(List<T> listT);

    T update(T t) throws EntityNotFoundException;

    Optional<T> findById(K id) throws EntityNotFoundException;

    Boolean delete(K id);
}
