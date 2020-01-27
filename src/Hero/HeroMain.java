package Hero;

import Main.TheGame;
import Сreature.Main_All;

public class HeroMain {
    private String name;
    private int hp;
    private int defaultDamage;
    private int minSpellDamage;
    private int maxSpellDamage;
    private int restoresHealthPoint;
    private int chance;
    private int mana;

    public HeroMain(String name, int hp, int defaultDamage, int minSpellDamage, int maxSpellDamage, int restoresHealthPoint, int chance, int mana) {
        this.name = name;
        this.hp = hp;
        this.defaultDamage = defaultDamage;
        this.minSpellDamage = minSpellDamage;
        this.maxSpellDamage = maxSpellDamage;
        this.restoresHealthPoint = restoresHealthPoint;
        this.chance = chance;
        this.mana = mana;
    }

    public void setValue() {
        Main_All.setHeroName(name);
        Main_All.setHeroHP(hp);
        Main_All.setDefaultDamage(defaultDamage);
        Main_All.setMinSpellDamageHERO(minSpellDamage);
        Main_All.setMaxSpellDamageHero(maxSpellDamage);
        Main_All.setRestoreHealth(restoresHealthPoint);
        Main_All.setChance(chance);
        Main_All.setMana(mana);

        TheGame game = new TheGame();
        game.createNewHero();
    }

    @Override
    public String toString() {
        String getFormat = "%1$-8s|%2$-9s|%3$-12s|%4$-22s|%5$-22s|%6$-26s|%7$-11s|";
        String value = String.format(getFormat,
                name,
                " HP: " + hp,
                " Damage: " + defaultDamage,
                " Min Spell Damage: " + minSpellDamage,
                " Max Spell Damage: " + maxSpellDamage,
                " Restore Health point: " + restoresHealthPoint,
                " Mana: " + mana);
        return value;
    }

}

