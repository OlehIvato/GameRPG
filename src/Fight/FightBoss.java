package Fight;

import Armor.Equipment;
import Armor.Stick;
import Armor.Weapon;
import Main.*;
import Сreature.Main_All;
import java.util.Random;
import java.util.Scanner;

public class FightBoss extends Main_All implements Text, Levels {

    private int res = Main_All.getIndex() + restoreHealth;
    private int hero_HP = Equipment.getRess();
    private int heroHP_wOut = getHeroHP();
    private int manaFinal = Stick.getResult();
    private int manaFinal_wOut = getMana();

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
                    "\n3. Restore " + res + " health point, Need " + Main_All.getHealCast() + " Mana, You Have " + manaFinal + " Mana" +
                    "\n4. Get defeat and back to Main Menu ";
            System.out.println(cases);
            Scanner scan = new Scanner(System.in);
            while (healthPoint > 0 && hero_HP > 0) {
                switch (scan.nextInt()) {
                    case 1: {
                        heroMove();
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
                        Main.menu();
                        break;
                    }
                }
            }
        }
        if (TheGame.getInfo() == 2) {
            String cases = "\n Your Turn \n" +
                    "1. Hit " + name + " on " + defaultDamage + hp + "\n2. Strike with magic on " + randomDamage + " health point " +
                    "\n3. Restore " + res + " health point, Need " + Main_All.getHealCast() + " Mana, You Have " + manaFinal_wOut + " Mana" +
                    "\n4. To get defeat and back to Main Menu ";
            System.out.println(cases);
            Scanner scan = new Scanner(System.in);
            while (healthPoint > 0 && heroHP_wOut > 0) {
                switch (scan.nextInt()) {
                    case 1: {
                        heroMove();
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
                        Main.menu();
                        break;
                    }
                }
            }
        }
    }

    private void heroMove() {
        if (TheGame.getInfo() == 1) {
            while (healthPoint > 0 && hero_HP > 0) {
                System.out.println(youHitNameOnWeaponHp);
                System.out.print(nowBossHave + ((healthPoint + restoreCreature) - Weapon.getRET()) + hp);
                healthPoint = (healthPoint + restoreCreature) - Weapon.getRET();
                if (healthPoint <= 0) {
                    System.out.println(youHaveWonOverThe + name);
                    break;
                } else mobMove();
                break;
            }
        }
        if (TheGame.getInfo() == 2) {
            while (healthPoint > 0 && heroHP_wOut > 0) {
                System.out.println(youHitNameOnDefaultDamageHp);
                System.out.print(nowBossHave + ((healthPoint + restoreCreature) - defaultDamage) + hp);
                healthPoint = (healthPoint + restoreCreature) - defaultDamage;
                if (healthPoint <= 0) {
                    System.out.println(youHaveWonOverThe + name);
                    break;
                } else mobMove();
                break;
            }
        }
    }

    private void mobMove() {
        if (TheGame.getInfo() == 1) {
            while (hero_HP > 0 && healthPoint > 0) {
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
            while (heroHP_wOut > 0 && healthPoint > 0) {
                System.out.println(nameTurn);
                int EqualRandom = random();
                System.out.print(nameHitYouOn + EqualRandom + hp);
                heroHP_wOut -= EqualRandom;
                System.out.println(nowYouHaveHp + heroHP_wOut + hp);
                if (heroHP_wOut <= 0) {
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
            while (healthPoint > 0 && hero_HP > 0) {
                if (manaFinal >= Main_All.getHealCast()) {
                    hero_HP += res;
                    System.out.println(youChoseHealingYourself);
                    manaFinal -= Main_All.getHealCast();
                    System.out.println(youHaveBeenRecovered);
                    System.out.println(nowYourHealthPointEqual + hero_HP);
                    System.out.println("Now you have left " + manaFinal + " Mana ");
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
                            Main.menu();
                            break;
                        }
                    }
                }
                if (manaFinal < Main_All.getHealCast()) {
                    System.out.println(noMoreMana);
                    move();
                    break;
                }
            }
        }
        if (TheGame.getInfo() == 2) {
            while (healthPoint > 0 && heroHP_wOut > 0) {
                if (manaFinal_wOut >= Main_All.getHealCast()) {
                    heroHP_wOut += res;
                    System.out.println(youChoseHealingYourself);
                    manaFinal_wOut -= Main_All.getHealCast();
                    System.out.println(youHaveBeenRecovered);
                    System.out.println(nowYourHealthPointEqual + heroHP_wOut);
                    System.out.println("Now you have left " + manaFinal_wOut + " Mana ");
                    Scanner scan = new Scanner(System.in);
                    System.out.println(chooseNewOptions_Mana_Menu_wout);
                    switch (scan.nextInt()) {
                        case 1: {
                            heroMove();
                            break;
                        }
                        case 2: {
                            spell();
                            break;
                        }
                        case 3: {
                            System.err.println(getLOSS);
                            Main.menu();
                            break;
                        }
                    }
                }
                if (manaFinal_wOut < Main_All.getHealCast()) {
                    System.out.println(noMoreMana);
                    move();
                    break;
                }
            }
        }
    }

    private int random_Spell_damage() {
        int max = maxSpellDamageHero;
        int min = minSpellDamageHERO;
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
        if (num < chanceToSuperDamage) {
            result = Main_All.getIncreaseDamage();
            System.out.println(name + " uses Super Damage ");
        } else if (healthPoint < 30) {
            result = max_Damage + Main_All.getIncreaseDamage();
            System.out.println(name + " Have less than 20 hp, his damage will be increased.");
        } else
            result = (int) (Math.random() * range) + min;
        return result;
    }


    private void spell() {
        while (healthPoint > 0 && hero_HP > 0 || healthPoint > 0 && heroHP_wOut > 0) {
            int result = random_Spell_damage();
            System.out.println(youHitNameUsingSpellOn + result + hp);
            System.out.println("After Recovering " + Main_All.getRestoreCreature() + " health point " + Main_All.getName() + " have " + ((healthPoint + restoreCreature) - result) + hp);
            healthPoint = (healthPoint + restoreCreature) - result;
            if (minSpellDamageHERO <= 0 && maxSpellDamageHero <= 0) {
                System.out.println(sorryButYouCantDoThat);
                move();
                break;
            } else if (healthPoint <= 0) {
                System.out.println(youHaveWonOverThe + name);
                break;
            } else mobMove();
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
            Main_All.setDefaultDamage(0);
        }
        if (minSpellDamageHERO <= 0 && maxSpellDamageHero <= 0) {
            Main_All.setMinSpellDamageHERO(0);
            Main_All.setMaxSpellDamageHero(0);
        }
    }
}




