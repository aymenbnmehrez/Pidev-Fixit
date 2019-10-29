/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Db.DataSource;
import Entity.Ad;
import Entity.ClientComment;
import Entity.Comment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aymen
 */
public class ServiceComment {
     private Connection con = DataSource.getInstance().getConnection();
        private Statement ste;
       
    public ServiceComment() {
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println("connexion"+ex);  
        }
    }

     public void ajouterCommentaire(String comment,String client) throws SQLException{
        int idA=getidAdByUsername(client);
        int idC=FindIdByUsername(client);
      String requete = "INSERT INTO `comment` (`comment_id`,`client_id`,`ad_id`,`description`) " + "VALUES (NULL,'"+1+"','"+1+"','"+comment+"');";
      ste.executeUpdate(requete);
        System.out.println("elment inseré");
    }
     public List<Comment> readAll() throws SQLException
    {List<Comment> list=new ArrayList<>();
    ResultSet res=ste.executeQuery("select * from comment");
    Comment per=null;
    while (res.next()) {            
      per=new Comment( res.getInt(2),res.getString(3));
      list.add(per);
        }
    return list;
    } 
      public int FindIdByUsername(String usrname) throws SQLException{
       int id = 0;
        ResultSet res=ste.executeQuery("select `provider_id` from provider where `username`='"+usrname+"'");
       while (res.next()){
           id=res.getInt(1);
       }
       return id ;
    }
     public int  getidAdByUsername (String usrname) throws SQLException{
         int id = FindIdByUsername(usrname);
        ResultSet res=ste.executeQuery("select `provider_id` from provider where `username`='"+usrname+"'");
       while (res.next()){
           id=res.getInt(1);
       }
         return id;
     }
      public List<Comment> readByAd(String username) throws SQLException
    {int id =getidAdByUsername(username);
        List<Comment> list=new ArrayList<>();
    ResultSet res=ste.executeQuery("select comment.description  from comment join ad on comment.ad_id=ad.ad_id where comment.ad_id="+id );
    Comment per=null;
    while (res.next()) {            
      per=new Comment(res.getString("description"));
      list.add(per);
        }
    return list;
    } 
 
  public void ModifierCommentaire(String username,String commentaire) throws SQLException{  
      int id =getidAdByUsername(username);
  String req="UPDATE comment SET description = ?  WHERE `comment`.`Id_comment` = ?;";
  PreparedStatement pres=con.prepareStatement(req);
    pres.setString(1, commentaire);
    pres.setInt(2, id);
  pres.executeUpdate(req);
  System.out.println("element modifier");
  
  }
  public void SupprimerCommentaire(String username) throws SQLException{  
  int id =getidAdByUsername(username);
  String req="DELETE  FROM comment c join ad d WHERE `comment`.`Id_comment` = ?";
  PreparedStatement pres=con.prepareStatement(req);
  pres.setInt(1, id);
  pres.executeUpdate();
      System.out.println("element supprimer");
  
  }
    /*
   public Comment FindById(Comment p) throws SQLException
    {
     String req="select * from p_claim WHERE `Id_comment` = ?; ";
     PreparedStatement pres=con.prepareStatement(req);
     pres.setInt(1, p.getId_comment());
      return p;
    }*/
   public int AfficheLike(String nom) throws SQLException{
      
    ResultSet res=ste.executeQuery("SELECT Nb_likes from ad join provider on provider.provider_id=ad.provider_id where ad_id=1" );
    Ad an=null;
          while (res.next()) {
        an=new Ad(res.getInt("Nb_Likes"));
}
      int nblikes=an.getNb_Likes();    
   return nblikes;
  }
   public int NbrComments(String username) throws SQLException{
      // int id =getidAdByUsername(username);
       int nbr=0;
      ResultSet res= ste.executeQuery("select count(*) from comment where ad_id="+1);
 while (res.next()) 
 nbr= res.getInt(1);
     return nbr; 
   }
  public void AjoutLike (String nom) throws SQLException{
     Ad an=new Ad();
      int nombre_final=AfficheLike(nom);
      nombre_final=nombre_final+1;
      String requete = "UPDATE ad SET Nb_Likes = "+nombre_final+"  WHERE ad_id =1;";
     PreparedStatement pres=con.prepareStatement(requete);
     //pres.setInt(1, nombre_final);
     ste.executeUpdate(requete);
     //con = DataSource.getInstance().getConnection();
      AfficheLike(nom);
        System.out.println("elment inseré");
  }
  public List<ClientComment> AffichClientComments () throws SQLException{
       List<ClientComment> list=new ArrayList<>();
    ResultSet res=ste.executeQuery("select `first_name`,`last_name`,`description`  from comment join client on comment.client_id=client.client_id " );
    ClientComment per=null;
    while (res.next()) {   
      per=new ClientComment(res.getString(1),res.getString(2),res.getString(3));
      list.add(per);
        }
    return list;
  }
}
