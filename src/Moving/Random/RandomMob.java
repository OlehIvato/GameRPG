package Moving.Random;

import Mobs.*;

import java.util.Random;

public class RandomMob extends MainCharactericticOfMobs {

    public RandomMob(String name, int healthpoint, int max_Damage, int min_Damage, int chanseToSuperDamageMob) {
        super(name, healthpoint, max_Damage, min_Damage, chanseToSuperDamageMob);
    }

    public static void  get_random_mob() {
        Random random = new Random();

        Pudge pudge = new Pudge(name, healthpoint, max_Damage, min_Damage, chanseToSuperDamageMob);
        Alien alien = new Alien(name, healthpoint, max_Damage, min_Damage, chanseToSuperDamageMob);
        Druid druid = new Druid(name, healthpoint, max_Damage, min_Damage, chanseToSuperDamageMob);
        DeathKnight deathKnight = new DeathKnight(name, healthpoint, max_Damage, min_Damage, chanseToSuperDamageMob);
        Ork ork = new Ork(name, healthpoint, max_Damage, min_Damage, chanseToSuperDamageMob);
        Pig pig = new Pig(name, healthpoint, max_Damage, min_Damage, chanseToSuperDamageMob);

        switch (random.nextInt(6)) {
            case 0: {
                pudge.fightON();
                break;
            }
            case 1: {
                pig.fightON();
                break;
            }
            case 2: {
                ork.fightON();
                break;
            }
            case 3: {
                druid.fightON();
                break;
            }
            case 4: {
                alien.fightON();
                break;
            }
            case 5: {
                deathKnight.fightON();
                break;
            }
        }
    }
}




