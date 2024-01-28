package asavershin.car.repositories;

import org.jooq.Condition;

import java.util.List;

public interface CrudRepository<T> {

    Integer SUCCESS_CODE = 1;

    T save(T t);

    T update(T t);

    T findById(Long id);

    List<T> findAll(Condition condition);

    Boolean delete(Long id);
}
