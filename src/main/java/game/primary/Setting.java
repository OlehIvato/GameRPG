package game.primary;

abstract public class Setting {

    private static int LEVEL_DIFFICULT;                // level difficult for current level
    private static int LEVEL_COUNT;                    // current level

    private static boolean IS_GAME_WITH_EQUIPMENTS;    // info about game with equipment, or without
    private static boolean IS_GAME_AGAINST_BOSS;       // info about game with boss, or without

    private static String PLAYER_NAME;                 // name of player


    public static int getLevelDifficult() {
        return LEVEL_DIFFICULT;
    }

    public static void setLevelDifficult(int levelDifficult) {
        LEVEL_DIFFICULT = levelDifficult;
    }

    public static int getLevelCount() {
        return LEVEL_COUNT;
    }

    public static void setLevelCount(int levelCount) {
        LEVEL_COUNT = levelCount;
    }

    public static boolean isIsGameWithEquipments() {
        return IS_GAME_WITH_EQUIPMENTS;
    }

    public static void setIsGameWithEquipments(boolean isGameWithEquipments) {
        IS_GAME_WITH_EQUIPMENTS = isGameWithEquipments;
    }

    public static boolean isIsGameAgainstBoss() {
        return IS_GAME_AGAINST_BOSS;
    }

    public static void setIsGameAgainstBoss(boolean isGameAgainstBoss) {
        IS_GAME_AGAINST_BOSS = isGameAgainstBoss;
    }

    public static String getPlayerName() {
        return PLAYER_NAME;
    }

    public static void setPlayerName(String playerName) {
        PLAYER_NAME = playerName;
    }
}