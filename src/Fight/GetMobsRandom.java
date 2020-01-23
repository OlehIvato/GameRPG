package Fight;

import Сreature.Bosses.CaptainPrice;
import Сreature.Bosses.LichKing;
import Сreature.Bosses.Ragnar_Lodbrok;
import Сreature.Mobs.*;
import java.util.Random;

public class GetMobsRandom {
    public static void random() {
        Random random = new Random();

        Pudge pudge = new Pudge("Pudge", 120, 34, 27, 56);
        Alien alien = new Alien( "Alien", 105, 60, 28,34);
        Druid druid = new Druid("Druid", 115, 54, 37, 37);
        DeathKnight deathKnight = new DeathKnight( "Death King", 130, 25, 18,51);
        Pig pig = new Pig( "Pig", 110, 29, 20,43);
        Ork ork = new Ork("Ork", 114, 28, 27, 38);

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

    public static void random_Boss() {
        Random random = new Random();

        CaptainPrice captainPrice = new CaptainPrice("Captain Price", 137, 45, 35, 14, 9, 44);
        LichKing lichKing = new LichKing("Lich King", 170, 34, 29, 0, 6, 24);
        Ragnar_Lodbrok ragnar_lodbrok = new Ragnar_Lodbrok("Ragnar Lodbrok", 124, 67, 35, 7, 14, 35);

        switch (random.nextInt(3)) {
            case 0:
                captainPrice.fight();
                break;
            case 1:
                lichKing.fight();
                break;
            case 2:
                ragnar_lodbrok.fight();
                break;
        }
    }
}
