package Fight;

import Armor.Equipment;
import Armor.Stick;
import Armor.Weapon;
import Main.*;
import Сreature.Main_All;

import java.util.Random;
import java.util.Scanner;

public class Fight extends Main_All implements Text, Levels {

    private int hero_HP = Equipment.getRess();
    private int heroHP_wOut = getHeroHP();
    private int manaFinal = Stick.getResult();
    private int manaFinal_wOut = getMana();

    public Fight() {
    }

    public void main() {
        setZero();
        if (TheGame.getInfo() == 1) {
            Text.description_vs_mob();
        }
        if (TheGame.getInfo() == 2) {
            Text.description_vs_mob_wout();
        }
        move();
    }

    private void move() {
        if (TheGame.getInfo() == 1) {
            String cases = "\nYour Turn \n" +
                    "1. Hit " + name + " on " + Weapon.getRET() + " health point \n2. Strike with magic on " + randomDamage + " health point " +
                    "\n3. Restore " + res + " health point, Need " + Main_All.getHealCast() + " Mana, You Have " + manaFinal + " Mana" +
                    "\n4. Get defeat and back to Main Menu ";
            System.out.println(cases);
            Scanner scan = new Scanner(System.in);
            while (healthPoint > 0 && hero_HP > 0) {
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
                        Main.menu();
                        break;
                    }
                }
            }
        }
        if (TheGame.getInfo() == 2) {
            String cases = "\nYour Turn \n" +
                    "1. Hit " + name + " on " + defaultDamage + hp + "\n2. Strike with magic on " + randomDamage + " health point " +
                    "\n3. Restore " + res + " health point, Need " + Main_All.getHealCast() + " Mana, You Have " + manaFinal_wOut + " Mana" +
                    "\n4. To get defeat and back to Main Menu ";
            System.out.println(cases);
            Scanner scan = new Scanner(System.in);
            while (healthPoint > 0 && heroHP_wOut > 0) {
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
                        Main.menu();
                        break;
                    }
                }
            }
        }
    }

    private void heromove() {
        if (TheGame.getInfo() == 1) {
            while (healthPoint > 0 && hero_HP > 0) {
                System.out.println(youHitNameOnWeaponHp);
                System.out.print(nowNameHave);
                System.out.println(healthPoint - Weapon.getRET() + hp);
                healthPoint -= Weapon.getRET();
                if (healthPoint <= 0) {
                    System.out.println(youHaveWonOverThe + name);
                    break;
                } else mobmove();
                break;
            }
        }
        if (TheGame.getInfo() == 2) {
            while (healthPoint > 0 && heroHP_wOut > 0) {
                System.out.println(youHitNameOnDefaultDamageHp);
                System.out.print(nowNameHave);
                System.out.println(healthPoint - defaultDamage + hp);
                healthPoint -= defaultDamage;
                if (healthPoint <= 0) {
                    System.out.println(youHaveWonOverThe + name);
                    break;
                } else mobmove();
                break;
            }
        }

    }

    private void mobmove() {
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
                            heromove();
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
                            heromove();
                            break;
                        }
                        case 2: {
                            spell();
                            break;
                        }
                        case 3:
                            System.err.print(getLOSS);
                            Main.menu();
                            break;
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
            result = max_Damage + Main_All.getIncreaseDamage();
            System.out.println(name + " uses Super Damage ");
        } else
            result = (int) (Math.random() * range) + min;
        return result;
    }


    private void spell() {
        while (healthPoint > 0 && hero_HP > 0 || healthPoint > 0 && heroHP_wOut > 0) {
            int result = random_Spell_damage();
            System.out.println(youHitNameUsingSpellOn + result + hp);
            System.out.print(nowNameHave);
            System.out.println(healthPoint - result + hp);
            healthPoint -= result;
            if (minSpellDamageHERO <= 0 && maxSpellDamageHero <= 0) {
                System.out.println(sorryButYouCantDoThat);
                move();
                break;
            } else if (healthPoint <= 0) {
                System.out.println(youHaveWonOverThe + name);
                break;
            } else mobmove();
            break;
        }
    }


    public static void again() {
        Scanner scanner = new Scanner(System.in);
        String cases = "\nSelect option :" +
                "\n1. Play Again " +
                "\n2. Create new Hero and play Again" +
                "\n3 Exit ";
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
        if (restoreHealth <= 0) {
            Main_All.setRestoreHealth(0);
        }
    }

}


