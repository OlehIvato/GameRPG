package game.Primary;

import game.sql.EquipmentDatabase;
import game.Fight.Levels;
import game.sql.HeroDatabase;
import game.sql.LocationDatabase;


import java.util.Scanner;

public class Game implements Levels {

    public static boolean isEquip;         // info about game with equipment, or without
    public static boolean isBoss;          // info about boss or no


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
        Levels.level_1_1();
        Levels.level_1_2();
        Levels.level_1_3();

        Levels.vs_boss();

        Levels.level_2_1();
        Levels.level_2_2();
        Levels.level_2_3();

        Levels.vs_boss();

        Levels.level_3_1();
        Levels.level_3_2();
        Levels.level_3_3();

        Levels.final_vs_boss();

        Levels.win();
    }
}
