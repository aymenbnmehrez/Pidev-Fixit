/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Db.DataSource;
import Entity.AskService;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aymen
 */
public class ServiceAskService {

    Connection con = DataSource.getInstance().getConnection();
    private Statement ste;

    public ServiceAskService() {
        try {
            ste = con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void addAskService(AskService as) throws SQLException {
        String requete = "INSERT INTO `ask_service`(`service_id`,`date`, `duration`, `description`, `client_id`,`started_at`) VALUES ('" + as.getService_id() + "','" + as.getDate() + "','" + as.getDuration() + "','" + as.getDescription() + "','" + as.getClient_id() + "','" + as.getStarted_at() + "');";
        ste.executeUpdate(requete);
    }

    public List<AskService> getDataAskServiceRequest(int client_id) throws SQLException {
        List<AskService> list = new ArrayList<>();

        ResultSet res = ste.executeQuery("SELECT `date`,`isconfirmed`,`isnotconfirmed`,`iscanceled`,`isfinished` FROM `ask_service` WHERE client_id='" + client_id + "'");
        AskService as = null;
        while (res.next()) {
            as = new AskService(res.getDate(1), res.getBoolean(2), res.getBoolean(3), res.getBoolean(4), res.getBoolean(4));
//            System.out.println("id client : "+cl.getClient_id()+" username : "+cl.getUsername()+" pwd : "+cl.getPassword()+" first name : "+cl.getFirst_name()+" last name : "+cl.getLast_name()+" adress : "+cl.getAdress()+" phone : "+cl.getPhone()+" mail :"+cl.getMail());
            list.add(as);
        }
        return list;
    }

    public List<AskService> getDataAskServiceRequest2() throws SQLException {
        List<AskService> list = new ArrayList<>();

        ResultSet res = ste.executeQuery("SELECT  `ask_service_id`,`date`,`duration`,`description` From ask_service");
        AskService as = null;
        while (res.next()) {
            as = new AskService(res.getInt(1), res.getDate("date"), res.getString("duration"), res.getString("description"));
//            System.out.println("id client : "+cl.getClient_id()+" username : "+cl.getUsername()+" pwd : "+cl.getPassword()+" first name : "+cl.getFirst_name()+" last name : "+cl.getLast_name()+" adress : "+cl.getAdress()+" phone : "+cl.getPhone()+" mail :"+cl.getMail());
            list.add(as);
        }
        return list;
    }

    public void getStatusAskService() {
        String status;
        AskService as = new AskService();
        if (as.isIsconfirmed() == true) {
            status = "Service confirmed";
        } else if (as.isIsnotconfirmed() == true) {
            status = "Service not confirmed yet";
        } else if (as.isIscanceled() == true) {
            status = "Service canceled";
        } else if (as.isIsfinished() == true);
        {
            status = "Service done";
        }

    }

    public void deleteAskService(int id) throws SQLException {
        String requete = "DELETE FROM `ask_service` WHERE ask_service_id='" + id + "'";
        ste.executeUpdate(requete);
    }

    public List<AskService> getAskServiceById(int id) throws SQLException {
        List<AskService> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("SELECT  `service_id`,`date`, `duration`, `description`,`started_at` FROM `ask_service` where ask_service_id='" + id + "'");
        AskService as = null;
        while (res.next()) {
            as = new AskService(res.getInt("service_id"), res.getDate("date"), res.getString("duration"), res.getString("description"), res.getString("started_at"));
            list.add(as);
        }
        return list;
    }

    public void editAskService(AskService as,int id) throws SQLException {
        String requete = "    UPDATE `ask_service` SET `service_id`='"+as.getService_id()+"',`date`='"+as.getDate()+"',`duration`='"+as.getDuration()+"',`description`='"+as.getDescription()+"',`started_at`='"+as.getStarted_at()+"' WHERE `ask_service_id`='"+id+"'";
        ste.executeUpdate(requete);
    }
    
    
     public List<String> descriptionAsk() throws SQLException {
                List<String> list = new ArrayList<>();

         String requete ="select description from ask_service " ;
            ResultSet res =ste.executeQuery(requete);
            while (res.next()) {
                list.add(res.getString("description"));
                
            }
        
        return list ;
    }
}
