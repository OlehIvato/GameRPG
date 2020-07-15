package spring.controller.gameController;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.model.BossesModel;
import spring.model.MobsModel;
import spring.model.User;
import spring.model.gameModel.*;
import spring.repository.BossesRepository;
import spring.repository.MobsRepository;
import spring.repository.gameRepository.*;

@Controller
@RequestMapping("game/level/")
public class LevelController {

    private final MobsRepository mobsRepository;
    private final BossesRepository bossesRepository;
    private final Game_CreatureRepository game_creatureRepository;
    private final Game_LocationRepository gameLocationRepository;
    private final Game_FightRepository gameFightRepository;
    private final Game_SettingRepository gameSettingRepository;
    private final Game_HeroRepository gameHeroRepository;

    public LevelController(MobsRepository mobsRepository,
                           BossesRepository bossesRepository,
                           Game_CreatureRepository game_creatureRepository,
                           Game_LocationRepository gameLocationRepository,
                           Game_FightRepository gameFightRepository,
                           Game_SettingRepository gameSettingRepository,
                           Game_HeroRepository gameHeroRepository) {
        this.mobsRepository = mobsRepository;
        this.bossesRepository = bossesRepository;
        this.game_creatureRepository = game_creatureRepository;
        this.gameLocationRepository = gameLocationRepository;
        this.gameFightRepository = gameFightRepository;
        this.gameSettingRepository = gameSettingRepository;
        this.gameHeroRepository = gameHeroRepository;
    }

    static int levelCount = 0;
    static int levelDifficult = 0;
    static int gameCount = 0;

    static int HERO_MAIN_HP;
    static int HERO_MAIN_MANA;

    static boolean isGameContinue = false;

    @GetMapping("get")
    public String getLevel(@AuthenticationPrincipal User currentUser, Model model) {
        Game_SettingModel setting = gameSettingRepository.getOne(1L);
        Game_Hero_Model hero = gameHeroRepository.findByUsername(currentUser.getUsername());
        Game_Fight_Model fight = gameFightRepository.findByUsername(currentUser.getUsername());
        if (gameCount == 5) {
            model.addAttribute("WON_THE_GAME",
                    "Congratulations "
                            + currentUser.getUsername()
                            + " you went through all levels and won the game");
            return "rpg/fight/win_game";
        }


        if (fight.getIsGameStarted() == 0) {
            levelCount = 0;
            levelDifficult = 0;
            gameCount = 0;
            HERO_MAIN_HP = hero.getHp();
            HERO_MAIN_MANA = hero.getMana();
        }

        gameCount++;
        if (gameCount > 4) {
            gameCount = 0;
            gameCount++;
        }
        if (gameCount == 1 && !isGameContinue) {
            levelCount++;
            levelDifficult += 10;
            isGameContinue = false;
        }
        if (levelCount == 1) {
            levelDifficult = 0;
        }
        if (fight.getIsGameWithEquipments() == 0) {
            levelDifficult = setting.getDEFAULT_GAME_WITHOUT_EQUIP_INDEX();
        }

        // if that count equals default levelCount in Setting table, then will be last fight
        if (setting.getLEVEL_COUNT() == levelCount) {
            return "redirect:/game/level/start"
                    + "/" + 110
                    + "/" + 999
                    + "/" + 5;
        }
        return "redirect:/game/level/start"
                + "/" + levelDifficult
                + "/" + levelCount
                + "/" + gameCount;
    }


    @GetMapping("start/{getLvlDifficult}/{getLevelCount}/{getGameCount}")
    public String startLevel(@AuthenticationPrincipal User currentUser,
                             @PathVariable("getLvlDifficult") int getLvlDifficult,
                             @PathVariable("getLevelCount") int getLevelCount,
                             @PathVariable("getGameCount") int getGameCount) {
        Game_Hero_Model hero = gameHeroRepository.findByUsername(currentUser.getUsername());
        hero.setHp(HERO_MAIN_HP);
        hero.setMana(HERO_MAIN_MANA);

        Game_Fight_Model fight = gameFightRepository.findByUsername(currentUser.getUsername());
        fight.setLevelDifficult(getLvlDifficult);
        fight.setLevelCount(getLevelCount);
        fight.setGameCount(getGameCount);

        Game_Creature_Model creature_game = new Game_Creature_Model();
        Game_Location_Model game_location = gameLocationRepository.findByUsername(currentUser.getUsername());
        BossesModel boss = bossesRepository.getOneRandomBoss();
        MobsModel mob = mobsRepository.getOneRandomMob();

        if (creature_game.getUsername() != null) {
            game_creatureRepository.delete(creature_game);
        }
        creature_game.setUsername(currentUser.getUsername());


        if (getGameCount == 4 || getGameCount == 5) { // 4 = game vs boss,  5 = final fight
            fight.setIsBoss(1);
            if (fight.getIsGameWithEquipments() == 1) {
                creature_game.setRestoreHp(setLvlDifficult(boss.getRestoreHealth()));
                creature_game.setHp(setLvlDifficult(boss.getHp() + game_location.getCreatureHp()));
                creature_game.setMinDamage(setLvlDifficult(boss.getMinDamage() + game_location.getCreatureDamage()));
                creature_game.setMaxDamage(setLvlDifficult(boss.getMaxDamage() + game_location.getCreatureDamage()));
                creature_game.setChanceToSuperDamage(
                        setLvlDifficult(boss.getChanceToSuperDamage() + game_location.getCreatureChance()));
            } else {
                creature_game.setRestoreHp(
                        reduceDifficulty(boss.getRestoreHealth()));
                creature_game.setHp(
                        reduceDifficulty(boss.getHp() + game_location.getCreatureHp()));
                creature_game.setMinDamage(
                        reduceDifficulty(boss.getMinDamage() + game_location.getCreatureDamage()));
                creature_game.setMaxDamage(
                        reduceDifficulty(boss.getMaxDamage() + game_location.getCreatureDamage()));
                creature_game.setChanceToSuperDamage(
                        reduceDifficulty(boss.getChanceToSuperDamage() + game_location.getCreatureChance()));
            }
            creature_game.setName(boss.getName());
        } else {
            fight.setIsBoss(0);
            if (fight.getIsGameWithEquipments() == 1) {
                creature_game.setHp(setLvlDifficult(mob.getHp() + game_location.getCreatureHp()));
                creature_game.setMinDamage(setLvlDifficult(mob.getMinDamage() + game_location.getCreatureDamage()));
                creature_game.setMaxDamage(setLvlDifficult(mob.getMaxDamage() + game_location.getCreatureDamage()));
                creature_game.setChanceToSuperDamage(
                        setLvlDifficult(mob.getChanceToSuperDamage() + game_location.getCreatureChance()));
            } else {
                creature_game.setHp(
                        reduceDifficulty(mob.getHp() + game_location.getCreatureHp()));
                creature_game.setMinDamage(
                        reduceDifficulty(mob.getMinDamage() + game_location.getCreatureDamage()));
                creature_game.setMaxDamage(
                        reduceDifficulty(mob.getMaxDamage() + game_location.getCreatureDamage()));
                creature_game.setChanceToSuperDamage(
                        reduceDifficulty(mob.getChanceToSuperDamage() + game_location.getCreatureChance()));
            }
            creature_game.setName(mob.getName());
        }

        game_creatureRepository.save(creature_game);
        gameFightRepository.save(fight);
        return "redirect:/game/fight/launch";

    }


    private int setLvlDifficult(int valueFromDataBase) {
        int value = valueFromDataBase;
        int subtract = (valueFromDataBase * levelDifficult) / 100;
        value += subtract;
        return value;
    }

    private int reduceDifficulty(int valueFromDataBase) {
        Game_SettingModel setting = gameSettingRepository.getOne(1L);
        int value = valueFromDataBase;
        int subtract = valueFromDataBase * (setting.getDEFAULT_GAME_WITHOUT_EQUIP_INDEX() * (-1)) / 100;
        value -= subtract;
        return value;
    }


}
