package Mobs;

import Moving.Fight.Fight;

public class Alien extends Main_Mob_Hero {
    public Alien(String name, int healthpoint, int max_Damage, int min_Damage, int chanseToSuperDamageMob) {
        super(name, healthpoint, max_Damage, min_Damage, chanseToSuperDamageMob);
    }


    public void fight() {
        Fight fight = new Fight( "Alien", 105, 60, 28,34);
        fight.main();
    }
}
