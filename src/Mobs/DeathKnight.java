package Mobs;
import Moving.Fight.FightOFF;
import Moving.Fight.FightON;

public class DeathKnight extends Main_Mob_Hero {
    public DeathKnight(String name, int healthpoint, int max_Damage, int min_Damage, int chanseToSuperDamageMob) {
        super(name, healthpoint, max_Damage, min_Damage, chanseToSuperDamageMob);
    }

    public void fightON() {

        FightON fight  = new FightON( "Death King", 130, 25, 18,51);
        fight.main();

    }

    public void fightOff(){
        FightOFF f = new FightOFF( "Death King", 120, 25, 18,51);
        f.main();
    }

}
