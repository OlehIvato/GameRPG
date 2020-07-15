package spring.controller.gameController;

import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.model.*;
import spring.model.gameModel.Game_Fight_Model;
import spring.model.gameModel.Game_Hero_Model;
import spring.repository.Hero_ArmorsRepository;
import spring.repository.Hero_ClassesRepository;
import spring.repository.gameRepository.Game_FightRepository;
import spring.repository.gameRepository.Game_HeroRepository;
import spring.service.imp.HeroServiceImp;

@Controller
@AllArgsConstructor
@RequestMapping("game/hero/")
public class SelectHeroController {

    private final HeroServiceImp heroServiceImp;
    private final Game_HeroRepository gameHeroRepository;
    private final Hero_ClassesRepository heroClassesRepository;
    private final Hero_ArmorsRepository hero_armorsRepository;
    private final Game_FightRepository gameFightRepository;

    @GetMapping("select")
    public String findAll(Model model) {
        model.addAttribute("heroes", heroServiceImp.findAll());
        return "rpg/equipment/select_hero";
    }

    @GetMapping("select/{heroId}")
    public String saveHeroToTable(@AuthenticationPrincipal User currentUser, @PathVariable("heroId") Long heroId) {
        HeroModel heroModel = heroServiceImp.findOneById(heroId);
        Hero_Armors hero_armors = hero_armorsRepository.getOne(heroId);
        Hero_Classes hero_classes = heroClassesRepository.getOne(heroId);
        Game_Hero_Model gameHeroModel = gameHeroRepository.findByUsername(currentUser.getUsername());
        Game_Fight_Model game_fight_model = gameFightRepository.findByUsername(currentUser.getUsername());

        game_fight_model.setIsGameStarted(0);
        SelectEquipmentController.typeForEquipment = 0;
        SelectEquipmentController.typeForWeapon = 0;
        gameFightRepository.save(game_fight_model);

        gameHeroModel.setName(heroModel.getName());
        gameHeroModel.setHeroID(heroModel.getId());
        gameHeroModel.setHp(heroModel.getHp());
        gameHeroModel.setDamage(heroModel.getDamage());
        gameHeroModel.setMinSpell(heroModel.getMinSpell());
        gameHeroModel.setMaxSpell(heroModel.getMaxSpell());
        gameHeroModel.setRestore(heroModel.getRestore());
        gameHeroModel.setMana(heroModel.getMana());
        gameHeroModel.setArmor(hero_armors.getArmor_id());
        gameHeroModel.setHeroClass(hero_classes.getClass_id());
        gameHeroRepository.save(gameHeroModel);
        return "redirect:/game/menu/mode/" + hero_armors.getArmor_id();
    }
}
