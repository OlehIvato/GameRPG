package spring.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import spring.model.gameModel.Game_SettingModel;
import spring.repository.gameRepository.Game_SettingRepository;

@Controller
@AllArgsConstructor
public class InfoPageController {

    private final Game_SettingRepository gameSettingRepository;


    @GetMapping("info")
    public String info(Model model) {
        Game_SettingModel setting = gameSettingRepository.getOne(1L);
        model.addAttribute("index", setting);
        return "info";
    }


}
