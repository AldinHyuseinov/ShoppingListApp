package bg.softuni.shoppinglist.services;

import bg.softuni.shoppinglist.models.entities.Category;
import bg.softuni.shoppinglist.models.enums.CategoryOption;
import bg.softuni.shoppinglist.repositories.CategoryRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @PostConstruct
    public void importCategories() {

        if (categoryRepository.count() <= 0) {
            Category foodCategory = new Category();
            foodCategory.setName(CategoryOption.Food);
            foodCategory.setDescription("This is a food category.");

            Category drinkCategory = new Category();
            drinkCategory.setName(CategoryOption.Drink);
            drinkCategory.setDescription("This is a drink category.");

            Category householdCategory = new Category();
            householdCategory.setName(CategoryOption.Household);
            householdCategory.setDescription("This is a household category.");

            Category othersCategory = new Category();
            othersCategory.setName(CategoryOption.Other);
            othersCategory.setDescription("This is a category for other products.");

            categoryRepository.saveAll(List.of(foodCategory, drinkCategory, householdCategory, othersCategory));
        }
    }
}
