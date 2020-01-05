package Moving.Fight;

import Armor.Stick;
import Armor.Weapon;
import Main.Menu;
import Main.Text;

import Mobs.Main_Mob_Hero;

import java.util.Random;
import java.util.Scanner;

public class FightOFF extends Main_Mob_Hero implements Text {

    private int hero_HP = getHeroHP();
    private int manafinal = getMana();

    public FightOFF(String heroName, int heroHP, int defaultDamage, int minspelldamageHERO, int maxspellDamageHero, int increasesDamage, int restoreshealth, int chance, int mana) {
        super(heroName, heroHP, defaultDamage, minspelldamageHERO, maxspellDamageHero, increasesDamage, restoreshealth, chance, mana);
    }

    public FightOFF(String name, int healthpoint, int max_Damage, int min_Damage, int chanseToSuperDamageMob) {
        super(name, healthpoint, max_Damage, min_Damage, chanseToSuperDamageMob);
    }

    public void main() {
        Text.mainDescription_Mob_OFF();
        move();
    }

    public void move() {
        if (defaultDamage < 0) {
            defaultDamage = 0;
        }
        String cases = "\n Your Turn \n" +
                " 1. Hit " + name + on + defaultDamage + h + "\n 2. Strike with magic" + on + randomgamage + h +
                "\n 3. Restore " + res + hp + " (Need " + Main_Mob_Hero.getHealcast() + " Mana) " + "You Have " + manafinal + " Mana" +
                "\n 4. To get defeat and back to Main Menu ";
        System.out.println(cases);
        Scanner scan = new Scanner(System.in);
        while (healthpoint > 0 && hero_HP > 0)
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
                    System.err.println(getLOSS);
                    Menu.mainMenu();
                    break;
                }
            }
    }


    private void heromove() {
        while (healthpoint > 0 && hero_HP > 0) {
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
        while (hero_HP > 0 && healthpoint > 0) {
            System.out.println(s + name + turn + s);
            int EqualRandom = random();
            System.out.print(name + hitsyouon + EqualRandom + hp);
            hero_HP = hero_HP - EqualRandom;
            System.out.println(s + now_you_have + hero_HP + hp);
            if (hero_HP <= 0) {
                System.out.println(youweredefeatedby + name);
                PlayAgainOFF.again();
                break;
            } else move();
            break;
        }
    }

    private void heal() {
        while (healthpoint > 0 && hero_HP > 0) {
            if (manafinal >= Main_Mob_Hero.getHealcast()) {
                hero_HP += res;
                System.out.println(youchoseHealingyourself);
                manafinal -= Main_Mob_Hero.getHealcast();
                System.out.println("\nYou have been recovered " + res + hp);
                System.out.println(nowyourhealthpointequal + hero_HP);
                System.out.println("Now you have left " + manafinal + " Mana ");
                Scanner scan = new Scanner(System.in);
                System.out.println("\n " + nowchosenextOption);
                String healcases = "\n 1. Hit " + name + on + Weapon.getRET() + h + "\n 2. Strike with magic " + on + randomgamage + h
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
                    case 3:
                        System.err.print(getLOSS);
                        Menu.mainMenu();
                        break;
                }
                break;
            }
            if (manafinal < Main_Mob_Hero.getHealcast()) {
                System.out.println(noMoreMana);
                move();
                break;
            }
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
        while (healthpoint > 0 && hero_HP > 0) {
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


