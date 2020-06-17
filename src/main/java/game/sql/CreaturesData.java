package game.sql;

import game.primary.TheMain;

import java.sql.*;

public class CreaturesData {

    static int reduceDifficulty(int getValue) {      // change values if game without equipment
        int value = getValue;
        int subtract = getValue * (TheMain.getWithOutEquipPercent() * (-1)) / 100;
        value -= subtract;
        return value;
    }

    private static int setLevelDifficulty(int resultSet, int getLevel) {     // change level difficulty
        int value = resultSet;
        int subtract = (resultSet * getLevel) / 100;
        value += subtract;
        return value;
    }

    public static void getRandomCreature(int lvlDifficult) {
        ResultSet resultSet;
        try {
            Connection connection = DriverManager.getConnection(TheMain.getUrl(), TheMain.getUsername(), TheMain.getPassword());
            Statement statement = connection.createStatement();
            if (TheMain.isIsBoss()) {
                resultSet = statement.executeQuery("SELECT * FROM bosses ORDER BY RAND() LIMIT 1");
            } else {
                resultSet = statement.executeQuery("SELECT * FROM mobs ORDER BY RAND() LIMIT 1");
            }
            while (resultSet.next()) {
                if (TheMain.isIsBoss()) {
                    if (TheMain.isIsEquip()) {
                        TheMain.setMobRestoreHp((setLevelDifficulty(resultSet.getInt("restoreHealth"), lvlDifficult)));
                    } else {
                        TheMain.setMobRestoreHp(CreaturesData.reduceDifficulty(resultSet.getInt("restoreHealth")));
                    }
                }
                if (TheMain.isIsEquip()) {
                    TheMain.setMobHp(setLevelDifficulty(resultSet.getInt("hp"), lvlDifficult));
                    TheMain.setMobMinDamage(setLevelDifficulty(resultSet.getInt("minDamage"), lvlDifficult));
                    TheMain.setMobMaxDamage(setLevelDifficulty(resultSet.getInt("maxDamage"), lvlDifficult));
                    TheMain.setMobChanceToSuperDamage(setLevelDifficulty(resultSet.getInt("chanceToSuperDamage"), lvlDifficult));
                } else {
                    TheMain.setMobHp(reduceDifficulty(resultSet.getInt("hp")));
                    TheMain.setMobMinDamage(reduceDifficulty(resultSet.getInt("minDamage")));
                    TheMain.setMobMaxDamage(reduceDifficulty(resultSet.getInt("maxDamage")));
                    TheMain.setMobChanceToSuperDamage(reduceDifficulty(resultSet.getInt("chanceToSuperDamage")));
                }
                TheMain.setMobName(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

