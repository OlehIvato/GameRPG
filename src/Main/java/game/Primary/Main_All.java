package game.primary;

public class Main_All   {
    private static final String userName = "root";
    private static final String password = "root";
    private static final String url = "jdbc:mysql://localhost:3306/minirpggame";

    private static String heroArmorType;              // HERO Armor Type
    private static String heroClass;                  // HERO Class
    private static String heroName;                   // HERO NAME
    protected static int heroHP;                      // HP of HERO
    protected static int defaultDamage;               // default damage HERO
    protected static int minSpellDamageHERO;          // min spell damage HERO
    protected static int maxSpellDamageHero;          // max spell damage HERO
    protected static int restoreHealth;               // how much hp can restore HERO
    protected static int mana;                        // mana for Heal Hero

    protected static String name;                     // MOB and Boss name
    protected static int healthPoint;                 // MOB and Boss HP
    protected static int max_Damage;                  // max damage MOB and Boss
    protected static int min_Damage;                  // min damage MOB and Boss
    protected static int restoreCreature;             // how many hp boss can restore
    protected static int chanceToSuperDamage;         // chance to super damage for MOB AND Boss

    protected static final int index = 6;                   // default index to restore Health point
    protected static final int healCast = 33;               // how much need mana to heal yourself
    private static final int defaultPercent = 25;           // default index fight without equipment minus all characteristics



    public static String getUserName() {
        return userName;
    }

    public static String getPassword() {
        return password;
    }

    public static String getUrl() {
        return url;
    }

    public static String getHeroArmorType() {
        return heroArmorType;
    }

    public static void setHeroArmorType(String heroArmorType) {
        Main_All.heroArmorType = heroArmorType;
    }

    public static String getHeroClass() {
        return heroClass;
    }

    public static void setHeroClass(String heroClass) {
        Main_All.heroClass = heroClass;
    }

    public static String getHeroName() {
        return heroName;
    }

    public static void setHeroName(String heroName) {
        Main_All.heroName = heroName;
    }

    public static int getHeroHP() {
        return heroHP;
    }

    public static void setHeroHP(int heroHP) {
        Main_All.heroHP = heroHP;
    }

    public static int getDefaultDamage() {
        return defaultDamage;
    }

    public static void setDefaultDamage(int defaultDamage) {
        Main_All.defaultDamage = defaultDamage;
    }

    public static int getMinSpellDamageHERO() {
        return minSpellDamageHERO;
    }

    public static void setMinSpellDamageHERO(int minSpellDamageHERO) {
        Main_All.minSpellDamageHERO = minSpellDamageHERO;
    }

    public static int getMaxSpellDamageHero() {
        return maxSpellDamageHero;
    }

    public static void setMaxSpellDamageHero(int maxSpellDamageHero) {
        Main_All.maxSpellDamageHero = maxSpellDamageHero;
    }

    public static int getRestoreHealth() {
        return restoreHealth;
    }

    public static void setRestoreHealth(int restoreHealth) {
        Main_All.restoreHealth = restoreHealth;
    }

    public static int getMana() {
        return mana;
    }

    public static void setMana(int mana) {
        Main_All.mana = mana;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Main_All.name = name;
    }

    public static int getHealthPoint() {
        return healthPoint;
    }

    public static void setHealthPoint(int healthPoint) {
        Main_All.healthPoint = healthPoint;
    }

    public static int getMax_Damage() {
        return max_Damage;
    }

    public static void setMax_Damage(int max_Damage) {
        Main_All.max_Damage = max_Damage;
    }

    public static int getMin_Damage() {
        return min_Damage;
    }

    public static void setMin_Damage(int min_Damage) {
        Main_All.min_Damage = min_Damage;
    }

    public static int getRestoreCreature() {
        return restoreCreature;
    }

    public static void setRestoreCreature(int restoreCreature) {
        Main_All.restoreCreature = restoreCreature;
    }

    public static int getChanceToSuperDamage() {
        return chanceToSuperDamage;
    }

    public static void setChanceToSuperDamage(int chanceToSuperDamage) {
        Main_All.chanceToSuperDamage = chanceToSuperDamage;
    }

    public static int getIndex() {
        return index;
    }

    public static int getHealCast() {
        return healCast;
    }

    public static int getDefaultPercent() {
        return defaultPercent;
    }

}