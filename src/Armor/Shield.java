package Armor;

import Main.Menu;
import Mobs.Main_Mob_Hero;

import java.util.Scanner;

public class Shield extends Main_Mob_Hero {

    private static int a;

    public Shield(String heroName, int heroHP, int defaultDamage, int minspelldamageHERO, int maxspellDamageHero, int increasesDamage, int restoreshealth, int chance, int mana) {
        super(heroName, heroHP, defaultDamage, minspelldamageHERO, maxspellDamageHero, increasesDamage, restoreshealth, chance, mana);
    }

    public void main_Shield() {
        int check = 0;
        while (check == 0) {
            if (heroName.equals("Mage")) {
                break;
            } else if (Equipment.getRess() >= 100 && Equipment.getRess() <= 140) {
                int info = createShield();
                System.out.println("You chose your Shield, that is + " + info + " to Health point ");
                System.out.print("Your Final Health point equal ");
                System.out.print(Equipment.getRess() + info);
                Equipment.setRess(Equipment.getRess() + info);
                break;
            } else {
                break;
            }
        }
    }

    private static int createShield() {
        String str = "\n\n Choose your Shield"
                + "\n    1. Steelforged Shield  (+11  to Health point)"
                + "\n    2. Truthguard (+23 to Health point)"
                + "\n    3. Not to choose this thing (+0 to Health point)"
                + "\n    4. Back to  Main Menu";
        System.out.println(str);
        Scanner scan = new Scanner(System.in);
        a = scan.nextInt();
        switch (a) {
            case 1: {
                a = 11;
                break;
            }
            case 2: {
                a = 23;
                break;
            }
            case 3: {
                a = 0;
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

