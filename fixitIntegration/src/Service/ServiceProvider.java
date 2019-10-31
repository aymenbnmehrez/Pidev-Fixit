/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Db.DataSource;
import java.sql.*;
import Entity.Provider;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Pattern;
import javax.mail.Session;

/**
 *
 * @author aymen
 */
public class ServiceProvider {

    Connection con = DataSource.getInstance().getConnection();
    private Statement ste;

    public ServiceProvider() {
        try {
            ste = con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }


    
     /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public boolean isAuthenticated(String username,String pwd) throws SQLException {
        List<Provider> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from provider ");
        Provider cl = null;
           while (res.next()) {
            cl = new Provider( res.getString(2), res.getString(3));
            if(username.equals(cl.getUsername())&&pwd.equals(cl.getPassword()))
                return true;
        }
        return false;
    }
    public void addProvider(Provider p) throws SQLException {
        String requete = "INSERT INTO `provider` (`provider_id`, `username`, `password`, `first_name`, `last_name`, `address`, `phone`, `mail`,`rating`) VALUES (NULL, '" + p.getUsername() + "', '" + p.getPassword() + "', '" + p.getFirst_name() + "', '" + p.getLast_name() + "', '" + p.getAddress()+ "', '" + p.getPhone() + "', '" + p.getMail() + "','"+p.getRating()+"');";
        ste.executeUpdate(requete);
    }

 
    public void updateProvider(int id, String userName, String pwd, String firstName, String lastName, String adress, int phone, String mail) throws SQLException {
        String requete = "UPDATE `provider` SET `username`='" + userName + "',`password`='" + pwd + "',`first_name`='" + firstName + "',`last_name`='" + lastName + "',`adress`='" + adress + "',`phone`='" + phone + "',`mail`='" + mail + "' WHERE provider_id='" + id + "'";
        ste.executeUpdate(requete);

    }
    public void deleteProvider(int id) throws SQLException{
        String requete="DELETE FROM `provider` WHERE provider_id='"+id+"'";
        ste.executeUpdate(requete);
    }
    public List<Provider> displayProvider(String username) throws SQLException {
        List<Provider> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from provider where username='"+username+"'");
        Provider cl = null;
        while (res.next()) {
            cl = new Provider(res.getString (2), res.getString (3), res.getString (4), res.getString (5), res.getString (6), res.getInt (7), res.getString (8), res.getFloat (9), res.getString (10), res.getInt (11));
//            System.out.println("id client : "+cl.getClient_id()+" username : "+cl.getUsername()+" pwd : "+cl.getPassword()+" first name : "+cl.getFirst_name()+" last name : "+cl.getLast_name()+" adress : "+cl.getAdress()+" phone : "+cl.getPhone()+" mail :"+cl.getMail());
            list.add(cl);
        }
        return list;
    }
      public void ajouterProvider(Provider p) throws SQLException{
        
String requete = "INSERT INTO `provider` (`provider_id`,`username`,`password`, `first_name`, `last_name`,`address`,`phone`,`mail`,`rating`,`experience` ,`confirmation`)"+" VALUES (NULL, '"+p.getUsername()+"', '"+p.getPassword()+"', '"+p.getFirst_name()+"', '"+p.getLast_name()+"', '"+p.getAddress()+"', '"+p.getPhone()+"', '"+p.getMail()+"', '"+p.getRating()+"', '"+p.getExperience()+"', '"+p.getConfirmation()+"');";  
   
ste.executeUpdate(requete);
        System.out.println("elment inste");
    }
    
    
    public void updateProvider(int provider_id, String username, String password, String first_name, String last_name, String city, int phone, String mail, float rating,String image,int like_nb,int confirmation) throws SQLException {
        String requete = "UPDATE provider SET `username`='" + username + "',`password`='" + password + "',`first_name`='" + first_name + "',`last_name`='" + last_name + "',`address`='" + city + "',`phone`='" + phone + "',`mail`='" + mail + "',`rating`='"+rating+"',`image`='"+image+ "',`confirmation`='"+confirmation+ "' WHERE provider_id='" + provider_id + "'";
        ste.executeUpdate(requete);

    }
    
    public boolean isAuthenticated(String username,String pwd,int conf) throws SQLException {
        List<Provider> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from provider ");
        Provider cl = null;
           while (res.next()) {
            cl = new Provider( res.getString(2), res.getString(3));
            if((username.equals(cl.getUsername()))&&(pwd.equals(cl.getPassword()))&&((conf==1)))
                return true;
        }
        return false;
    }
<<<<<<< HEAD
            public int select(String username) throws SQLException {
        List<Provider> list = new ArrayList<>();
        
        ResultSet res = ste.executeQuery("select * from provider WHERE username='"+username+"'");
        Provider cl = null;
        while (res.next()) {
            cl = new Provider(res.getInt(11));
            list.add(cl);}
            return cl.getConfirmation();
              
        }
            
            public List<Provider> getEmail(String username) throws SQLException {
        List<Provider> list = new ArrayList<>();
        
        ResultSet res = ste.executeQuery("select * from provider WHERE username='"+username+"'");
        Provider cl = null;
        while (res.next()) {
            cl = new Provider(res.getString(8));
            list.add(cl);}
            return list;
              
        }
    
    public List<Provider> readAll() throws SQLException
    {List<Provider> list=new ArrayList<>();
    ResultSet res=ste.executeQuery("select * from provider");
    Provider per=null;
    while (res.next()) {            
      per=new Provider(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getInt(7),res.getString(8),res.getFloat(9),res.getString(10),res.getInt(11));
      list.add(per);
        }
    return list;
    }
    
public List<Provider> readAll2(String username) throws SQLException
    {List<Provider> list=new ArrayList<>();
    ResultSet res=ste.executeQuery("select * from provider where username='"+username+"'");
    Provider per=null;
    while (res.next()) {            
      per=new Provider(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getInt(7),res.getString(8),res.getFloat(9),res.getString(10),res.getInt(11));
      list.add(per);
      
      
        }
    return list;
    } 

  public void delProvider(String username) throws SQLException{
        String requete="DELETE FROM provider WHERE username='"+username+"'";
        ste.executeUpdate(requete);}
  
   public List<Provider> getdata(String username) throws SQLException{
             List<Provider> list=new ArrayList<>();
            // client c = new client();
             ResultSet res=ste.executeQuery("select * from provider where username='"+username+"'");
                 Provider c=null;

             while(res.next()){
            //  c=new client(res.getString(3),res.getString(4)),res.getString(5),res.getString(6),res.getInt(7),res.getString(8)); 
      c=new Provider(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getInt(7),res.getString(8),res.getFloat(9),res.getString(10),res.getInt(11));


              
             
             list.add(c);
             
             }
          return list;
             
          }
   
    public void upProvider(String username,Provider p) throws SQLException {
        String requete = "UPDATE provider SET `password`='" + p.getPassword() + "',`first_name`='" + p.getFirst_name() + "',`last_name`='" + p.getLast_name() + "',`address`='" + p.getAddress() + "',`phone`='" + p.getPhone() + "',`mail`='" + p.getMail() + "' WHERE username='" + username+ "'";
        ste.executeUpdate(requete);}
    
    public void confirm(String mail,String username) throws SQLException {
   String requete = "UPDATE provider SET `confirmation`='"+1+"'where username='"+username+"'";
      ste.executeUpdate(requete); 
//     
//                List<Provider> list = new ArrayList<>();
//                Provider p = new Provider();
//                list=getEmail(username);
//                p=list.get(0);
//                   System.out.println(p.getMail());
       /*
       final String fromEmail = "medamin.bousbih@gmail.com"; //requires valid gmail id
        final String password = "a20460826"; // correct password for gmail id */
      //  final String toEmail =p.getMail(); // can be any email id 
        

		 
        final String fromEmail = "medamin.bousbih@gmail.com"; //requires valid gmail id
        final String password = "a20460826"; // correct password for gmail id
        //final String toEmail = "hamza.bayar@esprit.tn"; // can be any email id 
		
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
		
	Mailing.sendEmail(session,mail,"Claim From a Client", "your account is confirmed ");
       
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
           public List<Provider> displayProvider2(String username) throws SQLException {
=======
     
             public Provider getProviderByUsername(String username)throws SQLException{
        
            String req ="select * from provider where username='"+username+"'";
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(req);
            Provider p=new Provider();
            if (rs.next()) {
            p.setProvider_id(rs.getInt("provider_id"));
            p.setUsername(rs.getString("username"));
            }
            return p;
        }
             public List<Provider> displayProvider(String username) throws SQLException {
>>>>>>> 4b6d6d3b1aa0f55c096fb62d55e8e5e550ccbe22
        List<Provider> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from provider where username='"+username+"'");
        Provider cl = null;
        while (res.next()) {
            cl = new Provider(res.getInt("provider_id"));
//            System.out.println("id client : "+cl.getClient_id()+" username : "+cl.getUsername()+" pwd : "+cl.getPassword()+" first name : "+cl.getFirst_name()+" last name : "+cl.getLast_name()+" adress : "+cl.getAdress()+" phone : "+cl.getPhone()+" mail :"+cl.getMail());
            list.add(cl);
        }
        return list;
    }
}


