package game.creature;

import game.primary.Game;
import game.primary.TheMain;


public class MainCreature {
    private Long id;
    private String name;
    private int hp;
    private int minDamage;
    private int maxDamage;
    private int restoreHealth;
    private int chanceToSuperDamage;

    чекнгути сет прямо в мейн



    // без статичних полів дані будуть залишатися змінені а не оновлюватися
    private static int finalHp = TheMain.getMobHp();
    private static int finalMinDamage = TheMain.getMobMinDamage();
    private static int finalMaxDamage = TheMain.getMobMaxDamage();
    private static int finalRestoreHealth = TheMain.getMobRestoreHp();
    private static int finalChance = TheMain.getMobChanceToSuperDamage();

    public void setValuesToMain() {
        if (!Game.isBoss) {
            if (Game.isEquip) {
                TheMain.setMobName(name);
                TheMain.setMobHp(finalHp + hp);
                TheMain.setMobMinDamage(finalMinDamage + minDamage);
                TheMain.setMobMaxDamage(finalMaxDamage + maxDamage);
                TheMain.setMobChanceToSuperDamage(finalChance + chanceToSuperDamage);
            }

            if (!Game.isEquip) {
                TheMain.setMobName(name);
                TheMain.setMobHp(finalHp + GetRandom.changer(hp));
                TheMain.setMobMinDamage(finalMinDamage + GetRandom.changer(minDamage));
                TheMain.setMobMaxDamage(finalMaxDamage + GetRandom.changer(maxDamage));
                TheMain.setMobChanceToSuperDamage(finalChance + GetRandom.changer(chanceToSuperDamage));
            }
        }
        if (Game.isBoss) {
            if (Game.isEquip) {
                TheMain.setMobName(name);
                TheMain.setMobHp(finalHp + hp);
                TheMain.setMobMinDamage(finalMinDamage + minDamage);
                TheMain.setMobMaxDamage(finalMaxDamage + maxDamage);
                TheMain.setMobRestoreHp(finalRestoreHealth + restoreHealth);
                TheMain.setMobChanceToSuperDamage(finalChance + chanceToSuperDamage);

            }
            if (!Game.isEquip) {
                TheMain.setMobName(name);
                TheMain.setMobHp(finalHp + GetRandom.changer(hp));
                TheMain.setMobMinDamage(finalMinDamage + GetRandom.changer(minDamage));
                TheMain.setMobMaxDamage(finalMaxDamage + GetRandom.changer(maxDamage));
                TheMain.setMobRestoreHp(finalRestoreHealth + GetRandom.changer(restoreHealth));
                TheMain.setMobChanceToSuperDamage(finalChance + GetRandom.changer(chanceToSuperDamage));
            }
        }
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

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public void setMinDamage(int minDamage) {
        this.minDamage = minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }

    public int getRestoreHealth() {
        return restoreHealth;
    }

    public void setRestoreHealth(int restoreHealth) {
        this.restoreHealth = restoreHealth;
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

    public static int getFinalRestoreHealth() {
        return finalRestoreHealth;
    }

    public static void setFinalRestoreHealth(int finalRestoreHealth) {
        MainCreature.finalRestoreHealth = finalRestoreHealth;
    }

    public static int getFinalChance() {
        return finalChance;
    }

    public static void setFinalChance(int finalChance) {
        MainCreature.finalChance = finalChance;
    }
}
