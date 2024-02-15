package asavershin.car.mappers;

import asavershin.car.dto.autoservice.ResponseAutoservice;
import asavershin.car.dto.car.ResponseCarWithoutOwner;
import asavershin.car.entities.CarEntity;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-15T14:59:34+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21 (Oracle Corporation)"
)
@Component
public class CarMapperWithoutOwnerImpl implements CarMapperWithoutOwner {

    @Autowired
    private AutoserviceMapper autoserviceMapper;

    @Override
    public ResponseCarWithoutOwner carToResponseCarWithoutOwner(CarEntity car) {
        if ( car == null ) {
            return null;
        }

        String carReleaseDate = null;
        Long carId = null;
        String carColor = null;
        String carModel = null;
        Long carEvp = null;
        ResponseAutoservice carAutoservice = null;

        carReleaseDate = dateToString( car.getCarReleaseDate() );
        carId = car.getCarId();
        carColor = car.getCarColor();
        if ( car.getCarModel() != null ) {
            carModel = car.getCarModel().name();
        }
        carEvp = car.getCarEvp();
        carAutoservice = autoserviceMapper.autoserviceToResponseAutoservice( car.getCarAutoservice() );

        ResponseCarWithoutOwner responseCarWithoutOwner = new ResponseCarWithoutOwner( carId, carReleaseDate, carColor, carModel, carEvp, carAutoservice );

        return responseCarWithoutOwner;
    }
}
