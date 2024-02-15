package asavershin.car.repositories;

import asavershin.car.entities.PersonEntity;
import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.impl.TableImpl;

import java.util.List;

public interface JooqFilterRepository<T extends TableImpl<?>> {

    // Метод для поиска записей с пагинацией, фильтрацией и сортировкой
    List<PersonEntity> findAll(Condition condition, int offset, int limit, Field<?>... orderByFields);
    T getTable();
}
