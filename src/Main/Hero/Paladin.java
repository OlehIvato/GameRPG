package Main.Hero;

import Main.TheGame;
import Mobs.Main_Mob_Hero;

public class Paladin extends Main_Mob_Hero {
    public Paladin(String heroName, int heroHP, int defaultDamage, int minspelldamageHERO, int maxspellDamageHero, int increasesDamage, int restoreshealth, int chance, int mana) {
        super(heroName, heroHP, defaultDamage, minspelldamageHERO, maxspellDamageHero, increasesDamage, restoreshealth, chance, mana);
    }

    public void Main() {
        setHeroName("Paladin");
        setHeroHP(110);
        setDefaultDamage(15);
        setMinspelldamageHERO(17);
        setMaxspellDamageHero(40);
        setIncreasesDamage(0);
        setRestoreshealth(35);
        setMana(105);

        TheGame game = new TheGame(heroName, heroHP, defaultDamage, minspelldamageHERO, maxspellDamageHero, increasesDamage, restoreshealth, chance, mana);
        game.createNewHero();
    }
}
