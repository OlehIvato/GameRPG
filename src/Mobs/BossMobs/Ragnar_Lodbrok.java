package Mobs.BossMobs;
import Mobs.MainCharactericticOfMobs;
import Moving.Fight.FightBossOFF;
import Moving.Fight.FightBossON;
public class Ragnar_Lodbrok extends MainCharactericticOfMobs {
    public Ragnar_Lodbrok(String name, int healthpoint, int max_Damage, int min_Damage, int increaseBoss, int restoreBoss, int chanseToSuperDamageBOSS) {
        super(name, healthpoint, max_Damage, min_Damage, increaseBoss, restoreBoss, chanseToSuperDamageBOSS);
    }

    public void fightON() {
        FightBossON f = new FightBossON("Ragnar Lodbrok", 124, 67, 35, 7, 14, 35);
        f.main();
    }


    public void fightoff() {
        FightBossOFF f = new FightBossOFF("Ragnar Lodbrok", 113, 50, 27, 7, 14, 35);
        f.main();
    }
}