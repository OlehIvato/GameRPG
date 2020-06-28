package game.sql;

import game.primary.DefaultValues;
import game.primary.MainData;
import game.primary.Setting;

import java.sql.*;


public class CreaturesData extends MainData implements ConnectSetting, DefaultValues {


    private static final String GET_ONE_BOSS = "SELECT * FROM bosses ORDER BY RAND() LIMIT 1";
    private static final String GET_ONE_MOB = "SELECT * FROM mobs ORDER BY RAND() LIMIT 1";

    public static void getRandomCreature(int lvlDifficult) {
        ResultSet resultSet;
        try {
            Connection connection = DriverManager.getConnection(data_url, data_username, data_password);
            Statement statement = connection.createStatement();
            if (Setting.IS_GAME_AGAINST_BOSS) {
                resultSet = statement.executeQuery(GET_ONE_BOSS);
            } else {
                resultSet = statement.executeQuery(GET_ONE_MOB);
            }
            while (resultSet.next()) {
                if (Setting.IS_GAME_AGAINST_BOSS) {
                    if (Setting.IS_GAME_WITH_EQUIPMENTS) {
                        mobRestoreHp = setLevelDifficulty(resultSet.getInt("restoreHealth"), lvlDifficult);
                    } else {
                        mobRestoreHp = CreaturesData.reduceDifficulty(resultSet.getInt("restoreHealth"));
                    }
                }
                if (Setting.IS_GAME_WITH_EQUIPMENTS) {
                    mobHp = setLevelDifficulty(resultSet.getInt("hp"), lvlDifficult);
                    mobMinDamage = setLevelDifficulty(resultSet.getInt("minDamage"), lvlDifficult);
                    mobMaxDamage = setLevelDifficulty(resultSet.getInt("maxDamage"), lvlDifficult);
                    mobChanceToSuperDamage = mobChanceToSuperDamage + setLevelDifficulty(resultSet.getInt("chanceToSuperDamage"), lvlDifficult);
                } else {
                    mobHp = reduceDifficulty(resultSet.getInt("hp"));
                    mobMinDamage = reduceDifficulty(resultSet.getInt("minDamage"));
                    mobMaxDamage = reduceDifficulty(resultSet.getInt("maxDamage"));
                    mobChanceToSuperDamage = reduceDifficulty(resultSet.getInt("chanceToSuperDamage"));
                }
                mobName = (resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method reduces default values from data for every level if game without equipments.
     *
     * @param data shows default characteristics from database
     * @return returns characteristics, reduces difficult for every level
     * @see Setting There is default value for game without equipments
     */
    private static int reduceDifficulty(int data) {
        int value = data;
        int subtract = data * (withOutEquipPercent * (-1)) / 100;
        value -= subtract;
        return value;
    }

    /**
     * This method changes characteristics of creatures, if game with equipments
     *
     * @param data              shows default characteristics from database
     * @param getLevelDifficult shows current difficult for current level
     * @return returns characteristics, adding difficult according to current level
     */
    private static int setLevelDifficulty(int data, int getLevelDifficult) {
        int value = data;
        int subtract = (data * getLevelDifficult) / 100;
        value += subtract;
        return value;
    }
}

