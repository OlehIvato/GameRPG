package game.primary;

import java.util.Scanner;

public interface DefaultValues {

    Scanner scanner = new Scanner(System.in);
    byte restoreDefaultIndex = 6;    // default index to restore Health point
    byte healCast = 33;              // how much need mana to heal yourself
    byte withOutEquipPercent = -25;  // default index fight without equipment minus all characteristics


}
