package Main.Location;

import Armor.Equipment;
import Armor.Weapon;

import Mobs.Main_Mob_Hero;

public class IsleofDread extends Main_Mob_Hero {


    public IsleofDread(String heroName, int heroHP, int defaultDamage, int minspelldamageHERO, int maxspellDamageHero, int increasesDamage, int restoreshealth, int chance, int mana) {
        super(heroName, heroHP, defaultDamage, minspelldamageHERO, maxspellDamageHero, increasesDamage, restoreshealth, chance, mana);
    }

    public static void main() {
        Equipment.setRess(Equipment.getRess() - 13);
        setMaxspellDamageHero(getMaxspellDamageHero() + 14);
        setMinspelldamageHERO(getMinspelldamageHERO() + 14);
        Weapon.setRET(Weapon.getRET() + 9);
        setRestoreshealth(getRestoreshealth() - 9);

        heroHP -= 13;
        defaultDamage += 9;
    }
}
