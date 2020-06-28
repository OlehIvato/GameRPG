package game.sql;

import game.primary.MainData;

import java.sql.*;
import java.util.Scanner;

public class HeroData extends MainData implements ConnectSetting {
    private static Connection connection;

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


    public static void create() {
        showHeroesFromDatabase();
        setHeroToMain();
    }


    private static void setHeroToMain() {
        try {
            connection = DriverManager.getConnection(data_url, data_username, data_password);
            PreparedStatement preparedStatementHero = connection.prepareStatement(GET_HERO_WHERE_ID_UNKNOWN);
            PreparedStatement preparedStatementClass = connection.prepareStatement(GER_CLASS_WHERE_HERO_ID_UNKNOWN);
            PreparedStatement preparedStatementArmor = connection.prepareStatement(GER_ARMOR_WHERE_HERO_ID_UNKNOWN);

            int resultScan = new Scanner(System.in).nextInt();

            preparedStatementHero.setInt(1, resultScan);
            preparedStatementClass.setInt(1, resultScan);
            preparedStatementArmor.setInt(1, resultScan);

            ResultSet resultSetHero = preparedStatementHero.executeQuery();
            ResultSet resultSetClass = preparedStatementClass.executeQuery();
            ResultSet resultSetArmor = preparedStatementArmor.executeQuery();

            while (resultSetHero.next() && resultSetClass.next() && resultSetArmor.next()) {

                heroName = resultSetHero.getString("name");
                heroClass = resultSetClass.getString("class");
                heroArmor = resultSetArmor.getString("armor");
                heroHp = resultSetHero.getInt("hp");
                heroDamage = resultSetHero.getInt("damage");
                heroMinSpell = resultSetHero.getInt("minSpellDamage");
                heroMaxSpell = resultSetHero.getInt("maxSpellDamage");
                heroRestoreHp = resultSetHero.getInt("restoreHealth");
                heroMana = resultSetHero.getInt("mana");
                System.out.println("You selected " + resultSetHero.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void showHeroesFromDatabase() {
        try {
            connection = DriverManager.getConnection(data_url, data_username, data_password);
            Statement statementHero = connection.createStatement();
            Statement statementArmor = connection.createStatement();
            Statement statementClass = connection.createStatement();

            ResultSet resultSetHero = statementHero.executeQuery(GET_ALL_HEROES);
            ResultSet resultSetArmor = statementArmor.executeQuery(GET_ARMOR_BY_HERO_ID);
            ResultSet resultSetClass = statementClass.executeQuery(GET_CLASS_BY_HERO_ID);

            System.out.println("\nSelect one:");
            while (resultSetHero.next() && resultSetArmor.next() && resultSetClass.next()) {
                String getFormat = "%1$-3s|%2$-16s|%3$-18s|%4$-9s|%5$-12s|%6$-22s|%7$-22s|%8$-16s|%9$-11s|%10$-21s|";
                String result = String.format(getFormat,
                        resultSetHero.getInt("id"),
                        " Class: " + resultSetClass.getString("class"),
                        " Name: " + resultSetHero.getString("name"),
                        " HP: " + resultSetHero.getInt("hp"),
                        " Damage: " + resultSetHero.getInt("damage"),
                        " Min Spell Damage: " + resultSetHero.getInt("minSpellDamage"),
                        " Max Spell Damage: " + resultSetHero.getInt("maxSpellDamage"),
                        " Restore HP: " + resultSetHero.getInt("restoreHealth"),
                        " Mana: " + resultSetHero.getInt("mana"),
                        " Armor Type: " + resultSetArmor.getString("armor"));
                System.out.println(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
