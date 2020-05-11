package game.fight;

import game.primary.Main_All;
import game.primary.UserName;


import java.io.*;
import java.util.Scanner;

public class Saving implements Serializable {

    private static Saving saving = new Saving();
    private static Scanner scanner = new Scanner(System.in);
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


    private void getFromMain() {
        heroArmorType = Main_All.getHeroArmorType();
        heroClass = Main_All.getHeroClass();
        heroName = Main_All.getHeroName();
        heroHP = Main_All.getHeroHP();
        defaultDamage = Main_All.getDefaultDamage();
        minSpellDamageHERO = Main_All.getMinSpellDamageHERO();
        maxSpellDamageHero = Main_All.getMaxSpellDamageHero();
        restoreHealth = Main_All.getRestoreHealth();
        mana = Main_All.getMana();
        userName = UserName.getUserName();
    }

    private void saveMain() {
        Main_All.setHeroArmorType(heroArmorType);
        Main_All.setHeroClass(heroClass);
        Main_All.setHeroName(heroName);
        Main_All.setHeroHP(heroHP);
        Main_All.setDefaultDamage(defaultDamage);
        Main_All.setMinSpellDamageHERO(minSpellDamageHERO);
        Main_All.setMaxSpellDamageHero(maxSpellDamageHero);
        Main_All.setRestoreHealth(restoreHealth);
        Main_All.setMana(mana);
        UserName.setUserName(userName);
    }


    public static void saveCharacteristics() {
        savedFile();
        saving.getFromMain();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
            objectOutputStream.writeObject(saving);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        JFrame jFrame = new JFrame();
//        JFileChooser fileChooser = new JFileChooser("src\\main\\savedFiles");
//        fileChooser.setDialogTitle("Specify a file to save");
//        int selection = fileChooser.showSaveDialog(jFrame);
//        if (selection == JFileChooser.APPROVE_OPTION) {
//            File file = fileChooser.getSelectedFile();
//            System.out.println("Save as file: " + file.getAbsolutePath());
//        }

    }



    public static void getSavedCharacteristics() {
        savedFile();
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
            saving = (Saving) objectInputStream.readObject();
            saving.saveMain();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        Level.getLevel();
    }

    private static void savedFile() {
        String result = "Save name: \n" +
                "1. Slot 1\n" +
                "2. Slot 2\n" +
                "3. Slot 3\n";
        System.out.println(result);
        switch (scanner.nextInt()) {
            case 1:
                fileName = "saveOne";
                break;
            case 2:
                fileName = "saveTwo";
                break;
            case 3:
                fileName = "saveThree";
                break;
        }
    }
}
