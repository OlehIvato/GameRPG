package Main.Hero;

import Mobs.MainCharactericticOfMobs;
import Main.NewHero;

public class Mage extends MainCharactericticOfMobs {
    public Mage(String heroName, int heroHP, int defaultDamage, int minspelldamageHERO, int maxspellDamageHero, int increasesDamage, int restoreshealth, int chance, int mana) {
        super(heroName, heroHP, defaultDamage, minspelldamageHERO, maxspellDamageHero, increasesDamage, restoreshealth, chance, mana);
    }

    public void Main() {
        setHeroName("Mage");
        setHeroHP(90);
        setDefaultDamage(4);
        setMinspelldamageHERO(35);
        setMaxspellDamageHero(55);
        setIncreasesDamage(0);
        setRestoreshealth(19);
        setMana(100);

        NewHero n = new NewHero(heroName, heroHP, defaultDamage, minspelldamageHERO, maxspellDamageHero, increasesDamage, restoreshealth);
        n.createNewHero();

    }


}

