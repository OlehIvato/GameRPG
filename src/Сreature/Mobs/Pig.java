package Сreature.Mobs;

import Fight.Fight;
import Сreature.MainMobs;

public class Pig extends MainMobs {
    public Pig(String nameMOb, int healthpointMOb, int min_DamageMOb, int max_DamageMob, int chanceToSuperDamageMob) {
        super(nameMOb, healthpointMOb, min_DamageMOb, max_DamageMob, chanceToSuperDamageMob);
    }

    public void fight() {

        Сreature.Mobs.Main_Mob_Hero.setName(getNameMOb());
        Сreature.Mobs.Main_Mob_Hero.setHealthpoint(getHealthpointMOb());
        Сreature.Mobs.Main_Mob_Hero.setMin_Damage(getMin_DamageMOb());
        Сreature.Mobs.Main_Mob_Hero.setMax_Damage(getMax_DamageMob());
        Сreature.Mobs.Main_Mob_Hero.setChanseToSuperDamageMob(getChanceToSuperDamageMob());

        Fight fight = new Fight();
        fight.main();

    }
}