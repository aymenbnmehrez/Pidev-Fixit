/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Db.DataSource;
import Entity.Cclaim;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

/**
 *
 * @author aymen
 */
public class ServiceCclaim {
     private Connection con = DataSource.getInstance().getConnection();
        private Statement ste;
       
    public ServiceCclaim() {
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println("connexion"+ex);  
        }
    }
public int FindIdByUsername(String usrname) throws SQLException{
       int id = 0;
        ResultSet res=ste.executeQuery("select `client_id` from client where `username`='"+usrname+"'");
       while (res.next()){
           id=res.getInt(1);
       }
       return id ;
    }
     public int ajouterReclamation(String desc,String usrname) throws SQLException, InterruptedException{
      int id=FindIdByUsername(usrname);
      String requete = "INSERT INTO `c_claim` (`claim_id`,`client_id`, `description`) " + "VALUES (NULL,'"+id+"','"+desc+"');";
      ste.executeUpdate(requete);
      System.out.println("elment inseré");
     
        final String fromEmail = "rrahouba7@gmail.com"; //requires valid gmail id
        final String password = "abcdefg2067458"; // correct password for gmail id
        final String toEmail = "ApplFixit@gmail.com"; // can be any email id 
		
		System.out.println("TLSEmail Start");
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
		props.put("mail.smtp.port", "587"); //TLS Port
		props.put("mail.smtp.auth", "true"); //enable authentication
		props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
		
                //create Authenticator object to pass in Session.getInstance argument
		Authenticator auth = new Authenticator() {
			//override the getPasswordAuthentication method
		protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(fromEmail, password);
			}
		};
		Session session = Session.getInstance(props, auth);
		
	int result=Mailing.sendEmail(session, toEmail,"Claim From a Client", desc);
        return result;
    }
     
     
     
     public List<Cclaim> readAll() throws SQLException
    {List<Cclaim> list=new ArrayList<>();
    ResultSet res=ste.executeQuery("select * from c_claim");
    Cclaim per=null;
    while (res.next()) {            
      per=new Cclaim(res.getString(3));
      list.add(per);
        }
    return list;
    } 
 
 /* public void ajouterReclamation2(reclamation p) throws SQLException{  
 String req="INSERT INTO `p_claim` ( `p_claim_id`, `description`) VALUES (?,?)";
   PreparedStatement pres=con.prepareStatement(req);
  pres.setInt(1, p.getId_Claim());
   pres.setString(2, p.getDescription());
 pres.executeUpdate(req);
  System.out.println("element inserer");
  
  }*/
  public void ModifierReclamation(Cclaim p,String reclamation) throws SQLException{  
  String req="UPDATE c_claim SET description = ?  WHERE `c_claim`.`claim_id`=? ;";
  PreparedStatement pres=con.prepareStatement(req);
    pres.setString(1, reclamation);
    pres.setInt(2, p.getClaim_id());
  pres.executeUpdate();
  System.out.println("element modifier");
  
  }
  public void SupprimerReclamation(Cclaim p) throws SQLException{  
  String req="DELETE FROM c_claim WHERE `c_claim`.`claim_id` = 2";
  PreparedStatement pres=con.prepareStatement(req);
  //pres.setInt(1, p.getId_Claim());
 pres.executeUpdate();
      System.out.println("element supprimer");
  
  }
    
   public Cclaim FindById(Cclaim p) throws SQLException
    {
 
     String req="select * from c_claim WHERE `claim_id` = ?; ";
     PreparedStatement pres=con.prepareStatement(req);
     pres.setInt(1, p.getClaim_id());
      return p;
    }
  
    
}
