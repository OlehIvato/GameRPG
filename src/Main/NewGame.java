package Main;

import Сreature.Main_All;

import java.util.Scanner;

public class NewGame extends Main_All {

    public NewGame(String heroName, int heroHP, int defaultDamage, int minSpellDamageHERO, int maxSpellDamageHero, int restoreHealth, int chance, int mana) {
        super(heroName, heroHP, defaultDamage, minSpellDamageHERO, maxSpellDamageHero, restoreHealth, chance, mana);
    }

    public static void createHero() {
        System.out.println();
        String create = UserName.getUserName() + " would you like to create new Hero and play game ? \n " +
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
                System.exit(0);
                break;
            }
        }
    }
}