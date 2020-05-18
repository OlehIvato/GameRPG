package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import spring.model.User;
import spring.service.UserService;

@Controller
public class WelcomePage {

    @Autowired
    UserService userService;

    @GetMapping("/welcome")
    public String mainPage(Model model, Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        Long id = user.getId();
        model.addAttribute("user", userService.getOneById(id));
        return "welcome";
    }


}