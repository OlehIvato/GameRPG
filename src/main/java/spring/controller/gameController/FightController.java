package spring.controller.gameController;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.dto.Game_Creature_Hero_Fight_Dto;
import spring.model.databaseModel.Class;
import spring.model.User;
import spring.model.gameModel.Game_Creature_Model;
import spring.model.gameModel.Game_Fight_Model;
import spring.model.gameModel.Game_Hero_Model;
import spring.model.gameModel.Game_SettingModel;
import spring.repository.ClassRepository;
import spring.repository.gameRepository.*;

import java.util.Random;

@Controller
@RequestMapping("game/fight/")
public class FightController {

    private final Game_CreatureRepository gameCreatureRepository;
    private final Game_HeroRepository gameHeroRepository;
    private final Game_SettingRepository settingRepository;
    private final ClassRepository classRepository;
    private final Game_FightRepository gameFightRepository;
    private final Game_SettingRepository gameSettingRepository;

    public FightController(Game_CreatureRepository gameCreatureRepository,
                           Game_HeroRepository gameHeroRepository,
                           Game_SettingRepository settingRepository,
                           ClassRepository classRepository,
                           Game_FightRepository gameFightRepository,
                           Game_SettingRepository gameSettingRepository) {
        this.gameCreatureRepository = gameCreatureRepository;
        this.gameHeroRepository = gameHeroRepository;
        this.settingRepository = settingRepository;
        this.classRepository = classRepository;
        this.gameFightRepository = gameFightRepository;
        this.gameSettingRepository = gameSettingRepository;
    }

    private boolean HERO_HIT = false;
    private boolean HERO_ENERGY_HIT = false;
    private boolean HERO_SPELL = false;
    private boolean HERO_HEAL = false;
    private boolean MOB_HIT = false;
    private boolean MOB_SUPER_DAMAGE = false;
    private boolean BOSS_LESS_HP = false;
    private boolean BOSS_RESTORE = false;
    private boolean isHeal = false;

    private boolean YOU_WIN = false;
    private boolean YOU_LOSE = false;
    private int MOVE_COUNT = 0;

    private int mobDamageView;
    private int heroSpellView;
    private int heroRestoreView;
    private int heroEnergyHitView;
    private String mobNameVIew;

    /**
     * This method make fight page, the whole description according to the hero and the creatures movements.
     *
     * @param currentUser needed to know for which user the game is.
     * @param model       to show whole descriptions in jsp page
     * @return returns fight page
     */
    @GetMapping("launch")
    public String launchGame(@AuthenticationPrincipal User currentUser, Model model) {
        Game_Fight_Model fight = gameFightRepository.findByUsername(currentUser.getUsername());
        Game_Hero_Model hero = gameHeroRepository.findByUsername(currentUser.getUsername());
        Game_Creature_Model mob = gameCreatureRepository.findByUsername(currentUser.getUsername());

        if (fight.getIsGameStarted() == 0) {
            HERO_HIT = false;
            HERO_ENERGY_HIT = false;
            HERO_SPELL = false;
            HERO_HEAL = false;
            MOB_HIT = false;
            MOB_SUPER_DAMAGE = false;
            BOSS_LESS_HP = false;
            BOSS_RESTORE = false;
            YOU_WIN = false;
            YOU_LOSE = false;
            isHeal = false;
            MOVE_COUNT = 0;
        }
        fight.setIsGameStarted(1);
        gameFightRepository.save(fight);

        model.addAttribute("CHF",
                new Game_Creature_Hero_Fight_Dto(
                        gameCreatureRepository.findByUsername(currentUser.getUsername()),
                        gameHeroRepository.findByUsername(currentUser.getUsername()),
                        gameFightRepository.findByUsername(currentUser.getUsername())));

        model.addAttribute("index", settingRepository.getOne(1L));
        model.addAttribute("moveCount", MOVE_COUNT);
        model.addAttribute("isLose", YOU_LOSE);
        model.addAttribute("isHeal", isHeal);
        Class heroClass = classRepository.getOne(hero.getHeroClass());
        model.addAttribute("heroClass", heroClass.getClassName());

        if (HERO_HIT) {
            model.addAttribute("HERO_HIT",
                    "You hit " + mob.getName() + " on " + hero.getDamage() + " health point;");
        }
        if (HERO_ENERGY_HIT) {
            model.addAttribute("HERO_ENERGY_HIT",
                    "You hit " + mob.getName() + " on " + heroEnergyHitView + " health point using Energy");
        }
        if (HERO_SPELL) {
            model.addAttribute("HERO_SPELL",
                    "You Hit " + mob.getName() + " using spell on " + heroSpellView + " health point");
        }
        if (MOB_HIT) {
            model.addAttribute("MOB_HIT",
                    mob.getName() + " Hits you on " + mobDamageView + " health point;");
        }
        if (HERO_HEAL) {
            model.addAttribute("HERO_HEAL", "You have restored " + heroRestoreView + " health points");
        }
        if (MOB_SUPER_DAMAGE) {
            model.addAttribute("MOB_SUPER_DAMAGE",
                    mob.getName() + " uses Super Damage");
        }
        if (BOSS_LESS_HP) {
            model.addAttribute("BOSS_LESS_HP",
                    mob.getName() + " Have less than 30 hp, his damage will be increased like a super damage");
        }
        if (BOSS_RESTORE) {
            model.addAttribute("BOSS_RESTORE", mob.getName() + " recover " + mob.getRestoreHp() + " health point");
        }
        if (YOU_WIN) {
            model.addAttribute("YOU_WIN", "You have won over the " + mobNameVIew);
            model.addAttribute("NEW_CREATURE", "Now you play against " + mob.getName());
        }
        if (YOU_LOSE) {
            model.addAttribute("YOU_LOSE", "You were defeated by " + mobNameVIew);
        }

        isHeal = false;
        HERO_HIT = false;
        HERO_ENERGY_HIT = false;
        HERO_SPELL = false;
        HERO_HEAL = false;
        MOB_HIT = false;
        MOB_SUPER_DAMAGE = false;
        BOSS_LESS_HP = false;
        BOSS_RESTORE = false;
        YOU_WIN = false;
        YOU_LOSE = false;
        return "rpg/fight";
    }

    /**
     * This method for simple hit of the hero
     *
     * @param currentUser needed to know for which user the game is.
     * @return returns movement of the creature
     */
    @GetMapping("hero-hit")
    public String heroHit(@AuthenticationPrincipal User currentUser) {
        Game_Hero_Model hero = gameHeroRepository.findByUsername(currentUser.getUsername());
        Game_Creature_Model mob = gameCreatureRepository.findByUsername(currentUser.getUsername());
        MOVE_COUNT++;
        mob.setHp(mob.getHp() - hero.getDamage());
        HERO_HIT = true;
        gameCreatureRepository.save(mob);
        return "redirect:/game/fight/mob-move";
    }


    /**
     * This method for energy hit of the hero
     *
     * @param currentUser needed to know for which user the game is.
     * @return returns movement of the creature
     */
    @GetMapping("hero-energy_hit")
    public String heroEnergyHit(@AuthenticationPrincipal User currentUser) {
        Game_Hero_Model hero = gameHeroRepository.findByUsername(currentUser.getUsername());
        Game_Creature_Model mob = gameCreatureRepository.findByUsername(currentUser.getUsername());
        Game_SettingModel setting = gameSettingRepository.getOne(1L);
        MOVE_COUNT++;
        int energyHit = hero.getDamage() * setting.getENERGY_MULTIPLY_INDEX();
        heroEnergyHitView = energyHit;
        mob.setHp(mob.getHp() - energyHit);
        hero.setEnergy(hero.getEnergy() - setting.getENERGY_HIT_INDEX());
        HERO_ENERGY_HIT = true;
        gameHeroRepository.save(hero);
        gameCreatureRepository.save(mob);
        return "redirect:/game/fight/mob-move";
    }

    /**
     * This method for spell hit of the hero
     *
     * @param currentUser needed to know for which user the game is.
     * @return returns movement of the creature
     */
    @GetMapping("hero-spell")
    public String heroSpell(@AuthenticationPrincipal User currentUser) {
        Game_Hero_Model hero = gameHeroRepository.findByUsername(currentUser.getUsername());
        Game_Creature_Model mob = gameCreatureRepository.findByUsername(currentUser.getUsername());
        MOVE_COUNT++;
        int randomSpell = (int) ((Math.random() * (hero.getMaxSpell() - hero.getMinSpell())) + hero.getMinSpell());
        mob.setHp(mob.getHp() - randomSpell);
        heroSpellView = randomSpell;
        HERO_SPELL = true;
        gameCreatureRepository.save(mob);
        return "redirect:/game/fight/mob-move";
    }


    /**
     * This Method for healing of the hero
     *
     * @param currentUser needed to know for which user the game is.
     * @return returns fight page to show information on the monitor
     */
    @GetMapping("hero-heal")
    public String heroHEal(@AuthenticationPrincipal User currentUser) {
        Game_Hero_Model hero = gameHeroRepository.findByUsername(currentUser.getUsername());
        Game_Creature_Model mob = gameCreatureRepository.findByUsername(currentUser.getUsername());
        Game_SettingModel setting = gameSettingRepository.getOne(1L);
        MOVE_COUNT++;
        heroRestoreView = (hero.getRestore() + setting.getRESTORE_HP_INDEX());
        hero.setHp(hero.getHp() + hero.getRestore() + setting.getRESTORE_HP_INDEX());
        hero.setMana(hero.getMana() - setting.getHEAL_CAST_INDEX());
        isHeal = true;
        HERO_HEAL = true;
        gameCreatureRepository.save(mob);
        return "redirect:/game/fight/launch";
    }


    /**
     * This method for the creature, here is its damage for hero, super damage etc.
     *
     * @param currentUser needed to know for which user the game is.
     * @return returns fight page to show information on the monitor
     */
    @GetMapping("mob-move")
    public String mobMove(@AuthenticationPrincipal User currentUser) {
        Game_Hero_Model hero = gameHeroRepository.findByUsername(currentUser.getUsername());
        Game_Creature_Model mob = gameCreatureRepository.findByUsername(currentUser.getUsername());
        Game_Fight_Model fight = gameFightRepository.findByUsername(currentUser.getUsername());
        Game_SettingModel setting = gameSettingRepository.getOne(1L);

        if (mob.getHp() <= 0) {
            YOU_WIN = true;
            mobNameVIew = mob.getName();
            return "redirect:/game/level/get";
        }
        if (fight.getIsBoss() == 1) {
            BOSS_RESTORE = true;
            mob.setHp(mob.getHp() + mob.getRestoreHp());
        }
        int result;
        int damage = (int) ((Math.random() * (mob.getMaxDamage() - mob.getMinDamage())) + mob.getMinDamage());
        int superDamage = (int) (mob.getMaxDamage() * setting.getSUPER_DAMAGE_MULTIPLY_INDEX());
        if (new Random().nextInt(100) < mob.getChanceToSuperDamage()) {
            MOB_SUPER_DAMAGE = true;
            MOB_HIT = true;
            mobDamageView = superDamage;
            result = superDamage;
        } else if (fight.getIsBoss() == 1 && mob.getHp() < 30) {
            BOSS_LESS_HP = true;
            MOB_HIT = true;
            mobDamageView = superDamage;
            result = superDamage;
        } else {
            MOB_HIT = true;
            mobDamageView = damage;
            result = damage;
        }
        hero.setHp(hero.getHp() - result);
        gameHeroRepository.save(hero);
        if (hero.getHp() <= 0) {
            YOU_LOSE = true;
            mobNameVIew = mob.getName();
            return "redirect:/game/fight/launch";
        }
        return "redirect:/game/fight/launch";
    }

}
