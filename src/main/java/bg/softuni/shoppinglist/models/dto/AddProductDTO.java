package bg.softuni.shoppinglist.models.dto;

import bg.softuni.shoppinglist.models.enums.CategoryOption;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class AddProductDTO {
    @Size(min = 3, max = 20, message = "Name length must be between 3 and 20 characters!")
    private String name;

    @Size(min = 5, message = "Description length must be more than 5 characters!")
    private String description;

    @Future(message = "The date cannot be in the past!")
    private LocalDateTime neededBefore;

    @NotNull(message = "Price must not be empty!")
    @Min(value = 1, message = "Price must be a positive number!")
    private Double price;

    @NotNull(message = "You must select the category!")
    private CategoryOption category;
}
