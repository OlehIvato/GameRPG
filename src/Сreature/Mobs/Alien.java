package Сreature.Mobs;

import Fight.Fight;
import Сreature.MainMobs;
import Сreature.Main_Mob_Hero;

public class Alien extends MainMobs {
    public Alien(String nameMOb, int healthpointMOb, int min_DamageMOb, int max_DamageMob, int chanceToSuperDamageMob) {
        super(nameMOb, healthpointMOb, min_DamageMOb, max_DamageMob, chanceToSuperDamageMob);
    }

    public void fight() {

        Main_Mob_Hero.setName(getNameMOb());
        Main_Mob_Hero.setHealthpoint(getHealthpointMOb());
        Main_Mob_Hero.setMin_Damage(getMin_DamageMOb());
        Main_Mob_Hero.setMax_Damage(getMax_DamageMob());
        Main_Mob_Hero.setChanseToSuperDamageMob(getChanceToSuperDamageMob());

        Fight fight = new Fight();
        fight.main();

    }
}
