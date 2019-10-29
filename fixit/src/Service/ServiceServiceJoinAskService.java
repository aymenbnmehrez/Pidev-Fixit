/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Db.DataSource;
import Entity.ServiceJoinAskService;
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
public class ServiceServiceJoinAskService {
      Connection con = DataSource.getInstance().getConnection();
    private Statement ste;

    public ServiceServiceJoinAskService() {
        try {
            ste = con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }


    public List<ServiceJoinAskService> getDataAskService(int clientId) throws SQLException {
        List<ServiceJoinAskService> list = new ArrayList<>();

        ResultSet res = ste.executeQuery("SELECT ask_service.ask_service_id,service.name, ask_service.date,ask_service.started_at,ask_service.status FROM service, ask_service WHERE ask_service.service_id = service.service_id AND ask_service.client_id='"+clientId+"'");
        ServiceJoinAskService s = null;
        while (res.next()) {
            s = new ServiceJoinAskService(res.getInt("ask_service.ask_service_id"),res.getString("service.name"), res.getDate("ask_service.date"), res.getString("ask_service.started_at"),res.getString("ask_service.status"));
//            System.out.println("id client : "+cl.getClient_id()+" username : "+cl.getUsername()+" pwd : "+cl.getPassword()+" first name : "+cl.getFirst_name()+" last name : "+cl.getLast_name()+" adress : "+cl.getAdress()+" phone : "+cl.getPhone()+" mail :"+cl.getMail());
            list.add(s);
        }
        return list;
    }
// public List<ServiceJoinAskService> getIdServicex(int clientId) throws SQLException {
//        List<ServiceJoinAskService> list = new ArrayList<>();
//
//        ResultSet res = ste.executeQuery("SELECT service.name, ask_service.date,ask_service.started_at,ask_service.isconfirmed,ask_service.isnotconfirmed,ask_service.iscanceled,ask_service.isfinished FROM service, ask_service WHERE ask_service.service_id = service.service_id AND ask_service.client_id='"+clientId+"'");
//        ServiceJoinAskService s = null;
//        while (res.next()) {
//            s = new ServiceJoinAskService(res.getString("service.name"), res.getDate("ask_service.date"), res.getString("ask_service.started_at"));
////            System.out.println("id client : "+cl.getClient_id()+" username : "+cl.getUsername()+" pwd : "+cl.getPassword()+" first name : "+cl.getFirst_name()+" last name : "+cl.getLast_name()+" adress : "+cl.getAdress()+" phone : "+cl.getPhone()+" mail :"+cl.getMail());
//            list.add(s);
//        }
//        return list;
//    }
        public List<ServiceJoinAskService> getDataAskService2(int idClient) throws SQLException {
        List<ServiceJoinAskService> list = new ArrayList<>();
        String requete = "SELECT ask_service.ask_service_id, service.name, ask_service.date,ask_service.started_at,ask_service.status FROM service, ask_service WHERE ask_service.service_id = service.service_id AND ask_service.client_id='"+idClient+"'";
        ResultSet res = ste.executeQuery(requete);
        ServiceJoinAskService s = null;
        while (res.next()) {
            s = new ServiceJoinAskService(res.getInt("ask_service.ask_service_id"),res.getString("service.name"), res.getDate("ask_service.date"), res.getString("ask_service.started_at"),res.getString("ask_service.status"));
//            System.out.println("id client : "+cl.getClient_id()+" username : "+cl.getUsername()+" pwd : "+cl.getPassword()+" first name : "+cl.getFirst_name()+" last name : "+cl.getLast_name()+" adress : "+cl.getAdress()+" phone : "+cl.getPhone()+" mail :"+cl.getMail());
            list.add(s);
        }
        return list;
    }
}
