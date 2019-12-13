package Armor;

import Mobs.MainCharactericticOfMobs;
import Main.Menu;
import Main.NewHero;

import java.util.Scanner;

public class Weapon  extends MainCharactericticOfMobs {

    private static int a;
    private static int RET;

    public Weapon(String heroName, int heroHP, int defaultDamage, int minspelldamageHERO, int maxspellDamageHero, int increasesDamage, int restoreshealth) {
        super(heroName, heroHP, defaultDamage, minspelldamageHERO, maxspellDamageHero, increasesDamage, restoreshealth);
    }

    public static int getRET() {
        return RET;
    }
    public static int getA() {
        return a;
    }

    public  int main_WEAPON() {
        int result = createWeapon();
        System.out.println("You chose +" + result + " to Damage ");
        System.out.print("Your Final damage equal ");
        System.out.print(defaultDamage + result);
        RET = (defaultDamage + result);

        return RET;
    }

    private static int createWeapon() {
        String weap = " Choose your Weapon"
                + "\n    1. Daggers  (+7  to Damage)"
                + "\n    2. Crossbows  (+13  to Damage)"
                + "\n    3. Sword (+21 to Damage)"
                + "\n    4. Back to Main menu ";
        System.out.println(weap);
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
                Menu.mainMenu();
                break;
            }
        }
        return a;
    }


}
