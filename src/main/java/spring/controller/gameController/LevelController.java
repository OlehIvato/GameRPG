package spring.controller.gameController;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.model.databaseModel.BossesModel;
import spring.model.databaseModel.MobsModel;
import spring.model.User;
import spring.model.gameModel.*;
import spring.repository.databaseRepository.BossesRepository;
import spring.repository.databaseRepository.MobsRepository;
import spring.repository.gameRepository.*;

import java.util.Optional;

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

    static int HERO_START_GAME_HP;
    static int HERO_START_GAME_ENERGY;
    static int HERO_START_GAME_MANA;

    static int HERO_CURRENT_GAME_HP;
    static int HERO_CURRENT_GAME_ENERGY;
    static int HERO_CURRENT_GAME_MANA;


    static boolean isGameContinue = false;
    private static boolean isLevelUp = false;
    private static boolean isGameUp = false;

    /**
     * This method takes information from Fight table and generates a level,
     * if  it is a new game, then generates the first level and the first game,
     * if it is a continue game then generates according last played level and game,
     * also if it's a game is without equipments it retains the corresponding values
     *
     * @param currentUser needed to know for which user the game is.
     * @param model       if user pass all levels and won the game
     * @return returns the appropriate level, game, and difficulty to the start method
     * also there other return:
     * if level count will be equals to default level count in Setting table, then will be last fight.
     */

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
            return "rpg/win_game";
        }


        if (fight.getIsGameStarted() == 0) {
            levelCount = 0;
            levelDifficult = 0;
            gameCount = 0;
            HERO_START_GAME_HP = hero.getHp();
            HERO_START_GAME_ENERGY = hero.getEnergy();
            HERO_START_GAME_MANA = hero.getMana();
        }
        gameCount++;

        if (gameCount > 4) {
            gameCount = 0;
            gameCount++;
        }
        if (gameCount == 1) {
            levelCount++;
            levelDifficult += setting.getLEVEL_DIFFICULT_PERCENT();
            HERO_CURRENT_GAME_HP = hero.getHp();
            HERO_CURRENT_GAME_ENERGY = hero.getEnergy();
            HERO_CURRENT_GAME_MANA = hero.getMana();
            if (levelCount > 1) {
                isLevelUp = true;
            }
        }
        if (levelCount == 1) {
            levelDifficult = 0;
        }
        if (isGameContinue) {
            gameCount = fight.getGameCount();
            levelCount = fight.getLevelCount();
            isGameContinue = false;
        }
        if (fight.getIsGameWithEquipments() == 0) {
            levelDifficult = setting.getGAME_WITHOUT_EQUIP_DIFFICULTY();
            isGameUp = true;
        }


        if (setting.getLEVEL_COUNT_INDEX() == levelCount) {
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

    /**
     * This method start game according to next parameters
     *
     * @param currentUser     needed to know for which user the game is,
     *                        and maybe he continues it instead of playing from the beginning
     *                        Fight table contains all information about the game,
     *                        whether it game with equipments or without,
     *                        whether it is a continuation of the game or new game.
     * @param getLvlDifficult needed to know the difficult of this level.
     * @param getLevelCount   needed to know from which level is.
     * @param getGameCount    needed to know from which game count to start.
     * @return returns the fight page where the whole game is.
     */
    @GetMapping("start/{getLvlDifficult}/{getLevelCount}/{getGameCount}")
    public String startLevel(@AuthenticationPrincipal User currentUser,
                             @PathVariable("getLvlDifficult") int getLvlDifficult,
                             @PathVariable("getLevelCount") int getLevelCount,
                             @PathVariable("getGameCount") int getGameCount) {
        Game_Hero_Model hero = gameHeroRepository.findByUsername(currentUser.getUsername());
        Game_Fight_Model fight = gameFightRepository.findByUsername(currentUser.getUsername());
        hero.setHp(HERO_START_GAME_HP);


        if (isLevelUp && fight.getIsGameWithEquipments() == 1) {
            hero.setEnergy(hero.getEnergy() + hero.getEnergyRes());
            hero.setMana(hero.getMana() + hero.getManaRes());
            gameHeroRepository.save(hero);
            isLevelUp = false;
        }

        if (isGameUp) {
            hero.setEnergy(hero.getEnergy() + hero.getEnergyRes());
            hero.setMana(hero.getMana() + hero.getManaRes());
            gameHeroRepository.save(hero);
            isGameUp = false;
        }

        fight.setLevelDifficult(getLvlDifficult);
        fight.setLevelCount(getLevelCount);
        fight.setGameCount(getGameCount);

        Game_Creature_Model creature_game = new Game_Creature_Model();
        Game_Location_Model game_location = gameLocationRepository.findByUsername(currentUser.getUsername());
        BossesModel boss = bossesRepository.getOneRandomBoss();
        MobsModel mob = mobsRepository.getOneRandomMob();

        if (Optional.ofNullable(creature_game.getUsername()).isPresent()) {
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

    /**
     * This method changes characteristics of creatures, if game with equipments
     *
     * @param valueFromDataBase shows default characteristics from database
     * @return returns characteristics, adding difficult according to current level
     */
    private int setLvlDifficult(int valueFromDataBase) {
        int value = valueFromDataBase;
        int subtract = (valueFromDataBase * levelDifficult) / 100;
        value += subtract;
        return value;
    }

    /**
     * This method reduces default values from data for every level if game without equipments.
     *
     * @param valueFromDataBase shows default characteristics from database
     * @return returns characteristics, reduces difficult for every level
     * Setting table, there is all default values for game
     */
    private int reduceDifficulty(int valueFromDataBase) {
        int value = valueFromDataBase;
        int subtract = valueFromDataBase
                * (gameSettingRepository.getOne(1L).getGAME_WITHOUT_EQUIP_DIFFICULTY() * (-1)) / 100;
        value -= subtract;
        return value;
    }


}
