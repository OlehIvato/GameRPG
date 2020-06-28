package game.sql;

import game.primary.MainData;

import java.sql.*;
import java.util.*;

public class LocationData extends MainData implements ConnectSetting {
    private static Connection connection;
    private static ResultSet resultSet;

    private static final String GET_ALL_EQUIPMENTS = "SELECT * FROM location";
    private static final String GET_LOCATIONS_WHERE_ID_UNKNOWN = "SELECT * FROM location WHERE id = ?";


    public static void createLocation() {
        showLocations();
        setLocationToMain();
    }

    private static void showLocations() {
        try {
            connection = DriverManager.getConnection(data_url, data_username, data_password);
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_ALL_EQUIPMENTS);
            while (resultSet.next()) {
                String getFormat = "%1$-3s|%2$-14s -  %3$-6s %4$-8s|%5$-19s|%6$-12s|%7$-21s  ||| %8$-15s %9$-9s|%10$-13s|%11$-27s";
                String result = String.format(getFormat,
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        "FOR HERO: ",
                        "HP: " + formatPlus(resultSet.getInt("heroHp")),
                        " Spell Damage: " + formatPlus(resultSet.getInt("heroDamage")),
                        " Damage: " + formatPlus(resultSet.getInt("heroSpellDamage")),
                        " Restore Health: " + formatPlus(resultSet.getInt("heroRestoreHealth")),
                        " FOR CREATURES: ",
                        " HP: " + formatPlus(resultSet.getInt("creatureHp")),
                        " Damage: " + formatPlus(resultSet.getInt("creatureDamage")),
                        " Chance to Super Damage: " + formatPlus(resultSet.getInt("creatureChance")));
                System.out.println(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void setLocationToMain() {
        try {
            connection = DriverManager.getConnection(data_url, data_username, data_password);
            PreparedStatement preparedStatement = connection.prepareStatement(GET_LOCATIONS_WHERE_ID_UNKNOWN);
            preparedStatement.setInt(1, new Scanner(System.in).nextInt());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                heroHp = heroHp + resultSet.getInt("heroHp");
                heroDamage = heroDamage + resultSet.getInt("heroDamage");
                heroMinSpell = heroMinSpell + resultSet.getInt("heroSpellDamage");
                heroMaxSpell = heroMaxSpell + resultSet.getInt("heroSpellDamage");
                heroRestoreHp = heroRestoreHp + resultSet.getInt("heroRestoreHealth");

                mobHp = mobHp + resultSet.getInt("creatureHp");
                mobMinDamage = mobMinDamage + resultSet.getInt("creatureDamage");
                mobMaxDamage = mobMaxDamage + resultSet.getInt("creatureDamage");
                mobChanceToSuperDamage = mobChanceToSuperDamage + resultSet.getInt("creatureChance");

                System.out.println("You selected " + resultSet.getString("name") + "\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static String formatPlus(int number) {
        if (number > 0)
            return "+" + number;
        else return "" + number;
    }
}

