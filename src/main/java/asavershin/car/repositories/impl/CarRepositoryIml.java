package asavershin.car.repositories.impl;

import asavershin.car.entities.CarEntity;
import asavershin.car.entities.PersonEntity;
import asavershin.car.handlers.localexceptions.EntityNotFoundException;
import asavershin.car.mappers.resultsetmapping.CarRowMapper;
import asavershin.car.repositories.CarRepository;
import asavershin.generated.package_.tables.Car;
import asavershin.generated.package_.tables.Person;
import asavershin.generated.package_.tables.records.CarRecord;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CarRepositoryIml implements CarRepository {

    private final JdbcTemplate jdbcTemplate;
    private final DSLContext dslContext;
    private final CarRowMapper carRowMapper;

    private String EXIST_BY_EVP = "SELECT COUNT(*) FROM car WHERE car_evp = ?";

    private final String UPDATE =
            """
                    UPDATE car SET
                                car_color = ?,
                                person_id = ?,
                                autoservice_id = ?
                            WHERE car_id = ?
                            RETURNING
                                car_id,
                                car_release_date,
                                car_color,
                                car_model,
                                car_evp,
                                car_created_at,
                                car_last_updated_at,
                                person_id,
                                autoservice_id
                    """;

    @Override
    public CarEntity insert(CarEntity carEntity) {
        return null;
    }

    @Override
    public List<CarEntity> insertAll(List<CarEntity> carList) {
        return dslContext.insertInto(Car.CAR)
                .set(
                        carList.stream().map(c -> {
                                    var r = dslContext.newRecord(Car.CAR, c);
                                    r.setPersonId(c.getCarPerson().getPersonId());
                                    return r;
                                }
                        ).toList()
                )
                .returning()
                .stream().map(r -> r.into(CarEntity.class)).toList();
    }

    @Override
    public CarEntity update(CarEntity car) throws EntityNotFoundException {
        List<CarEntity> updatedPersons = jdbcTemplate.query(UPDATE, carRowMapper,
                car.getCarColor(),
                car.getCarPerson().getPersonId(),
                car.getCarAutoservice().getAutoserviceId()
        );

        if (updatedPersons.isEmpty()) {
            throw new EntityNotFoundException("Not found: " + car.getCarId());
        } else {
            return updatedPersons.get(0);
        }
    }

    @Override
    public Optional<CarEntity> findById(Long id) throws EntityNotFoundException {
        return Optional.empty();
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    @Override
    public boolean existsByEvp(Long carEvp) {
        Integer count = jdbcTemplate.queryForObject(EXIST_BY_EVP, Integer.class, carEvp);
        return count != null && count > 0;
    }
}
