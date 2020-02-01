package Сreature;

public class Main_All {
    protected static String heroName;                 // HERO NAME
    protected static int heroHP;                      // HP of HERO
    protected static int defaultDamage;               // default damage HERO
    protected static int minSpellDamageHERO;          // min spell damage HERO
    protected static int maxSpellDamageHero;          // max spell damage HERO
    protected static int chance;                      // test  [ do not realizations ]
    protected static int restoreHealth;               // how much hp can restore HERO
    protected static int mana;                        // mana for Heal Hero

    protected static String name;                     // MOB and Boss name
    protected static int healthPoint;                 // MOB and Boss HP
    protected static int max_Damage;                  // max damage MOB and Boss
    protected static int min_Damage;                  // min damage MOB and Boss
    protected static int restoreCreature;             // how many hp boss can restore
    protected static int chanceToSuperDamage;         // chance to super damage for MOB AND Boss

    protected static int index = 6;                                   // default index to restore Health point
    protected static int healCast = 33;                               // hum much need mana to healed yourself
    private static int defaultPercent = 25;                         // default index fight without equipment minus POWER



    public Main_All(String heroName, int heroHP, int defaultDamage, int minSpellDamageHERO, int maxSpellDamageHero, int restoreHealth, int chance, int mana) {       //FOR HERO
        this.heroName = heroName;
        this.heroHP = heroHP;
        this.defaultDamage = defaultDamage;
        this.minSpellDamageHERO = minSpellDamageHERO;
        this.maxSpellDamageHero = maxSpellDamageHero;
        this.restoreHealth = restoreHealth;
        this.chance = chance;
        this.mana = mana;
    }

    public Main_All(String name, int healthPoint, int max_Damage, int min_Damage, int chanceToSuperDamage) {           // FOR MOB
        this.name = name;
        this.healthPoint = healthPoint;
        this.max_Damage = max_Damage;
        this.min_Damage = min_Damage;
        this.chanceToSuperDamage = chanceToSuperDamage;

    }

    public Main_All(String name, int healthPoint, int max_Damage, int min_Damage, int restoreCreature, int chanceToSuperDamage) {         //FOR BOSS
        this.name = name;
        this.healthPoint = healthPoint;
        this.max_Damage = max_Damage;
        this.min_Damage = min_Damage;
        this.restoreCreature = restoreCreature;
        this.chanceToSuperDamage = chanceToSuperDamage;
    }

    public Main_All() {

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

    public static int getChance() {
        return chance;
    }

    public static void setChance(int chance) {
        Main_All.chance = chance;
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

    public static int getRestoreHealth() {
        return restoreHealth;
    }

    public static void setRestoreHealth(int restoreHealth) {
        Main_All.restoreHealth = restoreHealth;
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

    public static void setIndex(int index) {
        Main_All.index = index;
    }

    public static int getHealCast() {
        return healCast;
    }

    public static void setHealCast(int healCast) {
        Main_All.healCast = healCast;
    }

    public static int getDefaultPercent() {
        return defaultPercent;
    }

    public static void setDefaultPercent(int defaultPercent) {
        Main_All.defaultPercent = defaultPercent;
    }

}