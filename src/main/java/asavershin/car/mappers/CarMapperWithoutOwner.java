package asavershin.car.mappers;

import asavershin.car.entities.CarEntity;
import asavershin.car.dto.car.ResponseCarWithoutOwner;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Mapper(componentModel = "spring", uses = {AutoserviceMapper.class})
public interface CarMapperWithoutOwner {
    @Mapping(target = "carReleaseDate", source = "carReleaseDate", qualifiedByName = "dateToString")
    ResponseCarWithoutOwner carToResponseCarWithoutOwner(CarEntity car);

    @Named("dateToString")
    default String dateToString(LocalDate date){
        return date.toString();
    }
}
