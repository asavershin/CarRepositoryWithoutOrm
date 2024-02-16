package asavershin.car.mappers;

import asavershin.car.dto.car.ResponseCarWithoutOwner;
import asavershin.car.dto.person.RequestPerson;
import asavershin.car.dto.person.ResponsePerson;
import asavershin.car.dto.person.ResponsePersonWithCars;
import asavershin.car.entities.CarEntity;
import asavershin.car.entities.PersonEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-16T18:04:23+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21 (Oracle Corporation)"
)
@Component
public class PersonMapperImpl implements PersonMapper {

    @Autowired
    private CarMapperWithoutOwner carMapperWithoutOwner;

    @Override
    public ResponsePerson personToResponsePerson(PersonEntity person) {
        if ( person == null ) {
            return null;
        }

        Long personId = null;
        String personName = null;
        Integer personAge = null;

        personId = person.getPersonId();
        personName = person.getPersonName();
        personAge = person.getPersonAge();

        ResponsePerson responsePerson = new ResponsePerson( personId, personName, personAge );

        return responsePerson;
    }

    @Override
    public List<ResponsePersonWithCars> pageResponseWithResponsePersonWithCars(List<PersonEntity> persons) {
        if ( persons == null ) {
            return null;
        }

        List<ResponsePersonWithCars> list = new ArrayList<ResponsePersonWithCars>( persons.size() );
        for ( PersonEntity personEntity : persons ) {
            list.add( personToResponsePersonWithCars( personEntity ) );
        }

        return list;
    }

    @Override
    public ResponsePersonWithCars personToResponsePersonWithCars(PersonEntity person) {
        if ( person == null ) {
            return null;
        }

        Integer carsAmount = null;
        Long personId = null;
        String personName = null;
        Integer personAge = null;
        List<ResponseCarWithoutOwner> personCars = null;

        carsAmount = carsAmount( person.getPersonCars() );
        personId = person.getPersonId();
        personName = person.getPersonName();
        personAge = person.getPersonAge();
        personCars = carEntityListToResponseCarWithoutOwnerList( person.getPersonCars() );

        ResponsePersonWithCars responsePersonWithCars = new ResponsePersonWithCars( personId, personName, personAge, carsAmount, personCars );

        return responsePersonWithCars;
    }

    @Override
    public PersonEntity requestPersonToPerson(RequestPerson request) {
        if ( request == null ) {
            return null;
        }

        PersonEntity.PersonEntityBuilder personEntity = PersonEntity.builder();

        personEntity.personName( request.getPersonName() );
        personEntity.personAge( request.getPersonAge() );

        return personEntity.build();
    }

    @Override
    public PersonEntity requestPersonToPerson(Long personId, RequestPerson request) {
        if ( personId == null && request == null ) {
            return null;
        }

        PersonEntity.PersonEntityBuilder personEntity = PersonEntity.builder();

        if ( request != null ) {
            personEntity.personName( request.getPersonName() );
            personEntity.personAge( request.getPersonAge() );
        }
        personEntity.personId( personId );

        return personEntity.build();
    }

    protected List<ResponseCarWithoutOwner> carEntityListToResponseCarWithoutOwnerList(List<CarEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<ResponseCarWithoutOwner> list1 = new ArrayList<ResponseCarWithoutOwner>( list.size() );
        for ( CarEntity carEntity : list ) {
            list1.add( carMapperWithoutOwner.carToResponseCarWithoutOwner( carEntity ) );
        }

        return list1;
    }
}
