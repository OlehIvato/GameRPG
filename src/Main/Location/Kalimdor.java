package Main.Location;

import Armor.Equipment;
import Armor.Weapon;

import Mobs.Main_Mob_Hero;

public class Kalimdor extends Main_Mob_Hero  {


    public Kalimdor(String heroName, int heroHP, int defaultDamage, int minspelldamageHERO, int maxspellDamageHero, int increasesDamage, int restoreshealth, int chance, int mana) {
        super(heroName, heroHP, defaultDamage, minspelldamageHERO, maxspellDamageHero, increasesDamage, restoreshealth, chance, mana);
    }

    public static void main() {
        Equipment.setRess(Equipment.getRess() + 2);
        setMaxspellDamageHero(getMaxspellDamageHero() + 9);
        setMinspelldamageHERO(getMinspelldamageHERO() + 9);
        Weapon.setRET(Weapon.getRET() + 14);
        setRestoreshealth(getRestoreshealth() - 16);

        heroHP += 2;
        defaultDamage += 14;
    }
}
