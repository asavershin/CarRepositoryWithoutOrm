package asavershin.car.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarEntity {
    private Long carId;
    private LocalDate carReleaseDate;
    private String carColor;
    private Model carModel;
    private Long carEvp;
    private LocalDateTime carCreatedAt;
    private LocalDateTime carLastUpdatedAt;
    private PersonEntity carPerson;
    private AutoserviceEntity carAutoservice;
}
