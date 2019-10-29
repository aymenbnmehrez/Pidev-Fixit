/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Db.DataSource;
import Entity.ClientJoinServiceJoinAskService;
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
public class ServiceClientJoinServiceJoinAskService {

    Connection con = DataSource.getInstance().getConnection();
    private Statement ste;

    public ServiceClientJoinServiceJoinAskService() {
        try {
            ste = con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
        public List<ClientJoinServiceJoinAskService> getDataTabProvider() throws SQLException {
        List<ClientJoinServiceJoinAskService> list = new ArrayList<>();

        ResultSet res = ste.executeQuery("SELECT client.first_name,client.last_name,service.name,ask_service.date,ask_service.started_at,ask_service.price,ask_service.ask_service_id,ask_service.status,ask_service.description FROM client JOIN ask_service ON client.client_id = ask_service.client_id JOIN service ON service.service_id = ask_service.service_id ");
        ClientJoinServiceJoinAskService s = null;
        while (res.next()) {
            s = new ClientJoinServiceJoinAskService(res.getString("client.first_name"),res.getString("client.last_name"), res.getString("service.name"), res.getDate("ask_service.date"),res.getString("ask_service.started_at"),res.getInt("ask_service.price"),res.getInt("ask_service.ask_service_id"),res.getString("ask_service.status"),res.getString("ask_service.description"));
//            System.out.println("id client : "+cl.getClient_id()+" username : "+cl.getUsername()+" pwd : "+cl.getPassword()+" first name : "+cl.getFirst_name()+" last name : "+cl.getLast_name()+" adress : "+cl.getAdress()+" phone : "+cl.getPhone()+" mail :"+cl.getMail());
            list.add(s);
        }
        return list;
    }
}
