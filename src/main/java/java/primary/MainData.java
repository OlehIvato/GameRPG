package game.primary;

/**
 * This is the main class of the program, other classes set values here,
 * and Fight class gets values from here to fight.
 */
abstract public class MainData  {
    private static String heroArmor;
    private static String heroClass;
    private static String heroName;
    private static int heroHp;
    private static int heroDamage;
    private static int heroMinSpell;
    private static int heroMaxSpell;
    private static int heroRestoreHp;             // how much hp hero can restore
    private static int heroMana;                  // mana for Heal Hero

    private static String mobName;
    private static int mobHp;
    private static int mobMaxDamage;
    private static int mobMinDamage;
    private static int mobRestoreHp;              // how many hp boss can restore
    private static int mobChanceToSuperDamage;    // chance to super damage for MOB AND Boss


    public static String getHeroArmor() {
        return heroArmor;
    }

    public static void setHeroArmor(String heroArmor) {
        MainData.heroArmor = heroArmor;
    }

    public static String getHeroClass() {
        return heroClass;
    }

    public static void setHeroClass(String heroClass) {
        MainData.heroClass = heroClass;
    }

    public static String getHeroName() {
        return heroName;
    }

    public static void setHeroName(String heroName) {
        MainData.heroName = heroName;
    }

    public static int getHeroHp() {
        return heroHp;
    }

    public static void setHeroHp(int heroHp) {
        MainData.heroHp = heroHp;
    }

    public static int getHeroDamage() {
        return heroDamage;
    }

    public static void setHeroDamage(int heroDamage) {
        MainData.heroDamage = heroDamage;
    }

    public static int getHeroMinSpell() {
        return heroMinSpell;
    }

    public static void setHeroMinSpell(int heroMinSpell) {
        MainData.heroMinSpell = heroMinSpell;
    }

    public static int getHeroMaxSpell() {
        return heroMaxSpell;
    }

    public static void setHeroMaxSpell(int heroMaxSpell) {
        MainData.heroMaxSpell = heroMaxSpell;
    }

    public static int getHeroRestoreHp() {
        return heroRestoreHp;
    }

    public static void setHeroRestoreHp(int heroRestoreHp) {
        MainData.heroRestoreHp = heroRestoreHp;
    }

    public static int getHeroMana() {
        return heroMana;
    }

    public static void setHeroMana(int heroMana) {
        MainData.heroMana = heroMana;
    }

    public static String getMobName() {
        return mobName;
    }

    public static void setMobName(String mobName) {
        MainData.mobName = mobName;
    }

    public static int getMobHp() {
        return mobHp;
    }

    public static void setMobHp(int mobHp) {
        MainData.mobHp = mobHp;
    }

    public static int getMobMaxDamage() {
        return mobMaxDamage;
    }

    public static void setMobMaxDamage(int mobMaxDamage) {
        MainData.mobMaxDamage = mobMaxDamage;
    }

    public static int getMobMinDamage() {
        return mobMinDamage;
    }

    public static void setMobMinDamage(int mobMinDamage) {
        MainData.mobMinDamage = mobMinDamage;
    }

    public static int getMobRestoreHp() {
        return mobRestoreHp;
    }

    public static void setMobRestoreHp(int mobRestoreHp) {
        MainData.mobRestoreHp = mobRestoreHp;
    }

    public static int getMobChanceToSuperDamage() {
        return mobChanceToSuperDamage;
    }

    public static void setMobChanceToSuperDamage(int mobChanceToSuperDamage) {
        MainData.mobChanceToSuperDamage = mobChanceToSuperDamage;
    }

}
