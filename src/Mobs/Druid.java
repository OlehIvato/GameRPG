package Mobs;
import Moving.Fight.FightOFF;
import Moving.Fight.FightON;
public class Druid extends Main_Mob_Hero {
    public Druid(String name, int healthpoint, int max_Damage, int min_Damage, int chanseToSuperDamageMob) {
        super(name, healthpoint, max_Damage, min_Damage, chanseToSuperDamageMob);
    }

    public void fightON() {

        FightON fight = new FightON (  "Druid", 115, 54, 37,37);
        fight.main();
    }

    public void fightOff(){
        FightOFF f = new FightOFF(  "Druid", 100, 50, 35,37);
        f.main();
    }

}

