package Сreature.Bosses;

import Fight.FightBoss;
import Сreature.MainBosses;

public class Ragnar_Lodbrok extends MainBosses {
    public Ragnar_Lodbrok(String nameBoss, int healthpointBoss, int min_DamageBoss, int max_DamageBoss, int increaseDamageBoss, int restoreHealthPointBoss, int chanceToSuperDamageBoss) {
        super(nameBoss, healthpointBoss, min_DamageBoss, max_DamageBoss, increaseDamageBoss, restoreHealthPointBoss, chanceToSuperDamageBoss);
    }

    public void fight() {
        FightBoss f = new FightBoss();
        f.main();
    }
}