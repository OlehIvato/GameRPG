package Mobs.BossMobs;


import Mobs.Main_Mob_Hero;
import Moving.Fight.FightBossOFF;
import Moving.Fight.FightBossON;

public class CaptainPrice extends Main_Mob_Hero {
    public CaptainPrice(String name, int healthpoint, int max_Damage, int min_Damage, int increaseBoss, int restoreBoss, int chanseToSuperDamageBOSS) {
        super(name, healthpoint, max_Damage, min_Damage, increaseBoss, restoreBoss, chanseToSuperDamageBOSS);
    }

    public void fightON() {
        FightBossON f = new FightBossON("Captain Price", 137, 45, 35, 14, 9, 44);
        f.main();
    }

    public void fightoff() {
        FightBossOFF f = new FightBossOFF("Captain Price", 125, 40, 30, 14, 9, 29);
        f.main();
    }
}
