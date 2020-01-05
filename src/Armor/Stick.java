package Armor;

import Main.Menu;

import Mobs.Main_Mob_Hero;

import java.util.Scanner;

public class Stick extends Main_Mob_Hero {
    private static int a;
    private static int result;

    public Stick(String heroName, int heroHP, int defaultDamage, int minspelldamageHERO, int maxspellDamageHero, int increasesDamage, int restoreshealth, int chance, int mana) {
        super(heroName, heroHP, defaultDamage, minspelldamageHERO, maxspellDamageHero, increasesDamage, restoreshealth, chance, mana);
    }

    public static int getResult() {
        return result;
    }

    public int main_Stick() {
        int info = createStick();
        System.out.println("You chose +" + info + " to Mana ");
        System.out.print("Your Final Mana equal ");
        System.out.print(mana + info);
        result = (mana + info);
        return result;
    }


    private static int createStick() {
        String weap = "\n\n Choose your Stick"
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
                a = 13;
                break;
            }
            case 2: {
                a = 21;
                break;
            }
            case 3: {
                a = 35;
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
