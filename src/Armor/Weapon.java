package Armor;


import Main.Menu;
import Mobs.Main_Mob_Hero;

import java.util.Scanner;

public class Weapon extends Main_Mob_Hero {

    private static int a;
    private static int RET;

    public Weapon(String heroName, int heroHP, int defaultDamage, int minspelldamageHERO, int maxspellDamageHero, int increasesDamage, int restoreshealth, int chance, int mana) {
        super(heroName, heroHP, defaultDamage, minspelldamageHERO, maxspellDamageHero, increasesDamage, restoreshealth, chance, mana);
    }

    public static int getRET() {
        return RET;
    }

    public static void setRET(int RET) {
        Weapon.RET = RET;
    }

    public int main_WEAPON() {
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
                + "\n    4. Not to choose this thing (+0 to Healthpoint)"
                + "\n    5. Back to  Main Menu";
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
