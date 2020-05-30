package game.sql;

import game.primary.Game;
import game.primary.TheMain;

import java.sql.*;

public class CreaturesData {

    private static Connection connection;
    private static ResultSet resultSet;
    private static PreparedStatement preparedStatement;


    static int reduceDifficulty(int getValue) {      // change values if game without equipment
        int value = getValue;
        int subtract = (getValue * TheMain.getDefaultPercent()) / 100;
        value -= subtract;
        return value;
    }

    private static int setLevelDifficulty(int resultSet, int getLevel) {     // change level difficulty
        int value = resultSet;
        int subtract = (resultSet * getLevel) / 100;
        value += subtract;
        return value;
    }

    public static void randomMob(int lvlDifficult) {
        Game.isBoss = false;
        try {
            connection = DriverManager.getConnection(TheMain.getUrl(), TheMain.getUsername(), TheMain.getPassword());
            preparedStatement = connection.prepareStatement("SELECT * FROM mobs ORDER BY RAND() LIMIT 1");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                if (Game.isEquip) {
                    TheMain.setMobName(resultSet.getString("name"));
                    TheMain.setMobHp(setLevelDifficulty(resultSet.getInt("hp"), lvlDifficult));
                    TheMain.setMobMinDamage(setLevelDifficulty(resultSet.getInt("minDamage"), lvlDifficult));
                    TheMain.setMobMaxDamage(setLevelDifficulty(resultSet.getInt("maxDamage"), lvlDifficult));
                    TheMain.setMobChanceToSuperDamage(setLevelDifficulty(resultSet.getInt("chanceToSuperDamage"), lvlDifficult));
                } else {
                    TheMain.setMobName(resultSet.getString("name"));
                    TheMain.setMobHp(reduceDifficulty(resultSet.getInt("hp")));
                    TheMain.setMobMinDamage(reduceDifficulty(resultSet.getInt("minDamage")));
                    TheMain.setMobMaxDamage(reduceDifficulty(resultSet.getInt("maxDamage")));
                    TheMain.setMobChanceToSuperDamage(reduceDifficulty(resultSet.getInt("chanceToSuperDamage")));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void randomBoss(int lvlDifficult) {
        Game.isBoss = true;
        try {
            connection = DriverManager.getConnection(TheMain.getUrl(), TheMain.getUsername(), TheMain.getPassword());
            preparedStatement = connection.prepareStatement("SELECT * FROM bosses ORDER BY RAND() LIMIT 1");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                if (Game.isEquip) {
                    TheMain.setMobName(resultSet.getString("name"));
                    TheMain.setMobHp(setLevelDifficulty(resultSet.getInt("hp"), lvlDifficult));
                    TheMain.setMobMinDamage(setLevelDifficulty(resultSet.getInt("minDamage"), lvlDifficult));
                    TheMain.setMobMaxDamage(setLevelDifficulty(resultSet.getInt("maxDamage"), lvlDifficult));
                    TheMain.setMobChanceToSuperDamage(setLevelDifficulty(resultSet.getInt("chanceToSuperDamage"), lvlDifficult));
                    TheMain.setMobRestoreHp(CreaturesData.reduceDifficulty(setLevelDifficulty(resultSet.getInt("restoreHealth"), lvlDifficult)));

                } else {
                    TheMain.setMobName(resultSet.getString("name"));
                    TheMain.setMobHp(reduceDifficulty(resultSet.getInt("hp")));
                    TheMain.setMobMinDamage(reduceDifficulty(resultSet.getInt("minDamage")));
                    TheMain.setMobMaxDamage(reduceDifficulty(resultSet.getInt("maxDamage")));
                    TheMain.setMobChanceToSuperDamage(reduceDifficulty(resultSet.getInt("chanceToSuperDamage")));
                    TheMain.setMobRestoreHp(CreaturesData.reduceDifficulty(resultSet.getInt("restoreHealth")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

