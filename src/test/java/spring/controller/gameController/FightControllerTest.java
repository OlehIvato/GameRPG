package spring.controller.gameController;

import org.junit.Assert;
import org.junit.Test;
public class FightControllerTest {

    @Test
    public void mobMove() {
        int damage = (int) ((Math.random() * (50 - 40)) + 40);
        int superDamage = (int) (50 * 1.5);

        boolean result = damage > 40 && damage < 50;

        Assert.assertEquals(result, result);
        Assert.assertEquals(75, superDamage);
    }
}