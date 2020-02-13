package Location;


import Main.Main_All;

import java.sql.*;
import java.util.*;

public class CreateLocation {
    private static final String userName = "root";
    private static final String password = "root";
    private static final String url = "jdbc:mysql://localhost:3306/main";
    private static Connection connection;
    private static ResultSet resultSet;
    private static MainLocation locationMain = new MainLocation();
    private static Scanner scanner = new Scanner(System.in);


    public static void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\nWould you like to select Location for Fight?  (it will change " + Main_All.getHeroName() + " and creatures characteristics)");
        System.out.println("1. Yes \n2. No, continue without Locations");
        switch (scanner.nextInt()) {
            case 1:
                showLocations();
                selectLocation();
                locationMain.setValues();
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
            connection = DriverManager.getConnection(url, userName, password);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM location WHERE id = ?");
            preparedStatement.setInt(1, scanner.nextInt());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                locationMain.setId(resultSet.getLong("id"));
                locationMain.setName(resultSet.getString("name"));
                locationMain.setHeroHp(resultSet.getInt("heroHp"));
                locationMain.setHeroDamage(resultSet.getInt("heroDamage"));
                locationMain.setHeroSpellDamage(resultSet.getInt("heroSpellDamage"));
                locationMain.setHeroRestoreHealth(resultSet.getInt("heroRestoreHealth"));
                locationMain.setCreatureHp(resultSet.getInt("creatureHp"));
                locationMain.setCreatureDamage(resultSet.getInt("creatureDamage"));
                locationMain.setCreatureChance(resultSet.getInt("creatureChance"));
            }
            System.out.println("You selected " + locationMain.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void showLocations() {
        try {
            connection = DriverManager.getConnection(url, userName, password);
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM location");
            while (resultSet.next()) {
                locationMain.setId(resultSet.getLong("id"));
                locationMain.setName(resultSet.getString("name"));
                locationMain.setHeroHp(resultSet.getInt("heroHp"));
                locationMain.setHeroDamage(resultSet.getInt("heroDamage"));
                locationMain.setHeroSpellDamage(resultSet.getInt("heroSpellDamage"));
                locationMain.setHeroRestoreHealth(resultSet.getInt("heroRestoreHealth"));
                locationMain.setCreatureHp(resultSet.getInt("creatureHp"));
                locationMain.setCreatureDamage(resultSet.getInt("creatureDamage"));
                locationMain.setCreatureChance(resultSet.getInt("creatureChance"));
                System.out.println(locationMain);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

