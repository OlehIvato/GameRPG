package spring.controller.gameController;

import org.junit.After;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

public class SelectEquipmentControllerTest {


    private int count = 0;
    private List<Integer> equipSetting = Arrays.asList(0, 0, 1, 1, 0, 1, 1, 0);

    @Test
    public void generateEquipment() {
        count++;
        if (equipSetting.get(0) == 1 && count == 1) {
            System.out.println("return getHead");
        }
        if (equipSetting.get(1) == 1 && count == 2) {
            System.out.println("return getShoulder");
        }
        if (equipSetting.get(2) == 1 && count == 3) {
            System.out.println("return getChest");
        }
        if (equipSetting.get(3) == 1 && count == 4) {
            System.out.println("return getLegs");
        }
        if (equipSetting.get(4) == 1 && count == 5) {
            System.out.println("return getWand");
        }
        if (equipSetting.get(5) == 1 && count == 6) {
            System.out.println("return getSword");
        }
        if (equipSetting.get(6) == 1 && count == 7) {
            System.out.println("return getShield");
        }
        if (equipSetting.get(7) == 1 && count == 8) {
            System.out.println("return getAmulet");
        }
    }

    @After
    public void tearDown() throws Exception {
        for (int i = 0; i < equipSetting.size(); i++) {
            generateEquipment();

        }
    }
}