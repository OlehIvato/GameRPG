package game.fight;

import game.sql.HeroDatabase;
import game.primary.*;
import game.primary.TheMain;

import java.util.Random;
import java.util.Scanner;

public class Fight extends TheMain implements Text {
    private final static Scanner scan = new Scanner(System.in);
    private final int superDamage = (int) (mobMaxDamage * 1.5);
    private int heroHpFinal = heroHp; // static will not change... heroHp is static
    private int heroManaFinal = heroMana;

    public void launch() {
        zeroChanger();
        if (!Game.isBoss)
            Text.gameDescription(false);
        if (Game.isBoss)
            Text.gameDescription(true);
        move();
    }

    private void move() {
        System.out.println(turnDescription);
        while (mobHp > 0 && heroHpFinal > 0) {
            switch (scan.nextInt()) {
                case 1:
                    heroMove();
                    break;
                case 2:
                    spell();
                    break;
                case 3:
                    heal();
                    break;
                case 4:
                    Saving.save(true);
                    move();
                    break;
                case 5:
                    System.err.println("\nYou gave up \n And turned back to Main Menu");
                    Game.menu();
                    break;
            }
        }
    }

    private void heroMove() {
        while (mobHp > 0 && heroHpFinal > 0) {
            System.out.println("You hit " + mobName + " on " + heroDamage + " Health point");
            if (!Game.isBoss) {
                System.out.print("Now " + mobName + " have ");
                System.out.println(mobHp - heroDamage + " Health point");
                mobHp -= heroDamage;
            }
            if (Game.isBoss) {
                System.out.print("After Recovering " + mobRestoreHp + " Health point " + mobName + " have " + ((mobHp + mobRestoreHp) - heroDamage) + " Health point ");
                mobHp = (mobHp + mobRestoreHp) - heroDamage;
            }
            if (mobHp <= 0) {
                System.out.println(youWon + mobName);
                break;
            } else mobMove();
            break;
        }
    }

    private void mobMove() {
        while (heroHpFinal > 0 && mobHp > 0) {
            System.out.println("\n" + mobName + " turn \n");
            int EqualRandom = randomDamage();
            System.out.print(mobName + " hits you on " + EqualRandom + " Health point");
            heroHpFinal -= EqualRandom;
            System.out.println("\nNow You Have " + heroHpFinal + " Health point");
            if (heroHpFinal <= 0) {
                System.out.println(youLose + mobName);
                defeatOptions();
                break;
            } else move();
            break;
        }
    }

    private void spell() {
        while (mobHp > 0 && heroHpFinal > 0) {
            int randomDamage = randomSpell();
            System.out.println("You Hit " + mobName + " using spell on " + randomDamage + " Health point ");
            if (!Game.isBoss) {
                System.out.print("Now " + mobName + " have ");
                System.out.println(mobHp - randomDamage + " Health point ");
                mobHp -= randomDamage;
            }
            if (Game.isBoss) {
                System.out.println("After Recovering " + mobRestoreHp + " health point " + mobName + " have " + ((mobHp + mobRestoreHp) - randomDamage) + " Health point ");
                mobHp = (mobHp + mobRestoreHp) - randomDamage;
            }
            if (heroMinSpell <= 0 && heroMaxSpell <= 0) {
                System.out.println("\nSorry but you can't do that, Try something else");
                move();
                break;
            } else if (mobHp <= 0) {
                System.out.println(youWon + mobName);
                break;
            } else mobMove();
            break;
        }
    }

    private void heal() {
        while (mobHp > 0 && heroHpFinal > 0) {
            if (heroManaFinal >= healCast) {
                heroHpFinal += (index + heroRestoreHp);
                System.out.println("\nYou chose Healing yourself ");
                heroManaFinal -= healCast;
                System.out.println("Now your health point equal " + heroHpFinal);
                System.out.println("Now you have left " + heroManaFinal + " Mana ");
                System.out.println(nextOption);
                switch (scan.nextInt()) {
                    case 1:
                        heroMove();
                        break;
                    case 2:
                        spell();
                        break;
                    case 3:
                        System.err.println("\nYou gave up \n And turn back to Main Menu");
                        Game.menu();
                        break;
                }
            }
            if (heroManaFinal < healCast) {
                System.out.println("\nSorry, but you haven't Mana\nPlease Select Something else");
                move();
                break;
            }
        }
    }

    private int randomSpell() {
        return (int) ((Math.random() * (heroMaxSpell - heroMinSpell)) + heroMinSpell);
    }

    private int randomDamage() {
        int result;
        int num = new Random().nextInt(100);
        if (num < mobChanceToSuperDamage) {
            result = superDamage;
            System.out.println(mobName + " uses Super Damage ");
        } else if (Game.isBoss && mobHp < 30) {
            result = superDamage;
            System.out.println(mobName + " Have less than 30 hp, his damage will be increased.");
        } else
            result = (int) (Math.random() * (mobMaxDamage - mobMinDamage)) + mobMinDamage;
        return result;
    }




    private static void defeatOptions() {
        String cases = "\n\n\n Select option: " +
                "\n   1. Create new Hero and play Again ?  " +
                "\n   2. Play again from " + TheMain.getLevelCount() + " Level " +
                "\n   3. EXIT ";
        System.out.println(cases);
        switch (scan.nextInt()) {
            case 1:
                HeroDatabase.createHero();
                break;
            case 2:
                Level.getLevel(TheMain.getLevelCount(), TheMain.getLevelDifficult());
                break;
            case 3:
                System.err.println("Exit");
                System.exit(0);
                break;
        }
    }

    private static void zeroChanger() {
        if (getHeroDamage() <= 0) {
            setHeroDamage(0);
        }
        if (heroDamage <= 0) {
            TheMain.setHeroDamage(0);
        }
        if (heroMinSpell <= 0 && heroMaxSpell <= 0) {
            TheMain.setHeroMinSpell(0);
            TheMain.setHeroMaxSpell(0);
        }
        if (heroRestoreHp <= 0) {
            TheMain.setHeroRestoreHp(0);
        }
    }
}


