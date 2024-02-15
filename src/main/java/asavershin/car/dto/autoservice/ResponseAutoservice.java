package asavershin.car.dto.autoservice;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseAutoservice {
    private Long autoserviceId;
    private String autoserviceName;
    private String autoserviceAddress;
    private String autoserviceCountry;

}
