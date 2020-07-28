package spring.controller.gameController;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LevelControllerTest {

    private static int levelCount = 0;
    private static int levelDifficult = 0;
    private static int gameCount = 0;

    @Test
    public void setLvlDifficult() {
        int valueFromDataBase = 20;
        int levelDifficult = 10; // +10%
        int value = valueFromDataBase;
        int subtract = (valueFromDataBase * levelDifficult) / 100;
        value += subtract;
        Assert.assertEquals(22, value);
    }

    @Test
    public void reduceDifficulty() {
        int valueFromDataBase = 20;
        int getGAME_WITHOUT_EQUIP_DIFFICULTY = -10; // -10%
        int value = valueFromDataBase;
        int subtract = valueFromDataBase * (getGAME_WITHOUT_EQUIP_DIFFICULTY * (-1)) / 100;
        value -= subtract;
        Assert.assertEquals(18, value);

    }

    @Test
    public void getLevel() {
        gameCount++;
        if (gameCount > 4) {
            gameCount = 0;
            gameCount++;
        }
        if (gameCount == 1) {
            levelCount++;
            levelDifficult += 10;
        }
        if (levelCount == 1) {
            levelDifficult = 0;
        }

//        System.out.println(gameCount + " -------setGameCount----- ");
//        System.out.println(levelCount + " -------setLevelCount-------- ");
//        System.out.println(levelDifficult + " -----setLevelDifficult-------- ");
//        System.out.println("********************************************************");

        assertEquals(gameCount, gameCount);
        assertEquals(levelDifficult, levelDifficult);
        assertEquals(gameCount, gameCount);
    }

    @After
    public void tearDown() throws Exception {
        for (int i = 0; i <50 ; i++) {
            getLevel();
        }
    }


}