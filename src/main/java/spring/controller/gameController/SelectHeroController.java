package spring.controller.gameController;

import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.model.*;
import spring.model.databaseModel.HeroModel;
import spring.model.gameModel.Game_Fight_Model;
import spring.model.gameModel.Game_Hero_Model;
import spring.repository.gameRepository.Game_FightRepository;
import spring.repository.gameRepository.Game_HeroRepository;
import spring.service.imp.HeroServiceImp;

@Controller
@AllArgsConstructor
@RequestMapping("game/hero/")
public class SelectHeroController {

    private final HeroServiceImp heroServiceImp;
    private final Game_HeroRepository gameHeroRepository;
    private final Game_FightRepository gameFightRepository;

    @GetMapping("select")
    public String findAll(Model model) {
        model.addAttribute("heroes", heroServiceImp.findAll());
        return "rpg/select_hero";
    }

    @GetMapping("select/{heroId}")
    public String saveHeroToTable(@AuthenticationPrincipal User currentUser, @PathVariable("heroId") Long heroId) {
        HeroModel heroModel = heroServiceImp.findOneById(heroId);
        Game_Hero_Model gameHeroModel = gameHeroRepository.findByUsername(currentUser.getUsername());
        Game_Fight_Model fight = gameFightRepository.findByUsername(currentUser.getUsername());

        fight.setIsGameStarted(0);
        SelectEquipmentController.typeCount = 0;
        gameFightRepository.save(fight);

        gameHeroModel.setName(heroModel.getName());
        gameHeroModel.setHeroID(heroModel.getId());
        gameHeroModel.setHp(heroModel.getHp());
        gameHeroModel.setDamage(heroModel.getDamage());
        gameHeroModel.setEnergy(heroModel.getEnergy());
        gameHeroModel.setEnergyRes(heroModel.getEnergyRes());
        gameHeroModel.setMinSpell(heroModel.getMinSpell());
        gameHeroModel.setMaxSpell(heroModel.getMaxSpell());
        gameHeroModel.setRestore(heroModel.getRestore());
        gameHeroModel.setMana(heroModel.getMana());
        gameHeroModel.setManaRes(heroModel.getManaRes());
        gameHeroModel.setArmor(heroModel.getArmor_id());
        gameHeroModel.setHeroClass(heroModel.getClass_id());
        gameHeroRepository.save(gameHeroModel);
        return "redirect:/game/menu/mode/" + heroModel.getArmor_id();
    }
}
