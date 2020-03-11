package game.Primary;

import game.sql.EquipmentDatabase;
import game.Fight.Level;
import game.sql.HeroDatabase;
import game.sql.LocationDatabase;


import java.util.Scanner;

public class Game implements Level {

    public static boolean isEquip;         // info about game with equipment, or without
    public static boolean isBoss;          // info about boss or no

    private static int lvl1;
    private static int lvl2 = 10;
    private static int lvl3 = 15;
    private static int lvl4 = 20;
    private static int lvl5 = 25;
    private static int lvl6 = 30;
    private static int lvl7 = 35;
    private static int lvl8 = 40;
    private static int lvl9 = 45;
    private static int lvl10 = 50;

    public void createNewHero() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n" + UserName.getUserName() + " do you wanna choose Armor and Weapon for " + Main_All.getHeroName() + " ?");
        String cases = "1. Yes \n" +
                "2. No, play with standard characteristics.     (Creatures characteristics minus " + Main_All.getDefaultPercent() + "% power)."
                + "\n3. Turn Back";
        System.out.println(cases);
        switch (scan.nextInt()) {
            case 1: {
                isEquip = true;
                EquipmentDatabase.equipmentMain();
                LocationDatabase.main();
                break;
            }
            case 2:
                isEquip = false;
                break;
            case 3:
                HeroDatabase.main();
                break;
        }

        Level.mob(lvl1, level1, gameFirst);
        Level.mob(lvl1, level1, gameSecond);
        Level.mob(lvl1, level1, gameThird);
        Level.boss(lvl1, fightVsBoss, gameVsBoss);

        Level.mob(lvl2, level2, gameFirst);
        Level.mob(lvl2, level2, gameSecond);
        Level.mob(lvl2, level2, gameThird);
        Level.boss(lvl2, fightVsBoss, gameVsBoss);

        Level.mob(lvl3, level3, gameFirst);
        Level.mob(lvl3, level3, gameSecond);
        Level.mob(lvl3, level3, gameThird);
        Level.boss(lvl3, fightVsBoss, gameVsBoss);

        Level.boss(lvl3, fightFinalVsBoss, gameVsBoss);

        Level.win();
    }
}