package Main;

import Armor.Equipment;
import Armor.Stick;
import Armor.Weapon;
import Сreature.Main_All;


public interface Text {

    int res = Main_All.getIndex() + Main_All.getRestoreHealth();
    String randomDamage = " (Random damage from " + Main_All.getMinSpellDamageHERO() + " to " + Main_All.getMaxSpellDamageHero() + ")";

    String youHaveBeenRecovered = "\nYou have been recovered " + res + " health point";
    String hp = " health point ";
    String youHitNameOnWeaponHp = "You hit " + Main_All.getName() + " on " + Weapon.getRET() + " health point";
    String youHitNameOnDefaultDamageHp = "You hit " + Main_All.getName() + " on " + Main_All.getDefaultDamage() + " health point";
    String nowNameHave = "Now " + Main_All.getName() + " have ";
    String nowYouHaveHp = "\nNow You Have ";
    String nameHitYouOn = Main_All.getName() + " hits you on ";
    String nameTurn = "\n" + Main_All.getName() + " turn \n";
    String nowBossHave = "After Recovering " + Main_All.getRestoreCreature() + " health point " + Main_All.getName() + " have ";
    String youHitNameUsingSpellOn = "You Hit " + Main_All.getName() + " using spell on ";
    String sorryButYouCantDoThat = "\nSorry but you can't do that, Try something else";
    String youChoseHealingYourself = "\nYou chose Healing yourself ";
    String nowYourHealthPointEqual = "Now your health point equal ";
    String noMoreMana = "\nSorry, but you haven't Mana\nPlease Select Something else";
    String getLOSS = "\nYou gave up \n And turn back to Main Menu";


    String chooseNewOptions_Mana_Menu = "\nNow Chose Next Options: " +
            "\n1. Hit " + Main_All.getName() + " on " + Weapon.getRET() + " health point " +
            "\n2. Strike with magic on " + randomDamage + " health point " +
            "\n3. Get defeat and back to Main Menu";
    String chooseNewOptions_Mana_Menu_wout = "\nNow Chose Next Options: " +
            "\n1. Hit " + Main_All.getName() + " on " + Main_All.getDefaultDamage() + " health point " +
            "\n2. Strike with magic on " + randomDamage + " health point " +
            "\n3. Get defeat and back to Main Menu";

    String youHaveWonOverThe = " ------------------------------ YOU WON ------------------------------" +
            "\n                   You have won over the ";
    String youWereDefeatedBy = " ------------------------------ YOU LOST ------------------------------ " +
            "\n                   You were defeated by ";


    static void description_vs_mob() {
        System.out.println("\n \n ====================== GAME ======================");
        String inf = "\n You fight against " + Main_All.getName() + "," +
                "\n He Have " + Main_All.getHealthPoint() + " hp" +
                "\n His Max Damage = " + Main_All.getMax_Damage() +
                "\n And Min Damage = " + Main_All.getMin_Damage() +
                "\n He also have " + Main_All.getChanceToSuperDamage() + "% chance on super Damage, Super Damage = " + ((Main_All.getMax_Damage() / 2) + Main_All.getMax_Damage());

        System.out.println(inf);
        String info = "\n\n " + Main_All.getHeroName() + ", \n Your HP = " + +Equipment.getRess() +
                "\n Your Damage = " + Weapon.getRET() +
                "\n Your Max Spell Damage = " + Main_All.getMaxSpellDamageHero() +
                "\n Your Min Spell Damage = " + Main_All.getMinSpellDamageHERO() +
                "\n Your plus to restore Health point = " + Main_All.getRestoreHealth() + "    (default restore index = " + Main_All.getIndex() + ")" +
                "\n You Have " + Stick.getResult() + " Mana, one heal spell = " + Main_All.getHealCast() + " Mana";
        System.out.println(info);
    }

    static void description_vs_mob_wout() {
        System.out.println("\n \n ====================== GAME ======================");
        String inf = "\n You fight against " + Main_All.getName() + "," +
                "\n He Have " + Main_All.getHealthPoint() + " hp" +
                "\n His Max Damage = " + Main_All.getMax_Damage() +
                "\n And Min Damage = " + Main_All.getMin_Damage() +
                "\n He also have " + Main_All.getChanceToSuperDamage() + "% chance on super Damage, Super Damage = " + ((Main_All.getMax_Damage() / 2) + Main_All.getMax_Damage());

        System.out.println(inf);
        String info = "\n\n " + Main_All.getHeroName() + ", \n Your HP = " + Main_All.getHeroHP() +
                "\n Your Damage = " + Main_All.getDefaultDamage() +
                "\n Your Max Spell Damage = " + Main_All.getMaxSpellDamageHero() +
                "\n Your Min Spell Damage = " + Main_All.getMinSpellDamageHERO() +
                "\n Your plus to restore Health point = " + Main_All.getRestoreHealth() + "    (default restore index = " + Main_All.getIndex() + ")" +
                "\n You Have " + Main_All.getMana() + " Mana, one heal spell = " + Main_All.getHealCast() + " Mana";
        System.out.println(info);
    }


    static void description_vs_boss() {
        System.out.println("\n \n ====================== GAME ======================");
        String inf = "\n You fight against " + Main_All.getName() + "," +
                "\n He Have " + Main_All.getHealthPoint() + hp +
                "\n His Max Damage = " + Main_All.getMax_Damage() +
                "\n And Min Damage = " + Main_All.getMin_Damage() +
                "\n He restoring " + Main_All.getRestoreCreature() + hp + "every move" +
                "\n When his health point will be less than 20, his damage will be increased on " + Main_All.getIncreaseDamage() + ", Increased Damage = " + (Main_All.getMax_Damage() + Main_All.getIncreaseDamage()) +
                "\n He also have " + Main_All.getChanceToSuperDamage() + "% chance on super Damage, Super Damage = " + ((Main_All.getMax_Damage() / 2) + Main_All.getMax_Damage());

        System.out.println(inf);
        String info = "\n\n " + Main_All.getHeroName() + ", \n Your HP = " + +Equipment.getRess() +
                "\n Your Damage = " + Weapon.getRET() +
                "\n Your Max Spell Damage = " + Main_All.getMaxSpellDamageHero() +
                "\n Your Min Spell Damage = " + Main_All.getMinSpellDamageHERO() +
                "\n Your plus to restore Health point = " + Main_All.getRestoreCreature() + "    (default restore index = " + Main_All.getIndex() + ")" +
                "\n You Have " + Main_All.getMana() + " Mana, one heal spell = " + Main_All.getHealCast() + " Mana";
        System.out.println(info);
    }

    static void description_vs_boss_wout() {
        System.out.println("\n \n ====================== GAME ======================");
        String inf = "\n You fight against " + Main_All.getName() + "," +
                "\n He Have " + Main_All.getHealthPoint() + hp +
                "\n His Max Damage = " + Main_All.getMax_Damage() +
                "\n And Min Damage = " + Main_All.getMin_Damage() +
                "\n He restoring " + Main_All.getRestoreCreature() + hp + "every move" +
                "\n When his health point will be less than 20, his damage will be increased on " + Main_All.getIncreaseDamage() + ", Increased Damage = " + (Main_All.getMax_Damage() + Main_All.getIncreaseDamage()) +
                "\n He also have " + Main_All.getChanceToSuperDamage() + "% chance on super Damage, Super Damage = " + ((Main_All.getMax_Damage() / 2) + Main_All.getMax_Damage());

        System.out.println(inf);
        String info = "\n\n " + Main_All.getHeroName() + ", \n Your HP = " + Main_All.getHeroHP() +
                "\n Your Damage = " + Main_All.getDefaultDamage() +
                "\n Your Max Spell Damage = " + Main_All.getMaxSpellDamageHero() +
                "\n Your Min Spell Damage = " + Main_All.getMinSpellDamageHERO() +
                "\n Your plus to restore Health point = " + Main_All.getRestoreCreature() + "    (default restore index = " + Main_All.getIndex() + ")" +
                "\n You Have " + Main_All.getMana() + " Mana, one heal spell = " + Main_All.getHealCast() + " Mana";
        System.out.println(info);

    }
}