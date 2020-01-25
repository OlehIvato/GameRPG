package Сreature.Bosses;

import Fight.FightBoss;
import Сreature.MainBosses;
import Сreature.Main_Mob_Hero;

public class Ragnar_Lodbrok extends MainBosses {
    public Ragnar_Lodbrok(String nameBoss, int healthPointBoss, int min_DamageBoss, int max_DamageBoss, int increaseDamageBoss, int restoreHealthPointBoss, int chanceToSuperDamageBoss) {
        super(nameBoss, healthPointBoss, min_DamageBoss, max_DamageBoss, increaseDamageBoss, restoreHealthPointBoss, chanceToSuperDamageBoss);
    }

    public void fight() {

        Main_Mob_Hero.setName(getNameBoss());
        Main_Mob_Hero.setHealthPoint(Main_Mob_Hero.getHealthPoint() + getHealthPointBoss());
        Main_Mob_Hero.setMin_Damage(Main_Mob_Hero.getMin_Damage() + getMin_DamageBoss());
        Main_Mob_Hero.setMax_Damage(Main_Mob_Hero.getMax_Damage() + getMax_DamageBoss());
        Main_Mob_Hero.setIncreaseBoss(Main_Mob_Hero.getIncreaseBoss() + getIncreaseDamageBoss());
        Main_Mob_Hero.setRestoreBoss(Main_Mob_Hero.getRestoreBoss() + getRestoreHealthPointBoss());
        Main_Mob_Hero.setChanceToSuperDamageBOSS(Main_Mob_Hero.getChanceToSuperDamageBOSS() + getChanceToSuperDamageBoss());

        FightBoss f = new FightBoss();
        f.main();
    }
}

