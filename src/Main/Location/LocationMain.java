package Main.Location;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LocationMain {

    public static void main() {
        Map <Integer, String> loc = new HashMap <>();
        System.out.println("Select location for the game:\n");
        Scanner s = new Scanner(System.in);
        loc.put(1, "JAPAN");
        loc.put(2, "AUSTRALIA");
        loc.put(3, "SCANDINAVIA");
        loc.put(4, "ICELAND");
        for (Integer key : loc.keySet()) {
            System.out.println(key + " - " + loc.get(key));
        }

        switch (s.nextInt()) {
            case 1: {
                System.out.println("You chose " + loc.get(1));
                Japan.main();
                break;
            }
            case 2: {
                System.out.println("You chose " + loc.get(2));
                Australia.main();
                break;
            }
            case 3: {
                System.out.println("You chose " + loc.get(3));
                Scandinavia.main();
                break;
            }
            case 4: {
                System.out.println("You chose " + loc.get(4));
                Iceland.main();
                break;
            }
        }


    }
}
