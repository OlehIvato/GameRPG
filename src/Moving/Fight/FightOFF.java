package Moving.Fight;

import Mobs.MainCharactericticOfMobs;
import Main.Interface01;

import java.util.Random;
import java.util.Scanner;

public class FightOFF extends MainCharactericticOfMobs implements Interface01 {

    private static int index = 6;
    private static int res = index + restoreshealth;
    private String randomgamage = " (Random damage from " + minspelldamageHERO + " to " + maxspellDamageHero;
    private int herohp = getHeroHP();
    private int healcast = 33;

    public FightOFF(String heroName, int heroHP, int defaultDamage, int minspelldamageHERO, int maxspellDamageHero, int increasesDamage, int restoreshealth, int chance, int mana) {
        super(heroName, heroHP, defaultDamage, minspelldamageHERO, maxspellDamageHero, increasesDamage, restoreshealth, chance, mana);
    }


    public FightOFF(String name, int healthpoint, int max_Damage, int min_Damage, int chanseToSuperDamageMob) {
        super(name, healthpoint, max_Damage, min_Damage, chanseToSuperDamageMob);
    }

    public void main() {
        System.out.println("\n \n ====================== GAME ======================");
        String inf = "\n You fight against " + name + "," +
                "\n He Have " + healthpoint + " hp" +
                "\n His Max Damage = " + max_Damage +
                "\n And Min Damage = " + min_Damage +
                "\n He also have " + chanseToSuperDamageMob + "% chance on super Damage, Super Damage = " + ((max_Damage / 2) + max_Damage);

        System.out.println(inf);
        String info = "\n\n " + heroName + ", \n Your HP = " + herohp +
                "\n Your Damage = " + defaultDamage +
                "\n Your Max Spell Damage = " + maxspellDamageHero +
                "\n Your Min Spell Damage = " + minspelldamageHERO +
                "\n Your plus to restore Healthpoint = " + restoreshealth + "    (defalut restore index = " + 6 + ")" +
                "\n You Have " + mana + " Mana, one heal spell = " + healcast + " Mana";
        System.out.println(info);
        move();
    }

    public void move() {
        String cases = "\n Your Turn \n" +
                " 1. Hit " + name + on + defaultDamage + h + "\n 2. Strike with magic" + on + randomgamage + h +
                "\n 3. Restore " + res + hp + " (Need " + healcast + " Mana) " + "You Have " + mana + " Mana" +
                "\n 4. To get defeat and back to Main Menu ";
        System.out.println(cases);
        Scanner scan = new Scanner(System.in);
        while (healthpoint > 0 && herohp > 0)
            switch (scan.nextInt()) {
                case 1: {
                    heromove();
                    break;
                }
                case 2: {
                    spell();
                    break;
                }
                case 3: {
                    heal();
                    break;
                }
                case 4: {
                    System.err.println("You Loss \n And turn back to Main Menu");
                    break;
                }
            }
    }


    private void heromove() {
        while (healthpoint > 0 && herohp > 0) {
            System.out.println(youhit + name + on + defaultDamage + hp);
            System.out.print(now + name + have);
            System.out.println(healthpoint - defaultDamage + hp);
            healthpoint = healthpoint - defaultDamage;
            if (healthpoint <= 0) {
                System.out.println(youhavewonoverthe + name);
                break;
            } else mobmove();
            break;
        }
    }

    private void mobmove() {
        while (herohp > 0 && healthpoint > 0) {
            System.out.println(s + name + turn + s);
            int EqualRandom = random();
            System.out.print(name + hitsyouon + EqualRandom + hp);
            herohp = herohp - EqualRandom;
            System.out.println(s + now_you_have + herohp + hp);
            if (herohp <= 0) {
                System.out.println(youweredefeatedby + name);
                PlayAgainOFF.again();
                break;
            } else move();
            break;
        }
    }

    private void heal() {
        while (mana >= healcast) {
            herohp += res;
            System.out.println(youchoseHealingyourself);
            mana -= healcast;
            System.out.println("\nYou have been recovered " + res + hp);
            System.out.println(nowyourhealthpointequal + herohp);
            System.out.println("Now you have left " + mana + " Mana ");
            Scanner scan = new Scanner(System.in);
            System.out.println("\n " + nowchosenextOption);
            String healcases = "\n 1. Hit " + name + on + defaultDamage + h + "\n 2. Strike with magic " + on + randomgamage + h
                    + "\n 3. To get defeat and back to Main Menu";
            System.out.println(healcases);
            switch (scan.nextInt()) {
                case 1: {
                    heromove();
                    break;
                }
                case 2: {
                    spell();
                    break;
                }
            }
        }
        if (mana < healcast) {
            System.out.println("Sorry, but you have no more Mana");
            move();
        }

    }


    private int random_Spell_damage() {
        int max = maxspellDamageHero;
        int min = minspelldamageHERO;
        int range = max - min;
        int finalresult = (int) ((Math.random() * range) + min);
        return finalresult;
    }


    public int random() {
        int result = 0;
        int increasesDamage = max_Damage / 2;
        Random random = new Random();
        int num = random.nextInt(100);
        int max = max_Damage;
        int min = min_Damage;
        int range = max - min;
        if (num < chanseToSuperDamageMob) {
            result = max_Damage + increasesDamage;
            System.out.println(name + " uses Super Damage ");
        } else
            result = (int) (Math.random() * range) + min;
        return result;
    }

    private void spell() {
        while (healthpoint > 0 && herohp > 0) {
            int result = random_Spell_damage();
            System.out.println(youhit + name + usingSpell + on + result + hp);
            System.out.print(now + name + have);
            System.out.println(healthpoint - result + hp);
            healthpoint = healthpoint - result;
            if (healthpoint <= 0) {
                System.out.println(youhavewonoverthe + name);
                break;
            } else mobmove();
            break;
        }
    }


}


