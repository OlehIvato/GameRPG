package game.sql;


import game.primary.MainData;

import java.sql.*;
import java.util.*;

public class EquipmentData extends ConnectSetting {

    private static final Iterator<String> descriptionSelect =
            Arrays.asList("Select Head Armor:\n", "Select Shoulder Armor:\n", "Select Chest Armor:\n", "Select Leg Armor:\n")
                    .iterator();

    private static final Iterator<String> type = Arrays.asList("Head", "Shoulder", "Chest", "Legs").iterator();

    private static final String[] armor = new String[]{"Cloth", "Leather", "Plate"};


    private static final String GET_ALL_EQUIPMENTS = "SELECT * FROM equipment ";
    private static final String GET_EQUIPMENTS_WHERE_ID_UNKNOWN = "SELECT * FROM equipment WHERE id = ?";

    private static final String GET_TYPE_BY_EQUIPMENTS_ID = "select types0_.equipment_model_id as equipmen1_10_0_, " +
            "type1_.type as type " +
            "from equipment_types types0_ " +
            "inner join type type1_ on types0_.types_id=type1_.id " +
            "order by equipmen1_10_0_";

    private static final String GET_ARMOR_BY_EQUIPMENTS_ID = "select armors0_.equipment_model_id as equipmen1_9_0_, " +
            "armor1_.armor as armor " +
            "from equipment_armors armors0_ " +
            "inner join armor armor1_ on armors0_.armors_id = armor1_.id " +
            "order by equipmen1_9_0_";


    public static void createEquipments(String getArmor, String getClass) {
        createMainEquipments(getArmor);
        createAdditionalEquipments(getClass);

    }


    private static void createMainEquipments(String getArmor) {
        for (String result : armor) {
            if (getArmor.equals(result)) {
                while (type.hasNext() && descriptionSelect.hasNext()) {
                    System.out.println(descriptionSelect.next());
                    show(result, type.next());
                }
            }
        }
    }

    private static void createAdditionalEquipments(String getClass) {
        class Class {
            private static final String WARRIOR = "Warrior";
            private static final String PALADIN = "Paladin";
            private static final String MAGE = "Mage";
            private static final String DRUID = "Druid";
            private static final String PRIEST = "Priest";
            private static final String SHAMAN = "Shaman";
            private static final String MONK = "Monk";
            private static final String HUNTER = "Hunter";
        }
        class Create {
            private void getWeapon(String type, String description) {
                System.out.println(description);
                show("Weapon", type);
            }
        }
        if (getClass.equals(Class.WARRIOR)
                || getClass.equals(Class.PALADIN)
                || getClass.equals(Class.SHAMAN)) {
            new Create().getWeapon("Wand", "\nSelect Wand:\n");
        }
        if (getClass.equals(Class.WARRIOR)
                || getClass.equals(Class.PALADIN)
                || getClass.equals(Class.MONK)
                || getClass.equals(Class.HUNTER)) {
            new Create().getWeapon("Sword", "\nSelect Sword:\n");
        }
        if (getClass.equals(Class.MAGE)
                || getClass.equals(Class.DRUID)
                || getClass.equals(Class.PRIEST)
                || MainData.getHeroMana() < 110) {
            new Create().getWeapon("Amulet", "\nSelect Amulet:\n");
        }
        if (MainData.getHeroHp() < 150 && !getClass.equals(Class.MAGE)
                && !getClass.equals(Class.PRIEST)
                && !getClass.equals(Class.MONK)) {
            new Create().getWeapon("Shield", "\nSelect Shield:\n");
        }
    }


    private static void show(String getArmorOrWeapon, String getType) {
        List<Long> listOfSelectedId = new ArrayList<>();
        try {
            connectToDataBase();
            statement = connection.createStatement();
            Statement statementType = connection.createStatement();
            Statement statementArmor = connection.createStatement();

            resultSet = statement.executeQuery(GET_ALL_EQUIPMENTS);
            ResultSet resultType = statementType.executeQuery(GET_TYPE_BY_EQUIPMENTS_ID);
            ResultSet resultArmor = statementArmor.executeQuery(GET_ARMOR_BY_EQUIPMENTS_ID);

            while (resultSet.next() && resultType.next() && resultArmor.next()) {
                if (resultArmor.getString("armor").equals(getArmorOrWeapon)
                        && resultType.getString("type").equals(getType)) {
                    String getFormat = "%1$-4s|%2$-30s|%3$-8s|%4$-11s|%5$-18s|%6$-9s|%7$-16s|%8$-21s|";
                    String value = String.format(getFormat,
                            resultSet.getLong("id"),
                            resultSet.getString("name"),
                            " HP: " + resultSet.getInt("hp"),
                            " Damage: " + resultSet.getInt("damage"),
                            " Spell Damage: " + resultSet.getInt("spell_damage"),
                            " Mana: " + resultSet.getInt("mana"),
                            " Type: " + resultType.getString("type"),
                            " Armor Type: " + resultArmor.getString("armor"));
                    System.out.println(value);
                    listOfSelectedId.add(resultSet.getLong("id"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        setValuesToMain(listOfSelectedId);
    }


    private static void setValuesToMain(List<Long> getListOfSelectedId) {
        long getId;
        try {
            connectToDataBase();
            preparedStatement = connection.prepareStatement(GET_EQUIPMENTS_WHERE_ID_UNKNOWN);
            getId = new Scanner(System.in).nextLong();
            while (!getListOfSelectedId.contains(getId)) {
                System.out.println("wrong id, try other");
                getId = new Scanner(System.in).nextLong();
            }
            preparedStatement.setLong(1, getId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                MainData.setHeroHp(MainData.getHeroHp() + resultSet.getInt("hp"));
                MainData.setHeroDamage(MainData.getHeroDamage() + resultSet.getInt("damage"));
                MainData.setHeroMinSpell(MainData.getHeroMinSpell() + resultSet.getInt("spell_damage"));
                MainData.setHeroMaxSpell(MainData.getHeroMaxSpell() + resultSet.getInt("spell_damage"));
                MainData.setHeroMana(MainData.getHeroMana() + resultSet.getInt("mana"));

                System.out.println("You selected " + " +" + resultSet.getInt("hp") + " to HP, +"
                        + resultSet.getInt("damage") + " to Damage, +"
                        + resultSet.getInt("spell_damage") + " to Spell Damage, +"
                        + resultSet.getInt("mana") + " to Mana. ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}