package Main.Location;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LocationMain {
    public static void location() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\nWould you like to select Location for fight ?  it change your characteristics");
        System.out.println("1. Yes \n2. No, continue without Locations");
        switch (scanner.nextInt()) {
            case 1:
                LocationMain.main();
                break;
            case 2:
                break;
        }
    }

    public static void main() {
        Map <Integer, String> loc = new HashMap <>();
        System.out.println("Select location for the game:\n");
        Scanner s = new Scanner(System.in);
        loc.put(1, "Northrend -     HP +8, Spell Damage + 14, Damage -5, Restore Health +5");
        loc.put(2, "Kalimdor -      HP +2, Spell Damage + 9, Damage + 14, Restore Health -16");
        loc.put(3, "Azeroth -       HP -9, Spell Damage -5, Damage - 3, Restore Health +15" );
        loc.put(4, "Isle of Dread - HP -13, Spell Damage + 14, Damage + 9, Restore Health -9");
        for (Integer key : loc.keySet()) {
            System.out.println(key + " - " + loc.get(key));
        }
        switch (s.nextInt()) {
            case 1: {
                System.out.println("You chose " + loc.get(1));
                Northrend.main();
                break;
            }
            case 2: {
                System.out.println("You chose " + loc.get(2));
                Kalimdor.main();
                break;
            }
            case 3: {
                System.out.println("You chose " + loc.get(3));
                Azeroth.main();
                break;
            }
            case 4: {
                System.out.println("You chose " + loc.get(4));
                IsleofDread.main();
                break;
            }
        }
    }
}
