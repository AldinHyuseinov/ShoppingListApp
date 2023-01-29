package bg.softuni.shoppinglist.models.entities;

import bg.softuni.shoppinglist.models.enums.CategoryOption;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "categories")
@NoArgsConstructor
@Getter
@Setter
public class Category extends BaseEntity {
    @Column(unique = true)
    @Enumerated(EnumType.STRING)
    private CategoryOption name;

    @Column(columnDefinition = "TEXT")
    private String description;
}
