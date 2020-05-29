package game.primary;

import game.sql.EquipmentDatabase;
import game.fight.Level;
import game.sql.HeroDatabase;
import game.sql.LocationDatabase;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    private static Scanner scanner = new Scanner(System.in);

    public static boolean isEquip;         // info about game with equipment, or without
    public static boolean isBoss;          // info about game with boss, or without
    private static String userName;        // name of player

    static void setUserName(String userName) {
        Game.userName = userName;
    }

    public static String getUserName() {
        return userName;
    }


    public static void menu() {
        try {
            String menu = "Main Menu \n 1. New Game \n 2. Exit";
            System.out.println(menu.toUpperCase());
            switch (new Scanner(System.in).nextInt()) {
                case 1:
                    if (getUserName() == null) {
                        System.out.println("What is your name ? ");
                        userName = new Scanner(System.in).nextLine();
                    }
                    String create = "\n" + Game.getUserName() + ", select next option:\n" +
                            "1. Create new Hero \n" +
                            "2. Upload saved equipped hero, and play new game \n" +
                            "3. Upload saved game, and continue \n" +
                            "4. Exit";
                    System.out.println(create);
                    switch (scanner.nextInt()) {
                        case 1:
                            HeroDatabase.createHero();
                            break;
                        case 2:
                            Saving.get(false);
                            break;
                        case 3:
                            Saving.get(true);
                            break;
                        case 4:
                            System.err.println("Exit");
                            System.exit(0);
                            break;
                    }
                    break;
                case 2:
                    System.err.println("Exit");
                    System.exit(0);
                    break;
            }
        } catch (NullPointerException | InputMismatchException | IllegalArgumentException e) {
            System.out.println("Something went wrong\n");
            menu();
        }

    }


    public void createNewHero() {
        System.out.println("\n" + Game.getUserName() + " do you wanna choose Armor and Weapon for " + TheMain.getHeroName() + " ?");
        String cases = "1. Yes \n" +
                "2. No, play with standard characteristics.     (Creatures characteristics minus " + TheMain.getDefaultPercent() + "% power)."
                + "\n3. Turn Back";
        System.out.println(cases);
        switch (scanner.nextInt()) {
            case 1: {
                isEquip = true;
                EquipmentDatabase.createEquipment(TheMain.getHeroArmor(), TheMain.getHeroClass());
                LocationDatabase.createLocation();
                System.out.println("Would you like to save your equipment and location?");
                System.out.println("1 Yes");
                System.out.println("2 No, Сontinue");
                switch (scanner.nextInt()) {
                    case 1:
                        Saving.save(false);
                    case 2:
                }
                break;
            }
            case 2:
                isEquip = false;
                break;
            case 3:
                HeroDatabase.createHero();
                break;
        }
        Level.getLevel(TheMain.getLevelCount(), TheMain.getLevelDifficult());
    }

}