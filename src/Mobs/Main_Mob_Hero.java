package Mobs;

import Armor.Stick;

public class Main_Mob_Hero {
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
    private static int index = 6;                     // default index to restore damage
    private static int healcast = 33;







    public Main_Mob_Hero(String heroName, int heroHP, int defaultDamage, int minspelldamageHERO, int maxspellDamageHero, int increasesDamage, int restoreshealth, int chance, int mana) {       //FOR HERO
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

    public Main_Mob_Hero(String name, int healthpoint, int max_Damage, int min_Damage, int chanseToSuperDamageMob) {           // FOR MOB
        this.name = name;
        this.healthpoint = healthpoint;
        this.max_Damage = max_Damage;
        this.min_Damage = min_Damage;
        this.chanseToSuperDamageMob = chanseToSuperDamageMob;

    }


    public Main_Mob_Hero(String name, int healthpoint, int max_Damage, int min_Damage, int increaseBoss, int restoreBoss, int chanseToSuperDamageBOSS) {         //FOR BOSS
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
        Main_Mob_Hero.heroName = heroName;
    }

    public static int getHeroHP() {
        return heroHP;
    }

    public static void setHeroHP(int heroHP) {
        Main_Mob_Hero.heroHP = heroHP;
    }

    public static int getIndex() {
        return index;
    }

    public static void setIndex(int index) {
        Main_Mob_Hero.index = index;
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

    public static int getHealthpoint() {
        return healthpoint;
    }

    public static void setHealthpoint(int healthpoint) {
        Main_Mob_Hero.healthpoint = healthpoint;
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

    public static int getMinspelldamageHERO() {
        return minspelldamageHERO;
    }

    public static void setMinspelldamageHERO(int minspelldamageHERO) {
        Main_Mob_Hero.minspelldamageHERO = minspelldamageHERO;
    }

    public static int getMaxspellDamageHero() {
        return maxspellDamageHero;
    }

    public static void setMaxspellDamageHero(int maxspellDamageHero) {
        Main_Mob_Hero.maxspellDamageHero = maxspellDamageHero;
    }

    public static int getIncreasesDamage() {
        return increasesDamage;
    }

    public static void setIncreasesDamage(int increasesDamage) {
        Main_Mob_Hero.increasesDamage = increasesDamage;
    }
    public static int getHealcast() {
        return healcast;
    }

    public static void setHealcast(int healcast) {
        Main_Mob_Hero.healcast = healcast;
    }
    public static int getRestoreshealth() {
        return restoreshealth;
    }

    public static void setRestoreshealth(int restoreshealth) {
        Main_Mob_Hero.restoreshealth = restoreshealth;
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

    public static int getChanseToSuperDamageMob() {
        return chanseToSuperDamageMob;
    }

    public static void setChanseToSuperDamageMob(int chanseToSuperDamageMob) {
        Main_Mob_Hero.chanseToSuperDamageMob = chanseToSuperDamageMob;
    }

    public static int getChanseToSuperDamageBOSS() {
        return chanseToSuperDamageBOSS;
    }

    public static void setChanseToSuperDamageBOSS(int chanseToSuperDamageBOSS) {
        Main_Mob_Hero.chanseToSuperDamageBOSS = chanseToSuperDamageBOSS;
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
}