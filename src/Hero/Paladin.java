package Hero;

import Main.TheGame;
import Сreature.Main_Mob_Hero;

public class Paladin extends HeroMain {
    public Paladin(String name, int hp, int defaultDamage, int minSpellDamage, int maxSpellDamage, int restoresHealthPoint, int chance, int mana) {
        super(name, hp, defaultDamage, minSpellDamage, maxSpellDamage, restoresHealthPoint, chance, mana);
    }

    public void Main() {
        Main_Mob_Hero.setHeroName(getName());
        Main_Mob_Hero.setHeroHP(getHp());
        Main_Mob_Hero.setDefaultDamage(getDefaultDamage());
        Main_Mob_Hero.setMinSpellDamageHERO(getMinSpellDamage());
        Main_Mob_Hero.setMaxSpellDamageHero(getMaxSpellDamage());
        Main_Mob_Hero.setChance(getChance());
        Main_Mob_Hero.setMana(getMana());

        TheGame game = new TheGame();
        game.createNewHero();
    }
}
