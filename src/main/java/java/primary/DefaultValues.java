package game.primary;

import java.util.Scanner;

public interface DefaultValues {

    Scanner SCANNER = new Scanner(System.in);
    byte DEFAULT_RESTORE_HP_INDEX = 6;    // default index to restore Health point
    byte DEFAULT_HEAL_CAST = 33;              // how much need mana to heal yourself
    byte DEFAULT_INDEX_GAME_WITHOUT_EQUIP = -25; // default index fight without equipment minus all characteristics
    short SUPER_DAMAGE = (short) (MainData.getMobMaxDamage() * 1.5); // super damage for creatures
    byte LEVEL_COUNT = 10; // how many levels in game
}

