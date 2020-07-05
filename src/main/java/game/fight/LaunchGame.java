package game.fight;

import game.primary.DefaultValues;
import game.primary.Menu;
import game.primary.Setting;
import game.sql.CreaturesData;

import java.util.Arrays;
import java.util.List;

public class LaunchGame implements DefaultValues {

    private static final int lvlCountList = 10;
    private static final List<Integer> lvlDifficultList = Arrays.asList(0, 10, 20, 30, 40, 50, 60, 70, 80, 90);
    private static final List<String> gameCountList = Arrays.asList("FIRST GAME", "SECOND GAME", "THIRD GAME", "VS BOSS");

    /**
     * This method for level and difficulty generation
     * checking, if, level count and level difficult equals null, if yes, start new game from first level,
     * if not, we get saved game
     */
    public static void getLevel(int getLvlCount, int getLvlDifficult) {
        int lvlD = 0;
        int lvlC = 1;
        if (getLvlCount != 0 && getLvlDifficult != 0) {
            lvlC = getLvlCount;
            lvlD = lvlDifficultList.indexOf(getLvlDifficult);
        }
        if (getLvlDifficult == DEFAULT_INDEX_FOR_GAME_WITHOUT_EQUIPMENTS) {
            lvlD = lvlDifficultList.indexOf(0);
        }
        for (int a = lvlD, b = lvlC; a <= lvlDifficultList.size() && b <= lvlCountList; a++, b++) {
            for (String c : gameCountList) {
                startLevel(lvlDifficultList.get(a), b, c);
            }
        }
        startLevel(110, 11, "FINAL GAME");
        win();
    }

    /**
     * This method for launch game, takes three parameters
     *
     * @param getLvlDifficult shows difficulty for game with equipments, if game without equipment,
     *                        this default represent is fixed for every levels, also this parameter uses for save game
     * @param getLevelCount   shows the number of levels, mainly need for save game, and remember last level
     * @param getGameCount    shows game count, there are 3 game against mobs and one game against boss,
     *                        after those four game you will pass the level
     */
    private static void startLevel(int getLvlDifficult, int getLevelCount, String getGameCount) {
        String sign;
        if (!Setting.isIsGameWithEquipments()) {
            getLvlDifficult = DEFAULT_INDEX_FOR_GAME_WITHOUT_EQUIPMENTS;
        }
        if (getLvlDifficult >= 0) {
            sign = " DIFFICULT +";
        } else
            sign = " DIFFICULT ";

        System.out.println("\n\n===========================================================" +
                " \n========================= Level " + getLevelCount + " =========================" +
                " \n==================" + sign + getLvlDifficult + " PERCENT " + "===================" +
                "\n======================== " + getGameCount + " =======================" +
                "\n===========================================================");

        Setting.setLevelCount(getLevelCount);
        Setting.setLevelDifficult(getLvlDifficult);

        if (getGameCount.equals("VS BOSS") || getGameCount.equals("FINAL GAME")) {
            Setting.setIsGameAgainstBoss(true);
            CreaturesData.getRandomCreatureFomDatabase(getLvlDifficult);
        } else
            Setting.setIsGameAgainstBoss(false);
        CreaturesData.getRandomCreatureFomDatabase(getLvlDifficult);

        new Fight().launchGame();
    }


    private static void win() {
        String win = "\n\n\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::" +
                "\n" + Setting.getPlayerName() + " you went through" + lvlCountList + " levels and won    " +
                "\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::";
        System.out.println(win.toUpperCase());
        Menu.main();
    }
}
