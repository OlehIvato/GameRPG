package spring.controller.game;

import game.primary.Main_All;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.model.HeroModel;
import spring.service.HeroService;

import java.util.List;

@Controller
@RequestMapping("game/")
public class Select_HeroController {

    @Autowired
    private HeroService heroService;


    @GetMapping("new-game")
    public String findAll(Model model) {
        List<HeroModel> heroModels = heroService.findAll();
        model.addAttribute("heroes", heroModels);
        return "game/new-game";
    }

    @PostMapping("setHero/{id}")
    public String create(HeroModel heroModel, @PathVariable("id") Long id) {
        heroService.findOneById(id);
        heroService.save(heroModel);
        Main_All.setHeroName(heroModel.getName());
        Main_All.setHeroHP(heroModel.getHp());
        Main_All.setDefaultDamage(heroModel.getDamage());
        Main_All.setMinSpellDamageHERO(heroModel.getMinSpell());
        Main_All.setMaxSpellDamageHero(heroModel.getMaxSpell());
        Main_All.setRestoreHealth(heroModel.getRestore());
        Main_All.setMana(heroModel.getMana());
        return "redirect:/game/equipment-select";
    }


}
