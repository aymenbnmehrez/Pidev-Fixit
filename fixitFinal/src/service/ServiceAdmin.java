/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import ENTITE.Admin;
import ENTITE.provider;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.Datasource;

/**
 *
 * @author LENOVO
 */
public class ServiceAdmin {
    private Connection con = Datasource.getInstance().getConnection();
    private Statement ste;
    
    public ServiceAdmin() {
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
    }
    
    public boolean isAuthenticated(String username,String pwd) throws SQLException {
        List<Admin> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from Admin ");
        Admin cl = null;
           while (res.next()) {
            cl = new Admin( res.getString(2), res.getString(3));
            if((username.equals(cl.getUsername()))&&(pwd.equals(cl.getPassword())))
                return true;
        }
        return false;
    }
    
}
