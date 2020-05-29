package game.sql;


import game.primary.TheMain;

import java.sql.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class EquipmentDatabase {

    private static Connection connection;
    private static final List<String> typeList = Arrays.asList("Head", "Shoulder", "Chest", "Legs");
    private static final List<String> descriptionList = Arrays.asList("Select Head Armor:\n", "Select Shoulder Armor:\n", "Select Chest Armor:\n", "Select Leg Armor:\n");

    private static final Iterator<String> type = typeList.iterator();
    private static final Iterator<String> description = descriptionList.iterator();

    public static void createEquipment(String getArmor, String getClass) {

        String selectWand = "Select Wand\n";
        String selectSword = "Select Sword\n";
        String selectShield = "Select Shield\n";
        String selectAmulet = "Select Amulet\n";

        String type_Wand = "Wand";
        String type_Sword = "Sword";
        String type_Shield = "Shield";
        String type_Amulets = "Amulet";


        String cloth = "Cloth";
        String leather = "Leather";
        String plate = "Plate";
        String weapon = "Weapon";


        if (getArmor.equals(cloth)) {
            while (type.hasNext() && description.hasNext()) {
                System.out.println(description.next());
                show(cloth, type.next());
            }
        }

        if (getArmor.equals(leather)) {
            while (type.hasNext() && description.hasNext()) {
                System.out.println(description.next());
                show(leather, type.next());
            }
        }

        if (getArmor.equals(plate)) {
            while (type.hasNext() && description.hasNext()) {
                System.out.println(description.next());
                show(plate, type.next());
            }
        }


        if (getClass.equals("Mage") || getClass.equals("Paladin")) {
            System.out.println(selectWand);
            show(weapon, type_Wand);
        }
        if (getClass.equals("Warrior") || getClass.equals("Paladin") || getClass.equals("Monk")) {
            System.out.println(selectSword);
            show(weapon, type_Sword);
        }
        if (getClass.equals("Mage") || getClass.equals("Druid") || getClass.equals("Priest") && TheMain.getHeroMana() < 110) {
            System.out.println(selectAmulet);
            show(weapon, type_Amulets);
        }
        if (TheMain.getHeroHp() < 150) {
            System.out.println(selectShield);
            show(weapon, type_Shield);
        }

    }

    private static void show(String getArmor, String getType) {
        try {
            connection = DriverManager.getConnection(TheMain.getUrl(), TheMain.getUsername(), TheMain.getPassword());
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
        setValuesToMain();
    }

    private static void setValuesToMain() {
        try {
            connection = DriverManager.getConnection(TheMain.getUrl(), TheMain.getUsername(), TheMain.getPassword());
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM equipment WHERE id = ?");
            preparedStatement.setInt(1, new Scanner(System.in).nextInt());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                TheMain.setHeroHp(TheMain.getHeroHp() + resultSet.getInt("hp"));
                TheMain.setHeroDamage(TheMain.getHeroDamage() + resultSet.getInt("damage"));
                TheMain.setHeroMinSpell(TheMain.getHeroMinSpell() + resultSet.getInt("spell_damage"));
                TheMain.setHeroMaxSpell(TheMain.getHeroMaxSpell() + resultSet.getInt("spell_damage"));
                TheMain.setHeroMana(TheMain.getHeroMana() + resultSet.getInt("mana"));
                System.out.println("You selected " + " +" + resultSet.getInt("hp") + " to HP," + " +" + resultSet.getInt("damage") + " to Damage," + " +" + resultSet.getInt("spell_damage") + " to Spell Damage," + " +" + resultSet.getInt("mana") + " to Mana. ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}