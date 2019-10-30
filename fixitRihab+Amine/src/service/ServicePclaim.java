/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Db.DataSource;
import Entity.Pclaim;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author aymen
 */
public class ServicePclaim {
     private Connection con = DataSource.getInstance().getConnection();
        private Statement ste;
       
    public ServicePclaim() {
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println("connexion"+ex);  
        }
    }
    
    public int FindIdByUsername(String usrname) throws SQLException{
       int id = 0;
        ResultSet res=ste.executeQuery("select `provider_id` from provider where `username`='"+usrname+"'");
       while (res.next()){
           id=res.getInt(1);
       }
       return id ;
    }
    public String FindEmailByUsername(String usrname) throws SQLException{
        String email=null;
           ResultSet res=ste.executeQuery("select `mail` from provider where `username`='"+usrname+"'");
       while (res.next()){
           email=res.getString("mail");
       }
       return email ;
    }
     public int ajouterReclamation(String desc,String usrname) throws SQLException{
        int id=FindIdByUsername(usrname);
        String requete = "INSERT INTO `p_claim` (`p_claim_id`,`provider_id`, `description`) " + "VALUES (NULL,"+id+",'"+desc+"');";
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
		
		int result =Mailing.sendEmail(session, toEmail,"Claim from a Provider", desc);
                return result;
   
    }
     public List<Pclaim> readAll() throws SQLException
    {List<Pclaim> list=new ArrayList<>();
    ResultSet res=ste.executeQuery("select * from p_claim");
    Pclaim per=null;
    while (res.next()) {            
      per=new Pclaim(res.getString(3));
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
  public void ModifierReclamation(Pclaim p,String reclamation) throws SQLException{  
  String req="UPDATE p_claim SET description = ?  WHERE `p_claim`.`Id_claimP` = ?;";
  PreparedStatement pres=con.prepareStatement(req);
    pres.setString(1, reclamation);
    pres.setInt(2, p.getId_claimP());
  pres.executeUpdate(req);
  System.out.println("element modifier");
  
  }
  public void SupprimerReclamation(Pclaim p) throws SQLException{  
  String req="DELETE FROM p_claim WHERE `p_claim`.`Id_claimP` = 2";
  PreparedStatement pres=con.prepareStatement(req);
  //pres.setInt(1, p.getId_Claim());
 pres.executeUpdate();
      System.out.println("element supprimer");
  
  }
    
 
}
