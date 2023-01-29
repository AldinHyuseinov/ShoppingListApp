package bg.softuni.shoppinglist.web;

import bg.softuni.shoppinglist.models.dto.LoginUserDTO;
import bg.softuni.shoppinglist.models.dto.RegisterUserDTO;
import bg.softuni.shoppinglist.models.entities.User;
import bg.softuni.shoppinglist.services.UserService;
import bg.softuni.shoppinglist.utils.user.CurrentUser;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/users")
@AllArgsConstructor(onConstructor_ = @Autowired)
public class UserController {
    private final UserService userService;

    private CurrentUser currentUser;

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @ModelAttribute("userRegisterModel")
    public RegisterUserDTO initUserRegister() {
        return new RegisterUserDTO();
    }

    @PostMapping("/register")
    public String register(@Valid RegisterUserDTO userRegisterModel, BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRegisterModel", userRegisterModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterModel",
                    bindingResult);
            return "redirect:/users/register";
        }
        userService.registerUser(userRegisterModel);

        return "redirect:/users/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @ModelAttribute("userLoginModel")
    public LoginUserDTO initUserLogin() {
        return new LoginUserDTO();
    }

    @PostMapping("/login")
    public String login(@Valid LoginUserDTO userLoginModel, BindingResult bindingResult,
                        RedirectAttributes redirectAttributes, HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginModel", userLoginModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginModel",
                    bindingResult);
            return "redirect:/users/login";
        }
        Optional<User> user = userService.loginUser(userLoginModel);

        if (user.isPresent()) {
            currentUser.setUser(user.get());
            httpSession.setAttribute("userSession", currentUser);

            return "redirect:/home";
        }
        redirectAttributes.addFlashAttribute("invalidUser", "Incorrect username or password!");

        return "redirect:/users/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession) {
        currentUser.setUser(null);
        httpSession.invalidate();

        return "redirect:/";
    }
}
