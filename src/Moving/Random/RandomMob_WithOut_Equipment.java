package Moving.Random;

import Mobs.*;
import java.util.Random;

public class RandomMob_WithOut_Equipment extends  Main_Mob_Hero {

    public RandomMob_WithOut_Equipment(String name, int healthpoint, int max_Damage, int min_Damage, int chanseToSuperDamageMob) {
        super(name, healthpoint, max_Damage, min_Damage, chanseToSuperDamageMob);
    }

    public static int get_random_mob_WITHOUT() {

        Pudge pudge = new Pudge(name, healthpoint, max_Damage, min_Damage, chanseToSuperDamageMob);
        Alien alien = new Alien(name, healthpoint, max_Damage, min_Damage, chanseToSuperDamageMob);
        Druid druid = new Druid(name, healthpoint, max_Damage, min_Damage, chanseToSuperDamageMob);
        DeathKnight deathKnight = new DeathKnight(name, healthpoint, max_Damage, min_Damage, chanseToSuperDamageMob);
        Ork ork = new Ork(name, healthpoint, max_Damage, min_Damage, chanseToSuperDamageMob);
        Pig pig = new Pig(name, healthpoint, max_Damage, min_Damage, chanseToSuperDamageMob);

        Random random = new Random();
        int Case;
        Case = random.nextInt(6);
        switch (Case) {
            case 0:
                ork.fightOff();
                break;
            case 1:
                pig.fightOff();
                break;
            case 2:
               pudge.fightOff();
                break;
            case 3:
                druid.fightOff();
                break;
            case 4:
                alien.fightOff();
                break;
            case 5:
                deathKnight.fightOff();
                break;
        }
        return Case;
    }
}
