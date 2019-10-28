/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.Admin;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.DataSource;

/**
 *
 * @author asus
 */
public class AdminFixit {
    private Connection con = DataSource.getInstance().getConnection();

    private Statement ste;
    public AdminFixit() {

        try {
            ste = con.createStatement();

        } catch (SQLException ex) {

            System.out.println(ex);
        }

    }
     public boolean isAuthenticated(String username,String pwd) throws SQLException {
        List<Admin> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from admin ");
        Admin a = null;
           while (res.next()) {
            a = new Admin( res.getString(2), res.getString(3));
            if((username.equals(a.getUsername()))&&(pwd.equals(a.getPassword())))
                return true;
        }
        return false;
    }
    
}
