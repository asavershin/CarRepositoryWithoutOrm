package asavershin.car.entities;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AutoserviceEntity {
    private Long autoserviceId;
    private String autoserviceName;
    private String autoserviceAddress;
    private String autoserviceCountry;
}
