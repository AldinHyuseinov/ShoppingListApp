package bg.softuni.shoppinglist.models.dto;

import bg.softuni.shoppinglist.utils.validation.FieldMatch;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@FieldMatch(first = "password", second = "confirmPassword", message = "Passwords must match!")
public class RegisterUserDTO {
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters!")
    private String username;

    @NotEmpty(message = "Email cannot be empty!")
    @Email(regexp = ".+@.+", message = "Email must be valid!")
    private String email;

    @Size(min = 3, max = 20, message = "Password must be between 3 and 20 characters!")
    private String password;

    private String confirmPassword;
}
