package Mobs;

import Moving.Fight.FightOFF;
import Moving.Fight.FightON;

public class Alien extends MainCharactericticOfMobs {
    public Alien(String name, int healthpoint, int max_Damage, int min_Damage, int chanseToSuperDamageMob) {
        super(name, healthpoint, max_Damage, min_Damage, chanseToSuperDamageMob);
    }


    public void fightON() {
        FightON fight = new FightON( "Alien", 105, 60, 28,34);
        fight.main();


    }

    public void fightOff(){
        FightOFF f = new FightOFF( "Alien", 105, 60, 28,34);
        f.main();

    }

}
