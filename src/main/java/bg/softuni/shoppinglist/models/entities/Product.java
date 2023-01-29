package bg.softuni.shoppinglist.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "products")
@NoArgsConstructor
@Getter
@Setter
public class Product extends BaseEntity {
    @Column(unique = true)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private Double price;

    private LocalDateTime neededBefore;

    @ManyToOne(optional = false)
    private Category category;
}
