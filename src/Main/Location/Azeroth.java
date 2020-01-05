package Main.Location;

import Armor.Equipment;
import Armor.Weapon;
import Mobs.Main_Mob_Hero;


public class Azeroth extends Main_Mob_Hero {

    public Azeroth(String heroName, int heroHP, int defaultDamage, int minspelldamageHERO, int maxspellDamageHero, int increasesDamage, int restoreshealth, int chance, int mana) {
        super(heroName, heroHP, defaultDamage, minspelldamageHERO, maxspellDamageHero, increasesDamage, restoreshealth, chance, mana);
    }

    public static void main() {

        Equipment.setRess(Equipment.getRess() - 9);
        setMaxspellDamageHero(getMaxspellDamageHero() - 5);
        setMinspelldamageHERO(getMinspelldamageHERO() - 5);
        Weapon.setRET(Weapon.getRET() - 3);
        setRestoreshealth(getRestoreshealth() + 15);

        heroHP -= 9;
        defaultDamage -= 5;

    }
}
