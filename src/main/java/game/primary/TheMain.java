package game.primary;

abstract public class TheMain {
    private static final String username = "root";
    private static final String password = "root";
    private static final String url = "jdbc:mysql://localhost/minirpggame" +
            "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    protected static String heroArmor;
    protected static String heroClass;
    protected static String heroName;
    protected static int heroHp;
    protected static int heroDamage;
    protected static int heroMinSpell;
    protected static int heroMaxSpell;
    protected static int heroRestoreHp;             // how much hp hero can restore
    protected static int heroMana;                  // mana for Heal Hero

    protected static String mobName;
    protected static int mobHp;
    protected static int mobMaxDamage;
    protected static int mobMinDamage;
    protected static int mobRestoreHp;              // how many hp boss can restore
    protected static int mobChanceToSuperDamage;    // chance to super damage for MOB AND Boss

    protected int superDamage = (int) (mobMaxDamage * 1.5);
    protected static final byte restoreDefaultIndex = 6;                  // default index to restore Health point
    protected static final byte healCast = 33;              // how much need mana to heal yourself
    protected static final byte withOutEquipPercent = -25;  // default index fight without equipment minus all characteristics

    protected static int levelDifficult;              // level difficult for current level
    protected static int levelCount;                  // current level

    protected static boolean isEquip;         // info about game with equipment, or without
    protected static boolean isBoss;          // info about game with boss, or without
    protected static String playerName;        // name of player


    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }

    public static String getUrl() {
        return url;
    }

    public static String getHeroArmor() {
        return heroArmor;
    }

    public static void setHeroArmor(String heroArmor) {
        TheMain.heroArmor = heroArmor;
    }

    public static String getHeroClass() {
        return heroClass;
    }

    public static void setHeroClass(String heroClass) {
        TheMain.heroClass = heroClass;
    }

    public static String getHeroName() {
        return heroName;
    }

    public static void setHeroName(String heroName) {
        TheMain.heroName = heroName;
    }

    public static int getHeroHp() {
        return heroHp;
    }

    public static void setHeroHp(int heroHp) {
        TheMain.heroHp = heroHp;
    }

    public static int getHeroDamage() {
        return heroDamage;
    }

    public static void setHeroDamage(int heroDamage) {
        TheMain.heroDamage = heroDamage;
    }

    public static int getHeroMinSpell() {
        return heroMinSpell;
    }

    public static void setHeroMinSpell(int heroMinSpell) {
        TheMain.heroMinSpell = heroMinSpell;
    }

    public static int getHeroMaxSpell() {
        return heroMaxSpell;
    }

    public static void setHeroMaxSpell(int heroMaxSpell) {
        TheMain.heroMaxSpell = heroMaxSpell;
    }

    public static int getHeroRestoreHp() {
        return heroRestoreHp;
    }

    public static void setHeroRestoreHp(int heroRestoreHp) {
        TheMain.heroRestoreHp = heroRestoreHp;
    }

    public static int getHeroMana() {
        return heroMana;
    }

    public static void setHeroMana(int heroMana) {
        TheMain.heroMana = heroMana;
    }

    public static String getMobName() {
        return mobName;
    }

    public static void setMobName(String mobName) {
        TheMain.mobName = mobName;
    }

    public static int getMobHp() {
        return mobHp;
    }

    public static void setMobHp(int mobHp) {
        TheMain.mobHp = mobHp;
    }

    public static int getMobMaxDamage() {
        return mobMaxDamage;
    }

    public static void setMobMaxDamage(int mobMaxDamage) {
        TheMain.mobMaxDamage = mobMaxDamage;
    }

    public static int getMobMinDamage() {
        return mobMinDamage;
    }

    public static void setMobMinDamage(int mobMinDamage) {
        TheMain.mobMinDamage = mobMinDamage;
    }

    public static int getMobRestoreHp() {
        return mobRestoreHp;
    }

    public static void setMobRestoreHp(int mobRestoreHp) {
        TheMain.mobRestoreHp = mobRestoreHp;
    }

    public static int getMobChanceToSuperDamage() {
        return mobChanceToSuperDamage;
    }

    public static void setMobChanceToSuperDamage(int mobChanceToSuperDamage) {
        TheMain.mobChanceToSuperDamage = mobChanceToSuperDamage;
    }

    public int getSuperDamage() {
        return superDamage;
    }

    public void setSuperDamage(int superDamage) {
        this.superDamage = superDamage;
    }

    public static byte getRestoreDefaultIndex() {
        return restoreDefaultIndex;
    }

    public static byte getHealCast() {
        return healCast;
    }

    public static byte getWithOutEquipPercent() {
        return withOutEquipPercent;
    }

    public static int getLevelDifficult() {
        return levelDifficult;
    }

    public static void setLevelDifficult(int levelDifficult) {
        TheMain.levelDifficult = levelDifficult;
    }

    public static int getLevelCount() {
        return levelCount;
    }

    public static void setLevelCount(int levelCount) {
        TheMain.levelCount = levelCount;
    }

    public static boolean isIsEquip() {
        return isEquip;
    }

    public static void setIsEquip(boolean isEquip) {
        TheMain.isEquip = isEquip;
    }

    public static boolean isIsBoss() {
        return isBoss;
    }

    public static void setIsBoss(boolean isBoss) {
        TheMain.isBoss = isBoss;
    }

    public static String getPlayerName() {
        return playerName;
    }

    public static void setPlayerName(String playerName) {
        TheMain.playerName = playerName;
    }
}
