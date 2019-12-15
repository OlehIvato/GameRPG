package Mobs;

import Main.Location.LocationMain;
import Moving.Fight.FightOFF;
import Moving.Fight.FightON;


public class Pudge extends MainCharactericticOfMobs {
    public Pudge(String name, int healthpoint, int max_Damage, int min_Damage, int chanseToSuperDamageMob) {
        super(name, healthpoint, max_Damage, min_Damage, chanseToSuperDamageMob);
    }

    public void fightON() {
        FightON fight = new FightON("Pudge", 120, 34, 27, 56);
        fight.main();
    }

    public void fightOff() {
        FightOFF f = new FightOFF("Pudge", 120, 34, 27, 56);
        f.main();
    }


}
