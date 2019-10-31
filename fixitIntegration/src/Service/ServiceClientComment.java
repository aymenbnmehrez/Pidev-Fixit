/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Db.DataSource;
import Entity.ClientComment;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Koala girl
 */
public class ServiceClientComment {

    Connection con = DataSource.getInstance().getConnection();
    private Statement ste;

    public ServiceClientComment() {
        try {
            ste = con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public List<ClientComment> getDataClientJoinComment(int adId) throws SQLException {
        List<ClientComment> list = new ArrayList<>();

        ResultSet res = ste.executeQuery("SELECT ad.ad_name,client.first_name ,client.last_name,comment.description,ad.ad_id,comment.comment_id ,ad.provider_id FROM comment INNER JOIN client ON comment.client_id = client.client_id INNER JOIN ad ON ad.ad_id = comment.ad_id");
        ClientComment s = null;
        while (res.next()) {
            s = new ClientComment(res.getString("ad.ad_name"),res.getString("client.first_name"), res.getString("client.last_name"), res.getString("comment.description"),res.getInt("ad.ad_id"),res.getInt("comment.comment_id"),res.getInt("ad.provider_id"));
            list.add(s);
        }
        return list;
    }
}
