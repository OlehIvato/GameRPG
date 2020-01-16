package Main.Location;

import Mobs.Main_Mob_Hero;

import java.util.*;

public class LocationMain {

    public static void location() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\nWould you like to select Location for Fight, It change your Characteristics.");
        System.out.println("1. Yes \n2. No, continue without Locations");
        LocationMain l = new LocationMain();
        switch (scanner.nextInt()) {
            case 1:
                l.main();
                break;
            case 2:
                break;
        }
    }

    public void main() {

        System.out.println("Select location for the game:\n");
        Scanner s = new Scanner(System.in);


        Azeroth azeroth = new Azeroth("Azeroth", -9, -5, -3, +15);
        Kalimdor kalimdor = new Kalimdor("Kalimdor", +2, +9, +14, -16);
        Northrend northrend = new Northrend("Northrend", +8, +14, -5, +5);
        IsleofDread isleofDread = new IsleofDread("Isle of Dread", -13, +14, +9, -9);

        Map <Integer, Value> map = new HashMap <>();
            map.put(4, isleofDread);
            map.put(3, azeroth);
            map.put(2, kalimdor);
            map.put(1, northrend);

        //  map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);

        for (Map.Entry show : map.entrySet()) {
            System.out.println(show.getKey() + " | " + show.getValue());
        }

        switch (s.nextInt()) {
            case 1: {
                System.out.println("You chose " + map.get(1));
                northrend.main();
                break;
            }
            case 2: {
                System.out.println("You chose " + map.get(2));
                kalimdor.main();
                break;
            }
            case 3: {
                System.out.println("You chose " + map.get(3));
                azeroth.main();
                break;
            }
            case 4: {
                System.out.println("You chose " + map.get(4));
                isleofDread.main();
                break;
            }
        }
    }
}


class Value {

    protected String nameLocation;
    protected int hpLocation;
    protected int spellDamageLocation;
    protected int damageLocation;
    protected int restoreHealthLocation;


    public Value(String nameLocation, int hpLocation, int spellDamageLocation, int damageLocation, int restoreHealthLocation) {
        this.nameLocation = nameLocation;
        this.hpLocation = hpLocation;
        this.spellDamageLocation = spellDamageLocation;
        this.damageLocation = damageLocation;
        this.restoreHealthLocation = restoreHealthLocation;
    }


    public static String format(int number) {
        if (number > 0)
            return "+" + number;
        else return "" + number;
    }

    @Override
    public String toString() {

        return nameLocation + " - " + " HP: " + format(hpLocation) + " Spell Damage: " + format(spellDamageLocation) + " Damage: " + format(damageLocation) + " Restore Health: " + format(restoreHealthLocation) + ".";
    }

    public String getNameLocation() {
        return nameLocation;
    }
    public void setNameLocation(String nameLocation) {
        this.nameLocation = nameLocation;
    }
    public int getHpLocation() {
        return hpLocation;
    }
    public void setHpLocation(int hpLocation) {
        this.hpLocation = hpLocation;
    }
    public int getSpellDamageLocation() {
        return spellDamageLocation;
    }
    public void setSpellDamageLocation(int spellDamageLocation) {
        this.spellDamageLocation = spellDamageLocation;
    }
    public int getDamageLocation() {
        return damageLocation;
    }
    public void setDamageLocation(int damageLocation) {
        this.damageLocation = damageLocation;
    }
    public int getRestoreHealthLocation() {
        return restoreHealthLocation;
    }
    public void setRestoreHealthLocation(int restoreHealthLocation) {
        this.restoreHealthLocation = restoreHealthLocation;
    }

}