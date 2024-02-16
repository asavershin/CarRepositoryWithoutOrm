package asavershin.car.repositories.impl;

import asavershin.car.entities.AutoserviceEntity;
import asavershin.car.entities.PersonEntity;
import asavershin.car.handlers.localexceptions.EntityNotFoundException;
import asavershin.car.mappers.resultsetmapping.AutoserviceRowMapper;
import asavershin.car.repositories.AutoserviceRepository;
import asavershin.generated.package_.tables.Autoservice;
import asavershin.generated.package_.tables.Person;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AutoserviceRepositoryIml implements AutoserviceRepository {

    private final AutoserviceRowMapper autoserviceRowMapper;
    private final JdbcTemplate jdbcTemplate;
    private final DSLContext dslContext;

    private final String FIND_BY_ID =
            """
            SELECT
                autoservice_id,
                autoservice_address,
                autoservice_country,
                autoservice_name
            FROM autoservice
            WHERE autoservice_id = ?
            """;

    private final String INSERT =
            """
            INSERT INTO autoservice (autoservice_address, autoservice_country, autoservice_name)
            VALUES (?, ?, ?)
            RETURNING
                autoservice_id,
                autoservice_address,
                autoservice_country,
                autoservice_name
            """;
    private final String DELETE =
            """
            DELETE FROM autoservice
            WHERE autoservice_id = ?
            """;

    private final String UPDATE =
            """
                    UPDATE autoservice SET
                        autoservice_address = ?,
                        autoservice_country = ?,
                        autoservice_name = ?
                    WHERE autoservice_id = ?
                    RETURNING
                        autoservice_id,
                        autoservice_address,
                        autoservice_country,
                        autoservice_name

            """;

    @Override
    public AutoserviceEntity insert(AutoserviceEntity autoservice) {
        return jdbcTemplate.queryForObject(INSERT, autoserviceRowMapper,
                autoservice.getAutoserviceAddress(), autoservice.getAutoserviceCountry(), autoservice.getAutoserviceName());
    }

    @Override
    public List<AutoserviceEntity> insertAll(List<AutoserviceEntity> autoserviceList) {
        return dslContext.insertInto(Autoservice.AUTOSERVICE)
                .values(autoserviceList)
                .returning()
                .fetch(autoserviceList.size(), AutoserviceEntity.class);
    }

    @Override
    public AutoserviceEntity update(AutoserviceEntity autoservice) throws EntityNotFoundException {
        List<AutoserviceEntity> updatedAutoservice = jdbcTemplate.query(UPDATE, autoserviceRowMapper,
                autoservice.getAutoserviceAddress(),
                autoservice.getAutoserviceCountry(),
                autoservice.getAutoserviceName(),
                autoservice.getAutoserviceId()
        );

        if (updatedAutoservice.isEmpty()) {
            throw new EntityNotFoundException("Not found: " + autoservice.getAutoserviceId());
        } else {
            return updatedAutoservice.get(0);
        }
    }

    @Override
    public Optional<AutoserviceEntity> findById(Long id) {
        var listAutoserice = jdbcTemplate.query(FIND_BY_ID, autoserviceRowMapper, id);
        return Optional.ofNullable(listAutoserice.isEmpty()? null : listAutoserice.get(0));
    }

    @Override
    public Boolean delete(Long id) {
        return jdbcTemplate.update(DELETE, id) > 0;
    }
}

