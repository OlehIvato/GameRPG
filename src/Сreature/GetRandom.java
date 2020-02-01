package Сreature;

import Сreature.Bosses.CaptainPrice;
import Сreature.Bosses.LichKing;
import Сreature.Bosses.Ragnar_Lodbrok;
import Сreature.Mobs.*;

import java.util.Random;

public class GetRandom {
    private static Random random = new Random();

    public static int changer(int a) {
        int value = a;
        int subtract = (a * Main_All.getDefaultPercent()) / 100;
        value -= subtract;
        return value;
    }

    public static void random() {
        Pudge pudge = new Pudge("Pudge", 120, 27, 34, 56);
        Alien alien = new Alien("Alien", 105, 28, 60, 34);
        Druid druid = new Druid("Druid", 115, 37, 54, 37);
        DeathKnight deathKnight = new DeathKnight("Death King", 130, 18, 25, 51);
        Pig pig = new Pig("Pig", 110, 20, 29, 43);
        Ork ork = new Ork("Ork", 114, 29, 29, 38);
        switch (random.nextInt(6)) {
            case 0:
                pudge.fightMob();
                break;
            case 1:
                pig.fightMob();
                break;
            case 2:
                ork.fightMob();
                break;
            case 3:
                druid.fightMob();
                break;
            case 4:
                alien.fightMob();
                break;
            case 5:
                deathKnight.fightMob();
                break;
        }
    }

    public static void random_Boss() {
        CaptainPrice captainPrice = new CaptainPrice("Captain Price", 137, 35, 45, 14, 44);
        LichKing lichKing = new LichKing("Lich King", 170, 30, 35, 4, 24);
        Ragnar_Lodbrok ragnar_lodbrok = new Ragnar_Lodbrok("Ragnar Lodbrok", 124, 35, 68, 7, 35);
        switch (random.nextInt(3)) {
            case 0:
                captainPrice.fightBoss();
                break;
            case 1:
                lichKing.fightBoss();
                break;
            case 2:
                ragnar_lodbrok.fightBoss();
                break;
        }
    }
}
