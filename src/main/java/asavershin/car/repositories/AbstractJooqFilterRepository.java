package asavershin.car.repositories;

import asavershin.car.entities.PersonEntity;
import lombok.RequiredArgsConstructor;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.impl.TableImpl;

import java.util.List;

@RequiredArgsConstructor
public class AbstractJooqFilterRepository <T extends TableImpl<?>> implements JooqFilterRepository<T>{
    private final DSLContext dslContext;
    @Override
    public List<PersonEntity> findAll(Condition condition, int offset, int limit, Field<?>... orderByFields) {
        var query = dslContext.selectFrom(getTable().$name()).where(condition);

        // Добавляем поля сортировки, если они были переданы
        if (orderByFields != null && orderByFields.length > 0) {
            query.orderBy(orderByFields);
        }

        // Применяем пагинацию
        query.offset(offset).limit(limit);

        // Выполняем запрос и возвращаем результат
        return query.fetch().into(PersonEntity.class);
    }

    @Override
    public T getTable() {
        return null;
    }
}
