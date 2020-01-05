package Main.Location;

import Armor.Equipment;
import Armor.Weapon;
import Mobs.Main_Mob_Hero;
public class Northrend extends Main_Mob_Hero {


    public Northrend(String heroName, int heroHP, int defaultDamage, int minspelldamageHERO, int maxspellDamageHero, int increasesDamage, int restoreshealth, int chance, int mana) {
        super(heroName, heroHP, defaultDamage, minspelldamageHERO, maxspellDamageHero, increasesDamage, restoreshealth, chance, mana);
    }

    public static void main() {
        Equipment.setRess(Equipment.getRess() + 8);
        setMaxspellDamageHero(getMaxspellDamageHero() + 14);
        setMinspelldamageHERO(getMinspelldamageHERO() + 14);
        Weapon.setRET(Weapon.getRET() - 5);
        setRestoreshealth(getRestoreshealth() + 5);

        heroHP += 8;
        defaultDamage -= 5;
    }


}
