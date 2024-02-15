package asavershin.car.mappers.resultsetmapping;

import asavershin.car.entities.AutoserviceEntity;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class AutoserviceRowMapper implements RowMapper<AutoserviceEntity> {
    @Override
    public AutoserviceEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        if(rs.next()) {
            return AutoserviceEntity.builder()
                    .autoserviceId(rs.getLong("autoservice_id"))
                    .autoserviceAddress(rs.getString("autoservice_address"))
                    .autoserviceName(rs.getString("autoservice_name"))
                    .autoserviceCountry(rs.getString("autoservice_country"))
                    .build();
        }
        return null;
    }
}
