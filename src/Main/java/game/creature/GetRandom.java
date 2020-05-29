package game.creature;

import game.primary.Game;
import game.primary.TheMain;

import java.sql.*;

public class GetRandom {
    private static Connection connection;
    private static ResultSet resultSet;
    private static PreparedStatement preparedStatement;
    private static final MainCreature mainCreature = new MainCreature();


    static int changer(int a) {      // change values if game without equipment
        int value = a;
        int subtract = (a * TheMain.getDefaultPercent()) / 100;
        value -= subtract;
        return value;
    }

    private static int levelChange(int resultSet, int getLevel) {     // change level difficulty
        int value = resultSet;
        int subtract = (resultSet * getLevel) / 100;
        value += subtract;
        return value;
    }

    public static void random(int lvlDifficult) {
        Game.isBoss = false;
        try {
            connection = DriverManager.getConnection(TheMain.getUrl(), TheMain.getUsername(), TheMain.getPassword());
            preparedStatement = connection.prepareStatement("SELECT * FROM mobs ORDER BY RAND() LIMIT 1");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                mainCreature.setId(resultSet.getLong("id"));
                mainCreature.setName(resultSet.getString("name"));
                mainCreature.setHp(levelChange(resultSet.getInt("hp"), lvlDifficult));
                mainCreature.setMinDamage(levelChange(resultSet.getInt("minDamage"), lvlDifficult));
                mainCreature.setMaxDamage(levelChange(resultSet.getInt("maxDamage"), lvlDifficult));
                mainCreature.setChanceToSuperDamage(levelChange(resultSet.getInt("chanceToSuperDamage"), lvlDifficult));
            }
            mainCreature.setValuesToMain();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void random_Boss(int lvlDifficult) {
        Game.isBoss = true;
        try {
            connection = DriverManager.getConnection(TheMain.getUrl(), TheMain.getUsername(), TheMain.getPassword());
            preparedStatement = connection.prepareStatement("SELECT * FROM bosses ORDER BY RAND() LIMIT 1");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                mainCreature.setId(resultSet.getLong("id"));
                mainCreature.setName(resultSet.getString("name"));
                mainCreature.setHp(levelChange(resultSet.getInt("hp"), lvlDifficult));
                mainCreature.setMinDamage(levelChange(resultSet.getInt("minDamage"), lvlDifficult));
                mainCreature.setMaxDamage(levelChange(resultSet.getInt("maxDamage"), lvlDifficult));
                mainCreature.setRestoreHealth(levelChange(resultSet.getInt("restoreHealth"), lvlDifficult));
                mainCreature.setChanceToSuperDamage(levelChange(resultSet.getInt("chanceToSuperDamage"), lvlDifficult));
            }
            mainCreature.setValuesToMain();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

