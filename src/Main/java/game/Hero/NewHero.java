package game.Hero;

import game.Primary.Game;
import game.Primary.Main_All;

import java.sql.*;
import java.util.Scanner;

public class NewHero {
    private static Connection connection;
    private static ResultSet resultSet;
    private static HeroMain m = new HeroMain();
    private static Scanner scanner = new Scanner(System.in);

    public static void main() {
        showHeroes();
        setValues();
        m.setValue();
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
                m.setId(resultSet.getLong("id"));
                m.setName(resultSet.getString("name"));
                m.setHp(resultSet.getInt("hp"));
                m.setDefaultDamage(resultSet.getInt("damage"));
                m.setMinSpellDamage(resultSet.getInt("minSpellDamage"));
                m.setMaxSpellDamage(resultSet.getInt("maxSpellDamage"));
                m.setRestoresHealthPoint(resultSet.getInt("restoreHealth"));
                m.setMana(resultSet.getInt("mana"));
                System.out.println("You selected " + m.getName());
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
                m.setId(resultSet.getLong("id"));
                m.setName(resultSet.getString("name"));
                m.setHp(resultSet.getInt("hp"));
                m.setDefaultDamage(resultSet.getInt("damage"));
                m.setMinSpellDamage(resultSet.getInt("minSpellDamage"));
                m.setMaxSpellDamage(resultSet.getInt("maxSpellDamage"));
                m.setRestoresHealthPoint(resultSet.getInt("restoreHealth"));
                m.setMana(resultSet.getInt("mana"));
                System.out.println(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
