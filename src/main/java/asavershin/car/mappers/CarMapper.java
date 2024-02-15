package asavershin.car.mappers;

import asavershin.car.dto.car.RequestCar;
import asavershin.car.dto.person.RequestPersonWithCars;
import asavershin.car.entities.CarEntity;
import asavershin.car.dto.car.ResponseCar;
import asavershin.car.entities.PersonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring", uses = {PersonMapper.class, AutoserviceMapper.class})
public interface CarMapper {

    @Mapping(target = "carReleaseDate", source = "carReleaseDate", qualifiedByName = "dateToString")
    ResponseCar carToResponseCar(CarEntity car);
//
//    PageResponse<ResponseCar> pageResponseWithResponseCars(Page<Car> page);

    List<ResponseCar> listCarToListRC(List<CarEntity> cars);


    @Mapping(target = "carReleaseDate", source = "carReleaseDate", qualifiedByName = "stringToDate")
    CarEntity requestCarToCar(RequestCar requestCar);

    PersonEntity personWithCars(RequestPersonWithCars request);

    @Named("dateToString")
    default String dateToString(LocalDate date){
        return date.toString();
    }

    @Named("stringToDate")
    default LocalDate stringToDate(String date) throws ParseException {
        return LocalDate.parse(date);
    }

}
