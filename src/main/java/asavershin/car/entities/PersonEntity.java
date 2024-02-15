package asavershin.car.entities;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonEntity {
    private Long personId;

    private String personName;

    private Integer personAge;

    private List<CarEntity> personCars = new ArrayList<>();
}
