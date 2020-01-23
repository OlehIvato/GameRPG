package Location;

import Armor.Equipment;
import Armor.Weapon;
import Сreature.Mobs.Main_Mob_Hero;

public class Azeroth extends Value {


    public Azeroth( String nameLocation, int hpLocation, int spellDamageLocation, int damageLocation, int restoreHealthLocation) {
        super( nameLocation, hpLocation, spellDamageLocation, damageLocation, restoreHealthLocation);
    }

    public void main() {
        Equipment.setRess(Equipment.getRess() + getHpLocation());
        Main_Mob_Hero.setMaxspellDamageHero(Main_Mob_Hero.getMaxspellDamageHero() + getSpellDamageLocation());
        Main_Mob_Hero.setMinspelldamageHERO(Main_Mob_Hero.getMinspelldamageHERO() + getSpellDamageLocation());
        Weapon.setRET(Weapon.getRET() + getDamageLocation());
        Main_Mob_Hero.setRestoreshealth(Main_Mob_Hero.getRestoreshealth() + getDamageLocation());

        Main_Mob_Hero.setHeroHP(Main_Mob_Hero.getHeroHP() + getHpLocation());
        Main_Mob_Hero.setDefaultDamage(Main_Mob_Hero.getDefaultDamage() + getDamageLocation());
    }
}