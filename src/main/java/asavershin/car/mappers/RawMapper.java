package asavershin.car.mappers;

import java.sql.ResultSet;
import java.util.List;

public interface RawMapper<T> {
    public T resultSetToEntity(ResultSet resultSet);
    public List<T> resultSetToListEntity(ResultSet resultSet);
}
