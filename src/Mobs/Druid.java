package Mobs;
import Moving.Fight.Fight;

public class Druid extends Main_Mob_Hero {
    public Druid(String name, int healthpoint, int max_Damage, int min_Damage, int chanseToSuperDamageMob) {
        super(name, healthpoint, max_Damage, min_Damage, chanseToSuperDamageMob);
    }

    public void fight() {
        Fight fight = new Fight("Druid", 115, 54, 37, 37);
        fight.main();
    }



}

