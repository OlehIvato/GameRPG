package game.primary;

import game.fight.Level;
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashSet;
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

    private String playerName;

    private int levelDifficult;
    private int levelCount;

    private final static String gameSavePath = "src\\main\\java\\game\\primary\\save\\game\\";
    private final static String equipmentSavePath = "src\\main\\java\\game\\primary\\save\\equipment\\";


    static void get(boolean isGameSave) {
        try {
            if (isGameSave) {
                Files.walkFileTree(Paths.get(gameSavePath), new HashSet<>(), 1, new ShowFiles());
            } else {
                Files.walkFileTree(Paths.get(equipmentSavePath), new HashSet<>(), 1, new ShowFiles());
            }
            String a = (isGameSave) ? "\nSelect file of saved game" : "\nSelect file of saved equipment";
            System.out.println(a + ", if you wanna turn back, write \"back\"");
            fileName = new Scanner(System.in).nextLine();
            if (fileName.equals("back")) {
                Game.menu();
            } else {
                ObjectInputStream objectInputStream;
                if (isGameSave) {
                    objectInputStream = new ObjectInputStream(new FileInputStream(gameSavePath + fileName));
                } else {
                    objectInputStream = new ObjectInputStream(new FileInputStream(equipmentSavePath + fileName));
                }
                storage = (Storage) objectInputStream.readObject();
                storage.saveValuesToMain(isGameSave);
                Game.isEquip = true;
                Level.getLevel(TheMain.getLevelCount(), TheMain.getLevelDifficult());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void save(boolean isGameSave) {
        storage.getValuesFromMain(isGameSave);
        String a = (isGameSave) ? "\nWrite name of your file, for Game save:" : "\nWrite name of your file, for Equipment save:";
        System.out.println(a + ", if you wanna turn back, write \"back\"");
        fileName = new Scanner(System.in).nextLine();
        if (fileName.equals("back")) {
            Game.menu();
        } else {
            try {
                ObjectOutputStream objectOutputStream;
                if (isGameSave) {
                    objectOutputStream = new ObjectOutputStream(new FileOutputStream(gameSavePath + fileName));
                } else {
                    objectOutputStream = new ObjectOutputStream(new FileOutputStream(equipmentSavePath + fileName));
                }
                objectOutputStream.writeObject(storage);
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Successfully saved");
    }


    private void getValuesFromMain(boolean isGameSave) {
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

        playerName = TheMain.getPlayerName();
    }

    private void saveValuesToMain(boolean isGameSave) {
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

        Game.setPlayerName(playerName);
    }

    static class ShowFiles extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
            System.out.println(file.getFileName());
            return FileVisitResult.CONTINUE;
        }
    }
}