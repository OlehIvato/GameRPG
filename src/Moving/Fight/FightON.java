package Moving.Fight;

import Armor.Equipment;
import Armor.Stick;
import Armor.Weapon;
import Main.ChoseNewHero;
import Main.Enum_Case;
import Main.Menu;
import Main.Text;
import Mobs.Main_Mob_Hero;
import java.util.Random;
import java.util.Scanner;

public class FightON extends Main_Mob_Hero implements Text {

    private int hero_HP = Equipment.getRess();
    private int manafinal = Stick.getResult();

    public FightON(String heroName, int heroHP, int defaultDamage, int minspelldamageHERO, int maxspellDamageHero, int increasesDamage, int restoreshealth, int chance, int mana) {
        super(heroName, heroHP, defaultDamage, minspelldamageHERO, maxspellDamageHero, increasesDamage, restoreshealth, chance, mana);
    }

    public FightON(String name, int healthpoint, int max_Damage, int min_Damage, int chanseToSuperDamageMob) {
        super(name, healthpoint, max_Damage, min_Damage, chanseToSuperDamageMob);
    }

    public void main() {
        Text.mainDescription_Mob_ON();
        move();
    }

    public void move() {
        if (Weapon.getRET() < 0) {
            Weapon.setRET(0);
        }
        String cases = "\n Your Turn \n" +
                " 1. Hit " + name + on + Weapon.getRET() + h + "\n 2. Strike with magic" + on + randomgamage + h +
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
            System.out.println(youhit + name + on + Weapon.getRET() + hp);
            System.out.print(now + name + have);
            System.out.println(healthpoint - Weapon.getRET() + hp);
            healthpoint = healthpoint - Weapon.getRET();
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
                again();
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
                    case 3: {
                        System.err.println(getLOSS);
                        Menu.mainMenu();
                        break;
                    }
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
            if (minspelldamageHERO < 0 && maxspellDamageHero < 0) {
                System.out.println(sorryButYouCantDoThat);
                move();
                break;
            } else if (healthpoint <= 0) {
                System.out.println(youhavewonoverthe + name);
                break;
            } else mobmove();
            break;
        }
    }

    public static void again() {
        Scanner scanner = new Scanner(System.in);
        String cases = "\n Select option :" +
                "\n 1. Play Again " +
                "\n 2. Create new Hero and play Again" +
                "\n 3 Exit ";
        System.out.println(cases);
        switch (scanner.nextInt()) {
            case 1: {
                Level.level_1_1();
            }
            case 2: {
                ChoseNewHero.main();
                break;
            }
            case 3: {
                Enum_Case.TestEnum(Enum_Case.ENUM.FINISHED);
                Menu.mainMenu();
                break;
            }
        }
    }

}


