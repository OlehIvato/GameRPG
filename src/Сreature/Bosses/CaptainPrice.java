package Сreature.Bosses;

import Fight.FightBoss;
import Сreature.MainBosses;
import Сreature.Main_Mob_Hero;

public class CaptainPrice extends MainBosses {
    public CaptainPrice(String nameBoss, int healthpointBoss, int min_DamageBoss, int max_DamageBoss, int increaseDamageBoss, int restoreHealthPointBoss, int chanceToSuperDamageBoss) {
        super(nameBoss, healthpointBoss, min_DamageBoss, max_DamageBoss, increaseDamageBoss, restoreHealthPointBoss, chanceToSuperDamageBoss);
    }

    public void fight() {

        Main_Mob_Hero.setName(getNameBoss());
        Main_Mob_Hero.setHealthpoint(getHealthpointBoss());
        Main_Mob_Hero.setMin_Damage(getMin_DamageBoss());
        Main_Mob_Hero.setMax_Damage(getMax_DamageBoss());
        Main_Mob_Hero.setIncreaseBoss(getIncreaseDamageBoss());
        Main_Mob_Hero.setRestoreBoss(getRestoreHealthPointBoss());
        Main_Mob_Hero.setChanseToSuperDamageBOSS(getChanceToSuperDamageBoss());

        FightBoss f = new FightBoss();
        f.main();
    }
}
