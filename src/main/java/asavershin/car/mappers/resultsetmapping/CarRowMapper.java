package asavershin.car.mappers.resultsetmapping;

import asavershin.car.entities.CarEntity;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
@Component
public class CarRowMapper implements RowMapper<CarEntity> {
    @Override
    public CarEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
//        if(rs.next()) {
//            return CarEntity.builder()
//                    .carId(rs.getLong("autoservice_id"))
//                    .(rs.getString("autoservice_address"))
//                    .setName(rs.getString("autoservice_name"))
//                    .setCountry(rs.getString("autoservice_country"))
//                    .build();
//        }
        return null;
    }
}
