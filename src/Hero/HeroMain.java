package Hero;

public class HeroMain {
    private String name;
    private int hp;
    private int defaultDamage;
    private int minSpellDamage;
    private int maxSpellDamage;
    private int increasesDamage;
    private int restoresHealthPoint;
    private int chance;
    private int mana;

    public HeroMain(String name, int hp, int defaultDamage, int minSpellDamage, int maxSpellDamage, int increasesDamage, int restoresHealthPoint, int chance, int mana) {
        this.name = name;
        this.hp = hp;
        this.defaultDamage = defaultDamage;
        this.minSpellDamage = minSpellDamage;
        this.maxSpellDamage = maxSpellDamage;
        this.increasesDamage = increasesDamage;
        this.restoresHealthPoint = restoresHealthPoint;
        this.chance = chance;
        this.mana = mana;
    }

    public HeroMain() {

    }

    @Override
    public String toString() {
        return name + " | HP: " +
                hp + " | Damage: " +
                defaultDamage + " | Min Spell Damage: " +
                minSpellDamage + " | Max Spell Damage: " +
                maxSpellDamage + " | Increase Damage: " +
                increasesDamage + " | Restore Health point: " +
                restoresHealthPoint;

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

    public int getIncreasesDamage() {
        return increasesDamage;
    }

    public void setIncreasesDamage(int increasesDamage) {
        this.increasesDamage = increasesDamage;
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

