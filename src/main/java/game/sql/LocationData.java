package game.sql;

import game.primary.MainData;

import java.sql.*;
import java.util.*;

public class  LocationData extends ConnectSetting {

    private static final String GET_ALL_EQUIPMENTS = "SELECT * FROM location";
    private static final String GET_LOCATIONS_WHERE_ID_UNKNOWN = "SELECT * FROM location WHERE id = ?";


    public static void createLocation() {
        showLocations();
        setLocationToMain();
    }

    private static void showLocations() {
        try {
            connectToDataBase();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_ALL_EQUIPMENTS);
            while (resultSet.next()) {
                String getFormat = "%1$-3s|%2$-14s -  %3$-6s %4$-8s|%5$-19s|%6$-12s|%7$-21s  " +
                        "||| %8$-15s %9$-9s|%10$-13s|%11$-27s";
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
            connectToDataBase();
            preparedStatement = connection.prepareStatement(GET_LOCATIONS_WHERE_ID_UNKNOWN);
            preparedStatement.setInt(1, new Scanner(System.in).nextInt());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                MainData.setHeroHp(MainData.getHeroHp() + resultSet.getInt("heroHp"));
                MainData.setHeroDamage(MainData.getHeroDamage() + resultSet.getInt("heroDamage"));
                MainData.setHeroMinSpell(MainData.getHeroMinSpell() + resultSet.getInt("heroSpellDamage"));
                MainData.setHeroMaxSpell(MainData.getHeroMaxSpell() + resultSet.getInt("heroSpellDamage"));
                MainData.setHeroRestoreHp(MainData.getHeroRestoreHp() + resultSet.getInt("heroRestoreHealth"));

                MainData.setMobHp(MainData.getMobHp() + resultSet.getInt("creatureHp"));
                MainData.setMobMinDamage(MainData.getMobMinDamage() + resultSet.getInt("creatureDamage"));
                MainData.setMobMaxDamage(MainData.getMobMaxDamage() + resultSet.getInt("creatureDamage"));
                MainData.setMobChanceToSuperDamage(MainData.getMobChanceToSuperDamage() + resultSet.getInt("creatureChance"));

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

