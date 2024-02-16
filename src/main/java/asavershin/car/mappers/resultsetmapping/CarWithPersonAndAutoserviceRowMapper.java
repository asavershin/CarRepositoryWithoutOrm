package asavershin.car.mappers.resultsetmapping;

import asavershin.car.entities.AutoserviceEntity;
import asavershin.car.entities.CarEntity;
import asavershin.car.entities.Model;
import asavershin.car.entities.PersonEntity;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class CarWithPersonAndAutoserviceRowMapper implements RowMapper<CarEntity> {
    @Override
    public CarEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        CarEntity car = null;
        var carEntityBuilder = CarEntity.builder()
                .carId(rs.getLong("car_id"))
                .carReleaseDate(rs.getDate("car_release_date").toLocalDate())
                .carColor(rs.getString("car_color"))
                .carModel(Model.valueOf(rs.getString("car_model")))
                .carEvp(rs.getLong("car_evp"))
                .carCreatedAt(rs.getTimestamp("car_created_at").toLocalDateTime())
                .carLastUpdatedAt(rs.getTimestamp("car_last_updated_at").toLocalDateTime());

        if (rs.getLong("autoservice_id") != 0) {
            carEntityBuilder.carAutoservice(
                    AutoserviceEntity.builder()
                            .autoserviceId(rs.getLong("autoservice_id"))
                            .autoserviceName(rs.getString("autoservice_name"))
                            .autoserviceAddress(rs.getString("autoservice_address"))
                            .autoserviceCountry(rs.getString("autoservice_country"))
                            .build());
        }

        if (rs.getLong("person_id") != 0) {
            carEntityBuilder.carPerson(
                    PersonEntity.builder()
                            .personId(rs.getLong("person_id"))
                            .personName(rs.getString("person_name"))
                            .personAge(rs.getInt("person_age"))
                            .build());
        }

        car = carEntityBuilder.build();
        return car;
    }
}
