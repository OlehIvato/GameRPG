package Hero;
import Main.TheGame;
import Сreature.Mobs.Main_Mob_Hero;

public class Mage extends HeroMain {
    public Mage(String name, int hp, int defaultDamage, int minSpellDamage, int maxSpellDamage, int increasesDamage, int restoresHealthPoint, int chance, int mana) {
        super(name, hp, defaultDamage, minSpellDamage, maxSpellDamage, increasesDamage, restoresHealthPoint, chance, mana);
    }


    public void Main() {
        Main_Mob_Hero.setHeroName(getName());
        Main_Mob_Hero.setHeroHP(getHp());
        Main_Mob_Hero.setDefaultDamage(getDefaultDamage());
        Main_Mob_Hero.setMinspelldamageHERO(getMinSpellDamage());
        Main_Mob_Hero.setMaxspellDamageHero(getMaxSpellDamage());
        Main_Mob_Hero.setIncreasesDamage(getIncreasesDamage());
        Main_Mob_Hero.setChance(getChance());
        Main_Mob_Hero.setMana(getMana());

        TheGame game = new TheGame();
        game.createNewHero();
    }
}

