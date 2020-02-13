package Hero;

import Main.Game;
import Main.Main_All;

import java.sql.*;
import java.util.Scanner;

public class NewHero {
    private static Connection connection;
    private static ResultSet resultSet;
    private static HeroMain m = new HeroMain();
    private static Scanner scanner = new Scanner(System.in);

    public static void main() {
        showHeroes();
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
                m.setMinSpellDamage(resultSet.getInt("MinSpellDamage"));
                m.setMaxSpellDamage(resultSet.getInt("MaxSpellDamage"));
                m.setRestoresHealthPoint(resultSet.getInt("restoreHealthPoint"));
                m.setChance(resultSet.getInt("chance"));
                m.setMana(resultSet.getInt("mana"));
                System.out.println("You selected "+ m.getName());
            }
            m.setValue();
            Game game = new Game();
            game.createNewHero();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void showHeroes() {
        try {
            connection = DriverManager.getConnection(Main_All.getUrl(), Main_All.getUserName(), Main_All.getPassword());
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM hero");
            while (resultSet.next()) {
                m.setId(resultSet.getLong("id"));
                m.setName(resultSet.getString("name"));
                m.setHp(resultSet.getInt("hp"));
                m.setDefaultDamage(resultSet.getInt("damage"));
                m.setMinSpellDamage(resultSet.getInt("MinSpellDamage"));
                m.setMaxSpellDamage(resultSet.getInt("MaxSpellDamage"));
                m.setRestoresHealthPoint(resultSet.getInt("restoreHealthPoint"));
                m.setChance(resultSet.getInt("chance"));
                m.setMana(resultSet.getInt("mana"));
                System.out.println(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
