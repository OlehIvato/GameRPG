package game.Fight;

import game.Primary.NewGame;
import game.Primary.UserName;
import game.Сreature.GetRandom;

public interface Level {
    String level1 = "Level 1";
    String level2 = "Level 2";
    String level3 = "Level 3";
    String level4 = "Level 4";
    String level5 = "Level 5";
    String level6 = "Level 6";
    String level7 = "Level 7";
    String level8 = "Level 8";
    String level9 = "Level 9";
    String level10 = "Level 10";
    String fightVsBoss = "FINAL";
    String fightFinalVsBoss = "FINAL FIGHT";

    String gameFirst = "FIRST GAME";
    String gameSecond = "SECOND GAME";
    String gameThird = "THIRD GAME";
    String gameVsBoss = "VS BOSS";

    static void mob(Integer lvl, String levelDescription, String game) {
        String cases = "\n\n===========================================================" +
                " \n===========================" + levelDescription + "=========================" +
                " \n==================" + " DIFFICULT +" + lvl + " PERCENT " + "===================" +
                "\n=========================" + game + "========================" +
                "\n===========================================================";
        System.out.println(cases);
        GetRandom.random(lvl);
    }


    static void boss(int lvl, String levelDescription, String game) {
        String cases = "\n\n===========================================================" +
                " \n===========================" + levelDescription + "=========================" +
                " \n==================" + " DIFFICULT +" + lvl + " PERCENT " + "===================" +
                "\n=========================" + game + "========================" +
                "\n===========================================================";
        System.out.println(cases);
        GetRandom.random_Boss(lvl);
    }

    static void win() {
        String win = "\n\n\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::" +
                "\n" + UserName.getUserName() + " you went through three levels and won    " +
                "\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::";
        System.out.println(win.toUpperCase());
        NewGame.backToMain();
    }
}
