package game.sql;

import game.primary.Game;
import game.primary.Main_All;


import java.sql.*;
import java.util.Scanner;

public class HeroDatabase {
    private static Connection connection;
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
            PreparedStatement preparedStatementHero = connection.prepareStatement("SELECT * FROM hero WHERE id = ?");
            PreparedStatement preparedStatementClass = connection.prepareStatement("select classtype1_.class as class  from hero_classes classes0_ inner join class classtype1_ on classes0_.classes_id=classtype1_.id where hero_model_id = ? order by hero_model_id");
            PreparedStatement preparedStatementArmor = connection.prepareStatement("select armor1_.armor as armor from hero_armors armors0_ inner join armor armor1_ on armors0_.armors_id = armor1_.id  where hero_model_id = ? order by hero_model_id");

            int resultScan = scanner.nextInt();

            preparedStatementHero.setInt(1, resultScan);
            preparedStatementClass.setInt(1, resultScan);
            preparedStatementArmor.setInt(1, resultScan);

            ResultSet resultSetHero = preparedStatementHero.executeQuery();
            ResultSet resultSetClass = preparedStatementClass.executeQuery();
            ResultSet resultSetArmor = preparedStatementArmor.executeQuery();

            while (resultSetHero.next() && resultSetClass.next() && resultSetArmor.next()) {
                Main_All.setHeroClass(resultSetClass.getString("class"));
                Main_All.setHeroName(resultSetHero.getString("name"));
                Main_All.setHeroHP(Main_All.getHeroHP() + resultSetHero.getInt("hp"));
                Main_All.setDefaultDamage(Main_All.getDefaultDamage() + resultSetHero.getInt("damage"));
                Main_All.setMinSpellDamageHERO(Main_All.getMinSpellDamageHERO() + resultSetHero.getInt("minSpellDamage"));
                Main_All.setMaxSpellDamageHero(Main_All.getMaxSpellDamageHero() + resultSetHero.getInt("maxSpellDamage"));
                Main_All.setRestoreHealth(Main_All.getRestoreHealth() + resultSetHero.getInt("restoreHealth"));
                Main_All.setMana(Main_All.getMana() + resultSetHero.getInt("mana"));
                Main_All.setHeroArmorType(resultSetArmor.getString("armor"));
                System.out.println("You selected " + resultSetHero.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void showHeroes() {
        try {
            connection = DriverManager.getConnection(Main_All.getUrl(), Main_All.getUserName(), Main_All.getPassword());
            Statement statementHero = connection.createStatement();
            Statement statementArmor = connection.createStatement();
            Statement statementClass = connection.createStatement();

            ResultSet resultSetHero = statementHero.executeQuery("SELECT * FROM hero");
            ResultSet resultSetArmor = statementArmor.executeQuery("select armor1_.armor as armor from hero_armors armors0_ inner join armor armor1_ on armors0_.armors_id = armor1_.id order by hero_model_id");
            ResultSet resultSetClass = statementClass.executeQuery("select classtype1_.class as class from hero_classes classes0_ inner join class classtype1_ on classes0_.classes_id=classtype1_.id order by hero_model_id");

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
