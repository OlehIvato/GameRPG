package Armor;

import Main.Menu;
import Main.Main_All;
import java.util.Scanner;

public class Stick {

    public static void main() {
        while (true) {
            if (Main_All.getHeroName().equals("Mage") || Main_All.getHeroName().equals("Paladin")) {
                int getMana = createStick();
                System.out.println("You chose +" + getMana + " to Mana ");
                System.out.print("Your Final Mana equal ");
                System.out.print(Main_All.getMana() + getMana);
                Main_All.setMana(Main_All.getMana() + getMana);
                break;
            } else
                break;
        }
    }

    private static int createStick() {
        String weap = "\n\nChoose your Stick"
                + "\n    1. Arcanite Stick  (+13  to Mana)"
                + "\n    2. Helcular's Stick  (+21  to Mana)"
                + "\n    3. Golden Stick (+35 to Mana)"
                + "\n    4. Not to choose this thing (+0 to Mana)"
                + "\n    5. Back to  Main Menu";
        System.out.println(weap);
        Scanner scan = new Scanner(System.in);
        int result;
        switch (result = scan.nextInt()) {
            case 1:
                result = 13;
                break;
            case 2:
                result = 21;
                break;
            case 3:
                result = 35;
                break;
            case 4:
                result = 0;
                break;
            case 5:
                Menu.menu();
                break;
        }
        return result;
    }
}