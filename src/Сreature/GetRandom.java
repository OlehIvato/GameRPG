package Сreature;

import java.sql.*;
import java.util.Random;

public class GetRandom {

    private static final String userName = "root";
    private static final String password = "root";
    private static final String url = "jdbc:mysql://localhost:3306/main";
    private static Connection connection;
    private static ResultSet resultSet;
    private static PreparedStatement preparedStatement;
    private static Random random = new Random();
    private static MainCreature mainCreature = new MainCreature();


    public static int changer(int a) {
        int value = a;
        int subtract = (a * Main_All.getDefaultPercent()) / 100;
        value -= subtract;
        return value;
    }

    public static void random() {
        try {
            connection = DriverManager.getConnection(url, userName, password);
            preparedStatement = connection.prepareStatement("SELECT * FROM mobs WHERE id = ?");
            preparedStatement.setInt(1, random.nextInt(6));
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                mainCreature.setId(resultSet.getLong("id"));
                mainCreature.setName(resultSet.getString("name"));
                mainCreature.setHealthPoint(resultSet.getInt("hp"));
                mainCreature.setMin_Damage(resultSet.getInt("minDamage"));
                mainCreature.setMax_Damage(resultSet.getInt("maxDamage"));
                mainCreature.setChanceToSuperDamage(resultSet.getInt("chanceToSuperDamage"));
            }
            mainCreature.fightMob();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void random_Boss() {
        try {
            connection = DriverManager.getConnection(url, userName, password);
            preparedStatement = connection.prepareStatement("SELECT * FROM bosses WHERE id = ?");
            preparedStatement.setInt(1, random.nextInt(3));
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                mainCreature.setId(resultSet.getLong("id"));
                mainCreature.setName(resultSet.getString("name"));
                mainCreature.setHealthPoint(resultSet.getInt("hp"));
                mainCreature.setMin_Damage(resultSet.getInt("minDamage"));
                mainCreature.setMax_Damage(resultSet.getInt("maxDamage"));
                mainCreature.setRestoreHealth(resultSet.getInt("restoreHealth"));
                mainCreature.setChanceToSuperDamage(resultSet.getInt("chanceToSuperDamage"));
            }
            mainCreature.fightBoss();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

