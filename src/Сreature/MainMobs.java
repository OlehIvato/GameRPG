package Сreature;

public class MainMobs {

    private String nameMOb;
    private int healthPointMOb;
    private int min_DamageMOb;
    private int max_DamageMob;
    private int chanceToSuperDamageMob;

    public MainMobs(String nameMOb, int healthPointMOb, int min_DamageMOb, int max_DamageMob, int chanceToSuperDamageMob) {
        this.nameMOb = nameMOb;
        this.healthPointMOb = healthPointMOb;
        this.min_DamageMOb = min_DamageMOb;
        this.max_DamageMob = max_DamageMob;
        this.chanceToSuperDamageMob = chanceToSuperDamageMob;
    }

    public String getNameMOb() {
        return nameMOb;
    }

    public void setNameMOb(String nameMOb) {
        this.nameMOb = nameMOb;
    }

    public int getHealthPointMOb() {
        return healthPointMOb;
    }

    public void setHealthPointMOb(int healthPointMOb) {
        this.healthPointMOb = healthPointMOb;
    }

    public int getMin_DamageMOb() {
        return min_DamageMOb;
    }

    public void setMin_DamageMOb(int min_DamageMOb) {
        this.min_DamageMOb = min_DamageMOb;
    }

    public int getMax_DamageMob() {
        return max_DamageMob;
    }

    public void setMax_DamageMob(int max_DamageMob) {
        this.max_DamageMob = max_DamageMob;
    }

    public int getChanceToSuperDamageMob() {
        return chanceToSuperDamageMob;
    }

    public void setChanceToSuperDamageMob(int chanceToSuperDamageMob) {
        this.chanceToSuperDamageMob = chanceToSuperDamageMob;
    }
}
