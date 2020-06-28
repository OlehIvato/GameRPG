package game.fight;

import game.primary.*;
import game.primary.MainData;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Fight extends MainData implements DefaultValues {
    private int heroHpFinal = heroHp;    // static field changes only one time...
    private int mobHpFinal = mobHp;
    private int heroManaFinal = heroMana;

    public void launchGame() {
        if (!Setting.IS_GAME_AGAINST_BOSS)
            Text.gameDescription(false);
        if (Setting.IS_GAME_AGAINST_BOSS)
            Text.gameDescription(true);
        getMoveOptions();
    }

    private void getMoveOptions() {
        try {
            Text.turnOptions();
            while (mobHpFinal > 0 && heroHpFinal > 0) {
                switch (new Scanner(System.in).nextInt()) {
                    case 1 -> heroMove();
                    case 2 -> spell();
                    case 3 -> heal();
                    case 4 -> {
                        if (Setting.IS_GAME_WITH_EQUIPMENTS) {
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
            System.out.println("You hit " + mobName + " on " + heroDamage + " Health point");
            if (!Setting.IS_GAME_AGAINST_BOSS) {
                System.out.print("Now " + mobName + " have ");
                System.out.println(mobHpFinal - heroDamage + " Health point");
                mobHpFinal -= heroDamage;
            }
            if (Setting.IS_GAME_AGAINST_BOSS) {
                System.out.print("After Recovering " + mobRestoreHp + " Health point " + mobName + " have " + ((mobHpFinal + mobRestoreHp) - heroDamage) + " Health point ");
                mobHpFinal = (mobHpFinal + mobRestoreHp) - heroDamage;
            }
        }
        if (mobHpFinal <= 0) {
            System.out.println(Text.youWon + mobName);
        } else mobMove();
    }

    private void mobMove() {
        if (heroHpFinal > 0 && mobHpFinal > 0) {
            System.out.println("\n" + mobName + " turn \n");
            int EqualRandom = randomCreatureDamage();
            System.out.print(mobName + " hits you on " + EqualRandom + " Health point");
            heroHpFinal -= EqualRandom;
            System.out.println("\nNow You Have " + heroHpFinal + " Health point");
        }
        if (heroHpFinal <= 0) {
            System.out.println(Text.youLose + mobName);
            defeatOptions();
        } else getMoveOptions();
    }

    private void spell() {
        if (mobHpFinal > 0 && heroHpFinal > 0) {
            int randomDamage = randomSpell();
            System.out.println("You Hit " + mobName + " using spell on " + randomDamage + " Health point ");
            if (!Setting.IS_GAME_AGAINST_BOSS) {
                System.out.print("Now " + mobName + " have ");
                System.out.println(mobHpFinal - randomDamage + " Health point ");
                mobHpFinal -= randomDamage;
            }
            if (Setting.IS_GAME_AGAINST_BOSS) {
                System.out.println("After Recovering " + mobRestoreHp + " health point " + mobName + " have " + ((mobHpFinal + mobRestoreHp) - randomDamage) + " Health point ");
                mobHpFinal = (mobHpFinal + mobRestoreHp) - randomDamage;
            }
            if (heroMinSpell <= 0 && heroMaxSpell <= 0) {
                System.out.println("\nSorry but you can't do that, Try something else");
                getMoveOptions();
            }
        }
        if (mobHpFinal <= 0) {
            System.out.println(Text.youWon + mobName);
        } else mobMove();

    }

    private void heal() {
        while (mobHpFinal > 0 && heroHpFinal > 0) {
            if (heroManaFinal >= healCast) {
                heroHpFinal += (restoreDefaultIndex + heroRestoreHp);
                System.out.println("\nYou chose Healing yourself ");
                heroManaFinal -= healCast;
                System.out.println("Now your health point equal " + heroHpFinal);
                System.out.println("Now you have left " + heroManaFinal + " Mana ");
                System.out.println(Text.turnSecondOptions);
                switch (scanner.nextInt()) {
                    case 1 -> heroMove();
                    case 2 -> spell();
                    case 3 -> {
                        System.err.println("\nYou gave up \n And turn back to Main Menu");
                        Menu.main();
                    }
                }
            }
            if (heroManaFinal < healCast) {
                System.out.println("\nSorry, but you haven't Mana\nPlease Select Something else");
                getMoveOptions();
                break;
            }
        }
    }

    private int randomSpell() {
        return (int) ((Math.random() * (heroMaxSpell - heroMinSpell)) + heroMinSpell);
    }

    private int randomCreatureDamage() {
        int result;
        int num = new Random().nextInt(100);
        if (num < mobChanceToSuperDamage) {
            result = superDamage;
            System.out.println(mobName + " uses Super Damage ");
        } else if (Setting.IS_GAME_AGAINST_BOSS && mobHpFinal < 30) {
            result = superDamage;
            System.out.println(mobName + " Have less than 30 hp, his damage will be increased.");
        } else
            result = (int) (Math.random() * (mobMaxDamage - mobMinDamage)) + mobMinDamage;
        return result;
    }

    private static void defeatOptions() {
        System.out.println("\n\n\n Select option: " +
                "\n   1. Create new Hero and play Again ?  " +
                "\n   2. Play again from " + Setting.LEVEL_COUNT + " Level " +
                "\n   3. Back to Main Menu ");
        switch (scanner.nextInt()) {
            case 1 -> Menu.second();
            case 2 -> LaunchGame.getLevel(Setting.LEVEL_COUNT, Setting.LEVEL_DIFFICULT);
            case 3 -> Menu.main();
        }
    }
}