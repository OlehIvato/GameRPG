package Main.Hero;


import Main.NewHero;
import Mobs.Main_Mob_Hero;

public class Warrior extends Main_Mob_Hero {
    public Warrior(String heroName, int heroHP, int defaultDamage, int minspelldamageHERO, int maxspellDamageHero, int increasesDamage, int restoreshealth, int chance, int mana) {
        super(heroName, heroHP, defaultDamage, minspelldamageHERO, maxspellDamageHero, increasesDamage, restoreshealth, chance, mana);
    }

    public void Main() {
        setHeroName("Warrior");
        setHeroHP(167);
        setDefaultDamage(21);
        setMinspelldamageHERO(0);
        setMaxspellDamageHero(0);
        setIncreasesDamage(0);
        setRestoreshealth(0);
        setMana(0);

        NewHero n = new NewHero(heroName, heroHP, defaultDamage, minspelldamageHERO, maxspellDamageHero, increasesDamage, restoreshealth, chance, mana);
        n.createNewHero();
    }


}



