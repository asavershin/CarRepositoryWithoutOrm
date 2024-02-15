package asavershin.car.mappers;

import asavershin.car.dto.autoservice.RequestAutoservice;
import asavershin.car.dto.autoservice.ResponseAutoservice;
import asavershin.car.entities.AutoserviceEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-15T14:59:34+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21 (Oracle Corporation)"
)
@Component
public class AutoserviceMapperImpl implements AutoserviceMapper {

    @Override
    public ResponseAutoservice autoserviceToResponseAutoservice(AutoserviceEntity autoservice) {
        if ( autoservice == null ) {
            return null;
        }

        Long autoserviceId = null;
        String autoserviceName = null;
        String autoserviceAddress = null;
        String autoserviceCountry = null;

        autoserviceId = autoservice.getAutoserviceId();
        autoserviceName = autoservice.getAutoserviceName();
        autoserviceAddress = autoservice.getAutoserviceAddress();
        autoserviceCountry = autoservice.getAutoserviceCountry();

        ResponseAutoservice responseAutoservice = new ResponseAutoservice( autoserviceId, autoserviceName, autoserviceAddress, autoserviceCountry );

        return responseAutoservice;
    }

    @Override
    public AutoserviceEntity requestAutoserviceToAutoservice(RequestAutoservice request) {
        if ( request == null ) {
            return null;
        }

        AutoserviceEntity.AutoserviceEntityBuilder autoserviceEntity = AutoserviceEntity.builder();

        autoserviceEntity.autoserviceName( request.getAutoserviceName() );
        autoserviceEntity.autoserviceAddress( request.getAutoserviceAddress() );
        autoserviceEntity.autoserviceCountry( request.getAutoserviceCountry() );

        return autoserviceEntity.build();
    }

    @Override
    public AutoserviceEntity requestAutoserviceToAutoservice(Long id, RequestAutoservice requestAutoservice) {
        if ( id == null && requestAutoservice == null ) {
            return null;
        }

        AutoserviceEntity.AutoserviceEntityBuilder autoserviceEntity = AutoserviceEntity.builder();

        if ( requestAutoservice != null ) {
            autoserviceEntity.autoserviceName( requestAutoservice.getAutoserviceName() );
            autoserviceEntity.autoserviceAddress( requestAutoservice.getAutoserviceAddress() );
            autoserviceEntity.autoserviceCountry( requestAutoservice.getAutoserviceCountry() );
        }

        return autoserviceEntity.build();
    }
}
