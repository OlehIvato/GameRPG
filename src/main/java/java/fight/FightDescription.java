package game.fight;

import game.primary.DefaultValues;

import game.primary.MainData;
import game.primary.Setting;


interface FightDescription extends DefaultValues {
    /**
     * This method shows descriptions about hero and creature before every game
     *
     * @param isBoss shows if game against boss or mob
     */
    static void gameDescription(boolean isBoss) {
        String restoreInfo = "";
        String manaInfo = "";
        String spellInfo = "";

        System.out.println("\n\n ====================== GAME ======================");

        String info = "\n You fight against " + MainData.getMobName() + "," +
                "\n He Have " + MainData.getMobHp() + " hp" +
                "\n Max Damage = " + MainData.getMobMaxDamage() +
                "\n Min Damage = " + MainData.getMobMinDamage() +
                "\n He also have " + MainData.getMobChanceToSuperDamage()
                + "% chance on super Damage, Super Damage = " + SUPER_DAMAGE + "\n";


        if (isBoss) {
            restoreInfo = " He restoring " + MainData.getMobRestoreHp() + " Health point every move" +
                    "\n When his Health point will be less than 30, his damage will be as super Damage\n";
        }

        String heroInfo = "\n\n " + MainData.getHeroName() + ", Class: " + MainData.getHeroClass()
                + "\n Health Point = " + MainData.getHeroHp() +
                "\n Damage = " + MainData.getHeroDamage();

        if (MainData.getHeroMinSpell() != 0) {
            spellInfo = "\n Max Spell Damage = " + MainData.getHeroMaxSpell() +
                    "\n Min Spell Damage = " + MainData.getHeroMinSpell();
        }

        if (MainData.getHeroMana() != 0) {
            manaInfo = "\n Plus to restore Health point = " + MainData.getHeroRestoreHp()
                    + "  (default restore index = " + DEFAULT_RESTORE_HP_INDEX + ")" +
                    "\n You Have " + MainData.getHeroMana() + " Mana, one heal spell = "
                    + DEFAULT_HEAL_CAST + " Mana";
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
                "1. Hit " + MainData.getMobName() + " on " + MainData.getHeroDamage() + " hp ";
        if (MainData.getHeroMinSpell() != 0) {
            ifMagic = "\n2. Strike with magic on (Random damage from " + MainData.getHeroMinSpell()
                    + " to " + MainData.getHeroMaxSpell() + ") health point ";
        }
        if (MainData.getHeroMana() != 0) {
            ifRestore = "\n3. Restore " + (DEFAULT_RESTORE_HP_INDEX + MainData.getHeroRestoreHp()) + " hp.";
        }
        if (Setting.isIsGameWithEquipments()) {
            ifWith = "\n4. Save Game";
        }
        String valueEnd = "\n5. Get defeat and back to Main Menu ";

        System.out.println(value + ifMagic + ifRestore + ifWith + valueEnd);
    }

    /**
     * Shows second options when hero used heal spell
     */
    String turnSecondOptions = "\nNow Chose Next Options: " +
            "\n1. Hit " + MainData.getMobName() + " on " + MainData.getHeroDamage() + " health point " +
            "\n2. Strike with magic on (Random damage from " + MainData.getHeroMinSpell()
            + " to " + MainData.getHeroMaxSpell() + ")" + " health point " +
            "\n3. Get defeat and back to Main Menu";


    String youWon = "\n ------------------------------ YOU WON ------------------------------" +
            "\n                   You have won over the ";
    String youLose = "\n ------------------------------ YOU LOST ------------------------------ " +
            "\n                   You were defeated by ";

}