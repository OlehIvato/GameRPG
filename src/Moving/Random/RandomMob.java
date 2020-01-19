package Moving.Random;

import Mobs.*;

import java.util.Random;

public class RandomMob extends Main_Mob_Hero {

    public RandomMob(String name, int healthpoint, int max_Damage, int min_Damage, int chanseToSuperDamageMob) {
        super(name, healthpoint, max_Damage, min_Damage, chanseToSuperDamageMob);
    }

    public static void random() {
        Random random = new Random();

        Pudge pudge = new Pudge(name, healthpoint, max_Damage, min_Damage, chanseToSuperDamageMob);
        Alien alien = new Alien(name, healthpoint, max_Damage, min_Damage, chanseToSuperDamageMob);
        Druid druid = new Druid(name, healthpoint, max_Damage, min_Damage, chanseToSuperDamageMob);
        DeathKnight deathKnight = new DeathKnight(name, healthpoint, max_Damage, min_Damage, chanseToSuperDamageMob);
        Ork ork = new Ork(name, healthpoint, max_Damage, min_Damage, chanseToSuperDamageMob);
        Pig pig = new Pig(name, healthpoint, max_Damage, min_Damage, chanseToSuperDamageMob);

        switch (random.nextInt(6)) {
            case 0: {
                pudge.fight();
                break;
            }
            case 1: {
                pig.fight();
                break;
            }
            case 2: {
                ork.fight();
                break;
            }
            case 3: {
                druid.fight();
                break;
            }
            case 4: {
                alien.fight();
                break;
            }
            case 5: {
                deathKnight.fight();
                break;
            }
        }
    }
}






