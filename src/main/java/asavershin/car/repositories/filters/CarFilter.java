package asavershin.car.repositories.filters;

import asavershin.car.dto.Page;
import asavershin.car.entities.CarEntity;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.TableField;

import java.sql.SQLException;

public interface CarFilter {
    Page<CarEntity> findAllByAgeColorCountry(Condition condition, int pageNumber, int pageSize, TableField<?, ?>... groupByFields) throws SQLException;
}
