package spring.controller.gameController;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.model.gameModel.Game_SettingModel;
import spring.repository.gameRepository.Game_SettingRepository;

@Controller
@RequestMapping("game/")
@AllArgsConstructor
public class Game_SettingController {

    private final Game_SettingRepository gameSettingRepository;

    @GetMapping("setting")
    public String getLevel(Model model) {
        model.addAttribute("settingTable", gameSettingRepository.getOne((long) 1));
        return "rpg/main/setting";
    }

    @PostMapping("setting")
    public String saveSetting(Game_SettingModel game_settingModel) {
        game_settingModel.setId(1L);
        gameSettingRepository.save(game_settingModel);

        return "/welcome";
    }

}