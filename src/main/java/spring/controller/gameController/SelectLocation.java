package spring.controller.gameController;

import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.model.LocationModel;
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
        Game_Fight_Model game_fight_model = gameFightRepository.findByUsername(currentUser.getUsername());
        if (game_fight_model.getIsGameStarted() == 1) {
            return "rpg/main/forbidden_move";
        }

        model.addAttribute("location", locationServiceImp.findAll());
        return "rpg/location/select_location";
    }

    @GetMapping("save/{locationId}")
    public String save(@AuthenticationPrincipal User currentUser, @PathVariable("locationId") Long locationId) {
        LocationModel locationModel = locationServiceImp.findOneById(locationId);
        Game_Hero_Model gameHeroModel = gameHeroRepository.findByUsername(currentUser.getUsername());
        Game_Location_Model game_location_model = new Game_Location_Model();

        gameHeroModel.setHp(gameHeroModel.getHp() + locationModel.getHeroHp());
        gameHeroModel.setDamage(gameHeroModel.getDamage() + locationModel.getHeroDamage());
        gameHeroModel.setMinSpell(gameHeroModel.getMinSpell() + locationModel.getHeroSpellDamage());
        gameHeroModel.setMaxSpell(gameHeroModel.getMaxSpell() + locationModel.getHeroSpellDamage());
        gameHeroModel.setRestore(gameHeroModel.getRestore() + locationModel.getHeroRestoreHealth());

        game_location_model.setName(locationModel.getName());
        game_location_model.setUsername(currentUser.getUsername());
        game_location_model.setHeroHp(locationModel.getHeroHp());
        game_location_model.setHeroDamage(locationModel.getHeroDamage());
        game_location_model.setHeroSpellDamage(locationModel.getHeroSpellDamage());
        game_location_model.setHeroRestoreHealth(locationModel.getHeroRestoreHealth());
        game_location_model.setCreatureHp(locationModel.getCreatureHp());
        game_location_model.setCreatureDamage(locationModel.getCreatureDamage());
        game_location_model.setCreatureChance(locationModel.getCreatureChance());

        gameLocationRepository.save(game_location_model);
        gameHeroRepository.save(gameHeroModel);
        return "redirect:/game/menu/get-level";
    }
}
