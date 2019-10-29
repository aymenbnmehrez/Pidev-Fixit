/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Db.DataSource;
import Entity.Client;
import Entity.Service;
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
public class ServiceService {

    Connection con = DataSource.getInstance().getConnection();
    private Statement ste;

    public ServiceService() {
        try {
            ste = con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public List<Service> readAll() throws SQLException {
        List<Service> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from service");
        Service serv = null;
        while (res.next()) {
            serv = new Service(res.getInt(1), res.getInt(2), res.getString(3));
            System.out.println("service id : : " + serv.getService_id() + " category id : " + serv.getCategory_id() + " name : " + serv.getName());
        }
        return list;
    }

    public List<Service> getIdService(String nameService) throws SQLException {
        List<Service> list = new ArrayList<>();

        ResultSet res = ste.executeQuery("SELECT * FROM `service` WHERE `name`='" + nameService + "'");
        Service s = null;
        while (res.next()) {
            s = new Service(res.getInt(1), res.getInt(2), res.getString(3));
//            System.out.println("id client : "+cl.getClient_id()+" username : "+cl.getUsername()+" pwd : "+cl.getPassword()+" first name : "+cl.getFirst_name()+" last name : "+cl.getLast_name()+" adress : "+cl.getAdress()+" phone : "+cl.getPhone()+" mail :"+cl.getMail());
            list.add(s);
        }
        return list;
    }
       public List<Service> getListService(int categoryId) throws SQLException {
        List<Service> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("select name from service where category_id='"+categoryId+"'");
        Service serv = null;
        while (res.next()) {
            serv = new Service( res.getString("name"));
            list.add(serv);
        }
        return list;
    }
    
}
