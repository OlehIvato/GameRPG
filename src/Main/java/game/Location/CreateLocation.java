package game.Location;


import game.Primary.Main_All;

import java.sql.*;
import java.util.*;

public class CreateLocation {
    private static Connection connection;
    private static ResultSet resultSet;
    private static MainLocation mainLocation = new MainLocation();
    private static Scanner scanner = new Scanner(System.in);

    public static void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\nWould you like to select Location for Fight?  (it will change " + Main_All.getHeroName() + " and creatures characteristics)");
        System.out.println("1. Yes \n2. No, continue without Locations");
        switch (scanner.nextInt()) {
            case 1:
                showLocations();
                selectLocation();
                mainLocation.setValues();
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
                mainLocation.setId(resultSet.getLong("id"));
                mainLocation.setName(resultSet.getString("name"));
                mainLocation.setHeroHp(resultSet.getInt("heroHp"));
                mainLocation.setHeroDamage(resultSet.getInt("heroDamage"));
                mainLocation.setHeroSpellDamage(resultSet.getInt("heroSpellDamage"));
                mainLocation.setHeroRestoreHealth(resultSet.getInt("heroRestoreHealth"));
                mainLocation.setCreatureHp(resultSet.getInt("creatureHp"));
                mainLocation.setCreatureDamage(resultSet.getInt("creatureDamage"));
                mainLocation.setCreatureChance(resultSet.getInt("creatureChance"));
            }
            System.out.println("You selected " + mainLocation.getName());
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
                mainLocation.setId(resultSet.getLong("id"));
                mainLocation.setName(resultSet.getString("name"));
                mainLocation.setHeroHp(resultSet.getInt("heroHp"));
                mainLocation.setHeroDamage(resultSet.getInt("heroDamage"));
                mainLocation.setHeroSpellDamage(resultSet.getInt("heroSpellDamage"));
                mainLocation.setHeroRestoreHealth(resultSet.getInt("heroRestoreHealth"));
                mainLocation.setCreatureHp(resultSet.getInt("creatureHp"));
                mainLocation.setCreatureDamage(resultSet.getInt("creatureDamage"));
                mainLocation.setCreatureChance(resultSet.getInt("creatureChance"));
                System.out.println(mainLocation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

