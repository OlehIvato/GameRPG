package Location;

import Сreature.Main_All;

public class LocationMain {

    private Long id;
    private String name;
    private int heroHp;
    private int heroDamage;
    private int heroSpellDamage;
    private int heroRestoreHealth;
    private int creatureHp;
    private int creatureDamage;
    private int creatureChance;


    private static String formatPlus(int number) {
        if (number > 0)
            return "+" + number;
        else return "" + number;
    }

    @Override
    public String toString() {
        String getFormat = "%1$-14s -  %2$-6s %3$-8s|%4$-19s|%5$-12s|%6$-21s  ||| %7$-15s %8$-9s|%9$-13s|%10$-27s";

        String result = String.format(getFormat,
                name,
                "FOR HERO: ",
                "HP: " + formatPlus(heroHp),
                " Spell Damage: " + formatPlus(heroDamage),
                " Damage: " + formatPlus(heroSpellDamage),
                " Restore Health: " + formatPlus(heroRestoreHealth),
                " FOR CREATURES: ",
                " HP: " + formatPlus(creatureHp),
                " Damage: " + formatPlus(creatureDamage),
                " Chance to Super Damage: " + formatPlus(creatureChance));
        return result;
    }

    public void setValues() {
        Main_All.setHeroHP(Main_All.getHeroHP() + heroHp);
        Main_All.setMaxSpellDamageHero(Main_All.getMaxSpellDamageHero() + heroSpellDamage);
        Main_All.setMinSpellDamageHERO(Main_All.getMinSpellDamageHERO() + heroSpellDamage);
        Main_All.setDefaultDamage(Main_All.getDefaultDamage() + heroDamage);
        Main_All.setRestoreHealth(Main_All.getRestoreHealth() + heroRestoreHealth);

        Main_All.setHeroHP(Main_All.getHeroHP() + heroHp);
        Main_All.setDefaultDamage(Main_All.getDefaultDamage() + heroDamage);

        Main_All.setHealthPoint(creatureHp);
        Main_All.setMin_Damage(creatureDamage);
        Main_All.setMax_Damage(creatureDamage);
        Main_All.setChanceToSuperDamage(Main_All.getChanceToSuperDamage() + creatureChance);
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

    public int getHeroHp() {
        return heroHp;
    }

    public void setHeroHp(int heroHp) {
        this.heroHp = heroHp;
    }

    public int getHeroDamage() {
        return heroDamage;
    }

    public void setHeroDamage(int heroDamage) {
        this.heroDamage = heroDamage;
    }

    public int getHeroSpellDamage() {
        return heroSpellDamage;
    }

    public void setHeroSpellDamage(int heroSpellDamage) {
        this.heroSpellDamage = heroSpellDamage;
    }

    public int getHeroRestoreHealth() {
        return heroRestoreHealth;
    }

    public void setHeroRestoreHealth(int heroRestoreHealth) {
        this.heroRestoreHealth = heroRestoreHealth;
    }

    public int getCreatureHp() {
        return creatureHp;
    }

    public void setCreatureHp(int creatureHp) {
        this.creatureHp = creatureHp;
    }

    public int getCreatureDamage() {
        return creatureDamage;
    }

    public void setCreatureDamage(int creatureDamage) {
        this.creatureDamage = creatureDamage;
    }

    public int getCreatureChance() {
        return creatureChance;
    }

    public void setCreatureChance(int creatureChance) {
        this.creatureChance = creatureChance;
    }
}