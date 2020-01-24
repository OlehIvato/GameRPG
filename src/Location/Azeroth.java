package Location;

import Armor.Equipment;
import Armor.Weapon;
import Сreature.Main_Mob_Hero;

public class Azeroth extends Value {


    public Azeroth( String nameLocation, int hpLocation, int spellDamageLocation, int damageLocation, int restoreHealthLocation) {
        super( nameLocation, hpLocation, spellDamageLocation, damageLocation, restoreHealthLocation);
    }

    public void main() {
        Equipment.setRess(Equipment.getRess() + hpLocation);
        Main_Mob_Hero.setMaxspellDamageHero(Main_Mob_Hero.getMaxspellDamageHero() + spellDamageLocation);
        Main_Mob_Hero.setMinspelldamageHERO(Main_Mob_Hero.getMinspelldamageHERO() + spellDamageLocation);
        Weapon.setRET(Weapon.getRET() + damageLocation);
        Main_Mob_Hero.setRestoreshealth(Main_Mob_Hero.getRestoreshealth() + restoreHealthLocation);

        Main_Mob_Hero.setHeroHP(Main_Mob_Hero.getHeroHP() + hpLocation);
        Main_Mob_Hero.setDefaultDamage(Main_Mob_Hero.getDefaultDamage() + damageLocation);
    }
}