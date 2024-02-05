package asavershin.car.mappers;

import asavershin.car.dao.entities.Autoservice;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

@Component
public class AutoserviceRawMapper implements RawMapper<Autoservice> {
    @Override
    @SneakyThrows
    public Autoservice resultSetToEntity(ResultSet resultSet) {
        if(resultSet.next()) {
            return new Autoservice.Builder()
                    .setId(resultSet.getLong("autoservice_id"))
                    .setAddress(resultSet.getString("autoservice_address"))
                    .setName(resultSet.getString("autoservice_name"))
                    .setCountry(resultSet.getString("autoservice_country"))
                    .build();
        }
        return null;
    }

    @Override
    @SneakyThrows
    public List<Autoservice> resultSetToListEntity(ResultSet resultSet) {
        List<Autoservice> autoserviceList = new LinkedList<>();
        Autoservice autoservice;
        while(resultSet.next()) {
            autoservice = new Autoservice.Builder()
                    .setId(resultSet.getLong("autoservice_id"))
                    .setAddress(resultSet.getString("autoservice_address"))
                    .setName(resultSet.getString("autoservice_name"))
                    .setCountry(resultSet.getString("autoservice_country"))
                    .build();
            autoserviceList.add(autoservice);
        }
        return autoserviceList;
    }
}
