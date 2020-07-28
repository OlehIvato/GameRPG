package spring.dto;

import lombok.Data;
import spring.model.gameModel.Game_Creature_Model;
import spring.model.gameModel.Game_Fight_Model;
import spring.model.gameModel.Game_Hero_Model;

@Data
public class Game_Creature_Hero_Fight_Dto {

    private String username;

    private String creatureName;
    private int creatureHp;
    private int creatureMinDamage;
    private int creatureMaxDamage;
    private int creatureRestoreHp;
    private int creatureChanceToSuperDamage;

    private String heroName;
    private Long heroHeroID;
    private int heroHp;
    private int heroDamage;
    private int heroEnergy;
    private int heroEnergyRes;
    private int heroMinSpell;
    private int heroMaxSpell;
    private int heroRestore;
    private int heroMana;
    private int heroManaRes;
    private Long heroHeroClass;
    private Long heroArmor;

    private int fightIsGameWithEquipments;
    private int fightIsBoss;
    private int fightIsGameStarted;
    private int fightGameCount;
    private int fightLevelCount;
    private int fightLevelDifficult;


    public Game_Creature_Hero_Fight_Dto(Game_Creature_Model creature, Game_Hero_Model hero, Game_Fight_Model fight) {
        this.username = creature.getUsername();
        this.username = hero.getUsername();
        this.username = fight.getUsername();

        this.creatureName = creature.getName();
        this.creatureHp = creature.getHp();
        this.creatureMinDamage = creature.getMinDamage();
        this.creatureMaxDamage = creature.getMaxDamage();
        this.creatureRestoreHp = creature.getRestoreHp();
        this.creatureChanceToSuperDamage = creature.getChanceToSuperDamage();

        this.heroName = hero.getName();
        this.heroHeroID = hero.getHeroID();
        this.heroHp = hero.getHp();
        this.heroDamage = hero.getDamage();
        this.heroEnergy = hero.getEnergy();
        this.heroEnergyRes = hero.getEnergyRes();
        this.heroMinSpell = hero.getMinSpell();
        this.heroMaxSpell = hero.getMaxSpell();
        this.heroRestore = hero.getRestore();
        this.heroMana = hero.getMana();
        this.heroManaRes = hero.getManaRes();
        this.heroHeroClass = hero.getHeroClass();
        this.heroArmor = hero.getArmor();

        this.fightIsGameWithEquipments = fight.getIsGameWithEquipments();
        this.fightIsBoss = fight.getIsBoss();
        this.fightIsGameStarted = fight.getIsGameStarted();
        this.fightGameCount = fight.getGameCount();
        this.fightLevelCount = fight.getLevelCount();
        this.fightLevelDifficult = fight.getLevelDifficult();


    }


}



