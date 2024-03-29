package yte.spring.application.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = TcKimlikNoValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TcKimlikNo {

	String message() default "Tc kimlik numarası formatı uygun değildir";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}

