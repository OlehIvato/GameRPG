package game.sql;

import game.primary.TheMain;

import java.sql.*;
import java.util.*;

public class LocationData {
    private static Connection connection;
    private static ResultSet resultSet;

    public static void createLocation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\nWould you like to select Location for Fight?  (it will change " + TheMain.getHeroName() + " and creatures characteristics)");
        System.out.println("1. Yes \n2. No, continue without Locations");
        switch (scanner.nextInt()) {
            case 1:
                showLocations();
                setLocationToMain();
                break;
            case 2:
                break;
            default: {
                System.out.println("Something went wrong");
                createLocation();
            }
        }
    }

    private static void setLocationToMain() {
        try {
            connection = DriverManager.getConnection(TheMain.getUrl(), TheMain.getUsername(), TheMain.getPassword());
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM location WHERE id = ?");
            preparedStatement.setInt(1, new Scanner(System.in).nextInt());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                TheMain.setHeroHp(TheMain.getHeroHp() + resultSet.getInt("heroHp"));
                TheMain.setHeroDamage(TheMain.getHeroDamage() + resultSet.getInt("heroDamage"));
                TheMain.setHeroMinSpell(TheMain.getHeroMinSpell() + resultSet.getInt("heroSpellDamage"));
                TheMain.setHeroMaxSpell(TheMain.getHeroMaxSpell() + resultSet.getInt("heroSpellDamage"));
                TheMain.setHeroRestoreHp(TheMain.getHeroRestoreHp() + resultSet.getInt("heroRestoreHealth"));
                TheMain.setMobHp(TheMain.getMobHp() + resultSet.getInt("creatureHp"));
                TheMain.setMobMinDamage(TheMain.getMobMinDamage() + resultSet.getInt("creatureDamage"));
                TheMain.setMobMaxDamage(TheMain.getMobMaxDamage() + resultSet.getInt("creatureDamage"));
                TheMain.setMobChanceToSuperDamage(TheMain.getMobChanceToSuperDamage() + resultSet.getInt("creatureChance"));
                System.out.println("You selected " + resultSet.getString("name") + "\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void showLocations() {
        try {
            connection = DriverManager.getConnection(TheMain.getUrl(), TheMain.getUsername(), TheMain.getPassword());
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

