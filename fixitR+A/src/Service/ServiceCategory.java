/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Db.DataSource;
import Entity.Category;
import Entity.Client;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aymen
 */
public class ServiceCategory {

    Connection con = DataSource.getInstance().getConnection();
    private Statement ste;

    public ServiceCategory() {
        try {
            ste = con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void addCategory(Category c) throws SQLException {
        String requete = "INSERT INTO `category` (`category_id`, `name`, `description`) VALUES (NULL, '" + c.getName() + "', '" + c.getDescription() + "');";
        ste.executeUpdate(requete);
    }

    public List<Category> displayCategory() throws SQLException {
        List<Category> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from category");
        Category cat = null;
        while (res.next()) {
            cat = new Category(res.getInt(1), res.getString(2), res.getString(3));
            System.out.println("id category : " + cat.getCategory_id() + " name : " + cat.getName() + " description : " + cat.getDescription());
        }
        return list;
    }

    public void updateCategory(int id, String name, String description) throws SQLException {
        String requete = "UPDATE `category` SET `name`='" + name + "',`description`='" + description + "' WHERE client_id='" + id + "'";
        ste.executeUpdate(requete);
    }
    
       public void deleteCategory(int id)throws SQLException{
        String requete="DELETE FROM `category` WHERE category_id='"+id+"'";
        ste.executeUpdate(requete);
    }
}
