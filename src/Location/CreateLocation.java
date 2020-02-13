package Location;


import Сreature.Main_All;

import java.sql.*;
import java.util.*;

public class CreateLocation {
    private static final String userName = "root";
    private static final String password = "root";
    private static final String url = "jdbc:mysql://localhost:3306/main";
    private static Connection connection;
    private static ResultSet resultSet;
    private static LocationMain locationMain = new LocationMain();
    private static Scanner scanner = new Scanner(System.in);


    public void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\nWould you like to select Location for Fight?  (it will change " + Main_All.getHeroName() + " and creatures characteristics)");
        System.out.println("1. Yes \n2. No, continue without Locations");
        switch (scanner.nextInt()) {
            case 1:
                location();
                break;
            case 2:
                break;
            default: {
                System.out.println("Something went wrong");
                main();
            }
        }
    }

    private void location() {


        //        System.out.println("Select location for the game:\n");
//        Scanner s = new Scanner(System.in);
//        Northrend northrend = new Northrend("Northrend", +11, +16, -5, +5, +28, -13, +15);
//
//        Azeroth azeroth = new Azeroth("Azeroth", -9, -5, -3, +15, +18, +12, -29);
//
//        Kalimdor kalimdor = new Kalimdor("Kalimdor", +2, +9, +14, -16, -9, +25, -5);
//
//        IsleofDread isleofDread = new IsleofDread("Isle of Dread", -13, +20, +9, -9, 0, +11, +6);
//
//        Map<Integer, Value> map = new HashMap<>();
//        map.put(1, northrend);
//        map.put(2, kalimdor);
//        map.put(3, azeroth);
//        map.put(4, isleofDread);
//
//        //  map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
//
//        for (Map.Entry show : map.entrySet()) {
//            System.out.println(show.getKey() + " | " + show.getValue());
//        }
//        switch (s.nextInt()) {
//            case 1:
//                System.out.println("You chose " + map.get(1));
//                northrend.setValues();
//                break;
//            case 2:
//                System.out.println("You chose " + map.get(2));
//                kalimdor.setValues();
//                break;
//            case 3:
//                System.out.println("You chose " + map.get(3));
//                azeroth.setValues();
//                break;
//            case 4:
//                System.out.println("You chose " + map.get(4));
//                isleofDread.setValues();
//                break;
//        }

    }


    public static void showLocation() {
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

