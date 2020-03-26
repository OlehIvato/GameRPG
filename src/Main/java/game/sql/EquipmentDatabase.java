package game.sql;


import game.Primary.Main_All;

import java.sql.*;
import java.util.Scanner;

public class EquipmentDatabase {

    private static Connection connection;

    public static void equipmentMain() {

        String headSelect = "Select Head Armor:\n";
        String shoulderSelect = "Select Shoulder Armor:\n";
        String chestSelect = "Select Chest Armor:\n";
        String legSelect = "Select Leg Armor\n";
        String wandSelect = "Select Wand\n";
        String swordSelect = "Select Sword\n";
        String shieldSelect = "Select Shield\n";
        String amuletsSelect = "Select Amulets\n";


        String type_Head = "Head";
        String type_Shoulder = "Shoulder";
        String type_Chest = "Chest";
        String type_Legs = "Legs";
        String type_Wand = "Wand";
        String type_Sword = "Sword";
        String type_Shield = "Shield";
        String type_Amulets = "Amulets";


        String armor_Cloth = "Cloth";
        String armor_leather = "Leather";
        String armor_Plate = "Plate";
        String armor_Weapon = "Weapon";


        if (Main_All.getHeroArmorType().equals("Cloth")) {
            System.out.println(headSelect);
            show(armor_Cloth, type_Head);

            System.out.println(shoulderSelect);
            show(armor_Cloth, type_Shoulder);

            System.out.println(chestSelect);
            show(armor_Cloth, type_Chest);

            System.out.println(legSelect);
            show(armor_Cloth, type_Legs);
        }
        if (Main_All.getHeroArmorType().equals("Leather")) {
            System.out.println(headSelect);
            show(armor_leather, type_Head);

            System.out.println(shoulderSelect);
            show(armor_leather, type_Shoulder);

            System.out.println(chestSelect);
            show(armor_leather, type_Chest);

            System.out.println(legSelect);
            show(armor_leather, type_Legs);
        }
        if (Main_All.getHeroArmorType().equals("Plate")) {
            System.out.println(headSelect);
            show(armor_Plate, type_Head);

            System.out.println(shoulderSelect);
            show(armor_Plate, type_Shoulder);

            System.out.println(chestSelect);
            show(armor_Plate, type_Chest);

            System.out.println(legSelect);
            show(armor_Plate, type_Legs);
        }
        if (Main_All.getHeroClass().equals("Mage") || Main_All.getHeroClass().equals("Paladin")) {
            System.out.println(wandSelect);
            show(armor_Weapon, type_Wand);
        }
        if (Main_All.getHeroClass().equals("Warrior") || Main_All.getHeroClass().equals("Paladin") || Main_All.getHeroClass().equals("Monk")) {
            System.out.println(swordSelect);
            show(armor_Weapon, type_Sword);
        }
        if (Main_All.getHeroHP() < 150) {
            System.out.println(shieldSelect);
            show(armor_Weapon, type_Shield);
        }
        if (Main_All.getHeroClass().equals("Mage") || Main_All.getHeroClass().equals("Druid") || Main_All.getHeroClass().equals("Priest") && Main_All.getMana() < 115) {
            System.out.println(amuletsSelect);
            show(armor_Weapon, type_Amulets);
        }

    }

    private static void show(String getArmor, String getType) {
        try {
            connection = DriverManager.getConnection(Main_All.getUrl(), Main_All.getUserName(), Main_All.getPassword());
            Statement statementMain = connection.createStatement();
            Statement statementType = connection.createStatement();
            Statement statementArmor = connection.createStatement();

            ResultSet resultMain = statementMain.executeQuery("SELECT * FROM equipment ");
            ResultSet resultType = statementType.executeQuery("select types0_.equipment_model_id as equipmen1_10_0_, type1_.type as type from equipment_types types0_ inner join type type1_ on types0_.types_id=type1_.id   order by equipmen1_10_0_");
            ResultSet resultArmor = statementArmor.executeQuery("select armors0_.equipment_model_id as equipmen1_9_0_, armor1_.armor as armor from equipment_armors armors0_ inner join armor armor1_ on armors0_.armors_id = armor1_.id order by equipmen1_9_0_");

            while (resultMain.next() && resultType.next() && resultArmor.next()) {
                if (resultArmor.getString("armor").equals(getArmor) && resultType.getString("type").equals(getType)) {
                    String getFormat = "%1$-4s|%2$-30s|%3$-8s|%4$-11s|%5$-18s|%6$-9s|%7$-16s|%8$-21s|";
                    String value = String.format(getFormat,
                            resultMain.getLong("id"),
                            resultMain.getString("name"),
                            " HP: " + resultMain.getInt("hp"),
                            " Damage: " + resultMain.getInt("damage"),
                            " Spell Damage: " + resultMain.getInt("spell_damage"),
                            " Mana: " + resultMain.getInt("mana"),
                            " Type: " + resultType.getString("type"),
                            " Armor Type: " + resultArmor.getString("armor"));
                    System.out.println(value);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        setValues();
    }

    private static void setValues() {
        Scanner scanner = new Scanner(System.in);
        try {
            connection = DriverManager.getConnection(Main_All.getUrl(), Main_All.getUserName(), Main_All.getPassword());
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM equipment WHERE id = ?");
            preparedStatement.setInt(1, scanner.nextInt());
            ResultSet resultSet = preparedStatement.executeQuery();
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