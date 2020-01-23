package Fight;

import Armor.Equipment;
import Armor.Stick;
import Armor.Weapon;
import Main.*;
import Сreature.Mobs.Main_Mob_Hero;
import java.util.Random;
import java.util.Scanner;


public class FightBoss extends Main_Mob_Hero implements Text, Levels {

    private static int res = Main_Mob_Hero.getIndex() + restoreshealth;
    private int hero_HP = Equipment.getRess();
    private int herohp_wout = getHeroHP();
    private int manafinal = Stick.getResult();
    private int manafinal_wout = getMana();


    public FightBoss(String name, int healthpoint, int max_Damage, int min_Damage, int increaseBoss, int restoreBoss, int chanseToSuperDamageBOSS) {
        super(name, healthpoint, max_Damage, min_Damage, increaseBoss, restoreBoss, chanseToSuperDamageBOSS);
    }

    public FightBoss(String heroName, int heroHP, int defaultDamage, int minspelldamageHERO, int maxspellDamageHero, int increasesDamage, int restoreshealth, int chance, int mana) {
        super(heroName, heroHP, defaultDamage, minspelldamageHERO, maxspellDamageHero, increasesDamage, restoreshealth, chance, mana);
    }

    public FightBoss() {

    }

    public void main() {
        setZero();
        if (TheGame.getInfo() == 1) {
            Text.description_vs_boss();
        }
        if (TheGame.getInfo() == 2) {
            Text.description_vs_boss_wout();
        }
        move();
    }

    public void move() {
        if (TheGame.getInfo() == 1) {
            String cases = "\n Your Turn \n" +
                    "1. Hit " + name + " on " + Weapon.getRET() + " health point \n2. Strike with magic on " + randomDamage + " health point " +
                    "\n3. Restore " + res + " health point, Need " + Main_Mob_Hero.getHealcast() + " Mana, You Have " + manafinal + " Mana" +
                    "\n4. Get defeat and back to Main Menu ";
            System.out.println(cases);
            Scanner scan = new Scanner(System.in);
            while (healthpoint > 0 && hero_HP > 0) {
                switch (scan.nextInt()) {
                    case 1: {
                        heromove();
                        break;
                    }
                    case 2: {
                        spell();
                        break;
                    }
                    case 3: {
                        heal();
                        break;
                    }
                    case 4: {
                        System.err.println(getLOSS);
                        Menu.mainMenu();
                        break;
                    }
                }
            }
        }
        if (TheGame.getInfo() == 2) {
            String cases = "\n Your Turn \n" +
                    "1. Hit " + name + " on " + defaultDamage + hp + "\n2. Strike with magic on " + randomDamage + " health point " +
                    "\n3. Restore " + res + " health point, Need " + Main_Mob_Hero.getHealcast() + " Mana, You Have " + manafinal_wout + " Mana" +
                    "\n4. To get defeat and back to Main Menu ";
            System.out.println(cases);
            Scanner scan = new Scanner(System.in);
            while (healthpoint > 0 && herohp_wout > 0) {
                switch (scan.nextInt()) {
                    case 1: {
                        heromove();
                        break;
                    }
                    case 2: {
                        spell();
                        break;
                    }
                    case 3: {
                        heal();
                        break;
                    }
                    case 4: {
                        System.err.println(getLOSS);
                        Menu.mainMenu();
                        break;
                    }
                }
            }
        }
    }

    private void heromove() {
        if (TheGame.getInfo() == 1) {
            while (healthpoint > 0 && hero_HP > 0) {
                System.out.println(youHitNameOnWeaponHp);
                System.out.print(nowBossHave + ((healthpoint + restoreBoss) - Weapon.getRET()) + hp);
                healthpoint = (healthpoint + restoreBoss) - Weapon.getRET();
                if (healthpoint <= 0) {
                    System.out.println(youHaveWonOverThe + name);
                    break;
                } else mobmove();
                break;
            }
        }
        if (TheGame.getInfo() == 2) {
            while (healthpoint > 0 && herohp_wout > 0) {
                System.out.println(youHitNameOnDefaultDamageHp);
                System.out.print(nowBossHave + ((healthpoint + restoreBoss) - defaultDamage) + hp);
                healthpoint = (healthpoint + restoreBoss) - defaultDamage;
                if (healthpoint <= 0) {
                    System.out.println(youHaveWonOverThe + name);
                    break;
                } else mobmove();
                break;
            }
        }
    }

    private void mobmove() {
        if (TheGame.getInfo() == 1) {
            while (hero_HP > 0 && healthpoint > 0) {
                System.out.println(nameTurn);
                int EqualRandom = random();
                System.out.print(nameHitYouOn + EqualRandom + hp);
                hero_HP -= EqualRandom;
                System.out.println(nowYouHaveHp + hero_HP + hp);
                if (hero_HP <= 0) {
                    System.out.println(youWereDefeatedBy + name);
                    again();
                    break;
                } else move();
                break;
            }
        }
        if (TheGame.getInfo() == 2) {
            while (herohp_wout > 0 && healthpoint > 0) {
                System.out.println(nameTurn);
                int EqualRandom = random();
                System.out.print(nameHitYouOn + EqualRandom + hp);
                herohp_wout -= EqualRandom;
                System.out.println(nowYouHaveHp + herohp_wout + hp);
                if (herohp_wout <= 0) {
                    System.out.println(youWereDefeatedBy + name);
                    again();
                    break;
                } else move();
                break;
            }
        }
    }


    private void heal() {
        if (TheGame.getInfo() == 1) {
            while (healthpoint > 0 && hero_HP > 0) {
                if (manafinal >= Main_Mob_Hero.getHealcast()) {
                    hero_HP += res;
                    System.out.println(youChoseHealingYourself);
                    manafinal -= Main_Mob_Hero.getHealcast();
                    System.out.println(youHaveBeenRecovered);
                    System.out.println(nowYourHealthPointEqual + hero_HP);
                    System.out.println("Now you have left " + manafinal + " Mana ");
                    Scanner scan = new Scanner(System.in);

                    System.out.println(chooseNewOptions_Mana_Menu);
                    switch (scan.nextInt()) {
                        case 1: {
                            break;
                        }
                        case 2: {
                            spell();
                            break;
                        }
                        case 3: {
                            System.err.println(getLOSS);
                            Menu.mainMenu();
                            break;
                        }
                    }
                }
                if (manafinal < Main_Mob_Hero.getHealcast()) {
                    System.out.println(noMoreMana);
                    move();
                    break;
                }
            }
        }
        if (TheGame.getInfo() == 2) {
            while (healthpoint > 0 && herohp_wout > 0) {
                if (manafinal_wout >= Main_Mob_Hero.getHealcast()) {
                    herohp_wout += res;
                    System.out.println(youChoseHealingYourself);
                    manafinal_wout -= Main_Mob_Hero.getHealcast();
                    System.out.println(youHaveBeenRecovered);
                    System.out.println(nowYourHealthPointEqual + herohp_wout);
                    System.out.println("Now you have left " + manafinal_wout + " Mana ");
                    Scanner scan = new Scanner(System.in);
                    System.out.println(chooseNewOptions_Mana_Menu_wout);
                    switch (scan.nextInt()) {
                        case 1: {
                            heromove();
                            break;
                        }
                        case 2: {
                            spell();
                            break;
                        }
                        case 3: {
                            System.err.println(getLOSS);
                            Menu.mainMenu();
                            break;
                        }
                    }
                }
                if (manafinal_wout < Main_Mob_Hero.getHealcast()) {
                    System.out.println(noMoreMana);
                    move();
                    break;
                }
            }
        }
    }

    private int random_Spell_damage() {
        int max = maxspellDamageHero;
        int min = minspelldamageHERO;
        int range = max - min;
        int finalresult = (int) ((Math.random() * range) + min);
        return finalresult;
    }

    public int random() {
        int result = 0;
        Random random = new Random();
        int num = random.nextInt(100);
        int max = max_Damage;
        int min = min_Damage;
        int range = max - min;
        if (num < chanseToSuperDamageBOSS) {
            result = (max_Damage / 2) + max_Damage;
            System.out.println(name + " uses Super Damage ");
        } else if (healthpoint < 20) {
            result = max_Damage + increaseBoss;
            System.out.println(name + " Have less than 20 hp, his damage will be increased.");
        } else
            result = (int) (Math.random() * range) + min;
        return result;
    }


    private void spell() {
        while (healthpoint > 0 && hero_HP > 0 || healthpoint > 0 && herohp_wout > 0) {
            int result = random_Spell_damage();
            System.out.println(youHitNameUsingSpellOn + result + hp);
            System.out.println("After Recovering " + Main_Mob_Hero.getRestoreBoss() + " health point " + Main_Mob_Hero.getName() + " have " + ((healthpoint + restoreBoss) - result) + hp);
            healthpoint = (healthpoint + restoreBoss) - result;
            if (minspelldamageHERO <= 0 && maxspellDamageHero <= 0) {
                System.out.println(sorryButYouCantDoThat);
                move();
                break;
            } else if (healthpoint <= 0) {
                System.out.println(youHaveWonOverThe + name);
                break;
            } else mobmove();
            break;
        }
    }

    public static void again() {
        Scanner scanner = new Scanner(System.in);
        String cases = "\n Select option :" +
                "\n 1. Play Again " +
                "\n 2. Create new Hero and play Again" +
                "\n 3 Exit ";
        System.out.println(cases);
        switch (scanner.nextInt()) {
            case 1: {
                Levels.level_1_1();
            }
            case 2: {
                ChoseNewHero.main();
                break;
            }
            case 3: {
                Enum_Case.TestEnum(Enum_Case.ENUM.FINISHED);
                System.exit(1);
                break;
            }
        }
    }

    private static void setZero() {
        if (Weapon.getRET() <= 0) {
            Weapon.setRET(0);
        }
        if (defaultDamage <= 0) {
            Main_Mob_Hero.setDefaultDamage(0);
        }
        if (minspelldamageHERO <= 0 && maxspellDamageHero <= 0) {
            Main_Mob_Hero.setMinspelldamageHERO(0);
            Main_Mob_Hero.setMaxspellDamageHero(0);
        }
    }
}




