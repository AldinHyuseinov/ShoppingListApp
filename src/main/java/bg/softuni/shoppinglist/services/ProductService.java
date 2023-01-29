package bg.softuni.shoppinglist.services;

import bg.softuni.shoppinglist.models.dto.AddProductDTO;
import bg.softuni.shoppinglist.models.dto.ProductDTO;
import bg.softuni.shoppinglist.models.entities.Product;
import bg.softuni.shoppinglist.repositories.CategoryRepository;
import bg.softuni.shoppinglist.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class ProductService {
    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    private final ModelMapper mapper;

    public void addProduct(AddProductDTO addProductDTO) {
        Product product = mapper.map(addProductDTO, Product.class);
        product.setCategory(categoryRepository.findByName(addProductDTO.getCategory()));

        productRepository.saveAndFlush(product);
    }

    public List<ProductDTO> allProducts() {
        return productRepository.findAll().stream().map(product -> mapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }

    public double sumAllProducts() {
        return productRepository.findAll().stream().map(Product::getPrice).mapToDouble(Double::doubleValue).sum();
    }

    public void buyProduct(String productName) {
        productRepository.deleteByName(productName);
    }

    public void buyAllProducts() {
        productRepository.deleteAll();
    }
}
