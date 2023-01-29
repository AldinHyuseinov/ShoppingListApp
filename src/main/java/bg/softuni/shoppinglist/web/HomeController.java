package bg.softuni.shoppinglist.web;

import bg.softuni.shoppinglist.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor(onConstructor_ = @Autowired)
public class HomeController {
    private final ProductService productService;

    @GetMapping("/")
    public String indexPage() {
        return "index";
    }

    @GetMapping("/home")
    public String homePage(Model model) {
        model.addAttribute("products", productService.allProducts());
        model.addAttribute("productSum", productService.sumAllProducts());

        return "home";
    }
}
