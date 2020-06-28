package game.primary;

import game.fight.LaunchGame;
import game.sql.EquipmentData;
import game.sql.HeroData;
import game.sql.LocationData;

import java.util.Scanner;

public class NewGame extends MainData {

    /**
     * This method has link to create new hero, create Equipments,
     * add location, then propose to save equipment and location
     * and get level and launch new game.
     * <p>
     * First of all, creating new hero, then method propose to select game with equipments or without,
     * if without, than just sets value that game is without equipments, gets first level and starting the game.
     * <p>
     * If with, sets value to that game is with equipments,
     * then goes to Equipment database,
     * then propose to select Location,
     * <p>
     * then gets first level and starting the game
     */
    public static void newGame() {
        HeroData.create();
        getEquipments();
        if (Setting.IS_GAME_WITH_EQUIPMENTS) {
            EquipmentData.createEquipments(heroArmor, heroClass);
            getLocation();
            save_Equipments_and_Location();
        }
        LaunchGame.getLevel(Setting.LEVEL_COUNT, Setting.LEVEL_DIFFICULT);
    }


    private static void getEquipments() {
        System.out.println("\n" + Setting.PLAYER_NAME + " do you wanna choose Armor and Weapon for " + heroName + " ?");
        System.out.println("1. Yes \n" +
                "2. No, play with standard characteristics.     (Creatures characteristics " + withOutEquipPercent + "% power)."
                + "\n3. Turn Back");
        switch (scanner.nextInt()) {
            case 1 -> Setting.IS_GAME_WITH_EQUIPMENTS = true;
            case 2 -> Setting.IS_GAME_WITH_EQUIPMENTS = false;
            case 3 -> newGame();
        }
    }

    private static void getLocation() {
        System.out.println("\n\nWould you like to select Location for Fight?  (it will change " + heroName + " and creatures characteristics)");
        System.out.println("1. Yes \n2. No, continue without Locations");
        switch (new Scanner(System.in).nextInt()) {
            case 1:
                LocationData.createLocation();
                break;
            case 2:
                break;
            default: {
                System.out.println("Something went wrong");
                getLocation();
            }
        }

    }

    private static void save_Equipments_and_Location() {
        System.out.println("Would you like to save your equipment and location?");
        System.out.println("1 Yes");
        System.out.println("2 No, Continue");
        switch (scanner.nextInt()) {
            case 1:
                Storage.saveFileToFolder(false);
            case 2:
        }
    }
}
