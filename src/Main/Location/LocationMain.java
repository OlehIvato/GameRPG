package Main.Location;

import java.util.*;

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
        List <Value> list = new ArrayList <>();
        System.out.println("Select location for the game:\n");
        Scanner scanner = new Scanner(System.in);

        list.add(new Value(1, "Northrend", "HP +8, Spell Damage + 14, Damage -5, Restore Health +5"));
        list.add(new Value(2, "Kalimdor", "HP +2, Spell Damage + 9, Damage + 14, Restore Health -16"));
        list.add(new Value(3, "Azeroth", "HP -9, Spell Damage -5, Damage - 3, Restore Health +15"));
        list.add(new Value(4, "Isle of Dread", "HP -13, Spell Damage + 14, Damage + 9, Restore Health -9"));

        list.stream().forEach(s -> System.out.println(s));
        switch (scanner.nextInt()) {
            case 1: {
                System.out.println("You chose " + list.get(0));
                Northrend.main();
                break;
            }
            case 2: {
                System.out.println("You chose " + list.get(1));
                Kalimdor.main();
                break;
            }
            case 3: {
                System.out.println("You chose " + list.get(2));
                Azeroth.main();
                break;
            }
            case 4: {
                System.out.println("You chose " + list.get(3));
                IsleofDread.main();
                break;
            }
        }

//        Map <Integer, String> loc = new HashMap <>();
//        System.out.println("Select location for the game:\n");
//        Scanner s = new Scanner(System.in);
//        loc.put(1, "Northrend -     HP +8, Spell Damage + 14, Damage -5, Restore Health +5");
//        loc.put(2, "Kalimdor -      HP +2, Spell Damage + 9, Damage + 14, Restore Health -16");
//        loc.put(3, "Azeroth -       HP -9, Spell Damage -5, Damage - 3, Restore Health +15");
//        loc.put(4, "Isle of Dread - HP -13, Spell Damage + 14, Damage + 9, Restore Health -9");
//        for (Integer key : loc.keySet()) {
//            System.out.println(key + " - " + loc.get(key));
//        }
//        switch (s.nextInt()) {
//            case 1: {
//                System.out.println("You chose " + loc.get(1));
//                Northrend.main();
//                break;
//            }
//            case 2: {
//                System.out.println("You chose " + loc.get(2));
//                Kalimdor.main();
//                break;
//            }
//            case 3: {
//                System.out.println("You chose " + loc.get(3));
//                Azeroth.main();
//                break;
//            }
//            case 4: {
//                System.out.println("You chose " + loc.get(4));
//                IsleofDread.main();
//                break;
//            }
//        }
    }
}


class Value {

    private Integer key;
    private String name;
    private String characteristics;


    public Value(Integer key, String name, String characteristics) {
        this.key = key;
        this.name = name;
        this.characteristics = characteristics;
    }

    @Override
    public String toString() {
        return key + " - " + name + " - " + characteristics;
    }


    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }


}