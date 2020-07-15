package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import spring.model.User;
import spring.service.UserService;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "security/registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("userForm") @Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "security/registration";
        }
        if (!user.getPassword().equals(user.getPassword_confirm())) {
            model.addAttribute("passwordError", "Password don't match");
            return "security/registration";
        }
        if (!userService.updateUsername(user)) {
            model.addAttribute("usernameError", "Someone already have that username");
            return "security/registration";
        }
        if (!userService.updateEmail(user)) {
            model.addAttribute("emailError", "Someone already have that email address");
            return "security/registration";
        }
        userService.createAccount(user);
        return "redirect:/login";
    }
}