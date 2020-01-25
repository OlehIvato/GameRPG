package Сreature.Mobs;

import Fight.Fight;
import Сreature.MainMobs;
import Сreature.Main_Mob_Hero;

public class DeathKnight extends MainMobs {
    public DeathKnight(String nameMOb, int healthPointMOb, int min_DamageMOb, int max_DamageMob, int chanceToSuperDamageMob) {
        super(nameMOb, healthPointMOb, min_DamageMOb, max_DamageMob, chanceToSuperDamageMob);
    }

    public void fight() {

        Main_Mob_Hero.setName(getNameMOb());
        Main_Mob_Hero.setHealthPoint(Main_Mob_Hero.getHealthPoint() + getHealthPointMOb());
        Main_Mob_Hero.setMin_Damage(Main_Mob_Hero.getMin_Damage() + getMin_DamageMOb());
        Main_Mob_Hero.setMax_Damage(Main_Mob_Hero.getMax_Damage() + getMax_DamageMob());
        Main_Mob_Hero.setChanceToSuperDamageMob(Main_Mob_Hero.getChanceToSuperDamageMob() + getChanceToSuperDamageMob());

        Fight fight = new Fight();
        fight.main();

    }
}