package Сreature;

public class MainBosses {

    private String nameBoss;
    private int healthPointBoss;
    private int min_DamageBoss;
    private int max_DamageBoss;
    private int increaseDamageBoss;
    private int restoreHealthPointBoss;
    private int chanceToSuperDamageBoss;

    public MainBosses(String nameBoss, int healthPointBoss, int min_DamageBoss, int max_DamageBoss, int increaseDamageBoss, int restoreHealthPointBoss, int chanceToSuperDamageBoss) {
        this.nameBoss = nameBoss;
        this.healthPointBoss = healthPointBoss;
        this.min_DamageBoss = min_DamageBoss;
        this.max_DamageBoss = max_DamageBoss;
        this.increaseDamageBoss = increaseDamageBoss;
        this.restoreHealthPointBoss = restoreHealthPointBoss;
        this.chanceToSuperDamageBoss = chanceToSuperDamageBoss;
    }

    public String getNameBoss() {
        return nameBoss;
    }

    public void setNameBoss(String nameBoss) {
        this.nameBoss = nameBoss;
    }

    public int getHealthPointBoss() {
        return healthPointBoss;
    }

    public void setHealthPointBoss(int healthPointBoss) {
        this.healthPointBoss = healthPointBoss;
    }

    public int getMin_DamageBoss() {
        return min_DamageBoss;
    }

    public void setMin_DamageBoss(int min_DamageBoss) {
        this.min_DamageBoss = min_DamageBoss;
    }

    public int getMax_DamageBoss() {
        return max_DamageBoss;
    }

    public void setMax_DamageBoss(int max_DamageBoss) {
        this.max_DamageBoss = max_DamageBoss;
    }

    public int getIncreaseDamageBoss() {
        return increaseDamageBoss;
    }

    public void setIncreaseDamageBoss(int increaseDamageBoss) {
        this.increaseDamageBoss = increaseDamageBoss;
    }

    public int getRestoreHealthPointBoss() {
        return restoreHealthPointBoss;
    }

    public void setRestoreHealthPointBoss(int restoreHealthPointBoss) {
        this.restoreHealthPointBoss = restoreHealthPointBoss;
    }

    public int getChanceToSuperDamageBoss() {
        return chanceToSuperDamageBoss;
    }

    public void setChanceToSuperDamageBoss(int chanceToSuperDamageBoss) {
        this.chanceToSuperDamageBoss = chanceToSuperDamageBoss;
    }
}
