package asavershin.car.repositories;

import org.jooq.Condition;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T> {

    Integer SUCCESS_CODE = 1;

    T insert(T t);

    T update(T t);

    Optional<T> findById(Long id);

    List<T> findAll(Condition condition);

    Boolean delete(Long id);
}
