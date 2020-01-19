package Moving.Random;

import Mobs.*;
import Mobs.BossMobs.CaptainPrice;
import Mobs.BossMobs.LichKing;
import Mobs.BossMobs.Ragnar_Lodbrok;
import java.util.Random;

public class RandomBoss extends Main_Mob_Hero {
    public RandomBoss(String name, int healthpoint, int max_Damage, int min_Damage, int increaseBoss, int restoreBoss, int chanseToSuperDamageBOSS) {
        super(name, healthpoint, max_Damage, min_Damage, increaseBoss, restoreBoss, chanseToSuperDamageBOSS);
    }

    public static void random_Boss() {
        Random random = new Random();

        CaptainPrice captainPrice = new CaptainPrice(name, healthpoint, max_Damage, min_Damage, increaseBoss, restoreBoss, chanseToSuperDamageBOSS);
        LichKing lichKing = new LichKing(name, healthpoint, max_Damage, min_Damage, increaseBoss, restoreBoss, chanseToSuperDamageBOSS);
        Ragnar_Lodbrok ragnar_lodbrok = new Ragnar_Lodbrok(name, healthpoint, max_Damage, min_Damage, increaseBoss, restoreBoss, chanseToSuperDamageBOSS);

        switch (random.nextInt(3)) {
            case 0:
                captainPrice.fight();
                break;
            case 1:
                lichKing.fight();
                break;
            case 2:
                ragnar_lodbrok.fight();
                break;
        }
    }
}
