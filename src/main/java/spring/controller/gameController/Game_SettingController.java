package spring.controller.gameController;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import spring.model.gameModel.Game_Equipment_Setting_Model;
import spring.model.gameModel.Game_SettingModel;
import spring.repository.ClassRepository;
import spring.repository.gameRepository.Game_Equipment_SettingRepository;
import spring.repository.gameRepository.Game_SettingRepository;

@Controller
@RequestMapping("game/")
@AllArgsConstructor
@PreAuthorize("hasAnyRole('ADMIN','MODERATOR')")
public class Game_SettingController {

    private final Game_SettingRepository gameSettingRepository;
    private final Game_Equipment_SettingRepository game_equipment_settingRepository;
    private final ClassRepository classRepository;

    private static boolean isIndexSave = false;
    private static boolean isEquipmentSave = false;

    @GetMapping("setting")
    public String getSettingPage(Model model) {
        model.addAttribute("settingTable", gameSettingRepository.getOne((long) 1));
        model.addAttribute("equipmentSetting", game_equipment_settingRepository.findAll());
        model.addAttribute("getHeroes", classRepository.findAll());
        if (isIndexSave) {
            model.addAttribute("settingSave", "Saved");
            isIndexSave = false;
        }
        if (isEquipmentSave) {
            model.addAttribute("equipmentSettingSaved", "Saved");
            isEquipmentSave = false;
        }
        return "rpg/setting";
    }

    @PostMapping("setting")
    public String saveSetting(Game_SettingModel game_settingModel) {
        game_settingModel.setId(1L);
        gameSettingRepository.save(game_settingModel);
        isIndexSave = true;
        return "redirect:/game/setting";
    }

    @GetMapping("change-equipment-setting/{id}")
    public String equipmentSettingPage(@PathVariable("id") Long id, Model model) {
        model.addAttribute("equipmentSetting", game_equipment_settingRepository.getOne(id));
     //   model.addAttribute("heroClass", classRepository.getOne(id));
        return "rpg/equipment_setting";
    }

    @PostMapping("change-equipment-setting")
    public String saveEquipmentSettingPage(Game_Equipment_Setting_Model game_equipment_setting_model) {
        game_equipment_settingRepository.save(game_equipment_setting_model);
        isEquipmentSave = true;
        return "redirect:/game/setting";
    }


}