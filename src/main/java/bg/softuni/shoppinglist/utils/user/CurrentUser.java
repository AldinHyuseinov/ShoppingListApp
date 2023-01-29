package bg.softuni.shoppinglist.utils.user;

import bg.softuni.shoppinglist.models.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
@NoArgsConstructor
@Getter
@Setter
public class CurrentUser {
    private User user;
}
