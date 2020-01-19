package Mobs;

import Moving.Fight.Fight;


public class Pudge extends Main_Mob_Hero {
    public Pudge(String name, int healthpoint, int max_Damage, int min_Damage, int chanseToSuperDamageMob) {
        super(name, healthpoint, max_Damage, min_Damage, chanseToSuperDamageMob);
    }

    public void fight() {
        Fight fight = new Fight("Pudge", 120, 34, 27, 56);
        fight.main();
    }

}
