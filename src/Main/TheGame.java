package Main;

import Armor.Equipment;
import Armor.Shield;
import Armor.Stick;
import Armor.Weapon;
import Fight.Levels;
import Fight.Winning;
import Location.LocationMain;
import Сreature.Mobs.Main_Mob_Hero;
import java.util.Scanner;

public class TheGame extends Main_Mob_Hero implements Levels {
    public TheGame(String heroName, int heroHP, int defaultDamage, int minspelldamageHERO, int maxspellDamageHero, int increasesDamage, int restoreshealth, int chance, int mana) {
        super(heroName, heroHP, defaultDamage, minspelldamageHERO, maxspellDamageHero, increasesDamage, restoreshealth, chance, mana);
    }

    public TheGame() {
    }

    private static int info;

    public static void setInfo(int info) {
        TheGame.info = info;
    }

    public static int getInfo() {
        return info;
    }

    public void createNewHero() {
        Equipment e = new Equipment(heroName, heroHP, defaultDamage, minspelldamageHERO, maxspellDamageHero, increasesDamage, restoreshealth, chance, mana);
        Weapon w = new Weapon(heroName, heroHP, defaultDamage, minspelldamageHERO, maxspellDamageHero, increasesDamage, restoreshealth, chance, mana);
        Stick s = new Stick(heroName, heroHP, defaultDamage, minspelldamageHERO, maxspellDamageHero, increasesDamage, restoreshealth, chance, mana);
        Shield sh = new Shield(heroName, heroHP, defaultDamage, minspelldamageHERO, maxspellDamageHero, increasesDamage, restoreshealth, chance, mana);

        Scanner scan = new Scanner(System.in);
        System.out.println("\n" + UserName.getUserNameIs() + " do you wanna choose Armor and Weapon for " + heroName + " ?");
        String cases = "\n1. Yes \n" +
                "2. No, Play with Standard Characteristics:"
                + "\n3. Turn Back  \n";
        System.out.println(cases);
        switch (scan.nextInt()) {
            case 1: {

                info = 1;

                e.mainEquip();
                w.main_WEAPON();
                s.main_Stick();
                sh.main_Shield();

                LocationMain.location();

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

                LocationMain.location();

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
