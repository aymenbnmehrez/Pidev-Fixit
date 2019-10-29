/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

/**
 *
 * @author LENOVO
 */



import ENTITE.client;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import utils.Datasource;
import ENTITE.provider;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;



public class serviceProvider {
   
    private Connection con = Datasource.getInstance().getConnection();
    private Statement ste;
    
    public serviceProvider() {
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
    }
    
    public void ajouterProvider(provider p) throws SQLException{
        
String requete = "INSERT INTO `provider` (`provider_id`,`username`,`password`, `first_name`, `last_name`,`city`,`phone`,`mail`,`rating`,`experience` ,`like_nb`,`confirmation`)"+" VALUES (NULL, '"+p.getUsername()+"', '"+p.getPassword()+"', '"+p.getFirst_name()+"', '"+p.getLast_name()+"', '"+p.getCity()+"', '"+p.getPhone()+"', '"+p.getMail()+"', '"+p.getRating()+"', '"+p.getExperience()+"', '"+p.getLike_nb()+"', '"+p.getConfirmation()+"');";  
    //String requete = "INSERT INTO `provider` (`provider_id`,`username`,`password`, `first_name`, `last_name`,`city`,`phone`,`mail`,`rating`,`image` ,`like_nb`)"+" VALUES (NULL, '"+p.getUsername()+"', '"+p.getPassword()+"', '"+p.getFirst_name()+"', '"+p.getLast_name()+"', '"+p.getCity()+"', '"+p.getPhone()+"', '"+p.getMail()+"', '"+p.getRating()+"', '"+p.getImage()+"', '"+p.getLike_nb()+"');";
ste.executeUpdate(requete);
        System.out.println("elment inste");
    }
    
    
    public void deleteProvider(int provider_id) throws SQLException{
        String requete="DELETE FROM provider WHERE provider_id='"+provider_id+"'";
        ste.executeUpdate(requete);
    }
    
    public void updateProvider(int provider_id, String username, String password, String first_name, String last_name, String city, int phone, String mail, float rating,String image,int like_nb,int confirmation) throws SQLException {
        String requete = "UPDATE provider SET `username`='" + username + "',`password`='" + password + "',`first_name`='" + first_name + "',`last_name`='" + last_name + "',`city`='" + city + "',`phone`='" + phone + "',`mail`='" + mail + "',`rating`='"+rating+"',`image`='"+image+"',`like_nb`='"+like_nb+ "',`confirmation`='"+confirmation+ "' WHERE provider_id='" + provider_id + "'";
        ste.executeUpdate(requete);

    }
    
    public boolean isAuthenticated(String username,String pwd,int conf) throws SQLException {
        List<provider> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from provider ");
        provider cl = null;
           while (res.next()) {
            cl = new provider( res.getString(2), res.getString(3));
            if((username.equals(cl.getUsername()))&&(pwd.equals(cl.getPassword()))&&((conf==1)))
                return true;
        }
        return false;
    }
            public int select(String username) throws SQLException {
        List<provider> list = new ArrayList<>();
        
        ResultSet res = ste.executeQuery("select * from provider WHERE username='"+username+"'");
        provider cl = null;
        while (res.next()) {
            cl = new provider(res.getInt(12));
            list.add(cl);}
            return cl.getConfirmation();
              
        }
            
            public String getEmail(String username) throws SQLException {
        List<provider> list = new ArrayList<>();
        
        ResultSet res = ste.executeQuery("select * from provider WHERE username='"+username+"'");
        provider cl = null;
        while (res.next()) {
            cl = new provider(res.getString(8));
            list.add(cl);}
            return cl.getMail();
              
        }
    
    

    
    
   
    
    
    
    public List<provider> readAll() throws SQLException
    {List<provider> list=new ArrayList<>();
    ResultSet res=ste.executeQuery("select * from provider");
    provider per=null;
    while (res.next()) {            
      per=new provider(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getInt(7),res.getString(8),res.getFloat(9),res.getString(10),res.getInt(11),res.getInt(12));
      list.add(per);
        }
    return list;
    }
    
public List<provider> readAll2(String username) throws SQLException
    {List<provider> list=new ArrayList<>();
    ResultSet res=ste.executeQuery("select * from provider where username='"+username+"'");
    provider per=null;
    while (res.next()) {            
      per=new provider(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getInt(7),res.getString(8),res.getFloat(9),res.getString(10),res.getInt(11));
      list.add(per);
        }
    return list;
    } 

  public void delProvider(String username) throws SQLException{
        String requete="DELETE FROM provider WHERE username='"+username+"'";
        ste.executeUpdate(requete);}
  
   public List<provider> getdata(String username) throws SQLException{
             List<provider> list=new ArrayList<>();
            // client c = new client();
             ResultSet res=ste.executeQuery("select * from provider where username='"+username+"'");
                 provider c=null;

             while(res.next()){
            //  c=new client(res.getString(3),res.getString(4)),res.getString(5),res.getString(6),res.getInt(7),res.getString(8)); 
      c=new provider(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getInt(7),res.getString(8),res.getFloat(9),res.getString(10),res.getInt(11));


              
             
             list.add(c);
             
             }
          return list;
             
          }
   
    public void upProvider(String username,provider p) throws SQLException {
        String requete = "UPDATE provider SET `password`='" + p.getPassword() + "',`first_name`='" + p.getFirst_name() + "',`last_name`='" + p.getLast_name() + "',`city`='" + p.getCity() + "',`phone`='" + p.getPhone() + "',`mail`='" + p.getMail() + "' WHERE username='" + username+ "'";
        ste.executeUpdate(requete);}
    
    public void confirm(String username) throws SQLException {
        String requete = "UPDATE provider SET `confirmation`='"+1+"'where username='"+username+"'";
       ste.executeUpdate(requete); 
       
       
       final String fromEmail = "medamin.bousbih@gmail.com"; //requires valid gmail id
        final String password = "a20460826"; // correct password for gmail id
        final String toEmail =getEmail(username); // can be any email id 
        final String mail = "your account is confirmed"; 

		
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
		
	serviceMail.sendEmail(session, toEmail,"Confirmation of fixit account",mail);
        //return result;
    }
    
     public boolean validMail(String mail) throws SQLException {
        
        
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";
                             
        Pattern pat = Pattern.compile(emailRegex);
        if (mail == null)
            return false;
        return pat.matcher(mail).matches();
    }
        public boolean validname(String name) throws SQLException {
            if (name.length()==0){return false;}
        
            for (int i = 0; i < name.length(); i++) {
  char c = name.charAt(i);
  if (!(((c >= 'a' && c <= 'z'))||((c >= 'A' && c <= 'Z'))||(c==' '))){return false;}
          }return true;}
        
          public boolean validpassword(String pwd) throws SQLException {
            if((pwd.length()>=8)&&(pwd.length()<=20)){return true;}
        
           
          return false;}
          
          public boolean validusername(String user) throws SQLException {
            if((user.length()>=0)||(user.length()<=20)){return true;}
        
           
          return false;}
          
          public boolean validexp(String exp) throws SQLException {
            if((exp.length()>=0)||(exp.length()<=40)){return true;}
        
           
          return false;}
          public boolean validcity(String city) throws SQLException {
            if((city.length()>=0)||(city.length()<=25)){return true;}
                             return false;}
          
          public boolean validphone(String phone) throws SQLException {
            if (phone.length()!=8){return false;}
        
            for (int i = 0; i < phone.length(); i++) {
  char c = phone.charAt(i);
  if (!((c >= '0' && c <= '9'))){return false;}
          }return true;}
   
    //public void ajouterClient(client c1) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   // }
    
}
