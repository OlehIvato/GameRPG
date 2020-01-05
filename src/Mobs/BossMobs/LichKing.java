package Mobs.BossMobs;


import Mobs.Main_Mob_Hero;
import Moving.Fight.FightBossOFF;
import Moving.Fight.FightBossON;


public class LichKing extends Main_Mob_Hero {
    public LichKing(String name, int healthpoint, int max_Damage, int min_Damage, int increaseBoss, int restoreBoss, int chanseToSuperDamageBOSS) {
        super(name, healthpoint, max_Damage, min_Damage, increaseBoss, restoreBoss, chanseToSuperDamageBOSS);
    }

    public void fightON() {
        FightBossON f = new FightBossON("Lich King", 170, 34, 29, 0, 0, 24);
        f.main();
    }

    public void fightoff() {
        FightBossOFF f = new FightBossOFF("Lich King", 160, 25, 20, 0, 0, 15);
        f.main();
    }
}
