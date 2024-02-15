package asavershin.car.dto.car;

import asavershin.car.dto.autoservice.ResponseAutoservice;
import asavershin.car.dto.person.ResponsePerson;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseCar {

    private Long carId;

    private String carReleaseDate;

    private String carColor;

    private String carModel;

    private Long carEvp;

    private String carCreatedAt;

    private String carLastUpdatedAt;

    private ResponsePerson carPerson;

    private ResponseAutoservice carAutoservice;
}
