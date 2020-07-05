package game.sql;

import game.primary.MainData;

import java.sql.*;
import java.util.Scanner;

public class HeroData extends ConnectSetting {

    private static final String GET_ALL_HEROES = "SELECT * FROM hero";
    private static final String GET_ARMOR_BY_HERO_ID = "select armor1_.armor as armor " +
            "from hero_armors armors0_ " +
            "inner join armor armor1_ on armors0_.armors_id = armor1_.id " +
            "order by hero_model_id";

    private static final String GET_CLASS_BY_HERO_ID = "select classtype1_.class as class " +
            "from hero_classes classes0_" +
            " inner join class classtype1_ on classes0_.classes_id=classtype1_.id " +
            "order by hero_model_id";

    private static final String GET_HERO_WHERE_ID_UNKNOWN = "SELECT * FROM hero WHERE id = ?";
    private static final String GER_CLASS_WHERE_HERO_ID_UNKNOWN = "select classtype1_.class as class  " +
            "from hero_classes classes0_ " +
            "inner join class classtype1_ on classes0_.classes_id=classtype1_.id " +
            "where hero_model_id = ? " +
            "order by hero_model_id";

    private static final String GER_ARMOR_WHERE_HERO_ID_UNKNOWN = "select armor1_.armor as armor " +
            "from hero_armors armors0_ " +
            "inner join armor armor1_ on armors0_.armors_id = armor1_.id  " +
            "where hero_model_id = ? " +
            "order by hero_model_id";


    public static void createHero() {
        showHeroesFromDatabase();
        setHeroToMainData();
    }


    private static void setHeroToMainData() {
        try {
            connectToDataBase();
            preparedStatement = connection.prepareStatement(GET_HERO_WHERE_ID_UNKNOWN);
            PreparedStatement preparedStatementClass = connection.prepareStatement(GER_CLASS_WHERE_HERO_ID_UNKNOWN);
            PreparedStatement preparedStatementArmor = connection.prepareStatement(GER_ARMOR_WHERE_HERO_ID_UNKNOWN);

            int resultScan = new Scanner(System.in).nextInt();

            preparedStatement.setInt(1, resultScan);
            preparedStatementClass.setInt(1, resultScan);
            preparedStatementArmor.setInt(1, resultScan);

            resultSet = preparedStatement.executeQuery();
            ResultSet resultSetClass = preparedStatementClass.executeQuery();
            ResultSet resultSetArmor = preparedStatementArmor.executeQuery();

            while (resultSet.next() && resultSetClass.next() && resultSetArmor.next()) {
                MainData.setHeroName(resultSet.getString("name"));
                MainData.setHeroClass(resultSetClass.getString("class"));
                MainData.setHeroArmor(resultSetArmor.getString("armor"));
                MainData.setHeroHp(resultSet.getInt("hp"));
                MainData.setHeroDamage(resultSet.getInt("damage"));
                MainData.setHeroMinSpell(resultSet.getInt("minSpellDamage"));
                MainData.setHeroMaxSpell(resultSet.getInt("maxSpellDamage"));
                MainData.setHeroRestoreHp(resultSet.getInt("restoreHealth"));
                MainData.setHeroMana(resultSet.getInt("mana"));
                System.out.println("You selected " + resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void showHeroesFromDatabase() {
        try {
            connectToDataBase();
            statement = connection.createStatement();
            Statement statementArmor = connection.createStatement();
            Statement statementClass = connection.createStatement();

            resultSet = statement.executeQuery(GET_ALL_HEROES);
            ResultSet resultSetArmor = statementArmor.executeQuery(GET_ARMOR_BY_HERO_ID);
            ResultSet resultSetClass = statementClass.executeQuery(GET_CLASS_BY_HERO_ID);

            System.out.println("\nSelect one:");
            while (resultSet.next() && resultSetArmor.next() && resultSetClass.next()) {
                String getFormat = "%1$-3s|%2$-16s|%3$-18s|%4$-9s|%5$-12s|%6$-22s|%7$-22s|%8$-16s|%9$-11s|%10$-21s|";
                String result = String.format(getFormat,
                        resultSet.getInt("id"),
                        " Class: " + resultSetClass.getString("class"),
                        " Name: " + resultSet.getString("name"),
                        " HP: " + resultSet.getInt("hp"),
                        " Damage: " + resultSet.getInt("damage"),
                        " Min Spell Damage: " + resultSet.getInt("minSpellDamage"),
                        " Max Spell Damage: " + resultSet.getInt("maxSpellDamage"),
                        " Restore HP: " + resultSet.getInt("restoreHealth"),
                        " Mana: " + resultSet.getInt("mana"),
                        " Armor Type: " + resultSetArmor.getString("armor"));
                System.out.println(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
