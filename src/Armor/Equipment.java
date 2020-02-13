package Armor;

import Main.Main;
import Main.Main_All;
import java.util.Scanner;

public class Equipment {

    private static Scanner scan = new Scanner(System.in);
    private static int result;

    public static void main() {

        int armor;
        int feet;
        int head;
        int boots;

        armor = createArmor();
        System.out.println("You chose +" + armor + " to Health Point ");
        feet = createFeetArmor();
        System.out.println("You chose +" + feet + " to Health Point ");
        head = createHeadArmor();
        System.out.println("You chose +" + head + " to Health Point ");
        boots = createBootsArmor();
        System.out.println("You chose +" + boots + " to Health Point ");
        System.out.print("\nYour final Health Point equal ");
        System.out.print(armor + feet + head + boots + Main_All.getHeroHP());
        Main_All.setHeroHP(armor + feet + head + boots + Main_All.getHeroHP());
        System.out.println();
    }

    private static int createArmor() {
        String cases = "\nChoose Chest Armor: " +
                "\n   1. Cloth  (+7 to Health Point) " +
                "\n   2. Leather (+15 to Health Point)" +
                "\n   3. Steel (+22 to Health Point) " +
                "\n   4. Not to choose this thing (+0 to Health Point)" +
                "\n   5. Back to  Main Menu";
        System.out.println(cases);
        switch (result = scan.nextInt()) {
            case 1:
                result = 7;
                break;
            case 2:
                result = 15;
                break;
            case 3:
                result = 22;
                break;
            case 4:
                result = 0;
                break;
            case 5:
                Main.menu();
                break;
        }
        return result;
    }

    private static int createFeetArmor() {
        String cases = "\nChoose Feet Armor: " +
                "\n   1. Boots  (+6  to Health Point) " +
                "\n   2. Cloth Slippers  (+11  to Health Point)" +
                "\n   3. Boots of Wrought Shadow  (+17 to Health Point) " +
                "\n   4. Not to choose this thing (+0 to Health Point)" +
                "\n   5. Back to  Main Menu";
        System.out.println(cases);
        switch (result = scan.nextInt()) {
            case 1:
                result = 6;
                break;
            case 2:
                result = 11;
                break;
            case 3:
                result = 17;
                break;
            case 4:
                result = 0;
                break;
            case 5:
                Main.menu();
                break;
        }
        return result;
    }

    private static int createHeadArmor() {
        String cases = "\nChoose Head Armor: " +
                "\n   1. Farseer's Mask (+2  to Health Point) " +
                "\n   2. Mail Helm  (+5  to Health Point)" +
                "\n   3. Shadowsong Vengeance Helm  (+11 to Health Point) " +
                "\n   4. Not to choose this thing (+0 to Health Point)" +
                "\n   5. Back to  Main Menu";
        System.out.println(cases);
        switch (result = scan.nextInt()) {
            case 1:
                result = 2;
                break;
            case 2:
                result = 5;
                break;
            case 3:
                result = 11;
                break;
            case 4:
                result = 0;
                break;
            case 5:
                Main.menu();
                break;
        }
        return result;
    }

    private static int createBootsArmor() {
        String cases = "\nChoose Boots: " +
                "\n   1. Albino Crocscale Boots (+2  to Health Point) " +
                "\n   2. Veteran's Leather Boots  (+4  to Health Point)" +
                "\n   3. Fathomstalker Boots  (+6 to Health Point) " +
                "\n   4. Not to choose this thing (+0 to Health Point)" +
                "\n   5. Back to  Main Menu";
        System.out.println(cases);
        switch (result = scan.nextInt()) {
            case 1:
                result = 2;
                break;
            case 2:
                result = 4;
                break;
            case 3:
                result = 6;
                break;
            case 4:
                result = 0;
                break;
            case 5:
                Main.menu();
                break;
        }
        return result;
    }
}