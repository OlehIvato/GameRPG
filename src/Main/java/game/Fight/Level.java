package game.fight;

import game.primary.GetGame;

import game.primary.UserName;
import game.creature.GetRandom;

public class Level {

    private static int levelCount = 10;
    private static int[] lvlDifficult = {0, 10, 15, 20, 25, 30, 35, 40, 45, 50};
    private static String[] gameCount = {"FIRST GAME", "SECOND GAME", "THIRD GAME", "VS BOSS"};


    public static void getLevel() {
        for (int x = 0, y = 1; x <= lvlDifficult.length && y <= levelCount; x++, y++) {
            for (String z : gameCount) {
                if (!z.equals("VS BOSS")) {
                    mob(lvlDifficult[x], y, z);
                } else
                    boss(lvlDifficult[x], y, z);
            }
        }
        boss(70, null, "FINAL GAME");
        win();
    }


    private static void mob(int lvlDifficult, int levelNumber, String gameCount) {
        String cases = "\n\n===========================================================" +
                " \n========================= Level " + levelNumber + " =========================" +
                " \n==================" + " DIFFICULT +" + lvlDifficult + " PERCENT " + "===================" +
                "\n======================== " + gameCount + " =======================" +
                "\n===========================================================";
        System.out.println(cases);
        GetRandom.random(lvlDifficult);
    }


    private static void boss(int lvlDifficult, Integer levelNumber, String gameCount) {
        String cases = "\n\n===========================================================" +
                " \n========================= Level " + levelNumber + " =========================" +
                " \n==================" + " DIFFICULT +" + lvlDifficult + " PERCENT " + "===================" +
                "\n======================== " + gameCount + " =======================" +
                "\n===========================================================";
        System.out.println(cases);
        GetRandom.random_Boss(lvlDifficult);
    }

    private static void win() {
        String win = "\n\n\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::" +
                "\n" + UserName.getUserName() + " you went through" + levelCount + " levels and won    " +
                "\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::";
        System.out.println(win.toUpperCase());
        GetGame.backToMain();
    }
}
