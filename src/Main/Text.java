package Main;

import Armor.Equipment;
import Armor.Stick;
import Armor.Weapon;
import Mobs.Main_Mob_Hero;

public interface Text {

    String randomgamage = " (Random damage from " + Main_Mob_Hero.getMinspelldamageHERO() + " to " + Main_Mob_Hero.getMaxspellDamageHero() + ")";
    int res = Main_Mob_Hero.getIndex() + Main_Mob_Hero.getRestoreshealth();

    String youhit = " You Hit ";
    String on = " on ";
    String hp = " health point ";
    String now = " Now ";
    String have = " Have ";
    String hitsyouon = " hits you on ";
    String turn = " turn ";
    String s = "\n";
    String now_you_have = "Now You Have ";
    String usingSpell = " Using Spell ";
    String h = " hp. ";
    String sorryButYouCantDoThat = "\nSorry but you can't do that, Try something else";
    String youchoseHealingyourself = "\nYou chose Healing yourself ";
    String nowyourhealthpointequal = "Now your health point equal ";
    String nowchosenextOption = "Now Chose Next Options: ";
    String RES = " After Recovering  ";
    String noMoreMana = "\nSorry, but you haven't Mana\nPlease Select Something else";
    String getLOSS = "\nYou gave up \n And turn back to Main Menu";
    String youhavewonoverthe = " ------------------------------ YOU WON ------------------------------" +
            "\n                   You have won over the ";
    String youweredefeatedby = " ------------------------------ YOU LOST ------------------------------ " +
            "\n                   You were defeated by ";


    static void mainDescription_Mob_ON() {
        System.out.println("\n \n ====================== GAME ======================");
        String inf = "\n You fight against " + Main_Mob_Hero.getName() + "," +
                "\n He Have " + Main_Mob_Hero.getHealthpoint() + " hp" +
                "\n His Max Damage = " + Main_Mob_Hero.getMax_Damage() +
                "\n And Min Damage = " + Main_Mob_Hero.getMin_Damage() +
                "\n He also have " + Main_Mob_Hero.getChanseToSuperDamageMob() + "% chance on super Damage, Super Damage = " + ((Main_Mob_Hero.getMax_Damage() / 2) + Main_Mob_Hero.getMax_Damage());

        System.out.println(inf);
        String info = "\n\n " + Main_Mob_Hero.getHeroName() + ", \n Your HP = " + +Equipment.getRess() +
                "\n Your Damage = " + Weapon.getRET() +
                "\n Your Max Spell Damage = " + Main_Mob_Hero.getMaxspellDamageHero() +
                "\n Your Min Spell Damage = " + Main_Mob_Hero.getMinspelldamageHERO() +
                "\n Your plus to restore Health point = " + Main_Mob_Hero.getRestoreshealth() + "    (default restore index = " + Main_Mob_Hero.getIndex() + ")" +
                "\n You Have " + Stick.getResult() + " Mana, one heal spell = " + Main_Mob_Hero.getHealcast() + " Mana";
        System.out.println(info);
    }

    static void mainDescription_Mob_OFF() {
        System.out.println("\n \n ====================== GAME ======================");
        String inf = "\n You fight against " + Main_Mob_Hero.getName() + "," +
                "\n He Have " + Main_Mob_Hero.getHealthpoint() + " hp" +
                "\n His Max Damage = " + Main_Mob_Hero.getMax_Damage() +
                "\n And Min Damage = " + Main_Mob_Hero.getMin_Damage() +
                "\n He also have " + Main_Mob_Hero.getChanseToSuperDamageMob() + "% chance on super Damage, Super Damage = " + ((Main_Mob_Hero.getMax_Damage() / 2) + Main_Mob_Hero.getMax_Damage());

        System.out.println(inf);
        String info = "\n\n " + Main_Mob_Hero.getHeroName() + ", \n Your HP = " + Main_Mob_Hero.getHeroHP() +
                "\n Your Damage = " + Main_Mob_Hero.getDefaultDamage() +
                "\n Your Max Spell Damage = " + Main_Mob_Hero.getMaxspellDamageHero() +
                "\n Your Min Spell Damage = " + Main_Mob_Hero.getMinspelldamageHERO() +
                "\n Your plus to restore Health point = " + Main_Mob_Hero.getRestoreshealth() + "    (default restore index = " + Main_Mob_Hero.getIndex() + ")" +
                "\n You Have " + Main_Mob_Hero.getMana() + " Mana, one heal spell = " + Main_Mob_Hero.getHealcast() + " Mana";
        System.out.println(info);
    }


    static void mainDescription_Boss_ON() {
        System.out.println("\n \n ====================== GAME ======================");
        String inf = "\n You fight against " + Main_Mob_Hero.getName() + "," +
                "\n He Have " + Main_Mob_Hero.getHealthpoint() + hp +
                "\n His Max Damage = " + Main_Mob_Hero.getMax_Damage() +
                "\n And Min Damage = " + Main_Mob_Hero.getMin_Damage() +
                "\n He restoring " + Main_Mob_Hero.getRestoreBoss() + hp + "every move" +
                "\n When his health point will be less than 20, his damage will be increased on " + Main_Mob_Hero.getIncreaseBoss() + ", Increased Damage = " + (Main_Mob_Hero.getMax_Damage() + Main_Mob_Hero.getIncreaseBoss()) +
                "\n He also have " + Main_Mob_Hero.getChanseToSuperDamageBOSS() + "% chance on super Damage, Super Damage = " + ((Main_Mob_Hero.getMax_Damage() / 2) + Main_Mob_Hero.getMax_Damage());

        System.out.println(inf);
        String info = "\n\n " + Main_Mob_Hero.getHeroName() + ", \n Your HP = " + +Equipment.getRess() +
                "\n Your Damage = " + Weapon.getRET() +
                "\n Your Max Spell Damage = " + Main_Mob_Hero.getMaxspellDamageHero() +
                "\n Your Min Spell Damage = " + Main_Mob_Hero.getMinspelldamageHERO() +
                "\n Your plus to restore Health point = " + Main_Mob_Hero.getRestoreBoss() + "    (default restore index = " + Main_Mob_Hero.getIndex() + ")" +
                "\n You Have " + Main_Mob_Hero.getMana() + " Mana, one heal spell = " + Main_Mob_Hero.getHealcast() + " Mana";
        System.out.println(info);
    }

    static void mainDescription_Boss_OFF() {
        System.out.println("\n \n ====================== GAME ======================");
        String inf = "\n You fight against " + Main_Mob_Hero.getName() + "," +
                "\n He Have " + Main_Mob_Hero.getHealthpoint() + hp +
                "\n His Max Damage = " + Main_Mob_Hero.getMax_Damage() +
                "\n And Min Damage = " + Main_Mob_Hero.getMin_Damage() +
                "\n He restoring " + Main_Mob_Hero.getRestoreBoss() + hp + "every move" +
                "\n When his health point will be less than 20, his damage will be increased on " + Main_Mob_Hero.getIncreaseBoss() + ", Increased Damage = " + (Main_Mob_Hero.getMax_Damage() + Main_Mob_Hero.getIncreaseBoss()) +
                "\n He also have " + Main_Mob_Hero.getChanseToSuperDamageBOSS() + "% chance on super Damage, Super Damage = " + ((Main_Mob_Hero.getMax_Damage() / 2) + Main_Mob_Hero.getMax_Damage());

        System.out.println(inf);
        String info = "\n\n " + Main_Mob_Hero.getHeroName() + ", \n Your HP = " + Main_Mob_Hero.getHeroHP() +
                "\n Your Damage = " + Main_Mob_Hero.getDefaultDamage() +
                "\n Your Max Spell Damage = " + Main_Mob_Hero.getMaxspellDamageHero() +
                "\n Your Min Spell Damage = " + Main_Mob_Hero.getMinspelldamageHERO() +
                "\n Your plus to restore Health point = " + Main_Mob_Hero.getRestoreBoss() + "    (default restore index = " + Main_Mob_Hero.getIndex() + ")" +
                "\n You Have " + Main_Mob_Hero.getMana() + " Mana, one heal spell = " + Main_Mob_Hero.getHealcast() + " Mana";
        System.out.println(info);

    }
}