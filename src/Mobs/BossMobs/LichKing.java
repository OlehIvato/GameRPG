package Mobs.BossMobs;

import Mobs.Main_Mob_Hero;
import Moving.Fight.FightBoss;

public class LichKing extends Main_Mob_Hero {
    public LichKing(String name, int healthpoint, int max_Damage, int min_Damage, int increaseBoss, int restoreBoss, int chanseToSuperDamageBOSS) {
        super(name, healthpoint, max_Damage, min_Damage, increaseBoss, restoreBoss, chanseToSuperDamageBOSS);
    }

    public void fight() {
        FightBoss f = new FightBoss("Lich King", 170, 34, 29, 0, 6, 24);
        f.main();
    }

}
