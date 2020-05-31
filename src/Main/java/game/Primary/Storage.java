package game.primary;

import game.fight.Level;

import java.io.*;
import java.util.Scanner;

public class Storage implements Serializable {

    private static Storage storage = new Storage();

    private static String fileName;

    private String heroArmorType;
    private String heroClass;
    private String heroName;
    private int heroHP;
    private int defaultDamage;
    private int minSpellDamageHERO;
    private int maxSpellDamageHero;
    private int restoreHealth;
    private int mana;

    private String userName;

    private int levelDifficult;
    private int levelCount;

    public static void save(boolean isGameSave) {
        save_upload_Menu(isGameSave);
        storage.getMain(isGameSave);
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
            objectOutputStream.writeObject(storage);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void get(boolean isGameSave) {
        save_upload_Menu(isGameSave);
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
            storage = (Storage) objectInputStream.readObject();
            storage.saveMain(isGameSave);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("The file is empty, try another");
            get(isGameSave);
        }
        Game.isEquip = true;
        Level.getLevel(TheMain.getLevelCount(), TheMain.getLevelDifficult());
    }

    private void getMain(boolean isGameSave) {
        if (isGameSave) {
            levelCount = TheMain.getLevelCount();
            levelDifficult = TheMain.getLevelDifficult();
        }
        heroArmorType = TheMain.getHeroArmor();
        heroClass = TheMain.getHeroClass();
        heroName = TheMain.getHeroName();
        heroHP = TheMain.getHeroHp();
        defaultDamage = TheMain.getHeroDamage();
        minSpellDamageHERO = TheMain.getHeroMinSpell();
        maxSpellDamageHero = TheMain.getHeroMaxSpell();
        restoreHealth = TheMain.getHeroRestoreHp();
        mana = TheMain.getHeroMana();

        userName = Game.getUserName();
    }

    private void saveMain(boolean isGameSave) {
        if (isGameSave) {
            TheMain.setLevelCount(levelCount);
            TheMain.setLevelDifficult(levelDifficult);
        }
        TheMain.setHeroArmor(heroArmorType);
        TheMain.setHeroClass(heroClass);
        TheMain.setHeroName(heroName);
        TheMain.setHeroHp(heroHP);
        TheMain.setHeroDamage(defaultDamage);
        TheMain.setHeroMinSpell(minSpellDamageHERO);
        TheMain.setHeroMaxSpell(maxSpellDamageHero);
        TheMain.setHeroRestoreHp(restoreHealth);
        TheMain.setHeroMana(mana);

        Game.setUserName(userName);
    }

    private static void save_upload_Menu(boolean isGameSave) {
        System.out.println("\n1. Slot 1\n2. Slot 2\n3. Slot 3\n");
        if (isGameSave) {
            switch (new Scanner(System.in).nextInt()) {
                case 1:
                    fileName = "GameSave1.txt";   // or "C:/GameSave1.txt"
                    break;
                case 2:
                    fileName = "GameSave2.txt";
                    break;
                case 3:
                    fileName = "GameSave3.txt";
                    break;
            }
        } else {
            switch (new Scanner(System.in).nextInt()) {
                case 1:
                    fileName = "HeroSave1.txt";
                    break;
                case 2:
                    fileName = "HeroSave2.txt";
                    break;
                case 3:
                    fileName = "HeroSave3.txt";
                    break;
            }
        }
    }

}