package Main.Hero;

import Main.TheGame;
import Mobs.Main_Mob_Hero;

public class Mage extends Main_Mob_Hero {
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
        setMana(87);

        TheGame game = new TheGame(heroName, heroHP, defaultDamage, minspelldamageHERO, maxspellDamageHero, increasesDamage, restoreshealth, chance, mana);
        game.createNewHero();
    }
}

