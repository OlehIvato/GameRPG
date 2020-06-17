package game.fight;

import game.primary.Game;
import game.sql.CreaturesData;
import game.primary.TheMain;

import java.util.Arrays;
import java.util.List;

public class Level {

    private static final int levelCountFinal = 10;
    private static final List<Integer> lvlDifficultFinal = Arrays.asList(0, 10, 20, 30, 40, 50, 60, 70, 80, 90);
    private static final List<String> gameCount = Arrays.asList("FIRST GAME", "SECOND GAME", "THIRD GAME", "VS BOSS");

    public static void getLevel(int getLvlCount, int getLvlDifficult) {
        int lvlD = 0;
        int lvlC = 1;
        if (getLvlCount != 0 && getLvlDifficult != 0) {
            lvlC = getLvlCount;
            lvlD = lvlDifficultFinal.indexOf(getLvlDifficult);
        }
        if (getLvlDifficult == TheMain.getWithOutEquipPercent()) {
            lvlD = lvlDifficultFinal.indexOf(0);
        }
        for (int a = lvlD, b = lvlC; a <= lvlDifficultFinal.size() && b <= levelCountFinal; a++, b++) {
            for (String c : gameCount) {
                launchGame(lvlDifficultFinal.get(a), b, c);
            }
        }
        launchGame(110, 11, "FINAL GAME");
        win();
    }

    private static void launchGame(int lvlDifficult, int levelCount, String gameCount) {
        String sign;
        if (!TheMain.isIsEquip()) {
            lvlDifficult = TheMain.getWithOutEquipPercent();
        }
        if (lvlDifficult >= 0) {
            sign = " DIFFICULT +";
        } else
            sign = " DIFFICULT ";

        System.out.println("\n\n===========================================================" +
                " \n========================= Level " + levelCount + " =========================" +
                " \n==================" + sign + lvlDifficult + " PERCENT " + "===================" +
                "\n======================== " + gameCount + " =======================" +
                "\n===========================================================");
        TheMain.setLevelDifficult(lvlDifficult);
        TheMain.setLevelCount(levelCount);

        if (gameCount.equals("VS BOSS") || gameCount.equals("FINAL GAME")) {
            TheMain.setIsBoss(true);
            CreaturesData.getRandomCreature(lvlDifficult);
        } else {
            TheMain.setIsBoss(false);
            CreaturesData.getRandomCreature(lvlDifficult);
        }
        new Fight().launch();
    }


    private static void win() {
        String win = "\n\n\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::" +
                "\n" + TheMain.getPlayerName() + " you went through" + levelCountFinal + " levels and won    " +
                "\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::";
        System.out.println(win.toUpperCase());
        Game.menu();
    }
}
