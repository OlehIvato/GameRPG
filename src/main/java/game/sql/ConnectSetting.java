package game.sql;

public interface ConnectSetting {

    String data_username = "root";
    String data_password = "root";
    String data_url = "jdbc:mysql://localhost/minirpggame" +
            "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

}