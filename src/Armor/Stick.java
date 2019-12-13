package Armor;

import Main.Menu;
import Mobs.MainCharactericticOfMobs;

import java.util.Scanner;

public class Stick extends MainCharactericticOfMobs {
    private static int a;
    private static int result;

    public Stick(String heroName, int heroHP, int defaultDamage, int minspelldamageHERO, int maxspellDamageHero, int increasesDamage, int restoreshealth, int chance, int mana) {
        super(heroName, heroHP, defaultDamage, minspelldamageHERO, maxspellDamageHero, increasesDamage, restoreshealth, chance, mana);
    }

    public static int getA() {
        return a;
    }

    public static int getResult() {
        return result;
    }

    public int main_Stick() {
        int result = createStick();
        System.out.println("You chose +" + result + " to Damage ");
        System.out.print("Your Final damage equal ");
        System.out.print(mana + result);
        result = (mana + result);
        return result;
    }


    private static int createStick() {
        String weap = " Choose your Stick"
                + "\n    1. Arcanite Stick  (+13  to Mana)"
                + "\n    2. Helcular's Stick  (+21  to Mana)"
                + "\n    3. Golden Stick (+35 to Mana)"
                + "\n    4. Not to choose this thing (+0 to Mana)"
                + "\n    5. Back to  Main Menu";
        System.out.println(weap);
        Scanner scan = new Scanner(System.in);
        a = scan.nextInt();
        switch (a) {
            case 1: {
                a = 5;
                break;
            }
            case 2: {
                a = 11;
                break;
            }
            case 3: {
                a = 18;
                break;
            }
            case 4: {
                a = 0;
            }
            case 5: {
                Menu.mainMenu();
                break;
            }
        }
        return a;
    }
}
