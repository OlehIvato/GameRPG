package game.fight;

import game.primary.Game;
import game.primary.TheMain;


public interface Text {

    static void gameDescription(boolean isBoss) {
        String restoreInfo = "";
        String manaInfo = "";
        String spellInfo = "";

        System.out.println("\n\n ====================== GAME ======================");

        String info = "\n You fight against " + TheMain.getMobName() + "," +
                "\n He Have " + TheMain.getMobHp() + " hp" +
                "\n His Max Damage = " + TheMain.getMobMaxDamage() +
                "\n And Min Damage = " + TheMain.getMobMinDamage() +
                "\n He also have " + TheMain.getMobChanceToSuperDamage() + "% chance on super Damage, Super Damage = " + (int) (TheMain.getMobMaxDamage() * 1.5) + "\n";
        if (isBoss) {
            restoreInfo = " He restoring " + TheMain.getMobRestoreHp() + " Health point every move" +
                    "\n When his Health point will be less than 30, his damage will be as super Damage\n";
        }


        String heroInfo = "\n\n " + TheMain.getHeroName() + ", Class: " + TheMain.getHeroClass() + "\n Your HP = " + TheMain.getHeroHp() +
                "\n Your Damage = " + TheMain.getHeroDamage();

        if (TheMain.getHeroMinSpell() != 0) {
            spellInfo = "\n Your Max Spell Damage = " + TheMain.getHeroMaxSpell() +
                    "\n Your Min Spell Damage = " + TheMain.getHeroMinSpell();
        }

        if (TheMain.getHeroMana() != 0) {
            manaInfo = "\n Your plus to restore Health point = " + TheMain.getHeroRestoreHp() + "    (default restore index = " + TheMain.getIndex() + ")" +
                    "\n You Have " + TheMain.getHeroMana() + " Mana, one heal spell = " + TheMain.getHealCast() + " Mana";
        }

        if (isBoss) {
            System.out.println(info + restoreInfo + heroInfo + spellInfo + manaInfo);
        } else {
            System.out.println(info + heroInfo + spellInfo + manaInfo);
        }
    }


    static void turnDescription() {
        String ifWith = "";
        String ifMagic = "";
        String ifRestore = "";
        String valueEnd = "";

        String value = "\n Your Turn \n" +
                "1. Hit " + TheMain.getMobName() + " on " + TheMain.getHeroDamage() + " health point ";
        if (TheMain.getHeroMinSpell() != 0) {
            ifMagic = "\n2. Strike with magic on (Random damage from " + TheMain.getHeroMinSpell() + " to " + TheMain.getHeroMaxSpell() + ") health point ";
        }
        if (TheMain.getHeroMana() != 0) {
            ifRestore = "\n3. Restore " + (TheMain.getIndex() + TheMain.getHeroRestoreHp()) + " hp, Need " + TheMain.getHealCast() + " Mana, You Have " + TheMain.getHeroMana() + " Mana";
        }
        if (Game.isEquip) {
            ifWith = "\n4. Save Game" ;
        } else {
            valueEnd = "\n5. Get defeat and back to Main Menu ";
        }
        System.out.println(value + ifMagic + ifRestore + ifWith + valueEnd);
    }


    String nextOption = "\nNow Chose Next Options: " +
            "\n1. Hit " + TheMain.getMobName() + " on " + TheMain.getHeroDamage() + " health point " +
            "\n2. Strike with magic on (Random damage from " + TheMain.getHeroMinSpell() + " to " + TheMain.getHeroMaxSpell() + ")" + " health point " +
            "\n3. Get defeat and back to Main Menu";


    String youWon = "\n ------------------------------ YOU WON ------------------------------" +
            "\n                   You have won over the ";
    String youLose = "\n ------------------------------ YOU LOST ------------------------------ " +
            "\n                   You were defeated by ";

}