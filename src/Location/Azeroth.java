package Location;

import Armor.Equipment;
import Armor.Weapon;
import Сreature.Main_Mob_Hero;

public class Azeroth extends Value {
    public Azeroth(String nameLocation, int heroHP_l, int heroSpellDamage_l, int heroDamage_l, int heroRestoreHealth_l, int creatureHP_l, int creatureDamage_l, int creatureChance_l) {
        super(nameLocation, heroHP_l, heroSpellDamage_l, heroDamage_l, heroRestoreHealth_l, creatureHP_l, creatureDamage_l, creatureChance_l);
    }

    public void main() {
        Equipment.setRess(Equipment.getRess() + heroHP_l);
        Main_Mob_Hero.setMaxSpellDamageHero(Main_Mob_Hero.getMaxSpellDamageHero() + heroSpellDamage_l);
        Main_Mob_Hero.setMinSpellDamageHERO(Main_Mob_Hero.getMinSpellDamageHERO() + heroSpellDamage_l);
        Weapon.setRET(Weapon.getRET() + heroDamage_l);
        Main_Mob_Hero.setRestoreHealth(Main_Mob_Hero.getRestoreHealth() + heroRestoreHealth_l);

        Main_Mob_Hero.setHeroHP(Main_Mob_Hero.getHeroHP() + heroHP_l);
        Main_Mob_Hero.setDefaultDamage(Main_Mob_Hero.getDefaultDamage() + heroDamage_l);

        Main_Mob_Hero.setHealthPoint(Main_Mob_Hero.getHealthPoint() + creatureHP_l);
        Main_Mob_Hero.setMin_Damage(Main_Mob_Hero.getMin_Damage() + creatureDamage_l);
        Main_Mob_Hero.setMax_Damage(Main_Mob_Hero.getMax_Damage() + creatureDamage_l);
        Main_Mob_Hero.setChanceToSuperDamageMob(Main_Mob_Hero.getChanceToSuperDamageMob() + creatureChance_l);
        Main_Mob_Hero.setChanceToSuperDamageBOSS(Main_Mob_Hero.getChanceToSuperDamageBOSS() + creatureChance_l);

    }
}