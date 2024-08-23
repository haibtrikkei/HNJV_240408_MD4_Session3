package ra.rekkei.restapi_basic.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ra.rekkei.restapi_basic.custom_validate.ConfirmPasswordMatching;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ConfirmPasswordMatching(password = "password",confirmPassword = "confirmPassword")
public class UserRequest {
    private String username;
    @NotBlank(message = "Password is empty!")
    private String password;
    private String confirmPassword;
}
