package Hero;

public class Warrior extends HeroMain {
    public Warrior(String name, int hp, int defaultDamage, int minSpellDamage, int maxSpellDamage, int restoresHealthPoint, int chance, int mana) {
        super(name, hp, defaultDamage, minSpellDamage, maxSpellDamage, restoresHealthPoint, chance, mana);
    }

    @Override
    public void setValue() {
        super.setValue();
    }
}



