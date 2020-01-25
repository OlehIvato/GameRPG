package Main;

import Hero.Mage;
import Hero.Paladin;
import Hero.Warrior;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ChoseNewHero {

    public static void main() {

        Mage mage = new Mage("Mage", 90, 4, 35, 55,  19, 0, 87);
        Warrior warrior = new Warrior("Warrior", 167, 21, 0, 0,  0, 0, 0);
        Paladin paladin = new Paladin("Paladin", 110, 15, 17, 40,  35, 0, 105);

        System.out.println("\nChoose new Hero:");
        Map <Integer, Object> n = new HashMap <>();
        n.put(1, mage);
        n.put(2, warrior);
        n.put(3, paladin);
        for (Integer key : n.keySet()) {
            System.out.println(key + " | " + n.get(key));
        }
        Scanner s = new Scanner(System.in);
        switch (s.nextInt()) {
            case 1: {
                System.out.println("You chose: " + n.get(1));
                mage.Main();
                break;
            }
            case 2: {
                System.out.println("You chose: " + n.get(2));
                warrior.Main();
                break;
            }
            case 3: {
                System.out.println("You chose: " + n.get(3));
                paladin.Main();
                break;
            }
        }
    }
}