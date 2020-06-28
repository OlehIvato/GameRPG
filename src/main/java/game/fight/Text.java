package game.fight;

import game.primary.DefaultValues;
import game.primary.MainData;
import game.primary.Setting;


public class Text extends MainData implements DefaultValues {
    /** This method shows descriptions about hero and creature before every game
     * @param isBoss shows if game against boss or mob
     */
   static void gameDescription(boolean isBoss) {
        String restoreInfo = "";
        String manaInfo = "";
        String spellInfo = "";

        System.out.println("\n\n ====================== GAME ======================");

        String info = "\n You fight against " + mobName + "," +
                "\n He Have " + mobHp + " hp" +
                "\n Max Damage = " + mobMaxDamage +
                "\n Min Damage = " + mobMinDamage +
                "\n He also have " + mobChanceToSuperDamage + "% chance on super Damage, Super Damage = " + (int) (mobMaxDamage * 1.5) + "\n";

        if (isBoss) {
            restoreInfo = " He restoring " + mobRestoreHp + " Health point every move" +
                    "\n When his Health point will be less than 30, his damage will be as super Damage\n";
        }

        String heroInfo = "\n\n " + heroName + ", Class: " + heroClass + "\n Health Point = " + heroHp +
                "\n Damage = " + heroDamage;

        if (heroMinSpell != 0) {
            spellInfo = "\n Max Spell Damage = " + heroMaxSpell +
                    "\n Min Spell Damage = " + heroMinSpell;
        }

        if (heroMana != 0) {
            manaInfo = "\n Plus to restore Health point = " + heroRestoreHp + "    (default restore index = " + restoreDefaultIndex + ")" +
                    "\n You Have " + heroMana + " Mana, one heal spell = " + healCast + " Mana";
        }

        if (isBoss) {
            System.out.println(info + restoreInfo + heroInfo + spellInfo + manaInfo);
        } else {
            System.out.println(info + heroInfo + spellInfo + manaInfo);
        }
    }

    /**
     * This method shows options every turn for hero
     */
    static void turnOptions() {
        String ifWith = "";
        String ifMagic = "";
        String ifRestore = "";

        String value = "\n Your Turn \n" +
                "1. Hit " + mobName + " on " + heroDamage + " hp ";
        if (heroMinSpell != 0) {
            ifMagic = "\n2. Strike with magic on (Random damage from " + heroMinSpell + " to " + heroMaxSpell + ") health point ";
        }
        if (heroMana != 0) {
            ifRestore = "\n3. Restore " + (restoreDefaultIndex + heroRestoreHp) + " hp.";
        }
        if (Setting.IS_GAME_WITH_EQUIPMENTS) {
            ifWith = "\n4. Save Game";
        }
        String valueEnd = "\n5. Get defeat and back to Main Menu ";

        System.out.println(value + ifMagic + ifRestore + ifWith + valueEnd);
    }

    /**
     * Shows second options when hero used heal spell
     */
    static String turnSecondOptions = "\nNow Chose Next Options: " +
            "\n1. Hit " + mobName + " on " + heroDamage + " health point " +
            "\n2. Strike with magic on (Random damage from " + heroMinSpell + " to " + heroMaxSpell + ")" + " health point " +
            "\n3. Get defeat and back to Main Menu";


    static String youWon = "\n ------------------------------ YOU WON ------------------------------" +
            "\n                   You have won over the ";
    static String youLose = "\n ------------------------------ YOU LOST ------------------------------ " +
            "\n                   You were defeated by ";

}