package bg.softuni.shoppinglist.models.dto;

import bg.softuni.shoppinglist.models.enums.CategoryOption;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ProductDTO {
    private String name;

    private Double price;

    private CategoryOption categoryName;
}
