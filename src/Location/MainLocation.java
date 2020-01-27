package Location;

import Armor.Equipment;
import Armor.Weapon;
import Сreature.Main_All;
import java.util.*;

public class MainLocation {

    public void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\nWould you like to select Location for Fight?  (it will change " + Main_All.getHeroName() + " and creatures characteristics)");
        System.out.println("1. Yes \n2. No, continue without Locations");
        switch (scanner.nextInt()) {
            case 1:
                location();
                break;
            case 2:
                break;
            default: {
                System.out.println("Something went wrong");
                location();
            }
        }
    }

    private void location() {
        System.out.println("Select location for the game:\n");
        Scanner s = new Scanner(System.in);
        Northrend northrend = new Northrend("Northrend", +11, +16, -5, +5, +28, -13, +15);
        Azeroth azeroth = new Azeroth("Azeroth", -9, -5, -3, +15, +18, +12, -29);
        Kalimdor kalimdor = new Kalimdor("Kalimdor", +2, +9, +14, -16, -9, +25, -5);
        IsleofDread isleofDread = new IsleofDread("Isle of Dread", -13, +20, +9, -9, 0, +11, +6);

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
                northrend.setValues();
                break;
            }
            case 2: {
                System.out.println("You chose " + map.get(2));
                kalimdor.setValues();
                break;
            }
            case 3: {
                System.out.println("You chose " + map.get(3));
                azeroth.setValues();
                break;
            }
            case 4: {
                System.out.println("You chose " + map.get(4));
                isleofDread.setValues();
                break;
            }
        }
    }
}

class Value {
    private String nameLocation;
    private int heroHP_l;
    private int heroSpellDamage_l;
    private int heroDamage_l;
    private int heroRestoreHealth_l;
    private int creatureHP_l;
    private int creatureDamage_l;
    private int creatureChance_l;


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

        String result = String.format(getFormat,
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
        return result;
    }

    public void setValues() {
        Equipment.setRess(Equipment.getRess() + heroHP_l);
        Main_All.setMaxSpellDamageHero(Main_All.getMaxSpellDamageHero() + heroSpellDamage_l);
        Main_All.setMinSpellDamageHERO(Main_All.getMinSpellDamageHERO() + heroSpellDamage_l);
        Weapon.setRET(Weapon.getRET() + heroDamage_l);
        Main_All.setRestoreHealth(Main_All.getRestoreHealth() + heroRestoreHealth_l);

        Main_All.setHeroHP(Main_All.getHeroHP() + heroHP_l);
        Main_All.setDefaultDamage(Main_All.getDefaultDamage() + heroDamage_l);

        Main_All.setHealthPoint(creatureHP_l);
        Main_All.setMin_Damage(creatureDamage_l);
        Main_All.setMax_Damage(creatureDamage_l);
        Main_All.setChanceToSuperDamage(Main_All.getChanceToSuperDamage() + creatureChance_l);
    }
}
