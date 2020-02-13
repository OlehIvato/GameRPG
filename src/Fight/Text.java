package Fight;

import Main.Main_All;


public interface Text {

    int recoverHP = Main_All.getIndex() + Main_All.getRestoreHealth();

    String chooseNewOptions_Mana_Menu = "\nNow Chose Next Options: " +
            "\n1. Hit " + Main_All.getName() + " on " + Main_All.getDefaultDamage() + " health point " +
            "\n2. Strike with magic on (Random damage from " + Main_All.getMinSpellDamageHERO() + " to " + Main_All.getMaxSpellDamageHero() + ")" + " health point " +
            "\n3. Get defeat and back to Main Menu";

    String youHaveWonOverThe = " ------------------------------ YOU WON ------------------------------" +
            "\n                   You have won over the ";
    String youWereDefeatedBy = " ------------------------------ YOU LOST ------------------------------ " +
            "\n                   You were defeated by ";


    static void description_Mob() {
        System.out.println("\n \n ====================== GAME ======================");
        String inf = "\n You fight against " + Main_All.getName() + "," +
                "\n He Have " + Main_All.getHealthPoint() + " hp" +
                "\n His Max Damage = " + Main_All.getMax_Damage() +
                "\n And Min Damage = " + Main_All.getMin_Damage() +
                "\n He also have " + Main_All.getChanceToSuperDamage() + "% chance on super Damage, Super Damage = " + (int) (Main_All.getMax_Damage() * 1.5);

        System.out.println(inf);
        String info = "\n\n " + Main_All.getHeroName() + ", \n Your HP = " + Main_All.getHeroHP() +
                "\n Your Damage = " + Main_All.getDefaultDamage() +
                "\n Your Max Spell Damage = " + Main_All.getMaxSpellDamageHero() +
                "\n Your Min Spell Damage = " + Main_All.getMinSpellDamageHERO() +
                "\n Your plus to restore Health point = " + Main_All.getRestoreHealth() + "    (default restore index = " + Main_All.getIndex() + ")" +
                "\n You Have " + Main_All.getMana() + " Mana, one heal spell = " + Main_All.getHealCast() + " Mana";
        System.out.println(info);
    }


    static void description_Boss() {
        System.out.println("\n \n ====================== GAME ======================");
        String inf = "\n You fight against " + Main_All.getName() + "," +
                "\n He Have " + Main_All.getHealthPoint() + " Health point " +
                "\n His Max Damage = " + Main_All.getMax_Damage() +
                "\n And Min Damage = " + Main_All.getMin_Damage() +
                "\n He restoring " + Main_All.getRestoreCreature() + " Health point every move" +
                "\n He also have " + Main_All.getChanceToSuperDamage() + "% chance on super Damage, Super Damage = " + (int) (Main_All.getMax_Damage() * 1.5) +
                "\n When his Health point will be less than 30, his damage will be as super Damage ";

        System.out.println(inf);
        String info = "\n\n " + Main_All.getHeroName() + ", \n Your HP = " + Main_All.getHeroHP() +
                "\n Your Damage = " + Main_All.getDefaultDamage() +
                "\n Your Max Spell Damage = " + Main_All.getMaxSpellDamageHero() +
                "\n Your Min Spell Damage = " + Main_All.getMinSpellDamageHERO() +
                "\n Your plus to restore Health point = " + Main_All.getRestoreCreature() + "    (default restore index = " + Main_All.getIndex() + ")" +
                "\n You Have " + Main_All.getMana() + " Mana, one heal spell = " + Main_All.getHealCast() + " Mana";
        System.out.println(info);

    }

    static void turnInformation() {
        String cases = "\n Your Turn \n" +
                "1. Hit " + Main_All.getName() + " on " + Main_All.getDefaultDamage() + " health point " +
                "\n2. Strike with magic on (Random damage from " + Main_All.getMinSpellDamageHERO() + " to " + Main_All.getMaxSpellDamageHero() + ") health point " +
                "\n3. Restore " + recoverHP + " health point, Need " + Main_All.getHealCast() + " Mana, You Have " + Main_All.getMana() + " Mana" +
                "\n4. Get defeat and back to Main Menu ";
        System.out.println(cases);
    }

}