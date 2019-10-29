/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.*;
 
public class Datasource {
    
    private static Datasource data;
    private Connection con;
    String url = "jdbc:mysql://localhost:3306/fixit";
    String login = "root";
    String pwd = "";
    


     private Datasource() {
        try {
            con = DriverManager.getConnection(url, login, pwd);
            System.out.println("connexion etablie");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
   

    public Connection getConnection() {
        return con;
    }

    public static Datasource getInstance() {
        if (data == null) {
            data = new Datasource();
        }
        return data;
    }
}
    

    
    
