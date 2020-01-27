package Сreature.Mobs;

import Сreature.MainCreature;

public class Pig extends MainCreature {
    public Pig(String nameCreature, int healthPointCreature, int min_DamageCreature, int max_DamageCreature, int chanceToSuperDamageCreature) {
        super(nameCreature, healthPointCreature, min_DamageCreature, max_DamageCreature, chanceToSuperDamageCreature);
    }

    @Override
    public void fightMob() {
        super.fightMob();
    }
}