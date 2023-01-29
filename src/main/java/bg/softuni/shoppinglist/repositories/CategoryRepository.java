package bg.softuni.shoppinglist.repositories;

import bg.softuni.shoppinglist.models.entities.Category;
import bg.softuni.shoppinglist.models.enums.CategoryOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(CategoryOption name);
}
