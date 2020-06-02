package game.primary;

import game.sql.EquipmentData;
import game.fight.Level;
import game.sql.HeroData;
import game.sql.LocationData;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

public class Game {
    private static final Scanner scanner = new Scanner(System.in);

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
            System.out.println("Main Menu \n 1. New Game \n 2. Upload saved game \n 3. Exit".toUpperCase());
            switch (new Scanner(System.in).nextInt()) {
                case 1:
                    if (!Optional.ofNullable(getUserName()).isPresent()) {
                        System.out.println("What is your name ? ");
                        userName = new Scanner(System.in).nextLine();
                    }



                    String create = "\n" + userName + ", select next option:\n" +
                            "1. Create new Hero \n" +
                            "2. Upload saved equipped hero, and play new game \n" +
                            "3. Back";
                    System.out.println(create);
                    switch (scanner.nextInt()) {
                        case 1:
                            Game.createNewHero();
                            break;
                        case 2:
                            Storage.get(false);
                            break;
                        case 3:
                            Game.menu();
                            break;
                    }
                    break;
                case 2:
                    Storage.get(true);
                    break;
                case 3:
                    System.err.println("Exit");
                    System.exit(0);
                    break;
            }
        } catch (NullPointerException | InputMismatchException | IllegalArgumentException e) {
            System.out.println("Something went wrong\n");
            menu();
        }

    }


    public static void createNewHero() {
        HeroData.create();
        System.out.println("\n" + Game.getUserName() + " do you wanna choose Armor and Weapon for " + TheMain.getHeroName() + " ?");
        System.out.println("1. Yes \n" +
                "2. No, play with standard characteristics.     (Creatures characteristics minus " + TheMain.getDefaultPercent() + "% power)."
                + "\n3. Turn Back");
        switch (scanner.nextInt()) {
            case 1: {
                isEquip = true;
                EquipmentData.createEquipment(TheMain.getHeroArmor(), TheMain.getHeroClass());
                LocationData.createLocation();
                System.out.println("Would you like to save your equipment and location?");
                System.out.println("1 Yes");
                System.out.println("2 No, Сontinue");
                switch (scanner.nextInt()) {
                    case 1:
                        Storage.save(false);
                    case 2:
                }
                break;
            }
            case 2:
                isEquip = false;
                break;
            case 3:
                createNewHero();
                break;
        }
        Level.getLevel(TheMain.getLevelCount(), TheMain.getLevelDifficult());
    }

}