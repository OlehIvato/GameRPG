package Mobs.BossMobs;

import Mobs.Main_Mob_Hero;
import Moving.Fight.FightBoss;

public class CaptainPrice extends Main_Mob_Hero {
    public CaptainPrice(String name, int healthpoint, int max_Damage, int min_Damage, int increaseBoss, int restoreBoss, int chanseToSuperDamageBOSS) {
        super(name, healthpoint, max_Damage, min_Damage, increaseBoss, restoreBoss, chanseToSuperDamageBOSS);
    }

    public void fight() {
        FightBoss f = new FightBoss("Captain Price", 137, 45, 35, 14, 9, 44);
        f.main();
    }

}
