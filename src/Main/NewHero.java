package Main;

import Armor.Equipment;
import Armor.Weapon;
import Mobs.MainCharactericticOfMobs;
import Moving.Fight.Level;
import Moving.Fight.Winning;

import java.util.Scanner;

public class NewHero extends MainCharactericticOfMobs {
    public NewHero(String heroName, int heroHP, int defaultDamage, int minspelldamageHERO, int maxspellDamageHero, int increasesDamage, int restoreshealth) {
        super(heroName, heroHP, defaultDamage, minspelldamageHERO, maxspellDamageHero, increasesDamage, restoreshealth);
    }


    public void createNewHero() {
        Equipment e = new Equipment(heroName, heroHP, defaultDamage, minspelldamageHERO, maxspellDamageHero, increasesDamage, restoreshealth);
        Weapon w = new Weapon(heroName, heroHP, defaultDamage, minspelldamageHERO, maxspellDamageHero, increasesDamage, restoreshealth);

        Scanner scan = new Scanner(System.in);

        System.out.println("\n  "+UserName.getUserNameIs() + " do you wanna choose Armor and Weapon for your " + heroName+" ?");
        String cases = "\n  1. Yes \n" +
                "  2. No.  Play with Standart Characteristics:"
                + "\n  3. Turn Back  \n";
        System.out.println(cases);
        String characteristics = "          HP = " + heroHP +
                "\n          Damage = " + defaultDamage +
                "\n          Min Spell Damage = " + minspelldamageHERO +
                "\n          Max Spell Damage = " + maxspellDamageHero +
                "\n          Plus to restore Healthpoint = " + restoreshealth;
        System.out.println(characteristics);
        switch (scan.nextInt()) {
            case 1: {

                e.mainEquip();
                w.main_WEAPON();

                Level.level_1_1();
                Level.level_1_2();
                Level.level_1_3();

                Level.level_2_1();
                Level.level_2_2();
                Level.level_2_3();

                Level.level_3_1();
                Level.level_3_2();
                Level.level_3_3();

                Level.fight_vs_boss();

                Winning.win();

                break;

            }
            case 2: {
                Level.level_1_1_NOequip();
                Level.level_1_2_NOequip();
                Level.level_1_3_NOequip();

                Level.level_2_1_NOequip();
                Level.level_2_2_NOequip();
                Level.level_2_3_NOequip();

                Level.level_3_1_NOequip();
                Level.level_3_2_NOequip();
                Level.level_3_3_NOequip();

                Level.fight_vs_boss_without_equip();

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
