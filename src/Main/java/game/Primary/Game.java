package game.primary;

import game.fight.Saving;
import game.sql.EquipmentDatabase;
import game.fight.Level;
import game.sql.HeroDatabase;
import game.sql.LocationDatabase;


import java.util.Scanner;

public class Game {
    private static Scanner scanner = new Scanner(System.in);

    public static boolean isEquip;         // info about game with equipment, or without
    public static boolean isBoss;          // info about game with boss, or without

    public void createNewHero() {
        System.out.println("\n" + UserName.getUserName() + " do you wanna choose Armor and Weapon for " + Main_All.getHeroName() + " ?");
        String cases = "1. Yes \n" +
                "2. No, play with standard characteristics.     (Creatures characteristics minus " + Main_All.getDefaultPercent() + "% power)."
                + "\n3. Turn Back";
        System.out.println(cases);
        switch (scanner.nextInt()) {
            case 1: {
                isEquip = true;
                EquipmentDatabase.equipmentMain();
                LocationDatabase.main();
                System.out.println("Would you like to save your past savings?");
                System.out.println("1 Yes");
                System.out.println("2 No, Сontinue");
                switch (scanner.nextInt()) {
                    case 1:
                        Saving.saveCharacteristics();
                    case 2:
                }
                break;
            }
            case 2:
                isEquip = false;
                break;
            case 3:
                HeroDatabase.main();
                break;
        }
        Level.getLevel();
    }
}