package game.fight;

import game.primary.*;
import game.primary.TheMain;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Fight extends TheMain implements Text {
    private final static Scanner scan = new Scanner(System.in);
    private int heroHpFinal = heroHp; // static will not change...
    private int mobHpFinal = mobHp;
    private int heroManaFinal = heroMana;


    public void launch() {
        if (!Game.isBoss)
            Text.gameDescription(false);
        if (Game.isBoss)
            Text.gameDescription(true);
        move();
    }

    private void move() {
        try {
            Text.turnDescription();
            while (mobHpFinal > 0 && heroHpFinal > 0) {
                switch (new Scanner(System.in).nextInt()) {
                    case 1 -> heroMove();
                    case 2 -> spell();
                    case 3 -> heal();
                    case 4 -> {
                        if (Game.isEquip) {
                            Storage.save(true);
                        } else {
                            System.out.println("\nSorry but you can't do that, Try something else");
                        }
                        System.out.println("Continue game?\n1. Yes\n2. No, Back to Main Menu");
                        switch (new Scanner(System.in).nextInt()) {
                            case 1 -> move();
                            case 2 -> Game.menu();
                        }
                    }
                    case 5 -> {
                        System.err.println("\nYou gave up\n");
                        Game.menu();
                    }
                }
            }
        } catch (NullPointerException | InputMismatchException | IllegalArgumentException e) {
            System.out.println("Something went wrong\n");
            move();
        }
    }


    private void heroMove() {
        if (mobHpFinal > 0 && heroHpFinal > 0) {
            System.out.println("You hit " + mobName + " on " + heroDamage + " Health point");
            if (!Game.isBoss) {
                System.out.print("Now " + mobName + " have ");
                System.out.println(mobHpFinal - heroDamage + " Health point");
                mobHpFinal -= heroDamage;
            }
            if (Game.isBoss) {
                System.out.print("After Recovering " + mobRestoreHp + " Health point " + mobName + " have " + ((mobHpFinal + mobRestoreHp) - heroDamage) + " Health point ");
                mobHpFinal = (mobHpFinal + mobRestoreHp) - heroDamage;
            }
        }
        if (mobHpFinal <= 0) {
            System.out.println(youWon + mobName);
        } else mobMove();
    }

    private void mobMove() {
        if (heroHpFinal > 0 && mobHpFinal > 0) {
            System.out.println("\n" + mobName + " turn \n");
            int EqualRandom = randomDamage();
            System.out.print(mobName + " hits you on " + EqualRandom + " Health point");
            heroHpFinal -= EqualRandom;
            System.out.println("\nNow You Have " + heroHpFinal + " Health point");
        }
        if (heroHpFinal <= 0) {
            System.out.println(youLose + mobName);
            defeatOptions();
        } else move();
    }

    private void spell() {
        if (mobHpFinal > 0 && heroHpFinal > 0) {
            int randomDamage = randomSpell();
            System.out.println("You Hit " + mobName + " using spell on " + randomDamage + " Health point ");
            if (!Game.isBoss) {
                System.out.print("Now " + mobName + " have ");
                System.out.println(mobHpFinal - randomDamage + " Health point ");
                mobHpFinal -= randomDamage;
            }
            if (Game.isBoss) {
                System.out.println("After Recovering " + mobRestoreHp + " health point " + mobName + " have " + ((mobHpFinal + mobRestoreHp) - randomDamage) + " Health point ");
                mobHpFinal = (mobHpFinal + mobRestoreHp) - randomDamage;
            }
            if (heroMinSpell <= 0 && heroMaxSpell <= 0) {
                System.out.println("\nSorry but you can't do that, Try something else");
                move();
            }
        } if (mobHpFinal <= 0) {
            System.out.println(youWon + mobName);
        } else mobMove();

    }

    private void heal() {
        while (mobHpFinal > 0 && heroHpFinal > 0) {
            if (heroManaFinal >= healCast) {
                heroHpFinal += (restoreDefaultIndex + heroRestoreHp);
                System.out.println("\nYou chose Healing yourself ");
                heroManaFinal -= healCast;
                TheMain.setHeroMana(heroManaFinal); // that need for show current mana in turn options
                System.out.println("Now your health point equal " + heroHpFinal);
                System.out.println("Now you have left " + heroManaFinal + " Mana ");
                System.out.println(nextOption);
                switch (scan.nextInt()) {
                    case 1 -> heroMove();
                    case 2 -> spell();
                    case 3 -> {
                        System.err.println("\nYou gave up \n And turn back to Main Menu");
                        Game.menu();
                    }
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
        } else if (Game.isBoss && mobHpFinal < 30) {
            result = superDamage;
            System.out.println(mobName + " Have less than 30 hp, his damage will be increased.");
        } else
            result = (int) (Math.random() * (mobMaxDamage - mobMinDamage)) + mobMinDamage;
        return result;
    }

    private static void defeatOptions() {
        System.out.println("\n\n\n Select option: " +
                "\n   1. Create new Hero and play Again ?  " +
                "\n   2. Play again from " + TheMain.getLevelCount() + " Level " +
                "\n   3. Back to Main Menu ");
        switch (scan.nextInt()) {
            case 1 -> Game.createNewHero();
            case 2 -> Level.getLevel(TheMain.getLevelCount(), TheMain.getLevelDifficult());
            case 3 -> Game.menu();
        }
    }
}