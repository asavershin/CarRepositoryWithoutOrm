package asavershin.car.validation.validators;

import asavershin.car.dto.car.RequestCar;
import asavershin.car.validation.constraints.LocalDateTimeFormat;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Slf4j
public class LocalDateTimeFormatValidator implements ConstraintValidator<LocalDateTimeFormat, RequestCar> {
    @Override
    public boolean isValid(RequestCar requestCar, ConstraintValidatorContext context) {

        try {
            log.info("Formatter used");
            System.out.println("Hello");
            LocalDate.parse(requestCar.getCarReleaseDate());
        } catch (Exception e) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Ошибка в дате создания").addConstraintViolation();
            return false;
        }

        return true;
    }
}
