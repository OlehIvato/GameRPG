package Main.Location;

import Armor.Equipment;
import Armor.Weapon;

import Mobs.Main_Mob_Hero;

public class Kalimdor extends Value  {


    public Kalimdor( String nameLocation, int hpLocation, int spellDamageLocation, int damageLocation, int restoreHealthLocation) {
        super( nameLocation, hpLocation, spellDamageLocation, damageLocation, restoreHealthLocation);
    }

    public void main() {
        Equipment.setRess(Equipment.getRess() + hpLocation);
        Main_Mob_Hero.setMaxspellDamageHero(Main_Mob_Hero.getMaxspellDamageHero() + spellDamageLocation);
        Main_Mob_Hero.setMinspelldamageHERO(Main_Mob_Hero.getMinspelldamageHERO() + spellDamageLocation);
        Weapon.setRET(Weapon.getRET() + damageLocation);
        Main_Mob_Hero.setRestoreshealth(Main_Mob_Hero.getRestoreshealth() + restoreHealthLocation);

        Main_Mob_Hero.setHeroHP(Main_Mob_Hero.getHeroHP() + getHpLocation());
        Main_Mob_Hero.setDefaultDamage(Main_Mob_Hero.getDefaultDamage() + getDamageLocation());
    }
}
