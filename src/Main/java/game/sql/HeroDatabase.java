package game.sql;

import game.Primary.Game;
import game.Primary.Main_All;

import java.sql.*;
import java.util.Scanner;

public class HeroDatabase {
    private static Connection connection;
    private static ResultSet resultSet;
    private static Scanner scanner = new Scanner(System.in);

    public static void main() {
        showHeroes();
        setValues();
        Game game = new Game();
        game.createNewHero();
    }

    private static void setValues() {
        try {
            connection = DriverManager.getConnection(Main_All.getUrl(), Main_All.getUserName(), Main_All.getPassword());
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM hero WHERE id = ?");
            preparedStatement.setInt(1, scanner.nextInt());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Main_All.setHeroClass(resultSet.getString("class"));
                Main_All.setHeroName(resultSet.getString("name"));
                Main_All.setHeroHP(Main_All.getHeroHP() + resultSet.getInt("hp"));
                Main_All.setDefaultDamage(Main_All.getDefaultDamage() + resultSet.getInt("damage"));
                Main_All.setMinSpellDamageHERO(Main_All.getMinSpellDamageHERO() + resultSet.getInt("minSpellDamage"));
                Main_All.setMaxSpellDamageHero(Main_All.getMaxSpellDamageHero() + resultSet.getInt("maxSpellDamage"));
                Main_All.setRestoreHealth(Main_All.getRestoreHealth() + resultSet.getInt("restoreHealth"));
                Main_All.setMana(Main_All.getMana() + resultSet.getInt("mana"));
                Main_All.setHeroArmorType(resultSet.getString("type_armor"));
                System.out.println("You selected " + resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void showHeroes() {
        try {
            connection = DriverManager.getConnection(Main_All.getUrl(), Main_All.getUserName(), Main_All.getPassword());
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM hero");
            while (resultSet.next()) {
                String getFormat = "%1$-3s|%2$-16s|%3$-13s|%4$-9s|%5$-12s|%6$-22s|%7$-22s|%8$-16s|%9$-11s|%10$-21s|";
                String result = String.format(getFormat,
                        resultSet.getInt("id"),
                        " Class: " + resultSet.getString("class"),
                        " Name: " + resultSet.getString("name"),
                        " HP: " + resultSet.getInt("hp"),
                        " Damage: " + resultSet.getInt("damage"),
                        " Min Spell Damage: " + resultSet.getInt("minSpellDamage"),
                        " Max Spell Damage: " + resultSet.getInt("maxSpellDamage"),
                        " Restore HP: " + resultSet.getInt("restoreHealth"),
                        " Mana: " + resultSet.getInt("mana"),
                        " Armor Type: " + resultSet.getString("type_armor"));
                System.out.println(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
