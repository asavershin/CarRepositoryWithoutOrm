package asavershin.car.mappers;

import asavershin.car.entities.AutoserviceEntity;
import asavershin.car.dto.autoservice.RequestAutoservice;
import asavershin.car.dto.autoservice.ResponseAutoservice;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = AutoserviceEntity.class)
public interface AutoserviceMapper {
    ResponseAutoservice autoserviceToResponseAutoservice(AutoserviceEntity autoservice);
    AutoserviceEntity requestAutoserviceToAutoservice(RequestAutoservice request);
    AutoserviceEntity requestAutoserviceToAutoservice(Long id, RequestAutoservice requestAutoservice);
}
