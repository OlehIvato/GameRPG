package Mobs.BossMobs;

import Mobs.Main_Mob_Hero;
import Moving.Fight.FightBoss;

public class Ragnar_Lodbrok extends Main_Mob_Hero {
    public Ragnar_Lodbrok(String name, int healthpoint, int max_Damage, int min_Damage, int increaseBoss, int restoreBoss, int chanseToSuperDamageBOSS) {
        super(name, healthpoint, max_Damage, min_Damage, increaseBoss, restoreBoss, chanseToSuperDamageBOSS);
    }

    public void fight() {
        FightBoss f = new FightBoss("Ragnar Lodbrok", 124, 67, 35, 7, 14, 35);
        f.main();
    }



}