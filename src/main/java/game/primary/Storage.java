package game.primary;

import game.fight.LaunchGame;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class Storage {
    private static SaveData saveData = new SaveData();
    private static String fileName;

    private final static String gameSavePath = "src\\main\\java\\game\\primary\\save\\game\\";
    private final static String equipmentSavePath = "src\\main\\java\\game\\primary\\save\\equipment\\";

    /**
     * This method shows all list of files in folder for equipment or game, then gets these files, sets value to main Data,
     * and sets value, this is a game with equipments.
     *
     * @param isGameSave need to check if game is saved or equipment is saved, because for game and equipments saved there is two different folder.
     */
    public static void getFilesFromFolder(boolean isGameSave) {
        try {
            if (isGameSave) {
                Files.walkFileTree(Paths.get(gameSavePath), new HashSet<>(), 1, new ShowFiles());
            } else {
                Files.walkFileTree(Paths.get(equipmentSavePath), new HashSet<>(), 1, new ShowFiles());
            }
            String a = (isGameSave) ? "\nSelect file of saved game" : "\nSelect file of saved equipment";
            System.out.println(a + "\n0. Back");
            for (Integer result : ShowFiles.listOfFiles.keySet()) {
                System.out.println(result + ". " + ShowFiles.listOfFiles.get(result));
            }
            int scan = new Scanner(System.in).nextInt();
            fileName = String.valueOf(ShowFiles.listOfFiles.get(scan));
            if (scan == 0) {
                if (isGameSave) {
                    Menu.main();
                } else Menu.second();
            } else {
                ObjectInputStream objectInputStream;
                if (isGameSave) {
                    objectInputStream = new ObjectInputStream(new FileInputStream(gameSavePath + fileName));
                } else {
                    objectInputStream = new ObjectInputStream(new FileInputStream(equipmentSavePath + fileName));
                }
                saveData = (SaveData) objectInputStream.readObject();
                saveData.saveValuesToMain(isGameSave);

                Setting.IS_GAME_WITH_EQUIPMENTS = true;
                LaunchGame.getLevel(Setting.LEVEL_COUNT, Setting.LEVEL_DIFFICULT);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * This class needed for save game or equipments
     *
     * @param isGameSave need to check if this save for game or equipment, because there is two different folder.
     */
    public static void saveFileToFolder(boolean isGameSave) {
        saveData.getValuesFromMain(isGameSave);
        String a = (isGameSave) ? "\nWrite name of your file, for Game save:" : "\nWrite name of your file, for Equipment save:";
        System.out.println(a);
        fileName = new Scanner(System.in).nextLine();
        try {
            ObjectOutputStream objectOutputStream;
            if (isGameSave) {
                objectOutputStream = new ObjectOutputStream(new FileOutputStream(gameSavePath + fileName));
            } else {
                objectOutputStream = new ObjectOutputStream(new FileOutputStream(equipmentSavePath + fileName));
            }
            objectOutputStream.writeObject(saveData);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Successfully saved");
    }

    /**
     * This class needed for serialization, because in GameData all fields is static
     */
    private static class SaveData extends MainData implements Serializable {

        private String serialize_heroArmor;
        private String serialize_heroClass;
        private String serialize_heroName;
        private int serialize_heroHp;
        private int serialize_heroDamage;
        private int serialize_heroMinSpell;
        private int serialize_heroMaxSpell;
        private int serialize_heroRestoreHp;
        private int serialize_heroMana;

        private String serialize_playerName;

        private int serialize_levelDifficult;
        private int serialize_levelCount;


        private void getValuesFromMain(boolean isGameSave) {
            if (isGameSave) {

                serialize_levelCount = Setting.LEVEL_COUNT;
                serialize_levelDifficult = Setting.LEVEL_DIFFICULT;
            }
            serialize_heroArmor = heroArmor;
            serialize_heroClass = heroClass;
            serialize_heroName = heroName;
            serialize_heroHp = heroHp;
            serialize_heroDamage = heroDamage;
            serialize_heroMinSpell = heroMinSpell;
            serialize_heroMaxSpell = heroMaxSpell;
            serialize_heroRestoreHp = heroRestoreHp;
            serialize_heroMana = heroMana;

            serialize_playerName = Setting.PLAYER_NAME;
        }


        private void saveValuesToMain(boolean isGameSave) {
            if (isGameSave) {
                Setting.LEVEL_COUNT = serialize_levelCount;
                Setting.LEVEL_DIFFICULT = serialize_levelDifficult;
            }
            heroArmor = serialize_heroArmor;
            heroClass = serialize_heroClass;
            heroName = serialize_heroName;
            heroHp = serialize_heroHp;
            heroDamage = serialize_heroDamage;
            heroMinSpell = serialize_heroMinSpell;
            heroMaxSpell = serialize_heroMaxSpell;
            heroRestoreHp = serialize_heroRestoreHp;
            heroMana = serialize_heroMana;

            Setting.PLAYER_NAME = serialize_playerName;

        }
    }

    /**
     * This class is needed to see all saved files in the folder
     */
    private static class ShowFiles extends SimpleFileVisitor<Path> {
        static Map<Integer, Path> listOfFiles = new HashMap<>();
        int key = 0;

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
            key++;
            listOfFiles.put(key, file.getFileName());
            return FileVisitResult.CONTINUE;
        }
    }


}