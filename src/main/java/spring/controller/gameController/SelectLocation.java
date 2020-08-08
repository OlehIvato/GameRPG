package spring.controller.gameController;

import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.model.databaseModel.LocationModel;
import spring.model.User;
import spring.model.gameModel.Game_Fight_Model;
import spring.model.gameModel.Game_Hero_Model;
import spring.model.gameModel.Game_Location_Model;
import spring.repository.gameRepository.Game_FightRepository;
import spring.repository.gameRepository.Game_HeroRepository;
import spring.repository.gameRepository.Game_LocationRepository;
import spring.service.imp.LocationServiceImp;

@Controller
@RequestMapping("game/location/")
@AllArgsConstructor
public class SelectLocation {

    private final LocationServiceImp locationServiceImp;
    private final Game_HeroRepository gameHeroRepository;
    private final Game_LocationRepository gameLocationRepository;
    private final Game_FightRepository gameFightRepository;

    @GetMapping("show")
    public String findAll(@AuthenticationPrincipal User currentUser, Model model) {
        Game_Fight_Model fight = gameFightRepository.findByUsername(currentUser.getUsername());
        Game_Hero_Model hero = gameHeroRepository.findByUsername(currentUser.getUsername());
        if (fight.getIsGameStarted() == 1) {
            return "rpg/forbidden_move";
        }
        model.addAttribute("location", locationServiceImp.findAll());
        model.addAttribute("hero", hero);
        return "rpg/select_location";
    }

    @GetMapping("save/{locationId}")
    public String save(@AuthenticationPrincipal User currentUser, @PathVariable("locationId") Long locationId) {
        LocationModel location = locationServiceImp.findOneById(locationId);
        Game_Hero_Model hero = gameHeroRepository.findByUsername(currentUser.getUsername());
        Game_Location_Model game_location = gameLocationRepository.findByUsername(currentUser.getUsername());

        hero.setHp(hero.getHp() + location.getHeroHp());
        hero.setDamage(hero.getDamage() + location.getHeroDamage());
        hero.setEnergy(hero.getEnergy() + location.getHeroEnergy());
        hero.setMinSpell(hero.getMinSpell() + location.getHeroSpellDamage());
        hero.setMaxSpell(hero.getMaxSpell() + location.getHeroSpellDamage());
        hero.setMana(hero.getMana() + location.getHeroMana());
        hero.setRestore(hero.getRestore() + location.getHeroRestoreHealth());

        game_location.setName(location.getName());
        game_location.setUsername(currentUser.getUsername());
        game_location.setHeroHp(location.getHeroHp());
        game_location.setHeroEnergy(location.getHeroEnergy());
        game_location.setHeroDamage(location.getHeroDamage());
        game_location.setHeroSpellDamage(location.getHeroSpellDamage());
        game_location.setHeroRestoreHealth(location.getHeroRestoreHealth());
        game_location.setHeroMana(location.getHeroMana());
        game_location.setCreatureHp(location.getCreatureHp());
        game_location.setCreatureDamage(location.getCreatureDamage());
        game_location.setCreatureChance(location.getCreatureChance());

        gameLocationRepository.save(game_location);
        gameHeroRepository.save(hero);
        return "redirect:/game/menu/get-level";
    }
}
