package Mobs.BossMobs;
import Mobs.MainCharactericticOfMobs;
import Moving.Fight.FightBossON;
public class Ragnar_Lodbrok extends MainCharactericticOfMobs {
    public Ragnar_Lodbrok(String name, int healthpoint, int max_Damage, int min_Damage, int increaseBoss, int restoreBoss, int chanseToSuperDamageBOSS) {
        super(name, healthpoint, max_Damage, min_Damage, increaseBoss, restoreBoss, chanseToSuperDamageBOSS);
    }

    public void fightON() {
        FightBossON f = new FightBossON("Ragnar Lodbrok",124,67,35,7,14,35);
        f.main();
    }




//    public void Fight_WithOut_Equip() {
//
//        Fight_WithOut_Equipmenut fight_withOut_equipmenut = new Fight_WithOut_Equipmenut(name, healthpoint, max_Damage, min_Damage, increasesDamage, restoreshealth);
//
//        fight_withOut_equipmenut.Fighting();
//    }

}
