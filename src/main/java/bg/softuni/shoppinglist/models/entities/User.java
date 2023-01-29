package bg.softuni.shoppinglist.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class User extends BaseEntity {
    @Column(unique = true)
    private String username;

    private String password;

    @Column(nullable = false)
    private String email;
}
