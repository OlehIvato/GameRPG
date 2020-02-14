package Armor;

import Main.Main;
import Main.Main_All;
import java.util.Scanner;

public class Shield {

    public static void main() {
        while (true) {
            if (Main_All.getHeroName().equals("Mage")) {
                break;
            } else if (Main_All.getHeroHP() >= 100 && Main_All.getHeroHP() <= 152) {
                int info = createShield();
                System.out.println("You chose your Shield, that is + " + info + " to Health point ");
                System.out.print("Your Final Health point equal ");
                System.out.print(Main_All.getHeroHP() + info);
                Main_All.setHeroHP(Main_All.getHeroHP() + info);
                break;
            } else
                break;
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
        int result;
        switch (result = scan.nextInt()) {
            case 1:
                result = 11;
                break;
            case 2:
                result = 23;
                break;
            case 3:
                result = 0;
                break;
            case 4:
                Main.menu();
                break;
        }
        return result;
    }
}