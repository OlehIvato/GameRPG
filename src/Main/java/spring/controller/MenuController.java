package spring.controller;

import game.primary.Menu;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MenuController {


    @GetMapping("/new-game")
    public String getMenu() {
        return "game/new-game";
    }


    @PostMapping("/new-game")
    public String menu(Model model) {
        Menu menu = new Menu();
        model.addAttribute("menuForm", menu);
        return "game/new-game";
    }


}
