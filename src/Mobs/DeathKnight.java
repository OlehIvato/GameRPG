package Mobs;

import Moving.Fight.Fight;

public class DeathKnight extends Main_Mob_Hero {
    public DeathKnight(String name, int healthpoint, int max_Damage, int min_Damage, int chanseToSuperDamageMob) {
        super(name, healthpoint, max_Damage, min_Damage, chanseToSuperDamageMob);
    }

    public void fight() {
        Fight fight  = new Fight( "Death King", 130, 25, 18,51);
        fight.main();
    }
}
