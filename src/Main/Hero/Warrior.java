package Main.Hero;

import Mobs.MainCharactericticOfMobs;
import Main.NewHero;

public class Warrior extends MainCharactericticOfMobs {
    public Warrior(String heroName, int heroHP, int defaultDamage, int minspelldamageHERO, int maxspellDamageHero, int increasesDamage, int restoreshealth, int chance, int mana) {
        super(heroName, heroHP, defaultDamage, minspelldamageHERO, maxspellDamageHero, increasesDamage, restoreshealth, chance, mana);
    }

    public void Main() {
        setHeroName("Warrior");
        setHeroHP(167);
        setDefaultDamage(19);
        setMinspelldamageHERO(0);
        setMaxspellDamageHero(0);
        setIncreasesDamage(0);
        setRestoreshealth(0);

        NewHero n = new NewHero(heroName, heroHP, defaultDamage, minspelldamageHERO, maxspellDamageHero, increasesDamage, restoreshealth, chance, mana);
        n.createNewHero();
    }


}



