package game.fight;

import game.primary.*;
import game.primary.MainData;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

class Fight extends MainData implements DefaultValues {
    private int heroHpFinal = getHeroHp();
    private int mobHpFinal = getMobHp();
    private int heroManaFinal = getHeroMana();

    void launchGame() {
        if (!Setting.isIsGameAgainstBoss())
            FightDescription.gameDescription(false);
        if (Setting.isIsGameAgainstBoss())
            FightDescription.gameDescription(true);
        getMoveOptions();
    }

    private void getMoveOptions() {
        try {
            FightDescription.turnOptions();
            while (mobHpFinal > 0 && heroHpFinal > 0) {
                switch (new Scanner(System.in).nextInt()) {
                    case 1 -> heroMove();
                    case 2 -> spell();
                    case 3 -> heal();
                    case 4 -> {
                        if (Setting.isIsGameWithEquipments()) {
                            Storage.saveFileToFolder(true);
                        } else {
                            System.out.println("\nSorry but you can't do that, Try something else");
                        }
                        System.out.println("Continue game?\n1. Yes\n2. No, Back to Main Menu");
                        switch (new Scanner(System.in).nextInt()) {
                            case 1 -> getMoveOptions();
                            case 2 -> Menu.main();
                        }
                    }
                    case 5 -> {
                        System.err.println("\nYou gave up\n");
                        Menu.main();
                    }
                }
            }
        } catch (NullPointerException | InputMismatchException | IllegalArgumentException e) {
            System.out.println("Something went wrong\n");
            getMoveOptions();
        }
    }

    private void heroMove() {
        if (mobHpFinal > 0 && heroHpFinal > 0) {
            System.out.println("You hit " + getMobName() + " on " + getHeroDamage() + " Health point");
            if (!Setting.isIsGameAgainstBoss()) {
                System.out.print("Now " + getMobName() + " have ");
                System.out.println(mobHpFinal - getHeroDamage() + " Health point");
                mobHpFinal -= getHeroDamage();
            }
            if (Setting.isIsGameAgainstBoss()) {
                System.out.print("After Recovering " + getMobRestoreHp() + " Health point " + getMobName() + " have "
                        + ((mobHpFinal + getMobRestoreHp()) - getHeroDamage()) + " Health point ");
                mobHpFinal = (mobHpFinal + getMobRestoreHp()) - getHeroDamage();
            }
        }
        if (mobHpFinal <= 0) {
            System.out.println(FightDescription.youWon + getMobName());
        } else mobMove();
    }

    private void mobMove() {
        if (heroHpFinal > 0 && mobHpFinal > 0) {
            System.out.println("\n" + getMobName() + " turn \n");
            int EqualRandom = randomCreatureDamage();
            System.out.print(getMobName() + " hits you on " + EqualRandom + " Health point");
            heroHpFinal -= EqualRandom;
            System.out.println("\nNow You Have " + heroHpFinal + " Health point");
        }
        if (heroHpFinal <= 0) {
            System.out.println(FightDescription.youLose + getMobName());
            defeatOptions();
        } else getMoveOptions();
    }

    private void spell() {
        if (mobHpFinal > 0 && heroHpFinal > 0) {
            int randomDamage = randomSpell();
            System.out.println("You Hit " + getMobName() + " using spell on " + randomDamage + " Health point ");
            if (!Setting.isIsGameAgainstBoss()) {
                System.out.print("Now " + getMobName() + " have ");
                System.out.println(mobHpFinal - randomDamage + " Health point ");
                mobHpFinal -= randomDamage;
            }
            if (Setting.isIsGameAgainstBoss()) {
                System.out.println("After Recovering " + getMobRestoreHp() + " health point " + getMobName() + " have "
                        + ((mobHpFinal + getMobRestoreHp()) - randomDamage) + " Health point ");
                mobHpFinal = (mobHpFinal + getMobRestoreHp()) - randomDamage;
            }
            if (getHeroMinSpell() <= 0 && getHeroMaxSpell() <= 0) {
                System.out.println("\nSorry but you can't do that, Try something else");
                getMoveOptions();
            }
        }
        if (mobHpFinal <= 0) {
            System.out.println(FightDescription.youWon + getMobName());
        } else mobMove();
    }

    private void heal() {
        while (mobHpFinal > 0 && heroHpFinal > 0) {
            if (heroManaFinal >= DEFAULT_HEAL_CAST) {
                heroHpFinal += (DEFAULT_RESTORE_HP_INDEX + getHeroRestoreHp());
                System.out.println("\nYou chose Healing yourself ");
                heroManaFinal -= DEFAULT_HEAL_CAST;
                System.out.println("Now your health point equal " + heroHpFinal);
                        System.out.println("Now you have left " + heroManaFinal + " Mana ");
                        System.out.println(FightDescription.turnSecondOptions);
                        switch (SCANNER.nextInt()) {
                            case 1 -> heroMove();
                            case 2 -> spell();
                            case 3 -> {
                        System.err.println("\nYou gave up \n And turn back to Main Menu");
                        Menu.main();
                    }
                }
            }
            if (heroManaFinal < DEFAULT_HEAL_CAST) {
                System.err.println("\nSorry, but you haven't Mana\nPlease Select Something else");
                getMoveOptions();
                break;
            }
        }
    }

    private int randomSpell() {
        return (int) ((Math.random() * (getHeroMaxSpell() - getHeroMinSpell())) + getHeroMinSpell());
    }

    private int randomCreatureDamage() {
        int result;
        int num = new Random().nextInt(100);
        if (num < getMobChanceToSuperDamage()) {
            result = getMobChanceToSuperDamage();
            System.out.println(getMobName() + " uses Super Damage ");
        } else if (Setting.isIsGameAgainstBoss() && mobHpFinal < 30) {
            result = SUPER_DAMAGE;
            System.out.println(getMobName() + " Have less than 30 hp, his damage will be increased.");
        } else
            result = (int) (Math.random() * (getMobMaxDamage() - getMobMinDamage())) + getMobMinDamage();
        return result;
    }

    private static void defeatOptions() {
        System.out.println("\n\n\n Select option: " +
                "\n   1. Create new Hero and play Again ?  " +
                "\n   2. Play again from " + Setting.getLevelCount() + " Level " +
                "\n   3. Back to Main Menu ");
        switch (SCANNER.nextInt()) {
            case 1 -> Menu.second();
            case 2 -> LaunchGame.getLevel(Setting.getLevelCount(), Setting.getLevelDifficult());
            case 3 -> Menu.main();
        }
    }
}