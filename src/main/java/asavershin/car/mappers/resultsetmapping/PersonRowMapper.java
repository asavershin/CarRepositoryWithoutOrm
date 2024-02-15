package asavershin.car.mappers.resultsetmapping;

import asavershin.car.entities.AutoserviceEntity;
import asavershin.car.entities.CarEntity;
import asavershin.car.entities.Model;
import asavershin.car.entities.PersonEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class PersonRowMapper implements RowMapper<PersonEntity> {

    @Override
    public PersonEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        PersonEntity person = new PersonEntity();
        person.setPersonId(rs.getLong("person_id"));
        person.setPersonName(rs.getString("person_name"));
        person.setPersonAge(rs.getInt("person_age"));
        person.setPersonCars(new ArrayList<>());
        return person;
    }
}
