package Armor;

import Main.Menu;
import Mobs.Main_Mob_Hero;
import java.util.Scanner;

public class Equipment extends Main_Mob_Hero {

    public Equipment(String heroName, int heroHP, int defaultDamage, int minspelldamageHERO, int maxspellDamageHero, int increasesDamage, int restoreshealth, int chance, int mana) {
        super(heroName, heroHP, defaultDamage, minspelldamageHERO, maxspellDamageHero, increasesDamage, restoreshealth, chance, mana);
    }

    private static int ress;

    public static int getRess() {
        return ress;
    }

    public static void setRess(int ress) {
        Equipment.ress = ress;
    }

    public int mainEquip() {

        int result1;
        int result2;
        int result3;
        int result4;

        result1 = createArmor();
        System.out.println("You chose +" + result1 + " to Healthpoint ");
        result2 = creatFeetArmor();
        System.out.println("You chose +" + result2 + " to Healthpoint ");
        result3 = creatHeadArmor();
        System.out.println("You chose +" + result3 + " to Healthpoint ");
        result4 = creatBootsArmor();
        System.out.println("You chose +" + result4 + " to Healthpoint ");
        System.out.print("\nYour final Healthpoint equal ");
        System.out.print(result1 + result2 + result3 + result4 + heroHP);
        ress = (result1 + result2 + result3 + result4 + heroHP);
        System.out.println();
        return ress;
    }

    private static int createArmor() {
        String cases = "\nChoose Chest Armor: " +
                "\n   1. Cloth  (+7 to Healthpoint) " +
                "\n   2. Leather (+15 to Healthpoint)" +
                "\n   3. Steel (+22 to Healthpoint) " +
                "\n   4. Not to choose this thing (+0 to Healthpoint)" +
                "\n   5. Back to  Main Menu";
        System.out.println(cases);
        Scanner scan = new Scanner(System.in);
        int a;
        a = scan.nextInt();
        switch (a) {
            case 1: {
                a = 7;
                break;
            }
            case 2: {
                a = 15;
                break;
            }
            case 3: {
                a = 22;
                break;
            }
            case 4: {
                a = 0;
                break;
            }
            case 5: {
                Menu.mainMenu();
                break;
            }
        }
        return a;
    }

    private static int creatFeetArmor() {
        String cases = "\nChoose Feet Armor: " +
                "\n   1. Boots  (+6  to Healthpoint) " +
                "\n   2. Cloth Slippers  (+11  to Healthpoint)" +
                "\n   3. Boots of Wrought Shadow  (+17 to Healthpoint) " +
                "\n   4. Not to choose this thing (+0 to Healthpoint)" +
                "\n   5. Back to  Main Menu";
        System.out.println(cases);
        Scanner scan = new Scanner(System.in);
        int a = 0;
        a = scan.nextInt();
        switch (a) {
            case 1: {
                a = 6;
                break;
            }
            case 2: {
                a = 11;
                break;
            }
            case 3: {
                a = 17;
                break;
            }
            case 4: {
                a = 0;
                break;
            }
            case 5: {
                Menu.mainMenu();
                break;
            }
        }
        return a;
    }

    private static int creatHeadArmor() {
        String cases = "\nChoose Head Armor: " +
                "\n   1. Farseer's Mask (+2  to Healthpoint) " +
                "\n   2. Mail Helm  (+5  to Healthpoint)" +
                "\n   3. Shadowsong Vengeance Helm  (+11 to Healthpoint) " +
                "\n   4. Not to choose this thing (+0 to Healthpoint)" +
                "\n   5. Back to  Main Menu";
        System.out.println(cases);
        Scanner scan = new Scanner(System.in);
        int a = 0;
        a = scan.nextInt();
        switch (a) {
            case 1: {
                a = 2;
                break;
            }
            case 2: {
                a = 5;
                break;
            }
            case 3: {
                a = 11;
                break;
            }
            case 4: {
                a = 0;
                break;
            }
            case 5: {
                Menu.mainMenu();
                break;
            }
        }
        return a;
    }

    private static int creatBootsArmor() {
        String cases = "\nChoose Boots: " +
                "\n   1. Albino Crocscale Boots (+2  to Healthpoint) " +
                "\n   2. Veteran's Leather Boots  (+4  to Healthpoint)" +
                "\n   3. Fathomstalker Boots  (+6 to Healthpoint) " +
                "\n   4. Not to choose this thing (+0 to Healthpoint)" +
                "\n   5. Back to  Main Menu";
        System.out.println(cases);
        Scanner scan = new Scanner(System.in);
        int a = 0;
        a = scan.nextInt();
        switch (a) {
            case 1: {
                a = 2;
                break;
            }
            case 2: {
                a = 4;
                break;
            }
            case 3: {
                a = 6;
                break;
            }
            case 4: {
                a = 0;
                break;
            }
            case 5: {
                Menu.mainMenu();
                break;
            }
        }
        return a;
    }
}


