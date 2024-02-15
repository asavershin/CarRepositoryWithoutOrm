package asavershin.car.dto.car;

import asavershin.car.dto.autoservice.ResponseAutoservice;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseCarWithoutOwner {
    private Long carId;

    private String carReleaseDate;

    private String carColor;

    private String carModel;

    private Long carEvp;

    private ResponseAutoservice carAutoservice;
}
