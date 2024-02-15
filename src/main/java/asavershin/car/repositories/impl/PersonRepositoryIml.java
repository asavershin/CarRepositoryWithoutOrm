package asavershin.car.repositories.impl;

import asavershin.car.dto.person.PersonFilter;
import asavershin.car.entities.AutoserviceEntity;
import asavershin.car.entities.CarEntity;
import asavershin.car.entities.PersonEntity;
import asavershin.car.handlers.localexceptions.EntityNotFoundException;
import asavershin.car.mappers.resultsetmapping.AutoserviceRowMapper;
import asavershin.car.mappers.resultsetmapping.CarRowMapper;
import asavershin.car.mappers.resultsetmapping.PersonRowMapper;
import asavershin.car.repositories.PersonRepository;
import asavershin.generated.package_.tables.Autoservice;
import asavershin.generated.package_.tables.Car;
import asavershin.generated.package_.tables.Person;
import lombok.RequiredArgsConstructor;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

import static org.jooq.impl.DSL.select;

@Repository
@RequiredArgsConstructor
public class PersonRepositoryIml implements PersonRepository {

    private final PersonRowMapper personRowMapper;
    private final AutoserviceRowMapper autoserviceRowMapper;
    private final CarRowMapper carRowMapper;
    private final DSLContext dslContext;

    private final JdbcTemplate jdbcTemplate;

    private final String INSERT =
            """
                    INSERT INTO person (person_name, person_age)
                    VALUES (?, ?)
                    RETURNING
                        person_id,
                        person_name,
                        person_age
                    """;

    private final String UPDATE =
            """
                    UPDATE person SET
                                person_name = ?,
                                person_age = ?
                            WHERE person_id = ?
                            RETURNING
                                person_id,
                                person_name,
                                person_age
                    """;

    private final String FIND_BY_ID =
            """
                    SELECT
                        person_id,
                        person_name,
                        person_age
                    FROM person
                    WHERE person_id = ?
                    """;

    private final String DELETE =
            """
                    DELETE FROM person
                    WHERE person_id = ?
                    """;

    @Override
    public PersonEntity insert(PersonEntity person) {
        return jdbcTemplate.queryForObject(INSERT, personRowMapper,
                person.getPersonName(), person.getPersonAge());
    }

    @Override
    public List<PersonEntity> insertAll(List<PersonEntity> personList) {
        var query = dslContext.insertInto(Person.PERSON)
                .values(personList)
                .returning()
                .fetch(personList.size(), PersonEntity.class);
        return query;
    }

    @Override
    public PersonEntity update(PersonEntity person) throws DataAccessException, EntityNotFoundException {

        List<PersonEntity> updatedPersons = jdbcTemplate.query(UPDATE, personRowMapper, person.getPersonName(), person.getPersonAge(), person.getPersonId());

        if (updatedPersons.isEmpty()) {
            throw new EntityNotFoundException("Not found: " + person.getPersonId());
        } else {
            return updatedPersons.get(0);
        }
    }

    @Override
    public Optional<PersonEntity> findById(Long id) throws DataAccessException {
        var listPerson = jdbcTemplate.query(FIND_BY_ID, personRowMapper, id);
        return Optional.ofNullable(listPerson.isEmpty()? null : listPerson.get(0));
    }

    @Override
    public Boolean delete(Long id) {
        int affectedRows = jdbcTemplate.update(DELETE, id);
        return affectedRows > 0;
    }

    @Override
    public List<PersonEntity> findPeopleWithCarsFromCountryAndAmount(PersonFilter personFilter) {

        Condition condition = null;

        if(personFilter.getAmount() != null || personFilter.getCountry() != null){
            var autoserviceCountryCondition = personFilter.getCountry() != null ? Autoservice.AUTOSERVICE.AUTOSERVICE_COUNTRY.eq(personFilter.getCountry()) : null;
            var havingCountCondition = personFilter.getAmount() != null ? DSL.count(Car.CAR.CAR_ID).ge(personFilter.getAmount()) : null;
            condition = Person.PERSON.PERSON_ID.in( dslContext.select(Person.PERSON.PERSON_ID)
                    .from(Person.PERSON)
                    .leftJoin(Car.CAR).using(Person.PERSON.PERSON_ID)
                    .leftJoin(Autoservice.AUTOSERVICE).using(Autoservice.AUTOSERVICE.AUTOSERVICE_ID)
                    .where(autoserviceCountryCondition)
                    .groupBy(Person.PERSON.PERSON_ID)
                    .having(havingCountCondition));
        }

        var resultSet = dslContext.select(Person.PERSON.fields()).select(
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
                .where(condition);



        var personMap = new HashMap<Long, PersonEntity>();
        var personList = new LinkedList<PersonEntity>();

        for (var record : resultSet) {
            var person = record.into(PersonEntity.class);

            if(personMap.containsKey(person.getPersonId())){
                person = personMap.get(person.getPersonId());
            }else{
                personMap.put(person.getPersonId(), person);
                personList.add(person);
            }
            if(record.get(Car.CAR.CAR_ID) != null) {
                var car = record.into(CarEntity.class);
                car.setCarAutoservice(record.into(AutoserviceEntity.class));
                person.getPersonCars().add(car);
            }
        }

        return personList;
    }

}
