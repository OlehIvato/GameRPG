package Location;

import Сreature.Main_Mob_Hero;

import java.util.*;

public class MainLocation {

    public static void location() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\nWould you like to select Location for Fight, it will change "+ Main_Mob_Hero.getHeroName() +" and creature characteristics");
        System.out.println("1. Yes \n2. No, continue without Locations");
        MainLocation l = new MainLocation();
        switch (scanner.nextInt()) {
            case 1:
                l.main();
                break;
            case 2:
                break;
            default: {
                System.out.println("Something went wrong");
                location();
            }
        }
    }

    private void main() {

        System.out.println("Select location for the game:\n");
        Scanner s = new Scanner(System.in);

        Azeroth azeroth = new Azeroth("Azeroth", -9, -5, -3, +15, +18, +12, -29);
        Kalimdor kalimdor = new Kalimdor("Kalimdor", +2, +9, +14, -16, -9, +25, -5);
        IsleofDread isleofDread = new IsleofDread("Isle of Dread", -13, +20, +9, -9, 0, +8, +6);
        Northrend northrend = new Northrend("Northrend", +8, +14, -5, +5, +25, -13, +15);


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

    private String nameLocation;
    int heroHP_l;
    int heroSpellDamage_l;
    int heroDamage_l;
    int heroRestoreHealth_l;
    int creatureHP_l;
    int creatureDamage_l;
    int creatureChance_l;


    public Value(String nameLocation, int heroHP_l, int heroSpellDamage_l, int heroDamage_l, int heroRestoreHealth_l, int creatureHP_l, int creatureDamage_l, int creatureChance_l) {
        this.nameLocation = nameLocation;
        this.heroHP_l = heroHP_l;
        this.heroSpellDamage_l = heroSpellDamage_l;
        this.heroDamage_l = heroDamage_l;
        this.heroRestoreHealth_l = heroRestoreHealth_l;
        this.creatureHP_l = creatureHP_l;
        this.creatureDamage_l = creatureDamage_l;
        this.creatureChance_l = creatureChance_l;
    }

    private static String formatPlus(int number) {
        if (number > 0)
            return "+" + number;
        else return "" + number;
    }

    @Override
    public String toString() {
        String getFormat = "%1$-14s -  %2$-6s %3$-8s|%4$-19s|%5$-12s|%6$-21s  ||| %7$-15s %8$-9s|%9$-13s|%10$-27s";

        String value = String.format(getFormat,
                nameLocation,
                "FOR HERO: ",
                "HP: " + formatPlus(heroHP_l),
                " Spell Damage: " + formatPlus(heroSpellDamage_l),
                " Damage: " + formatPlus(heroDamage_l),
                " Restore Health: " + formatPlus(heroRestoreHealth_l),
                " FOR CREATURES: ",
                " HP: " + formatPlus(creatureHP_l),
                " Damage: " + formatPlus(creatureDamage_l),
                " Chance to Super Damage: " + formatPlus(creatureChance_l));

        return value;
    }
}