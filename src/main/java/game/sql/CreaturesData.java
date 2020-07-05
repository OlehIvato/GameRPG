package game.sql;

import game.primary.DefaultValues;
import game.primary.MainData;
import game.primary.Setting;

import java.sql.*;

public class CreaturesData extends ConnectSetting implements DefaultValues {

    private static final String GET_RANDOM_BOSS = "SELECT * FROM bosses ORDER BY RAND() LIMIT 1";
    private static final String GET_RANDOM_MOB = "SELECT * FROM mobs ORDER BY RAND() LIMIT 1";


    public static void getRandomCreatureFomDatabase(int lvlDifficult) {
        try {
            connectToDataBase();
            statement = connection.createStatement();
            if (Setting.isIsGameAgainstBoss()) {
                resultSet = statement.executeQuery(GET_RANDOM_BOSS);
            } else {
                resultSet = statement.executeQuery(GET_RANDOM_MOB);
            }
            while (resultSet.next()) {
                if (Setting.isIsGameAgainstBoss()) {
                    if (Setting.isIsGameWithEquipments()) {
                        MainData.setMobRestoreHp(setLevelDifficulty(resultSet.getInt("restoreHealth"), lvlDifficult));
                    } else {
                        MainData.setMobRestoreHp(reduceDifficulty(resultSet.getInt("restoreHealth")));
                    }
                }
                if (Setting.isIsGameWithEquipments()) {
                    MainData.setMobHp(setLevelDifficulty(resultSet.getInt("hp"), lvlDifficult));
                    MainData.setMobMinDamage(setLevelDifficulty(resultSet.getInt("minDamage"), lvlDifficult));
                    MainData.setMobMaxDamage(setLevelDifficulty(resultSet.getInt("maxDamage"), lvlDifficult));
                    MainData.setMobChanceToSuperDamage(setLevelDifficulty(resultSet.getInt("chanceToSuperDamage"), lvlDifficult));

                } else {
                    MainData.setMobHp(reduceDifficulty(resultSet.getInt("hp")));
                    MainData.setMobMinDamage(reduceDifficulty(resultSet.getInt("minDamage")));
                    MainData.setMobMaxDamage(reduceDifficulty(resultSet.getInt("maxDamage")));
                    MainData.setMobChanceToSuperDamage(reduceDifficulty(resultSet.getInt("chanceToSuperDamage")));
                }
                MainData.setMobName(resultSet.getString("name"));
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
        int subtract = data * (DEFAULT_INDEX_FOR_GAME_WITHOUT_EQUIPMENTS * (-1)) / 100;
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

