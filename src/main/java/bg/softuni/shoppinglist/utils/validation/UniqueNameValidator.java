package bg.softuni.shoppinglist.utils.validation;

import bg.softuni.shoppinglist.models.entities.BaseEntity;
import bg.softuni.shoppinglist.models.entities.Product;
import bg.softuni.shoppinglist.models.entities.User;
import bg.softuni.shoppinglist.repositories.ProductRepository;
import bg.softuni.shoppinglist.repositories.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class UniqueNameValidator implements ConstraintValidator<UniqueName, String> {
    private Class<? extends BaseEntity> entity;

    private final ApplicationContext applicationContext;

    @Autowired
    public UniqueNameValidator(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void initialize(UniqueName constraintAnnotation) {
        entity = constraintAnnotation.entity();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean isUnique = false;

        if (entity == User.class) {
            UserRepository userRepository = applicationContext.getBean(UserRepository.class);

            isUnique = userRepository.findByUsername(value).isEmpty();
        } else if (entity == Product.class) {
            ProductRepository productRepository = applicationContext.getBean(ProductRepository.class);

            isUnique = productRepository.findByName(value).isEmpty();
        }
        return isUnique;
    }
}
