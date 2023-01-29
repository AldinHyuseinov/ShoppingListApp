package bg.softuni.shoppinglist.web;

import bg.softuni.shoppinglist.models.dto.AddProductDTO;
import bg.softuni.shoppinglist.services.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/products")
@AllArgsConstructor(onConstructor_ = @Autowired)
public class ProductController {
    private final ProductService productService;

    @GetMapping("/add")
    public String addProduct() {
        return "product-add";
    }

    @ModelAttribute("productModel")
    public AddProductDTO initProduct() {
        return new AddProductDTO();
    }

    @PostMapping("/add")
    public String addProduct(@Valid AddProductDTO productModel, BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("productModel", productModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.productModel",
                    bindingResult);
            return "redirect:/products/add";
        }
        productService.addProduct(productModel);

        return "redirect:/home";
    }

    @GetMapping("/buy{product-name}")
    public String buyProduct(@PathVariable("product-name") String productName) {
        productService.buyProduct(productName);

        return "redirect:/home";
    }

    @GetMapping("/buy-all")
    public String buyAllProducts() {
        productService.buyAllProducts();

        return "redirect:/home";
    }
}
