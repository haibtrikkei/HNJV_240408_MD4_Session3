package ra.rekkei.restapi_basic.custom_validate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

import java.util.Objects;

public class CustomConfirmPasswordMatching implements ConstraintValidator<ConfirmPasswordMatching,Object> {
    private String password;
    private String confirmPassword;
    @Override
    public void initialize(ConfirmPasswordMatching constraintAnnotation) {
        password = constraintAnnotation.password();
        confirmPassword = constraintAnnotation.confirmPassword();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        Object passwordValue = new BeanWrapperImpl(o).getPropertyValue(password);
        Object confirmPasswordValue = new BeanWrapperImpl(o).getPropertyValue(confirmPassword);
        return Objects.equals(confirmPasswordValue,passwordValue);
    }
}
