package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(Model model, String error) {
        if (error != null)
            model.addAttribute("error", "username or password is invalid.");
        return "security/login";
    }
}
