package Main;


import Main.EnumTestPac.ENUM;
import Main.EnumTestPac.EnumCases;
import Mobs.Main_Mob_Hero;

import java.util.Scanner;

public class NewGame extends Main_Mob_Hero {

    public NewGame(String heroName, int heroHP, int defaultDamage, int minspelldamageHERO, int maxspellDamageHero, int increasesDamage, int restoreshealth, int chance, int mana) {
        super(heroName, heroHP, defaultDamage, minspelldamageHERO, maxspellDamageHero, increasesDamage, restoreshealth, chance, mana);
    }

    public static void createHero() {
        System.out.println();
        EnumCases.TestEnum(ENUM.STARTGAME);
        String create = "\nWould you like to create new Hero and play game ? \n " +
                "1. Yes \n " +
                "2. No (exit) ";
        System.out.println(create);
        Scanner scan = new Scanner(System.in);
        switch (scan.nextInt()) {
            case 1: {
                ChoseNewHero.main();
                break;
            }
            case 2: {
                System.err.println("Exit");
                EnumCases.TestEnum(ENUM.FINISHED);
                System.exit(0);
                break;
            }
        }

    }
}