package bg.softuni.shoppinglist.models.dto;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class LoginUserDTO {
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters!")
    private String username;

    @Size(min = 3, max = 20, message = "Password must be between 3 and 20 characters!")
    private String password;
}
