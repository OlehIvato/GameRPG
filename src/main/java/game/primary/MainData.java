package game.primary;

import game.sql.ConnectSetting;

/**
 * This is the main class of the program, other classes set values here,
 * and Fight class gets values from here to fight.
 */
abstract public class MainData implements DefaultValues, ConnectSetting {
    protected static String heroArmor;
    protected static String heroClass;
    protected static String heroName;
    protected static int heroHp;
    protected static int heroDamage;
    protected static int heroMinSpell;
    protected static int heroMaxSpell;
    protected static int heroRestoreHp;             // how much hp hero can restore
    protected static int heroMana;                  // mana for Heal Hero

    protected static String mobName;
    protected static int mobHp;
    protected static int mobMaxDamage;
    protected static int mobMinDamage;
    protected static int mobRestoreHp;              // how many hp boss can restore
    protected static int mobChanceToSuperDamage;    // chance to super damage for MOB AND Boss

    protected int superDamage = (int) (mobMaxDamage * 1.5);





}
