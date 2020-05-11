package spring.controller;

import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import spring.model.Profile;
import spring.model.User;
import spring.service.ProfileService;
import spring.service.UserService;

import java.security.Principal;
import java.util.Objects;

@Controller
public class WelcomePage {

    @Autowired
    UserService userService;
    @Autowired
    ProfileService profileService;

    @GetMapping("/welcome")
    public String mainPage(Model model, Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        Long id = user.getId();
        model.addAttribute("user", userService.getOneById(id));
        return "welcome";
    }


}
