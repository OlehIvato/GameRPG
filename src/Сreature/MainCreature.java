package Сreature;

import Fight.Fight;
import Main.Game;


public class MainCreature {
    private Long id;
    private String name;
    private int healthPoint;
    private int min_Damage;
    private int max_Damage;
    private int restoreHealth;
    private int chanceToSuperDamage;

    private static int finalHp = Main_All.getHealthPoint();
    private static int finalMinDamage = Main_All.getMin_Damage();
    private static int finalMaxDamage = Main_All.getMax_Damage();
    private static int finalRestoreHealthPoint = Main_All.getRestoreCreature();
    private static int finalChance = Main_All.getChanceToSuperDamage();


    public void fightMob() {
        Game.isBoss = false;
        if (Game.isEquip) {
            Main_All.setName(name);
            Main_All.setHealthPoint(finalHp + healthPoint);
            Main_All.setMin_Damage(finalMinDamage + min_Damage);
            Main_All.setMax_Damage(finalMaxDamage + max_Damage);
            Main_All.setChanceToSuperDamage(finalChance + chanceToSuperDamage);
        }
        if (!Game.isEquip) {
            Main_All.setName(name);
            Main_All.setHealthPoint(finalHp + GetRandom.changer(healthPoint));
            Main_All.setMin_Damage(finalMinDamage + GetRandom.changer(min_Damage));
            Main_All.setMax_Damage(finalMaxDamage + GetRandom.changer(max_Damage));
            Main_All.setChanceToSuperDamage(finalChance + GetRandom.changer(chanceToSuperDamage));
        }
        Fight f = new Fight();
        f.main();
    }

    public void fightBoss() {
        Game.isBoss = true;
        if (Game.isEquip) {
            Main_All.setName(name);
            Main_All.setHealthPoint(finalHp + healthPoint);
            Main_All.setMin_Damage(finalMinDamage + min_Damage);
            Main_All.setMax_Damage(finalMaxDamage + max_Damage);
            Main_All.setRestoreCreature(finalRestoreHealthPoint + restoreHealth);
            Main_All.setChanceToSuperDamage(finalChance + chanceToSuperDamage);

        }
        if (!Game.isEquip) {
            Main_All.setName(name);
            Main_All.setHealthPoint(finalHp + GetRandom.changer(healthPoint));
            Main_All.setMin_Damage(finalMinDamage + GetRandom.changer(min_Damage));
            Main_All.setMax_Damage(finalMaxDamage + GetRandom.changer(max_Damage));
            Main_All.setRestoreCreature(finalRestoreHealthPoint + GetRandom.changer(restoreHealth));
            Main_All.setChanceToSuperDamage(finalChance + GetRandom.changer(chanceToSuperDamage));
        }
        Fight f = new Fight();
        f.main();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    public int getMin_Damage() {
        return min_Damage;
    }

    public int getRestoreHealth() {
        return restoreHealth;
    }

    public void setRestoreHealth(int restoreHealth) {
        this.restoreHealth = restoreHealth;
    }

    public void setMin_Damage(int min_Damage) {
        this.min_Damage = min_Damage;
    }

    public int getMax_Damage() {
        return max_Damage;
    }

    public void setMax_Damage(int max_Damage) {
        this.max_Damage = max_Damage;
    }


    public int getChanceToSuperDamage() {
        return chanceToSuperDamage;
    }

    public void setChanceToSuperDamage(int chanceToSuperDamage) {
        this.chanceToSuperDamage = chanceToSuperDamage;
    }

    public static int getFinalHp() {
        return finalHp;
    }

    public static void setFinalHp(int finalHp) {
        MainCreature.finalHp = finalHp;
    }

    public static int getFinalMinDamage() {
        return finalMinDamage;
    }

    public static void setFinalMinDamage(int finalMinDamage) {
        MainCreature.finalMinDamage = finalMinDamage;
    }

    public static int getFinalMaxDamage() {
        return finalMaxDamage;
    }

    public static void setFinalMaxDamage(int finalMaxDamage) {
        MainCreature.finalMaxDamage = finalMaxDamage;
    }

    public static int getFinalRestoreHealthPoint() {
        return finalRestoreHealthPoint;
    }

    public static void setFinalRestoreHealthPoint(int finalRestoreHealthPoint) {
        MainCreature.finalRestoreHealthPoint = finalRestoreHealthPoint;
    }

    public static int getFinalChance() {
        return finalChance;
    }

    public static void setFinalChance(int finalChance) {
        MainCreature.finalChance = finalChance;
    }
}
