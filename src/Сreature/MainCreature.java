package Сreature;

import Fight.Fight;
import Fight.FightBoss;
import Main.TheGame;

public class MainCreature {

    private String nameCreature;
    private int healthPointCreature;
    private int min_DamageCreature;
    private int max_DamageCreature;
    private int restoreHealthPointCreature;
    private int chanceToSuperDamageCreature;

    private static int finalHp = Main_All.getHealthPoint();
    private static int finalMinDamage = Main_All.getMin_Damage();
    private static int finalMaxDamage = Main_All.getMax_Damage();
    private static int finalRestoreHealthPoint = Main_All.getIncreaseDamage();
    private static int finalChance = Main_All.getChanceToSuperDamage();

    public MainCreature(String nameCreature, int healthPointCreature, int min_DamageCreature, int max_DamageCreature, int chanceToSuperDamageCreature) {
        this.nameCreature = nameCreature;
        this.healthPointCreature = healthPointCreature;
        this.min_DamageCreature = min_DamageCreature;
        this.max_DamageCreature = max_DamageCreature;
        this.chanceToSuperDamageCreature = chanceToSuperDamageCreature;
    }

    public MainCreature(String nameCreature, int healthPointCreature, int min_DamageCreature, int max_DamageCreature, int restoreHealthPointCreature, int chanceToSuperDamageCreature) {
        this.nameCreature = nameCreature;
        this.healthPointCreature = healthPointCreature;
        this.min_DamageCreature = min_DamageCreature;
        this.max_DamageCreature = max_DamageCreature;
        this.restoreHealthPointCreature = restoreHealthPointCreature;
        this.chanceToSuperDamageCreature = chanceToSuperDamageCreature;
    }

    public void fightMob() {
        if (TheGame.getInfo() == 1) {
            Main_All.setName(nameCreature);
            Main_All.setHealthPoint(finalHp + healthPointCreature);
            Main_All.setMin_Damage(finalMinDamage + min_DamageCreature);
            Main_All.setMax_Damage(finalMaxDamage + max_DamageCreature);
            Main_All.setChanceToSuperDamage(finalChance + chanceToSuperDamageCreature);
        }
        if (TheGame.getInfo() == 2) {
            Main_All.setName(nameCreature);
            Main_All.setHealthPoint(finalHp + GetRandom.changer(healthPointCreature));
            Main_All.setMin_Damage(finalMinDamage + GetRandom.changer(min_DamageCreature));
            Main_All.setMax_Damage(finalMaxDamage + GetRandom.changer(max_DamageCreature));
            Main_All.setChanceToSuperDamage(finalChance + GetRandom.changer(chanceToSuperDamageCreature));
        }
        Fight f = new Fight();
        f.main();
    }

    public void fightBoss() {
        if (TheGame.getInfo() == 1) {
            Main_All.setName(nameCreature);
            Main_All.setHealthPoint(finalHp + healthPointCreature);
            Main_All.setMin_Damage(finalMinDamage + min_DamageCreature);
            Main_All.setMax_Damage(finalMaxDamage + max_DamageCreature);
            Main_All.setRestoreCreature(finalRestoreHealthPoint + restoreHealthPointCreature);
            Main_All.setChanceToSuperDamage(finalChance + chanceToSuperDamageCreature);

        }
        if (TheGame.getInfo() == 2) {
            Main_All.setName(nameCreature);
            Main_All.setHealthPoint(finalHp + GetRandom.changer(healthPointCreature));
            Main_All.setMin_Damage(finalMinDamage + GetRandom.changer(min_DamageCreature));
            Main_All.setMax_Damage(finalMaxDamage + GetRandom.changer(max_DamageCreature));
            Main_All.setRestoreCreature(finalRestoreHealthPoint + GetRandom.changer(restoreHealthPointCreature));
            Main_All.setChanceToSuperDamage(finalChance + GetRandom.changer(chanceToSuperDamageCreature));
        }
        FightBoss f = new FightBoss();
        f.main();
    }
}
