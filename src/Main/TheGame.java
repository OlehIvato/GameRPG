package Main;

import Armor.Equipment;
import Armor.Shield;
import Armor.Stick;
import Armor.Weapon;
import Fight.Levels;
import Fight.Winning;
import Location.MainLocation;
import Сreature.Main_All;

import java.util.Scanner;

public class TheGame extends Main_All implements Levels {
    public TheGame() {
    }

    private static int info;         // info about game with equipment, or without

    public static int getInfo() {
        return info;
    }

    public void createNewHero() {
        Equipment e = new Equipment(heroName, heroHP, defaultDamage, minSpellDamageHERO, maxSpellDamageHero, restoreHealth, chance, mana);
        Weapon w = new Weapon(heroName, heroHP, defaultDamage, minSpellDamageHERO, maxSpellDamageHero, restoreHealth, chance, mana);
        Stick s = new Stick(heroName, heroHP, defaultDamage, minSpellDamageHERO, maxSpellDamageHero, restoreHealth, chance, mana);
        Shield sh = new Shield(heroName, heroHP, defaultDamage, minSpellDamageHERO, maxSpellDamageHero, restoreHealth, chance, mana);

        Scanner scan = new Scanner(System.in);
        System.out.println("\n" + UserName.getUserName() + " do you wanna choose Armor and Weapon for " + heroName + " ?");
        String cases = "1. Yes \n" +
                "2. No, play with standard characteristics.     (Creatures characteristics minus " + Main_All.getDefaultPercent() + "% power)."
                + "\n3. Turn Back";
        System.out.println(cases);
        MainLocation mainLocation = new MainLocation();
        switch (scan.nextInt()) {
            case 1: {

                info = 1;

                e.mainEquip();
                w.main_WEAPON();
                s.main_Stick();
                sh.main_Shield();

                mainLocation.main();

                Levels.level_1_1();
                Levels.level_1_2();
                Levels.level_1_3();

                Levels.vs_boss();

                Levels.level_2_1();
                Levels.level_2_2();
                Levels.level_2_3();

                Levels.vs_boss();

                Levels.level_3_1();
                Levels.level_3_2();
                Levels.level_3_3();

                Levels.final_vs_boss();

                Winning.win();

                break;

            }
            case 2: {

                info = 2;

                // MainLocation.location();

                Levels.level_1_1();
                Levels.level_1_2();
                Levels.level_1_3();

                Levels.vs_boss();

                Levels.level_2_1();
                Levels.level_2_2();
                Levels.level_2_3();

                Levels.vs_boss();

                Levels.level_3_1();
                Levels.level_3_2();
                Levels.level_3_3();

                Levels.final_vs_boss();

                Winning.win();
                break;
            }
            case 3: {
                ChoseNewHero.main();
                break;
            }
        }
    }
}
