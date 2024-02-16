package asavershin.car.dto.car;

import asavershin.car.dto.PageDto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.jooq.Condition;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.noCondition;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class CarFilter extends PageDto {
    @Min(value = 0,message = "Возвраст не может быть меньше 0")
    private Integer age;
    @Size(max = 50, message = "Максимальная длина 50 символов")
    private String country;
    @Size(max = 20,message = "Слишком длинное название цвета")
    private String color;
    public Condition toCondition() {
        List<Condition> conditions = new ArrayList<>();

        if (nonNull(age)) {
            conditions.add(field("person_age").ge(age));
        }
        if (isNotBlank(country)) {
            conditions.add(field("autoservice_country").eq(country));
        }
        if (isNotBlank(color)) {
            conditions.add(field("car_color").eq(color));
        }

        return conditions.stream()
                .reduce(noCondition(), Condition::and);
    }
}
