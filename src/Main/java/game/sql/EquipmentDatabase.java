package game.sql;


import game.Primary.Main_All;

import java.sql.*;
import java.util.Scanner;

public class EquipmentDatabase {

    private static Connection connection;
    private static ResultSet resultSet;
    private static Scanner scanner = new Scanner(System.in);
    private static String showResult = "Final  Hero HP: " + Main_All.getHeroHP() + ", Damage = " + Main_All.getDefaultDamage() + ", Min/Max Spell Damage = " + Main_All.getMinSpellDamageHERO() + "/" + Main_All.getMaxSpellDamageHero() + ", Mana= " + Main_All.getMana();


    private static String head = "Select Head Armor:\n";
    private static String shoulder = "Select Shoulder Armor:\n";
    private static String chest = "Select Chest Armor:\n";
    private static String leg = "Select Leg Armor\n";

    private static String plate_head = "SELECT * FROM equipment WHERE type = 'head' and type_armor = 'plate'";
    private static String plate_shoulder = "SELECT * FROM equipment WHERE type = 'shoulder' and type_armor = 'plate'";
    private static String plate_legs = "SELECT * FROM equipment WHERE type = 'legs' and type_armor = 'plate'";
    private static String plate_chest = "SELECT * FROM equipment WHERE type = 'chest' and type_armor = 'plate'";

    private static String leather_head = "SELECT * FROM equipment WHERE type = 'head' and type_armor = 'leather'";
    private static String leather_shoulder = "SELECT * FROM equipment WHERE type = 'shoulder' and type_armor = 'leather'";
    private static String leather_legs = "SELECT * FROM equipment WHERE type = 'legs' and type_armor = 'leather'";
    private static String leather_chest = "SELECT * FROM equipment WHERE type = 'chest' and type_armor = 'leather'";

    private static String cloth_head = "SELECT * FROM equipment WHERE type = 'head' and type_armor = 'cloth'";
    private static String cloth_shoulder = "SELECT * FROM equipment WHERE type = 'shoulder' and type_armor = 'cloth'";
    private static String cloth_legs = "SELECT * FROM equipment WHERE type = 'legs' and type_armor = 'cloth'";
    private static String cloth_chest = "SELECT * FROM equipment WHERE type = 'chest' and type_armor = 'cloth'";

    private static String weapon_sword = "SELECT * FROM equipment WHERE type = 'sword'";
    private static String weapon_wand = "SELECT * FROM equipment WHERE type = 'wand'";
    private static String weapon_shield = "SELECT * FROM equipment WHERE type = 'shield'";

    public static void equipmentMain() {
        if (Main_All.getHeroArmorType().equals("cloth")) {
            System.out.println(head);
            show(cloth_head);

            System.out.println(shoulder);
            show(cloth_shoulder);

            System.out.println(chest);
            show(cloth_chest);

            System.out.println(leg);
            show(cloth_legs);
        }
        if (Main_All.getHeroArmorType().equals("leather")) {
            System.out.println(head);
            show(leather_head);

            System.out.println(shoulder);
            show(leather_shoulder);

            System.out.println(chest);
            show(leather_chest);

            System.out.println(leg);
            show(leather_legs);
        }
        if (Main_All.getHeroArmorType().equals("plate")) {
            System.out.println(head);
            show(plate_head);

            System.out.println(shoulder);
            show(plate_shoulder);

            System.out.println(chest);
            show(plate_chest);

            System.out.println(leg);
            show(plate_legs);
        }
        if (Main_All.getHeroClass().equals("Mage") || Main_All.getHeroClass().equals("Paladin")) {

            show(weapon_wand);
        }
        if (Main_All.getHeroClass().equals("Warrior") || Main_All.getHeroClass().equals("Paladin") || Main_All.getHeroClass().equals("Monk")) {

            show(weapon_sword);
        }
        if (Main_All.getHeroHP() < 150) {
            show(weapon_shield);
        }

    }

    private static void show(String sql) {
        try {
            connection = DriverManager.getConnection(Main_All.getUrl(), Main_All.getUserName(), Main_All.getPassword());
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String getFormat = "%1$-4s|%2$-30s|%3$-8s|%4$-11s|%5$-18s|%6$-9s|%7$-14s|%8$-21s|";
                String value = String.format(getFormat,
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        " HP: " + resultSet.getInt("hp"),
                        " Damage: " + resultSet.getInt("damage"),
                        " Spell Damage: " + resultSet.getInt("spell_damage"),
                        " Mana: " + resultSet.getInt("mana"),
                        " Type: " + resultSet.getString("type"),
                        " Armor Type: " + resultSet.getString("type_armor"));
                System.out.println(value);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        setValues();
    }

    private static void setValues() {
        try {
            connection = DriverManager.getConnection(Main_All.getUrl(), Main_All.getUserName(), Main_All.getPassword());
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM equipment WHERE id = ?");
            preparedStatement.setInt(1, scanner.nextInt());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Main_All.setHeroHP(Main_All.getHeroHP() + resultSet.getInt("hp"));
                Main_All.setDefaultDamage(Main_All.getDefaultDamage() + resultSet.getInt("damage"));
                Main_All.setMinSpellDamageHERO(Main_All.getMinSpellDamageHERO() + resultSet.getInt("spell_damage"));
                Main_All.setMaxSpellDamageHero(Main_All.getMaxSpellDamageHero() + resultSet.getInt("spell_damage"));
                Main_All.setMana(Main_All.getMana() + resultSet.getInt("mana"));
                System.out.println("You selected " + " +" + resultSet.getInt("hp") + " to HP," + " +" + resultSet.getInt("damage") + " to Damage," + " +" + resultSet.getInt("spell_damage") + " to Spell Damage," + " +" + resultSet.getInt("mana") + " to Mana. ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}