package game.sql;


import game.primary.Main_All;

import java.sql.*;
import java.util.*;

public class LocationDatabase {
    private static Connection connection;
    private static ResultSet resultSet;
    private static Scanner scanner = new Scanner(System.in);

    public static void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\nWould you like to select Location for Fight?  (it will change " + Main_All.getHeroName() + " and creatures characteristics)");
        System.out.println("1. Yes \n2. No, continue without Locations");
        switch (scanner.nextInt()) {
            case 1:
                showLocations();
                selectLocation();
                break;
            case 2:
                break;
            default: {
                System.out.println("Something went wrong");
                main();
            }
        }
    }

    private static void selectLocation() {
        try {
            connection = DriverManager.getConnection(Main_All.getUrl(), Main_All.getUserName(), Main_All.getPassword());
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM location WHERE id = ?");
            preparedStatement.setInt(1, scanner.nextInt());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Main_All.setHeroHP(Main_All.getHeroHP() + resultSet.getInt("heroHp"));
                Main_All.setDefaultDamage(Main_All.getDefaultDamage() + resultSet.getInt("heroDamage"));
                Main_All.setMinSpellDamageHERO(Main_All.getMinSpellDamageHERO() + resultSet.getInt("heroSpellDamage"));
                Main_All.setMaxSpellDamageHero(Main_All.getMaxSpellDamageHero() + resultSet.getInt("heroSpellDamage"));
                Main_All.setRestoreHealth(Main_All.getRestoreHealth() + resultSet.getInt("heroRestoreHealth"));
                Main_All.setHealthPoint(Main_All.getHealthPoint() + resultSet.getInt("creatureHp"));
                Main_All.setMin_Damage(Main_All.getMin_Damage() + resultSet.getInt("creatureDamage"));
                Main_All.setMax_Damage(Main_All.getMax_Damage() + resultSet.getInt("creatureDamage"));
                Main_All.setChanceToSuperDamage(Main_All.getChanceToSuperDamage() + resultSet.getInt("creatureChance"));
                System.out.println("You selected " + resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void showLocations() {
        try {
            connection = DriverManager.getConnection(Main_All.getUrl(), Main_All.getUserName(), Main_All.getPassword());
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM location");
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

    private static String formatPlus(int number) {
        if (number > 0)
            return "+" + number;
        else return "" + number;
    }
}

