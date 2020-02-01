package Armor;

import Main.Main;
import Сreature.Main_All;

import java.util.Scanner;

public class Weapon {

    public static void main() {
        while (true) {
            if (Main_All.getHeroName().equals("Mage") || Main_All.getHeroName().equals("Paladin")) {
                break;
            } else {
                int result = createWeapon();
                System.out.println("You chose +" + result + " to Damage ");
                System.out.print("Your Final damage equal ");
                System.out.print(Main_All.getDefaultDamage() + result);
                Main_All.setDefaultDamage(Main_All.getDefaultDamage() + result);
                break;
            }
        }
    }

    private static int createWeapon() {
        String weapon = "\nChoose your Weapon"
                + "\n    1. Daggers  (+7  to Damage)"
                + "\n    2. Crossbows  (+13  to Damage)"
                + "\n    3. Sword (+21 to Damage)"
                + "\n    4. Not to choose this thing (+0 to Health Point)"
                + "\n    5. Back to Main Menu";
        System.out.println(weapon + "\n");
        Scanner scan = new Scanner(System.in);
        int result;
        switch (result = scan.nextInt()) {
            case 1:
                result = 7;
                break;
            case 2:
                result = 13;
                break;
            case 3:
                result = 21;
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