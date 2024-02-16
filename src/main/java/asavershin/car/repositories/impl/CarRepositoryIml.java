package asavershin.car.repositories.impl;

import asavershin.car.dto.Page;
import asavershin.car.entities.CarEntity;
import asavershin.car.handlers.localexceptions.EntityNotFoundException;
import asavershin.car.mappers.resultsetmapping.CarWithPersonAndAutoserviceRowMapper;
import asavershin.car.repositories.CarRepository;
import asavershin.generated.package_.tables.Autoservice;
import asavershin.generated.package_.tables.Car;
import asavershin.generated.package_.tables.Person;
import lombok.RequiredArgsConstructor;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.TableField;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CarRepositoryIml implements CarRepository {

    private final JdbcTemplate jdbcTemplate;
    private final DSLContext dslContext;
    private final CarWithPersonAndAutoserviceRowMapper carWithPersonAndAutoserviceRowMapper;

    private String EXIST_BY_EVP = "SELECT COUNT(*) FROM car WHERE car_evp = ?";
    private String FIND_BY_EVP = """
                    SELECT
                        c.*,
                        p.person_name,
                        p.person_age,
                        a.autoservice_name,
                        a.autoservice_address,
                        a.autoservice_country
                    FROM car c
                    LEFT JOIN person p using(person_id)
                    LEFT JOIN autoservice a using(autoservice_id);
                    where c.car_evp = ?
            """;

    private final String UPDATE =
            """
                    WITH updated_car AS (
                        UPDATE car
                            SET car_color = ?,
                                person_id = ?,
                                autoservice_id = ?
                            WHERE car_id = ?
                            RETURNING car_id
                    )
                    SELECT
                        c.*,
                        p.person_name,
                        p.person_age,
                        a.autoservice_name,
                        a.autoservice_address,
                        a.autoservice_country
                    FROM updated_car uc
                             JOIN car c ON uc.car_id = c.car_id
                             LEFT JOIN person p using(person_id)
                             LEFT JOIN autoservice a using(autoservice_id);
                    """;
    private final String FIND_CARS_BY_PERSON_ID =
            """
                    SELECT 
                    c.*, 
                    autoservice_address,
                    autoservice_country,
                    autoservice_name,
                    person_name,
                    person_age
                    from car c
                    left join autoservice using(autoservice_id)
                    left join person using(person_id)
                    where person_id = ?
                    """;
    private final String FIND_CARS_BY_CAR_ID =
            """
                    SELECT 
                    c.*, 
                    autoservice_address,
                    autoservice_country,
                    autoservice_name,
                    person_name,
                    person_age
                    from car c
                    left join autoservice using(autoservice_id)
                    left join person using(person_id)
                    where car_id = ?
                    """;
    private String DELETE_BY_ID =
            """
                    delete from car
                    where car_id = ?;
                    """;
    private final String INSERT =
            """
                    INSERT INTO car (car_release_date, car_color, car_model, car_evp)
                    VALUES (?, ?, ?, ?)
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
    public CarEntity insert(CarEntity car) {
        return jdbcTemplate.queryForObject(INSERT, carWithPersonAndAutoserviceRowMapper,
                car.getCarReleaseDate(),
                car.getCarColor(),
                car.getCarModel().toString(),
                car.getCarEvp()
        );
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
        List<CarEntity> updatedCars = jdbcTemplate.query(UPDATE, carWithPersonAndAutoserviceRowMapper,
                car.getCarColor(),
                car.getCarPerson().getPersonId(),
                car.getCarAutoservice().getAutoserviceId(),
                car.getCarId()
        );

        if (updatedCars.isEmpty()) {
            throw new EntityNotFoundException("Not found: " + car.getCarId());
        } else {
            return updatedCars.get(0);
        }
    }

    @Override
    public Optional<CarEntity> findById(Long id) throws EntityNotFoundException {
        var cars = jdbcTemplate.query(FIND_CARS_BY_CAR_ID, carWithPersonAndAutoserviceRowMapper, id);
        return Optional.ofNullable(cars.isEmpty()? null : cars.get(0));
    }

    @Override
    public Boolean delete(Long id) {
        return jdbcTemplate.update(DELETE_BY_ID, id) > 0;
    }

    @Override
    public boolean existsByEvp(Long carEvp) {
        Integer count = jdbcTemplate.queryForObject(EXIST_BY_EVP, Integer.class, carEvp);
        return count != null && count > 0;
    }

    @Override
    public List<CarEntity> findCarByPersonId(Long personId) {
        return jdbcTemplate.query(FIND_CARS_BY_PERSON_ID, carWithPersonAndAutoserviceRowMapper, personId);
    }

    @Override
    public Optional<CarEntity> findCarByEvp(Long evp) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(FIND_CARS_BY_PERSON_ID, carWithPersonAndAutoserviceRowMapper, evp));
    }

    @Override
    public Page<CarEntity> findAllByAgeColorCountry(Condition condition, int pageNumber, int pageSize, TableField<?, ?>... groupByFields) throws SQLException {
        var select = dslContext.select(Person.PERSON.fields())
                .select(
                        Car.CAR.CAR_ID,
                        Car.CAR.CAR_EVP,
                        Car.CAR.CAR_COLOR,
                        Car.CAR.CAR_CREATED_AT,
                        Car.CAR.CAR_MODEL,
                        Car.CAR.CAR_RELEASE_DATE,
                        Car.CAR.CAR_LAST_UPDATED_AT)
                .select(Autoservice.AUTOSERVICE.fields())
                .from(Person.PERSON)
                .leftJoin(Car.CAR).using(Person.PERSON.PERSON_ID)
                .leftJoin(Autoservice.AUTOSERVICE).using(Autoservice.AUTOSERVICE.AUTOSERVICE_ID)
                .where(condition)
                .orderBy(groupByFields);

        var countSelect = dslContext.selectCount()
                .from(Person.PERSON)
                .leftJoin(Car.CAR).using(Person.PERSON.PERSON_ID)
                .leftJoin(Autoservice.AUTOSERVICE).using(Autoservice.AUTOSERVICE.AUTOSERVICE_ID)
                .where(condition);

        var totalElements = countSelect.fetchOne(0, Integer.class);

        var totalPages = (int) Math.ceil((double) (totalElements == null ? 0 : totalElements) / pageSize);

        var result = select
                .limit(pageSize)
                .offset(pageNumber * pageSize)
                .fetchResultSet();

        List<CarEntity> cars = new LinkedList<>();
        while (result.next()){
            cars.add(carWithPersonAndAutoserviceRowMapper.mapRow(result, 0));
        }

        Page<CarEntity> page = new Page<>();
        page.setContent(cars);
        page.setNumber(pageNumber);
        page.setSize(pageSize);
        page.setTotalElements(totalElements == null ? 0 : totalElements);
        page.setTotalPages(totalPages);

        return page;
    }
}
