package Main.Location;

import Armor.Weapon;
import Mobs.MainCharactericticOfMobs;

import java.sql.SQLOutput;

public class Northrend extends MainCharactericticOfMobs {


    public Northrend(String heroName, int heroHP, int defaultDamage, int minspelldamageHERO, int maxspellDamageHero, int increasesDamage, int restoreshealth, int chance, int mana) {
        super(heroName, heroHP, defaultDamage, minspelldamageHERO, maxspellDamageHero, increasesDamage, restoreshealth, chance, mana);
    }

    public Northrend(String name, int healthpoint, int max_Damage, int min_Damage, int chanseToSuperDamageMob) {
        super(name, healthpoint, max_Damage, min_Damage, chanseToSuperDamageMob);
    }

    public Northrend(String name, int healthpoint, int max_Damage, int min_Damage, int increaseBoss, int restoreBoss, int chanseToSuperDamageBOSS) {
        super(name, healthpoint, max_Damage, min_Damage, increaseBoss, restoreBoss, chanseToSuperDamageBOSS);
    }


    public static void main() {

        heroHP -= 4;
        defaultDamage += 4;
        restoreshealth += 5;
        mana += 4;
        chanseToSuperDamageBOSS += 5;
        healthpoint -= 7;

        System.out.println(heroName + " statistics will change: ");
        System.out.println(" HP = -");
        System.out.println(" Damage = +" + defaultDamage);
        System.out.println(" Restoreshealth = +");
        System.out.println(" Mana = +");
        System.out.println("\n" + name + " statistics will change: ");
        System.out.println(" HP = -");
        System.out.println(" Chanse To Super Damage = +");
        System.out.println(" Healthpoint = -");


    }


}
