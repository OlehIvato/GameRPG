package Сreature.Bosses;

import Сreature.MainCreature;

public class CaptainPrice extends MainCreature {
    public CaptainPrice(String nameCreature, int healthPointCreature, int min_DamageCreature, int max_DamageCreature, int restoreHealthPointCreature, int chanceToSuperDamageCreature) {
        super(nameCreature, healthPointCreature, min_DamageCreature, max_DamageCreature, restoreHealthPointCreature, chanceToSuperDamageCreature);
    }
    @Override
    public void fightBoss() {
        super.fightBoss();
    }
}
