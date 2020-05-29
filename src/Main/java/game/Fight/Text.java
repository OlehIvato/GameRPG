package game.fight;

import game.primary.TheMain;


public interface Text {

    int recoverHP = TheMain.getIndex() + TheMain.getHeroRestoreHp();

    String nextOption = "\nNow Chose Next Options: " +
            "\n1. Hit " + TheMain.getMobName() + " on " + TheMain.getHeroDamage() + " health point " +
            "\n2. Strike with magic on (Random damage from " + TheMain.getHeroMinSpell() + " to " + TheMain.getHeroMaxSpell() + ")" + " health point " +
            "\n3. Get defeat and back to Main Menu";

    String youWon = "\n ------------------------------ YOU WON ------------------------------" +
            "\n                   You have won over the ";
    String youLose = "\n ------------------------------ YOU LOST ------------------------------ " +
            "\n                   You were defeated by ";


    static void gameDescription(boolean isBoss) {
        String additionValue = null;
        System.out.println("\n \n ====================== GAME ======================");
        String desc = "\n You fight against " + TheMain.getMobName() + "," +
                "\n He Have " + TheMain.getMobHp() + " hp" +
                "\n His Max Damage = " + TheMain.getMobMaxDamage() +
                "\n And Min Damage = " + TheMain.getMobMinDamage() +
                "\n He also have " + TheMain.getMobChanceToSuperDamage() + "% chance on super Damage, Super Damage = " + (int) (TheMain.getMobMaxDamage() * 1.5);
        if (isBoss) {
            additionValue = " He restoring " + TheMain.getMobRestoreHp() + " Health point every move" +
                    "\n When his Health point will be less than 30, his damage will be as super Damage ";
        }
        String heroInfo = "\n\n " + TheMain.getHeroName() + ", Class: " + TheMain.getHeroClass() + "\n Your HP = " + TheMain.getHeroHp() +
                "\n Your Damage = " + TheMain.getHeroDamage() +
                "\n Your Max Spell Damage = " + TheMain.getHeroMaxSpell() +
                "\n Your Min Spell Damage = " + TheMain.getHeroMinSpell() +
                "\n Your plus to restore Health point = " + TheMain.getHeroRestoreHp() + "    (default restore index = " + TheMain.getIndex() + ")" +
                "\n You Have " + TheMain.getHeroMana() + " Mana, one heal spell = " + TheMain.getHealCast() + " Mana";

        if (isBoss) {
            System.out.println(desc + "\n" + additionValue + "\n" + heroInfo);
        } else {
            System.out.println(desc + "\n" + heroInfo);
        }
    }


    String turnDescription = "\n Your Turn \n" +
            "1. Hit " + TheMain.getMobName() + " on " + TheMain.getHeroDamage() + " health point " +
            "\n2. Strike with magic on (Random damage from " + TheMain.getHeroMinSpell() + " to " + TheMain.getHeroMaxSpell() + ") health point " +
            "\n3. Restore " + (TheMain.getIndex() + TheMain.getHeroRestoreHp()) + " hp, Need " + TheMain.getHealCast() + " Mana, You Have " + TheMain.getHeroMana() + " Mana" +
            "\n4. Save Game" +
            "\n5. Get defeat and back to Main Menu ";


}