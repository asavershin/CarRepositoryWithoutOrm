package asavershin.car.mappers;

import asavershin.car.dto.Page;
import asavershin.car.dto.autoservice.ResponseAutoservice;
import asavershin.car.dto.car.RequestCar;
import asavershin.car.dto.car.ResponseCar;
import asavershin.car.dto.person.RequestPersonWithCars;
import asavershin.car.dto.person.ResponsePerson;
import asavershin.car.entities.CarEntity;
import asavershin.car.entities.Model;
import asavershin.car.entities.PersonEntity;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
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
public class CarMapperImpl implements CarMapper {

    @Autowired
    private PersonMapper personMapper;
    @Autowired
    private AutoserviceMapper autoserviceMapper;

    @Override
    public ResponseCar carToResponseCar(CarEntity car) {
        if ( car == null ) {
            return null;
        }

        String carReleaseDate = null;
        Long carId = null;
        String carColor = null;
        String carModel = null;
        Long carEvp = null;
        String carCreatedAt = null;
        String carLastUpdatedAt = null;
        ResponsePerson carPerson = null;
        ResponseAutoservice carAutoservice = null;

        carReleaseDate = dateToString( car.getCarReleaseDate() );
        carId = car.getCarId();
        carColor = car.getCarColor();
        if ( car.getCarModel() != null ) {
            carModel = car.getCarModel().name();
        }
        carEvp = car.getCarEvp();
        if ( car.getCarCreatedAt() != null ) {
            carCreatedAt = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( car.getCarCreatedAt() );
        }
        if ( car.getCarLastUpdatedAt() != null ) {
            carLastUpdatedAt = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( car.getCarLastUpdatedAt() );
        }
        carPerson = personMapper.personToResponsePerson( car.getCarPerson() );
        carAutoservice = autoserviceMapper.autoserviceToResponseAutoservice( car.getCarAutoservice() );

        ResponseCar responseCar = new ResponseCar( carId, carReleaseDate, carColor, carModel, carEvp, carCreatedAt, carLastUpdatedAt, carPerson, carAutoservice );

        return responseCar;
    }

    @Override
    public Page<ResponseCar> pageResponseWithResponseCars(Page<CarEntity> page) {
        if ( page == null ) {
            return null;
        }

        Page<ResponseCar> page1 = new Page<ResponseCar>();

        page1.setTotalPages( page.getTotalPages() );
        page1.setTotalElements( page.getTotalElements() );
        page1.setNumber( page.getNumber() );
        page1.setSize( page.getSize() );
        page1.setContent( listCarToListRC( page.getContent() ) );

        return page1;
    }

    @Override
    public List<ResponseCar> listCarToListRC(List<CarEntity> cars) {
        if ( cars == null ) {
            return null;
        }

        List<ResponseCar> list = new ArrayList<ResponseCar>( cars.size() );
        for ( CarEntity carEntity : cars ) {
            list.add( carToResponseCar( carEntity ) );
        }

        return list;
    }

    @Override
    public CarEntity requestCarToCar(RequestCar requestCar) {
        if ( requestCar == null ) {
            return null;
        }

        CarEntity.CarEntityBuilder carEntity = CarEntity.builder();

        try {
            carEntity.carReleaseDate( stringToDate( requestCar.getCarReleaseDate() ) );
        }
        catch ( ParseException e ) {
            throw new RuntimeException( e );
        }
        carEntity.carColor( requestCar.getCarColor() );
        if ( requestCar.getCarModel() != null ) {
            carEntity.carModel( Enum.valueOf( Model.class, requestCar.getCarModel() ) );
        }
        carEntity.carEvp( requestCar.getCarEvp() );

        return carEntity.build();
    }

    @Override
    public PersonEntity personWithCars(RequestPersonWithCars request) {
        if ( request == null ) {
            return null;
        }

        PersonEntity.PersonEntityBuilder personEntity = PersonEntity.builder();

        personEntity.personName( request.getPersonName() );
        personEntity.personAge( request.getPersonAge() );
        personEntity.personCars( requestCarListToCarEntityList( request.getPersonCars() ) );

        return personEntity.build();
    }

    protected List<CarEntity> requestCarListToCarEntityList(List<RequestCar> list) {
        if ( list == null ) {
            return null;
        }

        List<CarEntity> list1 = new ArrayList<CarEntity>( list.size() );
        for ( RequestCar requestCar : list ) {
            list1.add( requestCarToCar( requestCar ) );
        }

        return list1;
    }
}
