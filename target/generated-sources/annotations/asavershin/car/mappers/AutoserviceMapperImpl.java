package asavershin.car.mappers;

import asavershin.car.dao.entities.Autoservice;
import asavershin.car.dto.autoservice.RequestAutoservice;
import asavershin.car.dto.autoservice.ResponseAutoservice;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-28T13:20:54+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21 (Oracle Corporation)"
)
@Component
public class AutoserviceMapperImpl implements AutoserviceMapper {

    @Override
    public ResponseAutoservice autoserviceToResponseAutoservice(Autoservice autoservice) {
        if ( autoservice == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        String address = null;
        String country = null;

        id = autoservice.getId();
        name = autoservice.getName();
        address = autoservice.getAddress();
        country = autoservice.getCountry();

        ResponseAutoservice responseAutoservice = new ResponseAutoservice( id, name, address, country );

        return responseAutoservice;
    }

    @Override
    public Autoservice requestAutoserviceToAutoservice(RequestAutoservice request) {
        if ( request == null ) {
            return null;
        }

        Autoservice autoservice = new Autoservice();

        autoservice.setName( request.getName() );
        autoservice.setAddress( request.getAddress() );
        autoservice.setCountry( request.getCountry() );

        return autoservice;
    }
}
