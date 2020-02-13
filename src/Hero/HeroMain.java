package Hero;

import Main.Main_All;

public class HeroMain {
    private Long id;
    private String name;
    private int hp;
    private int defaultDamage;
    private int minSpellDamage;
    private int maxSpellDamage;
    private int restoresHealthPoint;
    private int chance;
    private int mana;


    public void setValue() {
        Main_All.setHeroName(name);
        Main_All.setHeroHP(hp);
        Main_All.setDefaultDamage(defaultDamage);
        Main_All.setMinSpellDamageHERO(minSpellDamage);
        Main_All.setMaxSpellDamageHero(maxSpellDamage);
        Main_All.setRestoreHealth(restoresHealthPoint);
        Main_All.setChance(chance);
        Main_All.setMana(mana);
    }

    @Override
    public String toString() {
        String getFormat = "%1$-3s|%2$-8s|%3$-9s|%4$-12s|%5$-22s|%6$-22s|%7$-26s|%8$-11s|";
        String value = String.format(getFormat,
                id,
                name,
                " HP: " + hp,
                " Damage: " + defaultDamage,
                " Min Spell Damage: " + minSpellDamage,
                " Max Spell Damage: " + maxSpellDamage,
                " Restore Health point: " + restoresHealthPoint,
                " Mana: " + mana);
        return value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDefaultDamage() {
        return defaultDamage;
    }

    public void setDefaultDamage(int defaultDamage) {
        this.defaultDamage = defaultDamage;
    }

    public int getMinSpellDamage() {
        return minSpellDamage;
    }

    public void setMinSpellDamage(int minSpellDamage) {
        this.minSpellDamage = minSpellDamage;
    }

    public int getMaxSpellDamage() {
        return maxSpellDamage;
    }

    public void setMaxSpellDamage(int maxSpellDamage) {
        this.maxSpellDamage = maxSpellDamage;
    }

    public int getRestoresHealthPoint() {
        return restoresHealthPoint;
    }

    public void setRestoresHealthPoint(int restoresHealthPoint) {
        this.restoresHealthPoint = restoresHealthPoint;
    }

    public int getChance() {
        return chance;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }
}

