package asavershin.car.mappers;

import asavershin.car.entities.CarEntity;
import asavershin.car.entities.PersonEntity;
import asavershin.car.dto.person.RequestPerson;
import asavershin.car.dto.person.ResponsePerson;
import asavershin.car.dto.person.ResponsePersonWithCars;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CarMapperWithoutOwner.class})
public interface PersonMapper {


    ResponsePerson personToResponsePerson(PersonEntity person);

//    PageResponse<ResponsePersonWithCars> pageResponseWithResponsePersonWithCars(Page<Person> page);
    List<ResponsePersonWithCars> pageResponseWithResponsePersonWithCars(List<PersonEntity> persons);



    @Mapping(target = "carsAmount", source = "personCars", qualifiedByName = "carsAmount")
    ResponsePersonWithCars personToResponsePersonWithCars(PersonEntity person);

    PersonEntity requestPersonToPerson(RequestPerson request);
    @Named("carsAmount")
    default Integer carsAmount(List<CarEntity> cars){
        return cars.size();
    }

    PersonEntity requestPersonToPerson(Long personId, RequestPerson request);
}
