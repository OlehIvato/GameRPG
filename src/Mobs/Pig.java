package Mobs;
import Moving.Fight.FightOFF;
import Moving.Fight.FightON;

public class Pig extends  Main_Mob_Hero{
    public Pig(String name, int healthpoint, int max_Damage, int min_Damage, int chanseToSuperDamageMob) {
        super(name, healthpoint, max_Damage, min_Damage, chanseToSuperDamageMob);
    }

    public void fightON() {

        FightON fight = new FightON( "Pig", 110, 29, 20,43);
        fight.main();
    }

    public void fightOff(){
        FightOFF f = new FightOFF( "Pig", 101, 29, 20,43);
        f.main();
    }

}
