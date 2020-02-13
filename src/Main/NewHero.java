package Main;

import java.sql.*;
import java.util.Scanner;

public class NewHero {
    private static final String userName = "root";
    private static final String password = "root";
    private static final String url = "jdbc:mysql://localhost:3306/main";
    private static Connection connection;
    private static ResultSet resultSet;
    private static HeroMain m = new HeroMain();
    private static Scanner scanner = new Scanner(System.in);


    public static void main() {
        showDataBase();
        try {
            connection = DriverManager.getConnection(url, userName, password);
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

    public static void showDataBase() {
        try {
            connection = DriverManager.getConnection(url, userName, password);
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
