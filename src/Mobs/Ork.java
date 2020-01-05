package Mobs;
import Moving.Fight.FightOFF;
import Moving.Fight.FightON;

public class Ork extends Main_Mob_Hero {
    public Ork(String name, int healthpoint, int max_Damage, int min_Damage, int chanseToSuperDamageMob) {
        super(name, healthpoint, max_Damage, min_Damage, chanseToSuperDamageMob);
    }

    public void fightON() {
        FightON fight = new FightON("Ork", 114, 28, 27, 38);
        fight.main();
    }

    public void fightOff(){
        FightOFF f = new FightOFF("Ork", 104, 28, 27, 20);
        f.main();
    }


}



