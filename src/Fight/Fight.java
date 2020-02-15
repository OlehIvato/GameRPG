package Fight;

import Hero.NewHero;
import Main.*;
import Main.Main_All;

import java.util.Random;
import java.util.Scanner;

public class Fight extends Main_All implements Text, Levels {
    private static Scanner scan = new Scanner(System.in);
    private int superDamage = (int) (max_Damage * 1.5);
    private int hero_HP = heroHP;
    private int manaFinal = mana;

    public void main() {
        setZero();
        if (!Game.isBoss)
            Text.description_Mob();
        if (Game.isBoss)
            Text.description_Boss();
        move();
    }

    private void move() {
        Text.turnInformation();
        while (healthPoint > 0 && hero_HP > 0) {
            switch (scan.nextInt()) {
                case 1:
                    heroMove();
                    break;
                case 2:
                    spell();
                case 3:
                    heal();
                    break;
                case 4:
                    System.err.println("\nYou gave up \n And turn back to Main Menu");
                    Menu.menu();
                    break;
            }
        }
    }

    private void heroMove() {
        while (healthPoint > 0 && hero_HP > 0) {
            System.out.println("You hit " + name + " on " + defaultDamage + " Health point");
            if (!Game.isBoss) {
                System.out.print("Now " + name + " have ");
                System.out.println(healthPoint - defaultDamage + " Health point");
                healthPoint -= defaultDamage;
            }
            if (Game.isBoss) {
                System.out.print("After Recovering " + restoreCreature + " health point " + name + " have " + ((healthPoint + restoreCreature) - defaultDamage) + " Health point ");
                healthPoint = (healthPoint + restoreCreature) - defaultDamage;
            }
            if (healthPoint <= 0) {
                System.out.println(youHaveWonOverThe + name);
                break;
            } else mobMove();
            break;
        }
    }

    private void mobMove() {
        while (hero_HP > 0 && healthPoint > 0) {
            System.out.println("\n" + name + " turn \n");
            int EqualRandom = random();
            System.out.print(name + " hits you on " + EqualRandom + " Health point");
            hero_HP -= EqualRandom;
            System.out.println("\nNow You Have " + hero_HP + " Health point");
            if (hero_HP <= 0) {
                System.out.println(youWereDefeatedBy + name);
                again();
                break;
            } else move();
            break;
        }
    }

    private void heal() {
        while (healthPoint > 0 && hero_HP > 0) {
            if (manaFinal >= healCast) {
                hero_HP += (index + restoreHealth);
                System.out.println("\nYou chose Healing yourself ");
                manaFinal -= healCast;
                System.out.println("\nYou have been recovered " + (index + restoreHealth) + " health point");
                System.out.println("Now your health point equal " + hero_HP);
                System.out.println("Now you have left " + manaFinal + " Mana ");
                System.out.println(chooseNewOptions_Mana_Menu);
                switch (scan.nextInt()) {
                    case 1:
                        heroMove();
                        break;
                    case 2:
                        spell();
                        break;
                    case 3:
                        System.err.println("\nYou gave up \n And turn back to Main Menu");
                        Menu.menu();
                        break;
                }
            }
            if (manaFinal < healCast) {
                System.out.println("\nSorry, but you haven't Mana\nPlease Select Something else");
                move();
                break;
            }
        }
    }

    private int random_Spell_damage() {
        int max = maxSpellDamageHero;
        int min = minSpellDamageHERO;
        int range = max - min;
        return (int) ((Math.random() * range) + min);
    }

    public int random() {
        int result = 0;
        Random random = new Random();
        int num = random.nextInt(100);
        int max = max_Damage;
        int min = min_Damage;
        int range = max - min;
        if (num < chanceToSuperDamage) {
            result = superDamage;
            System.out.println(name + " uses Super Damage ");
        } else if (Game.isBoss && healthPoint < 30) {
            result = superDamage;
            System.out.println(name + " Have less than 30 hp, his damage will be increased.");
        } else
            result = (int) (Math.random() * range) + min;
        return result;
    }

    private void spell() {
        while (healthPoint > 0 && hero_HP > 0) {
            int result = random_Spell_damage();
            System.out.println("You Hit " + name + " using spell on " + result + " Health point ");
            if (!Game.isBoss) {
                System.out.print("Now " + name + " have ");
                System.out.println(healthPoint - result + " Health point ");
                healthPoint -= result;
            }
            if (Game.isBoss) {
                System.out.println("After Recovering " + restoreCreature + " health point " + name + " have " + ((healthPoint + restoreCreature) - result) + " Health point ");
                healthPoint = (healthPoint + restoreCreature) - result;
            }
            if (minSpellDamageHERO <= 0 && maxSpellDamageHero <= 0) {
                System.out.println("\nSorry but you can't do that, Try something else");
                move();
                break;
            } else if (healthPoint <= 0) {
                System.out.println(youHaveWonOverThe + name);
                break;
            } else mobMove();
            break;
        }
    }

    public static void again() {
        String cases = "\nSelect option :" +
                "\n1. Create new Hero and play Again" +
                "\n2 Exit ";
        System.out.println(cases);
        switch (scan.nextInt()) {
            case 1:
                NewHero.main();
                break;
            case 2:
                System.exit(1);
                break;
        }
    }

    private static void setZero() {
        if (getDefaultDamage() <= 0) {
            setDefaultDamage(0);
        }
        if (defaultDamage <= 0) {
            Main_All.setDefaultDamage(0);
        }
        if (minSpellDamageHERO <= 0 && maxSpellDamageHero <= 0) {
            Main_All.setMinSpellDamageHERO(0);
            Main_All.setMaxSpellDamageHero(0);
        }
        if (restoreHealth <= 0) {
            Main_All.setRestoreHealth(0);
        }
    }
}


