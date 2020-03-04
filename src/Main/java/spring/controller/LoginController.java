package spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.model.User;
import spring.service.UserService;

import javax.validation.Valid;

@Controller
public class LoginController {


    @Autowired
    UserService userService;


    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error, @Valid User user, BindingResult bindingResult, Model model) {
        String errorMessage = null;

        if (error != null) {
            errorMessage = "Username of Password is Incorrect !!!";
        }
        model.addAttribute("errorMessage", errorMessage);
        return "/login";
    }


}
