package Moving.Random;

import Mobs.BossMobs.CaptainPrice;
import Mobs.BossMobs.LichKing;
import Mobs.BossMobs.Ragnar_Lodbrok;
import Mobs.Main_Mob_Hero;
import java.util.Random;

public class RandomBoss_WithOut_Equipment extends Main_Mob_Hero {

    public RandomBoss_WithOut_Equipment(String name, int healthpoint, int max_Damage, int min_Damage, int increaseBoss, int restoreBoss, int chanseToSuperDamageBOSS) {
        super(name, healthpoint, max_Damage, min_Damage, increaseBoss, restoreBoss, chanseToSuperDamageBOSS);
    }

    public static int get_random_boss_without_equip() {
        CaptainPrice captainPrice = new CaptainPrice(name, healthpoint, max_Damage, min_Damage, increaseBoss, restoreBoss, chanseToSuperDamageBOSS);
        LichKing lichKing = new LichKing(name, healthpoint, max_Damage, min_Damage, increaseBoss, restoreBoss, chanseToSuperDamageBOSS);
        Ragnar_Lodbrok ragnar_lodbrok = new Ragnar_Lodbrok(name, healthpoint, max_Damage, min_Damage, increaseBoss, restoreBoss, chanseToSuperDamageBOSS);


        Random random = new Random();
        int Case;
        Case = random.nextInt(3);
        switch (Case) {
            case 0:
                captainPrice.fightoff();
                break;
            case 1:
                lichKing.fightoff();
                break;
            case 2:
                ragnar_lodbrok.fightoff();
                break;
        }
        return Case;
    }
}
