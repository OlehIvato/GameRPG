package Mobs;

public class MainCharactericticOfMobs {
    protected static String heroName;                 //  HERO NAME
    protected static int heroHP;                      // healthpoint of HERO
    protected static String name;                     // MOB and Boss name
    protected static int defaultDamage;               // default damage HERO
    protected static int healthpoint;                 // MOB and Boss HP
    protected static int max_Damage;                  // max damage MOB and Boss
    protected static int min_Damage;                  // min damage MOB and Boss
    protected static int minspelldamageHERO;          // min spell damage HERO
    protected static int maxspellDamageHero;          // max spell damage HERO
    protected static int increasesDamage;             // how much damage can increase Hero
    protected static int restoreshealth;              // how much hp can restore HERO
    protected static int restoreBoss;                 // how many hp boss can restore
    protected static int increaseBoss;                // how much damage boss can increase
    protected static int chanseToSuperDamageMob;      // chance to super damage for MOB
    protected static int chanseToSuperDamageBOSS;     // chance to super Damage for Boss
    protected static int chance;                      // test  [ do not realizations ]
    protected static int mana;                        // mana for Heal Hero

    public MainCharactericticOfMobs(String heroName, int heroHP, int defaultDamage, int minspelldamageHERO, int maxspellDamageHero, int increasesDamage, int restoreshealth, int chance, int mana) {       //FOR HERO
        this.heroName = heroName;
        this.heroHP = heroHP;
        this.defaultDamage = defaultDamage;
        this.minspelldamageHERO = minspelldamageHERO;
        this.maxspellDamageHero = maxspellDamageHero;
        this.increasesDamage = increasesDamage;
        this.restoreshealth = restoreshealth;
        this.chance = chance;
        this.mana = mana;
    }

    public MainCharactericticOfMobs(String name, int healthpoint, int max_Damage, int min_Damage, int chanseToSuperDamageMob) {           // FOR MOB
        this.name = name;
        this.healthpoint = healthpoint;
        this.max_Damage = max_Damage;
        this.min_Damage = min_Damage;
        this.chanseToSuperDamageMob = chanseToSuperDamageMob;

    }


    public MainCharactericticOfMobs(String name, int healthpoint, int max_Damage, int min_Damage, int increaseBoss, int restoreBoss, int chanseToSuperDamageBOSS) {         //FOR BOSS
        this.name = name;
        this.healthpoint = healthpoint;
        this.max_Damage = max_Damage;
        this.min_Damage = min_Damage;
        this.increaseBoss = increaseBoss;
        this.restoreBoss = restoreBoss;
        this.chanseToSuperDamageBOSS = chanseToSuperDamageBOSS;
    }

    public static String getHeroName() {
        return heroName;
    }

    public static void setHeroName(String heroName) {
        MainCharactericticOfMobs.heroName = heroName;
    }

    public static int getHeroHP() {
        return heroHP;
    }

    public static void setHeroHP(int heroHP) {
        MainCharactericticOfMobs.heroHP = heroHP;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        MainCharactericticOfMobs.name = name;
    }

    public static int getDefaultDamage() {
        return defaultDamage;
    }

    public static void setDefaultDamage(int defaultDamage) {
        MainCharactericticOfMobs.defaultDamage = defaultDamage;
    }

    public static int getHealthpoint() {
        return healthpoint;
    }

    public static void setHealthpoint(int healthpoint) {
        MainCharactericticOfMobs.healthpoint = healthpoint;
    }

    public static int getMax_Damage() {
        return max_Damage;
    }

    public static void setMax_Damage(int max_Damage) {
        MainCharactericticOfMobs.max_Damage = max_Damage;
    }

    public static int getMin_Damage() {
        return min_Damage;
    }

    public static void setMin_Damage(int min_Damage) {
        MainCharactericticOfMobs.min_Damage = min_Damage;
    }

    public static int getMinspelldamageHERO() {
        return minspelldamageHERO;
    }

    public static void setMinspelldamageHERO(int minspelldamageHERO) {
        MainCharactericticOfMobs.minspelldamageHERO = minspelldamageHERO;
    }

    public static int getMaxspellDamageHero() {
        return maxspellDamageHero;
    }

    public static void setMaxspellDamageHero(int maxspellDamageHero) {
        MainCharactericticOfMobs.maxspellDamageHero = maxspellDamageHero;
    }

    public static int getIncreasesDamage() {
        return increasesDamage;
    }

    public static void setIncreasesDamage(int increasesDamage) {
        MainCharactericticOfMobs.increasesDamage = increasesDamage;
    }

    public static int getRestoreshealth() {
        return restoreshealth;
    }

    public static void setRestoreshealth(int restoreshealth) {
        MainCharactericticOfMobs.restoreshealth = restoreshealth;
    }

    public static int getRestoreBoss() {
        return restoreBoss;
    }

    public static void setRestoreBoss(int restoreBoss) {
        MainCharactericticOfMobs.restoreBoss = restoreBoss;
    }

    public static int getIncreaseBoss() {
        return increaseBoss;
    }

    public static void setIncreaseBoss(int increaseBoss) {
        MainCharactericticOfMobs.increaseBoss = increaseBoss;
    }

    public static int getChanseToSuperDamageMob() {
        return chanseToSuperDamageMob;
    }
    public static int getChance() {
        return chance;
    }

    public static void setChance(int chance) {
        MainCharactericticOfMobs.chance = chance;
    }

    public static int getMana() {
        return mana;
    }

    public static void setMana(int mana) {
        MainCharactericticOfMobs.mana = mana;
    }

    public static void setChanseToSuperDamageMob(int chanseToSuperDamageMob) {
        MainCharactericticOfMobs.chanseToSuperDamageMob = chanseToSuperDamageMob;
    }

    public static int getChanseToSuperDamageBOSS() {
        return chanseToSuperDamageBOSS;
    }

    public static void setChanseToSuperDamageBOSS(int chanseToSuperDamageBOSS) {
        MainCharactericticOfMobs.chanseToSuperDamageBOSS = chanseToSuperDamageBOSS;
    }
}