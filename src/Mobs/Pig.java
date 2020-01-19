package Mobs;

import Moving.Fight.Fight;

public class Pig extends  Main_Mob_Hero{
    public Pig(String name, int healthpoint, int max_Damage, int min_Damage, int chanseToSuperDamageMob) {
        super(name, healthpoint, max_Damage, min_Damage, chanseToSuperDamageMob);
    }

    public void fight() {
        Fight fight = new Fight( "Pig", 110, 29, 20,43);
        fight.main();
    }

}
