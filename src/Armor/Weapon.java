package Armor;

import Main.Menu;
import Сreature.Main_Mob_Hero;

import java.util.Scanner;

public class Weapon extends Main_Mob_Hero {

    private static int a;
    private static int RET;

    public Weapon(String heroName, int heroHP, int defaultDamage, int minSpellDamageHERO, int maxSpellDamageHero, int restoreHealth, int chance, int mana) {
        super(heroName, heroHP, defaultDamage, minSpellDamageHERO, maxSpellDamageHero, restoreHealth, chance, mana);
    }

    public static int getRET() {
        return RET;
    }

    public static void setRET(int RET) {
        Weapon.RET = RET;
    }

    private int checkPoint = 0;

    public int main_WEAPON() {
        while (checkPoint == 0) {
            if (heroName.equals("Mage") || heroName.equals("Paladin")) {
                break;
            } else {
                int result = createWeapon();
                System.out.println("You chose +" + result + " to Damage ");
                System.out.print("Your Final damage equal ");
                System.out.print(defaultDamage + result);
                RET = (defaultDamage + result);
                break;
            }
        }
        return RET;
    }

    private static int createWeapon() {
        String weap = "\nChoose your Weapon"
                + "\n    1. Daggers  (+7  to Damage)"
                + "\n    2. Crossbows  (+13  to Damage)"
                + "\n    3. Sword (+21 to Damage)"
                + "\n    4. Not to choose this thing (+0 to Healthpoint)"
                + "\n    5. Back to  Main Menu";
        System.out.println(weap + "\n");
        Scanner scan = new Scanner(System.in);
        a = scan.nextInt();
        switch (a) {
            case 1: {
                a = 7;
                break;
            }
            case 2: {
                a = 13;
                break;
            }
            case 3: {
                a = 21;
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