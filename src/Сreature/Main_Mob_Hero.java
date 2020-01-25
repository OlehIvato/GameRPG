package Сreature;

public class Main_Mob_Hero {
    protected static String heroName;                 //  HERO NAME
    protected static int heroHP;                      // HP of HERO
    protected static String name;                     // MOB and Boss name
    protected static int defaultDamage;               // default damage HERO
    protected static int healthPoint;                 // MOB and Boss HP
    protected static int max_Damage;                  // max damage MOB and Boss
    protected static int min_Damage;                  // min damage MOB and Boss
    protected static int minSpellDamageHERO;          // min spell damage HERO
    protected static int maxSpellDamageHero;          // max spell damage HERO
    protected static int restoreHealth;              // how much hp can restore HERO
    protected static int restoreBoss;                 // how many hp boss can restore
    protected static int increaseBoss;                // how much damage boss can increase
    protected static int chanceToSuperDamageMob;      // chance to super damage for MOB
    protected static int chanceToSuperDamageBOSS;     // chance to super Damage for Boss
    protected static int chance;                      // test  [ do not realizations ]
    protected static int mana;                        // mana for Heal Hero
    private static int index = 6;                     // default index to restore damage
    private static int healCast = 33;                 // hum much need mana to healed yourself


    public Main_Mob_Hero(String heroName, int heroHP, int defaultDamage, int minSpellDamageHERO, int maxSpellDamageHero, int restoreHealth, int chance, int mana) {       //FOR HERO
        this.heroName = heroName;
        this.heroHP = heroHP;
        this.defaultDamage = defaultDamage;
        this.minSpellDamageHERO = minSpellDamageHERO;
        this.maxSpellDamageHero = maxSpellDamageHero;
        this.restoreHealth = restoreHealth;
        this.chance = chance;
        this.mana = mana;
    }

    public Main_Mob_Hero(String name, int healthPoint, int max_Damage, int min_Damage, int chanceToSuperDamageMob) {           // FOR MOB
        this.name = name;
        this.healthPoint = healthPoint;
        this.max_Damage = max_Damage;
        this.min_Damage = min_Damage;
        this.chanceToSuperDamageMob = chanceToSuperDamageMob;

    }

    public Main_Mob_Hero(String name, int healthPoint, int max_Damage, int min_Damage, int increaseBoss, int restoreBoss, int chanceToSuperDamageBOSS) {         //FOR BOSS
        this.name = name;
        this.healthPoint = healthPoint;
        this.max_Damage = max_Damage;
        this.min_Damage = min_Damage;
        this.increaseBoss = increaseBoss;
        this.restoreBoss = restoreBoss;
        this.chanceToSuperDamageBOSS = chanceToSuperDamageBOSS;
    }

    public Main_Mob_Hero() {

    }

    public static String getHeroName() {
        return heroName;
    }

    public static void setHeroName(String heroName) {
        Main_Mob_Hero.heroName = heroName;
    }

    public static int getHeroHP() {
        return heroHP;
    }

    public static void setHeroHP(int heroHP) {
        Main_Mob_Hero.heroHP = heroHP;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Main_Mob_Hero.name = name;
    }

    public static int getDefaultDamage() {
        return defaultDamage;
    }

    public static void setDefaultDamage(int defaultDamage) {
        Main_Mob_Hero.defaultDamage = defaultDamage;
    }

    public static int getHealthPoint() {
        return healthPoint;
    }

    public static void setHealthPoint(int healthPoint) {
        Main_Mob_Hero.healthPoint = healthPoint;
    }

    public static int getMax_Damage() {
        return max_Damage;
    }

    public static void setMax_Damage(int max_Damage) {
        Main_Mob_Hero.max_Damage = max_Damage;
    }

    public static int getMin_Damage() {
        return min_Damage;
    }

    public static void setMin_Damage(int min_Damage) {
        Main_Mob_Hero.min_Damage = min_Damage;
    }

    public static int getMinSpellDamageHERO() {
        return minSpellDamageHERO;
    }

    public static void setMinSpellDamageHERO(int minSpellDamageHERO) {
        Main_Mob_Hero.minSpellDamageHERO = minSpellDamageHERO;
    }

    public static int getMaxSpellDamageHero() {
        return maxSpellDamageHero;
    }

    public static void setMaxSpellDamageHero(int maxSpellDamageHero) {
        Main_Mob_Hero.maxSpellDamageHero = maxSpellDamageHero;
    }

    public static int getRestoreHealth() {
        return restoreHealth;
    }

    public static void setRestoreHealth(int restoreHealth) {
        Main_Mob_Hero.restoreHealth = restoreHealth;
    }

    public static int getRestoreBoss() {
        return restoreBoss;
    }

    public static void setRestoreBoss(int restoreBoss) {
        Main_Mob_Hero.restoreBoss = restoreBoss;
    }

    public static int getIncreaseBoss() {
        return increaseBoss;
    }

    public static void setIncreaseBoss(int increaseBoss) {
        Main_Mob_Hero.increaseBoss = increaseBoss;
    }

    public static int getChanceToSuperDamageMob() {
        return chanceToSuperDamageMob;
    }

    public static void setChanceToSuperDamageMob(int chanceToSuperDamageMob) {
        Main_Mob_Hero.chanceToSuperDamageMob = chanceToSuperDamageMob;
    }

    public static int getChanceToSuperDamageBOSS() {
        return chanceToSuperDamageBOSS;
    }

    public static void setChanceToSuperDamageBOSS(int chanceToSuperDamageBOSS) {
        Main_Mob_Hero.chanceToSuperDamageBOSS = chanceToSuperDamageBOSS;
    }

    public static int getChance() {
        return chance;
    }

    public static void setChance(int chance) {
        Main_Mob_Hero.chance = chance;
    }

    public static int getMana() {
        return mana;
    }

    public static void setMana(int mana) {
        Main_Mob_Hero.mana = mana;
    }

    public static int getIndex() {
        return index;
    }

    public static void setIndex(int index) {
        Main_Mob_Hero.index = index;
    }

    public static int getHealCast() {
        return healCast;
    }

    public static void setHealCast(int healCast) {
        Main_Mob_Hero.healCast = healCast;
    }
}