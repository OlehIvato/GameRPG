package Main;

import Armor.Equipment;
import Armor.Stick;
import Armor.Weapon;
import Сreature.Main_Mob_Hero;

public interface Text {

    int res = Main_Mob_Hero.getIndex() + Main_Mob_Hero.getRestoreHealth();
    String randomDamage = " (Random damage from " + Main_Mob_Hero.getMinSpellDamageHERO() + " to " + Main_Mob_Hero.getMaxSpellDamageHero() + ")";

    String youHaveBeenRecovered = "\nYou have been recovered " + res + " health point";
    String hp = " health point ";
    String youHitNameOnWeaponHp = "You hit " + Main_Mob_Hero.getName() + " on " + Weapon.getRET() + " health point";
    String youHitNameOnDefaultDamageHp = "You hit " + Main_Mob_Hero.getName() + " on " + Main_Mob_Hero.getDefaultDamage() + " health point";
    String nowNameHave = "Now " + Main_Mob_Hero.getName() + " have ";
    String nowYouHaveHp = "\nNow You Have ";
    String nameHitYouOn = Main_Mob_Hero.getName() + " hits you on ";
    String nameTurn = "\n" + Main_Mob_Hero.getName() + " turn \n";
    String nowBossHave = "After Recovering " + Main_Mob_Hero.getRestoreBoss() + " health point " + Main_Mob_Hero.getName() + " have ";
    String youHitNameUsingSpellOn = "You Hit " + Main_Mob_Hero.getName() + " using spell on ";
    String sorryButYouCantDoThat = "\nSorry but you can't do that, Try something else";
    String youChoseHealingYourself = "\nYou chose Healing yourself ";
    String nowYourHealthPointEqual = "Now your health point equal ";
    String noMoreMana = "\nSorry, but you haven't Mana\nPlease Select Something else";
    String getLOSS = "\nYou gave up \n And turn back to Main Menu";


    String chooseNewOptions_Mana_Menu = "\nNow Chose Next Options: " +
            "\n1. Hit " + Main_Mob_Hero.getName() + " on " + Weapon.getRET() + " health point " +
            "\n2. Strike with magic on " + randomDamage + " health point " +
            "\n3. Get defeat and back to Main Menu";
    String chooseNewOptions_Mana_Menu_wout = "\nNow Chose Next Options: " +
            "\n1. Hit " + Main_Mob_Hero.getName() + " on " + Main_Mob_Hero.getDefaultDamage() + " health point " +
            "\n2. Strike with magic on " + randomDamage + " health point " +
            "\n3. Get defeat and back to Main Menu";

    String youHaveWonOverThe = " ------------------------------ YOU WON ------------------------------" +
            "\n                   You have won over the ";
    String youWereDefeatedBy = " ------------------------------ YOU LOST ------------------------------ " +
            "\n                   You were defeated by ";


    static void description_vs_mob() {
        System.out.println("\n \n ====================== GAME ======================");
        String inf = "\n You fight against " + Main_Mob_Hero.getName() + "," +
                "\n He Have " + Main_Mob_Hero.getHealthPoint() + " hp" +
                "\n His Max Damage = " + Main_Mob_Hero.getMax_Damage() +
                "\n And Min Damage = " + Main_Mob_Hero.getMin_Damage() +
                "\n He also have " + Main_Mob_Hero.getChanceToSuperDamageMob() + "% chance on super Damage, Super Damage = " + ((Main_Mob_Hero.getMax_Damage() / 2) + Main_Mob_Hero.getMax_Damage());

        System.out.println(inf);
        String info = "\n\n " + Main_Mob_Hero.getHeroName() + ", \n Your HP = " + +Equipment.getRess() +
                "\n Your Damage = " + Weapon.getRET() +
                "\n Your Max Spell Damage = " + Main_Mob_Hero.getMaxSpellDamageHero() +
                "\n Your Min Spell Damage = " + Main_Mob_Hero.getMinSpellDamageHERO() +
                "\n Your plus to restore Health point = " + Main_Mob_Hero.getRestoreHealth() + "    (default restore index = " + Main_Mob_Hero.getIndex() + ")" +
                "\n You Have " + Stick.getResult() + " Mana, one heal spell = " + Main_Mob_Hero.getHealCast() + " Mana";
        System.out.println(info);
    }

    static void description_vs_mob_wout() {
        System.out.println("\n \n ====================== GAME ======================");
        String inf = "\n You fight against " + Main_Mob_Hero.getName() + "," +
                "\n He Have " + Main_Mob_Hero.getHealthPoint() + " hp" +
                "\n His Max Damage = " + Main_Mob_Hero.getMax_Damage() +
                "\n And Min Damage = " + Main_Mob_Hero.getMin_Damage() +
                "\n He also have " + Main_Mob_Hero.getChanceToSuperDamageMob() + "% chance on super Damage, Super Damage = " + ((Main_Mob_Hero.getMax_Damage() / 2) + Main_Mob_Hero.getMax_Damage());

        System.out.println(inf);
        String info = "\n\n " + Main_Mob_Hero.getHeroName() + ", \n Your HP = " + Main_Mob_Hero.getHeroHP() +
                "\n Your Damage = " + Main_Mob_Hero.getDefaultDamage() +
                "\n Your Max Spell Damage = " + Main_Mob_Hero.getMaxSpellDamageHero() +
                "\n Your Min Spell Damage = " + Main_Mob_Hero.getMinSpellDamageHERO() +
                "\n Your plus to restore Health point = " + Main_Mob_Hero.getRestoreHealth() + "    (default restore index = " + Main_Mob_Hero.getIndex() + ")" +
                "\n You Have " + Main_Mob_Hero.getMana() + " Mana, one heal spell = " + Main_Mob_Hero.getHealCast() + " Mana";
        System.out.println(info);
    }


    static void description_vs_boss() {
        System.out.println("\n \n ====================== GAME ======================");
        String inf = "\n You fight against " + Main_Mob_Hero.getName() + "," +
                "\n He Have " + Main_Mob_Hero.getHealthPoint() + hp +
                "\n His Max Damage = " + Main_Mob_Hero.getMax_Damage() +
                "\n And Min Damage = " + Main_Mob_Hero.getMin_Damage() +
                "\n He restoring " + Main_Mob_Hero.getRestoreBoss() + hp + "every move" +
                "\n When his health point will be less than 20, his damage will be increased on " + Main_Mob_Hero.getIncreaseBoss() + ", Increased Damage = " + (Main_Mob_Hero.getMax_Damage() + Main_Mob_Hero.getIncreaseBoss()) +
                "\n He also have " + Main_Mob_Hero.getChanceToSuperDamageBOSS() + "% chance on super Damage, Super Damage = " + ((Main_Mob_Hero.getMax_Damage() / 2) + Main_Mob_Hero.getMax_Damage());

        System.out.println(inf);
        String info = "\n\n " + Main_Mob_Hero.getHeroName() + ", \n Your HP = " + +Equipment.getRess() +
                "\n Your Damage = " + Weapon.getRET() +
                "\n Your Max Spell Damage = " + Main_Mob_Hero.getMaxSpellDamageHero() +
                "\n Your Min Spell Damage = " + Main_Mob_Hero.getMinSpellDamageHERO() +
                "\n Your plus to restore Health point = " + Main_Mob_Hero.getRestoreBoss() + "    (default restore index = " + Main_Mob_Hero.getIndex() + ")" +
                "\n You Have " + Main_Mob_Hero.getMana() + " Mana, one heal spell = " + Main_Mob_Hero.getHealCast() + " Mana";
        System.out.println(info);
    }

    static void description_vs_boss_wout() {
        System.out.println("\n \n ====================== GAME ======================");
        String inf = "\n You fight against " + Main_Mob_Hero.getName() + "," +
                "\n He Have " + Main_Mob_Hero.getHealthPoint() + hp +
                "\n His Max Damage = " + Main_Mob_Hero.getMax_Damage() +
                "\n And Min Damage = " + Main_Mob_Hero.getMin_Damage() +
                "\n He restoring " + Main_Mob_Hero.getRestoreBoss() + hp + "every move" +
                "\n When his health point will be less than 20, his damage will be increased on " + Main_Mob_Hero.getIncreaseBoss() + ", Increased Damage = " + (Main_Mob_Hero.getMax_Damage() + Main_Mob_Hero.getIncreaseBoss()) +
                "\n He also have " + Main_Mob_Hero.getChanceToSuperDamageBOSS() + "% chance on super Damage, Super Damage = " + ((Main_Mob_Hero.getMax_Damage() / 2) + Main_Mob_Hero.getMax_Damage());

        System.out.println(inf);
        String info = "\n\n " + Main_Mob_Hero.getHeroName() + ", \n Your HP = " + Main_Mob_Hero.getHeroHP() +
                "\n Your Damage = " + Main_Mob_Hero.getDefaultDamage() +
                "\n Your Max Spell Damage = " + Main_Mob_Hero.getMaxSpellDamageHero() +
                "\n Your Min Spell Damage = " + Main_Mob_Hero.getMinSpellDamageHERO() +
                "\n Your plus to restore Health point = " + Main_Mob_Hero.getRestoreBoss() + "    (default restore index = " + Main_Mob_Hero.getIndex() + ")" +
                "\n You Have " + Main_Mob_Hero.getMana() + " Mana, one heal spell = " + Main_Mob_Hero.getHealCast() + " Mana";
        System.out.println(info);

    }
}