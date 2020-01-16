package Main;


import Main.Hero.Mage;
import Main.Hero.Paladin;
import Main.Hero.Warrior;
import Mobs.Main_Mob_Hero;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ChoseNewHero extends Main_Mob_Hero {

    public ChoseNewHero(String heroName, int heroHP, int defaultDamage, int minspelldamageHERO, int maxspellDamageHero, int increasesDamage, int restoreshealth, int chance, int mana) {
        super(heroName, heroHP, defaultDamage, minspelldamageHERO, maxspellDamageHero, increasesDamage, restoreshealth, chance, mana);
    }

    public static void main() {

        Mage m = new Mage(heroName, heroHP, defaultDamage, minspelldamageHERO, maxspellDamageHero, increasesDamage, restoreshealth, chance, mana);
        Warrior w = new Warrior(heroName, heroHP, defaultDamage, minspelldamageHERO, maxspellDamageHero, increasesDamage, restoreshealth, chance, mana);
        Paladin p = new Paladin(heroName, heroHP, defaultDamage, minspelldamageHERO, maxspellDamageHero, increasesDamage, restoreshealth, chance, mana);

        System.out.println("\nChoose new hero:");
        Map <Integer, String> n = new HashMap <>();
        n.put(1, "Mage");
        n.put(2, "Warrior");
        n.put(3, "Paladin");
        for (Integer key : n.keySet()) {
            System.out.println(key + " | " + n.get(key));
        }
        Scanner s = new Scanner(System.in);
        switch (s.nextInt()) {
            case 1: {
                System.out.println("You chose: " + n.get(1));
                m.Main();
                break;
            }
            case 2: {
                System.out.println("You chose: " + n.get(2));
                w.Main();
                break;
            }
            case 3: {
                System.out.println("You chose: " + n.get(3));
                p.Main();
                break;
            }
        }
    }
}

