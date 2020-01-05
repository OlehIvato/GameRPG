package Main;

import Mobs.Main_Mob_Hero;

public interface Text {


    String youhit = " You Hit ";
    String on = " on ";
    String hp = " healthpoint ";
    String now = " Now ";
    String have = " Have ";
    String hitsyouon = " hits you on ";
    String turn = " turn ";
    String s = "\n";
    String now_you_have = "Now You Have ";
    String usingSpell = " Using Spell ";
    String h = " hp. ";
    String youchoseHealingyourself = "\nYou chose Healing yourself ";
    String nowyourhealthpointequal = "Now your healthpoint equal ";
    String nowchosenextOption = "Now Chose Next Options: ";
    String RES = " After Recovering  ";
    String youhavewonoverthe = " ------------------------------ YOU WON ------------------------------" +
            "\n                   You have won over the ";
    String youweredefeatedby = " ------------------------------ YOU LOST ------------------------------ " +
            "\n                   You were defeated by ";


    static void mainDescription() {
        System.out.println("\n \n ====================== GAME ======================");
        String inf = "\n You fight against " + Main_Mob_Hero.getName() + "," +
                "\n He Have " + Main_Mob_Hero.getHealthpoint() + " hp" +
                "\n His Max Damage = " + Main_Mob_Hero.getMax_Damage() +
                "\n And Min Damage = " + Main_Mob_Hero.getMin_Damage() +
                "\n He also have " + Main_Mob_Hero.getChanseToSuperDamageMob() + "% chance on super Damage, Super Damage = " + ((Main_Mob_Hero.getMin_Damage() / 2) + Main_Mob_Hero.getMax_Damage());

//        System.out.println(inf);
//        String info = "\n\n " + MainCharactericticOfMobs.getHeroName() + ", \n Your HP = " + +Equipment.getRess() +
//                "\n Your Damage = " + Weapon.getRET() +
//                "\n Your Max Spell Damage = " + MainCharactericticOfMobs.getMaxspellDamageHero() +
//                "\n Your Min Spell Damage = " + MainCharactericticOfMobs.getMaxspellDamageHero() +
//                "\n Your plus to restore Healthpoint = " + MainCharactericticOfMobs.getHealthpoint() + "    (defalut restore index = " + MainCharactericticOfMobs.getIndex() + ")" +
//                "\n You Have " + manafinal + " Mana, one heal spell = " + MainCharactericticOfMobs.gethe + " Mana";
//
//
//    }


    }
}