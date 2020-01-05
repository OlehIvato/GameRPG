package Mobs;


import Moving.Fight.FightOFF;
import Moving.Fight.FightON;


public class Pudge extends Main_Mob_Hero {
    public Pudge(String name, int healthpoint, int max_Damage, int min_Damage, int chanseToSuperDamageMob) {
        super(name, healthpoint, max_Damage, min_Damage, chanseToSuperDamageMob);
    }

    public void fightON() {
        FightON fight = new FightON("Pudge", 120, 34, 27, 56);
        fight.main();
    }

    public void fightOff() {
        FightOFF f = new FightOFF("Pudge", 105, 30, 25, 37);
        f.main();
    }


}
