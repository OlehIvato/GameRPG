package spring.controller.gameController;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.model.Class;
import spring.model.Hero_Classes;
import spring.model.User;
import spring.model.gameModel.Game_Creature_Model;
import spring.model.gameModel.Game_Fight_Model;
import spring.model.gameModel.Game_Hero_Model;
import spring.model.gameModel.Game_SettingModel;
import spring.repository.BossesRepository;
import spring.repository.ClassRepository;
import spring.repository.Hero_ClassesRepository;
import spring.repository.MobsRepository;
import spring.repository.gameRepository.*;

import java.util.Random;

@Controller
@RequestMapping("game/fight/")

public class FightController {

    private final Game_CreatureRepository gameCreatureRepository;
    private final Game_HeroRepository gameHeroRepository;
    private final Game_SettingRepository settingRepository;
    private final Hero_ClassesRepository hero_classesRepository;
    private final ClassRepository classRepository;
    private final Game_FightRepository gameFightRepository;
    private final Game_SettingRepository gameSettingRepository;

    public FightController(Game_CreatureRepository gameCreatureRepository,
                           Game_HeroRepository gameHeroRepository,
                           Game_SettingRepository settingRepository,
                           Hero_ClassesRepository hero_classesRepository,
                           ClassRepository classRepository,
                           Game_FightRepository gameFightRepository,
                           Game_SettingRepository gameSettingRepository) {
        this.gameCreatureRepository = gameCreatureRepository;
        this.gameHeroRepository = gameHeroRepository;
        this.settingRepository = settingRepository;
        this.hero_classesRepository = hero_classesRepository;
        this.classRepository = classRepository;
        this.gameFightRepository = gameFightRepository;
        this.gameSettingRepository = gameSettingRepository;
    }

    private boolean HERO_HIT = false;
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
    private String mobNameVIew;


    @GetMapping("launch")
    public String launchGame(@AuthenticationPrincipal User currentUser, Model model) {
        Game_Fight_Model fight = gameFightRepository.findByUsername(currentUser.getUsername());
        Game_Hero_Model hero = gameHeroRepository.findByUsername(currentUser.getUsername());
        Game_Creature_Model mob = gameCreatureRepository.findByUsername(currentUser.getUsername());

        if (fight.getIsGameStarted() == 0) {
            HERO_HIT = false;
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
        model.addAttribute("currentUser", currentUser.getUsername());
        model.addAttribute("getLvlDifficult", fight.getLevelDifficult());
        model.addAttribute("getLevelCount", fight.getLevelCount());
        model.addAttribute("getGameCount", fight.getGameCount());
        model.addAttribute("isBoss", fight.getIsBoss());
        model.addAttribute("creature", gameCreatureRepository.findByUsername(currentUser.getUsername()));
        model.addAttribute("hero", gameHeroRepository.findByUsername(currentUser.getUsername()));
        model.addAttribute("index", settingRepository.getOne(1L));
        model.addAttribute("moveCount", MOVE_COUNT);
        model.addAttribute("isLose", YOU_LOSE);
        model.addAttribute("isHeal", isHeal);

        Hero_Classes hero_classes = hero_classesRepository.getOne(currentUser.getId());
        Class heroClass = classRepository.getOne(hero_classes.getClass_id());
        model.addAttribute("heroClass", heroClass.getClassName());

        if (HERO_HIT) {
            model.addAttribute("HERO_HIT",
                    "You hit " + mob.getName() + " on " + hero.getDamage() + " health point;");
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
        HERO_SPELL = false;
        HERO_HEAL = false;
        MOB_HIT = false;
        MOB_SUPER_DAMAGE = false;
        BOSS_LESS_HP = false;
        BOSS_RESTORE = false;
        YOU_WIN = false;
        YOU_LOSE = false;
        return "rpg/fight/fight";
    }


    @GetMapping("hero-move")
    public String heroMove(@AuthenticationPrincipal User currentUser, Model model) {
        Game_Hero_Model hero = gameHeroRepository.findByUsername(currentUser.getUsername());
        Game_Creature_Model mob = gameCreatureRepository.findByUsername(currentUser.getUsername());
        MOVE_COUNT++;
        mob.setHp(mob.getHp() - hero.getDamage());
        HERO_HIT = true;
        gameCreatureRepository.save(mob);
        return "redirect:/game/fight/mob-move";
    }

    @GetMapping("hero-spell")
    public String heroSpell(@AuthenticationPrincipal User currentUser, Model model) {
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

    @GetMapping("hero-heal")
    public String heroHEal(@AuthenticationPrincipal User currentUser, Model model) {
        Game_Hero_Model hero = gameHeroRepository.findByUsername(currentUser.getUsername());
        Game_Creature_Model mob = gameCreatureRepository.findByUsername(currentUser.getUsername());
        Game_SettingModel setting = gameSettingRepository.getOne(1L);
        MOVE_COUNT++;
        heroRestoreView = (hero.getRestore() + setting.getDEFAULT_RESTORE_HP_INDEX());
        hero.setHp(hero.getHp() + hero.getRestore() + setting.getDEFAULT_RESTORE_HP_INDEX());
        hero.setMana(hero.getMana() - setting.getDEFAULT_HEAL_CAST());
        isHeal = true;
        HERO_HEAL = true;
        gameCreatureRepository.save(mob);
        return "redirect:/game/fight/launch";
    }


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
        int superDamage = (int) (mob.getMaxDamage() * setting.getSUPER_DAMAGE());
        System.out.println(new Random().nextInt(100) < mob.getChanceToSuperDamage());
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
