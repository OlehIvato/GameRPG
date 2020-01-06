package Moving.Random;

import Mobs.*;
import Mobs.BossMobs.CaptainPrice;
import Mobs.BossMobs.LichKing;
import Mobs.BossMobs.Ragnar_Lodbrok;
import java.util.Random;

public class RandomBoss extends  Main_Mob_Hero{
    public RandomBoss(String name, int healthpoint, int max_Damage, int min_Damage, int increaseBoss, int restoreBoss, int chanseToSuperDamageBOSS) {
        super(name, healthpoint, max_Damage, min_Damage, increaseBoss, restoreBoss, chanseToSuperDamageBOSS);
    }

    public static void get_random_boss  () {
        CaptainPrice captainPrice = new CaptainPrice(name, healthpoint, max_Damage, min_Damage, increaseBoss, restoreBoss, chanseToSuperDamageBOSS);
        LichKing lichKing = new LichKing(name, healthpoint, max_Damage, min_Damage, increaseBoss, restoreBoss, chanseToSuperDamageBOSS);
        Ragnar_Lodbrok ragnar_lodbrok = new Ragnar_Lodbrok(name, healthpoint, max_Damage, min_Damage, increaseBoss, restoreBoss, chanseToSuperDamageBOSS);

        Random random = new Random();
        switch (random.nextInt(3)) {
            case 0:
                captainPrice.fightON();
                break;
            case 1:
                lichKing.fightON();
                break;
            case 2:
                ragnar_lodbrok.fightON();
                break;
        }
    }
}
