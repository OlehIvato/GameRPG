package spring.controller.gameController;

import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.model.Class;
import spring.model.User;
import spring.model.gameModel.Game_Fight_Model;
import spring.model.gameModel.Game_Hero_Model;
import spring.model.gameModel.Game_Location_Model;
import spring.repository.ClassRepository;
import spring.repository.gameRepository.Game_FightRepository;
import spring.repository.gameRepository.Game_HeroRepository;
import spring.repository.gameRepository.Game_LocationRepository;

@Controller
@RequestMapping("game/menu/")
@AllArgsConstructor
public class MainController {

    private final Game_FightRepository gameFightRepository;
    private final Game_HeroRepository gameHeroRepository;
    private final Game_LocationRepository gameLocationRepository;
    private final ClassRepository classRepository;

    @GetMapping("main")
    public String start(@AuthenticationPrincipal User currentUser, Model model) {
        Game_Fight_Model fight = gameFightRepository.findByUsername(currentUser.getUsername());
        model.addAttribute("fight", fight);
        return "rpg/main_menu";
    }

    @GetMapping("mode/{armorId}")
    public String mode(@AuthenticationPrincipal User currentUser, @PathVariable("armorId") Long armorId, Model model) {
        Game_Hero_Model hero = gameHeroRepository.findByUsername(currentUser.getUsername());
        Class heroClass = classRepository.getOne(hero.getHeroClass());
        model.addAttribute("hero", hero);
        model.addAttribute("heroClass", heroClass.getClassName());
        model.addAttribute("armorId", armorId);
        return "rpg/select_mode";
    }

    @GetMapping("mode/without-equipment")
    public String gameWithOutEquipment(@AuthenticationPrincipal User currentUser) {
        Game_Fight_Model fight = gameFightRepository.findByUsername(currentUser.getUsername());
        fight.setIsGameWithEquipments(0);
        gameFightRepository.save(fight);
        return "rpg/get_location";
    }

    @GetMapping("again-first-level")
    public String playAgainFromFirstLevel(@AuthenticationPrincipal User currentUser) {
        Game_Fight_Model fight = gameFightRepository.findByUsername(currentUser.getUsername());
        Game_Hero_Model hero = gameHeroRepository.findByUsername(currentUser.getUsername());
        hero.setHp(LevelController.HERO_START_GAME_HP);
        hero.setEnergy(LevelController.HERO_START_GAME_ENERGY);
        hero.setMana(LevelController.HERO_START_GAME_MANA);
        fight.setIsGameStarted(0);
        gameHeroRepository.save(hero);
        gameFightRepository.save(fight);
        return "redirect:/game/level/get";
    }

    @GetMapping("again-current-game/{levelCount}/{levelDifficult}/{gameCount}")
    public String playAgainFromCurrentLevel(@AuthenticationPrincipal User currentUser,
                                            @PathVariable("levelCount") int levelCount,
                                            @PathVariable("levelDifficult") int levelDifficult,
                                            @PathVariable("gameCount") int gameCount) {
        Game_Hero_Model hero = gameHeroRepository.findByUsername(currentUser.getUsername());
        hero.setHp(LevelController.HERO_CURRENT_GAME_HP);
        LevelController.levelCount = levelCount;
        LevelController.levelDifficult = levelDifficult;
        LevelController.gameCount = gameCount - 1;
        gameHeroRepository.save(hero);
        return "redirect:/game/level/get";
    }

    @GetMapping("continue-game")
    public String continueGame(@AuthenticationPrincipal User currentUser) {
        Game_Hero_Model hero = gameHeroRepository.findByUsername(currentUser.getUsername());
        Game_Fight_Model fight = gameFightRepository.findByUsername(currentUser.getUsername());
        LevelController.HERO_START_GAME_HP = hero.getHp();
        LevelController.HERO_START_GAME_ENERGY = hero.getEnergy();
        LevelController.HERO_START_GAME_MANA = hero.getMana();
        LevelController.levelCount = fight.getLevelCount();
        LevelController.levelDifficult = fight.getLevelDifficult();
        LevelController.gameCount = fight.getGameCount();
        LevelController.isGameContinue = true;
        return "redirect:/game/level/get";

    }

    @GetMapping("without-location")
    public String withOutLocation(@AuthenticationPrincipal User currentUser) {
        Game_Location_Model location = gameLocationRepository.findByUsername(currentUser.getUsername());
        location.setName("null");
        location.setHeroHp(0);
        location.setHeroRestoreHealth(0);
        location.setHeroDamage(0);
        location.setHeroEnergy(0);
        location.setHeroSpellDamage(0);
        location.setHeroMana(0);
        location.setCreatureHp(0);
        location.setCreatureChance(0);
        location.setCreatureDamage(0);
        gameLocationRepository.save(location);
        return "redirect:/game/level/get";
    }


    @GetMapping("get-location")
    public String getLocation() {
        return "rpg/get_location";
    }

    @GetMapping("get-level")
    public String getLevel() {
        return "redirect:/game/level/get";
    }


}
