package DataBase;

import java.sql.*;

public class DataBase {

    private static DataBase data;
    static private Connection con;
    static String url = "jdbc:mysql://localhost:3306/fixit";
    static String login = "root";
    static String pwd = "";
    static Statement ste;

    private DataBase() {

        try {
            con = DriverManager.getConnection(url, login, pwd);
            ste = con.createStatement();
            System.out.println("connection successful!");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public Connection getConnection() {
        return con;
    }

    public static DataBase getInstance() {
        if (data == null) {
            data = new DataBase();
        }
        return data;
    }

}
