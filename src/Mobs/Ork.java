package Mobs;

import Moving.Fight.Fight;

public class Ork extends Main_Mob_Hero {
    public Ork(String name, int healthpoint, int max_Damage, int min_Damage, int chanseToSuperDamageMob) {
        super(name, healthpoint, max_Damage, min_Damage, chanseToSuperDamageMob);
    }

    public void fight() {
        Fight fight = new Fight("Ork", 114, 28, 27, 38);
        fight.main();
    }

}



