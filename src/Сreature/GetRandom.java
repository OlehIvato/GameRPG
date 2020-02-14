package Сreature;

import Main.Game;
import Main.Main_All;

import java.sql.*;
import java.util.Random;

public class GetRandom {
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
        Game.isBoss = false;
        try {
            connection = DriverManager.getConnection(Main_All.getUrl(), Main_All.getUserName(), Main_All.getPassword());
            preparedStatement = connection.prepareStatement("SELECT * FROM mobs WHERE id = ?");

            preparedStatement.setInt(1, random.nextInt(7 - 1 + 1) + 1);        // random.nextInt(max - min +1) +1
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                mainCreature.setId(resultSet.getLong("id"));
                mainCreature.setName(resultSet.getString("name"));
                mainCreature.setHealthPoint(resultSet.getInt("hp"));
                mainCreature.setMin_Damage(resultSet.getInt("minDamage"));
                mainCreature.setMax_Damage(resultSet.getInt("maxDamage"));
                mainCreature.setChanceToSuperDamage(resultSet.getInt("chanceToSuperDamage"));
            }
            mainCreature.fight();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void random_Boss() {
        Game.isBoss = true;
        try {
            connection = DriverManager.getConnection(Main_All.getUrl(), Main_All.getUserName(), Main_All.getPassword());
            preparedStatement = connection.prepareStatement("SELECT * FROM bosses WHERE id = ?");
            preparedStatement.setInt(1, random.nextInt(3 - 1 + 1) + 1);      // random.nextInt(max - min +1) +1
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
            mainCreature.fight();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

