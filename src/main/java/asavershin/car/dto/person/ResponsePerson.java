package asavershin.car.dto.person;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ResponsePerson {
    private Long personId;
    private String personName;
    private Integer personAge;
}
