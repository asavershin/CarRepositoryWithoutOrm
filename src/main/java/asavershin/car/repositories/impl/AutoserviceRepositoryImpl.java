package asavershin.car.repositories.impl;

import asavershin.car.dao.entities.Autoservice;
import asavershin.car.mappers.RawMapper;
import asavershin.car.repositories.AutoserviceRepository;
import asavershin.car.repositories.DataSourceConfig;
import lombok.RequiredArgsConstructor;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import your.generated.package_.tables.AutoserviceRef;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AutoserviceRepositoryImpl implements AutoserviceRepository {

    private final RawMapper<Autoservice> autoserviceRawMapper;

    private final DSLContext dsl;
    private final DataSourceConfig dataSourceConfig;
    private final String FIND_BY_ID =
            """
            select 
                id as autoservice_id, 
                address as autoservice_address, 
                country as autoservice_country, 
                name as autoservice_name
            from autoservice_ref
            where id = ?
            """;
    private final String FIND_ALL =
            """
            select 
                id as autoservice_id, 
                address as autoservice_address, 
                country as autoservice_country, 
                name as autoservice_name
            from autoservice_ref
            """;

    private final String INSERT =
            """
            INSERT INTO autoservice_ref (address, country, name) 
            VALUES (?, ?, ?) 
            RETURNING 
                id as autoservice_id, 
                address as autoservice_address, 
                country as autoservice_country, 
                name as autoservice_name
            """;


    @Override
    public Autoservice insert(Autoservice autoservice) {
        var INSERT_QUERY = INSERT;

        try (var connection = dataSourceConfig.getConnection();
             var preparedStatement = connection.prepareStatement(INSERT_QUERY)) {

            preparedStatement.setString(1, autoservice.getAddress());
            preparedStatement.setString(2, autoservice.getCountry());
            preparedStatement.setString(3, autoservice.getName());

            try (var resultSet = preparedStatement.executeQuery()) {
                return autoserviceRawMapper.resultSetToEntity(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to insert Autoservice", e);
        }
    }


    @Override
    public Autoservice update(Autoservice autoservice) {
        return null;
    }

    @Override
    public Optional<Autoservice> findById(Long id) {
        try {
            var connection = dataSourceConfig.getConnection();
            var preStatement = connection.prepareStatement(FIND_BY_ID);
            preStatement.setLong(1, id);
            try (var resultSet = preStatement.executeQuery()){
                return Optional.ofNullable(autoserviceRawMapper.resultSetToEntity(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Autoservice> findAll(Condition condition) {
        try {
            var connection = dataSourceConfig.getConnection();
            var preStatement = connection.prepareStatement(FIND_ALL);
            try (var resultSet = preStatement.executeQuery()) {
                return autoserviceRawMapper.resultSetToListEntity(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }
}
