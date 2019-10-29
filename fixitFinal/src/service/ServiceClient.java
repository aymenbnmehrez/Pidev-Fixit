/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import ENTITE.client;
import ENTITE.provider;
import com.sun.security.ntlm.Client;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import utils.Datasource;

/**
 *
 * @author LENOVO
 */
public class ServiceClient {
     private Connection con = Datasource.getInstance().getConnection();
    private Statement ste;
    
    public ServiceClient() {
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
    }
    
    public void ajouterClient(client c) throws SQLException{
        
  
    String requete = "INSERT INTO `client` (`client_id`,`username`,`password`, `first_name`, `last_name`,`city`,`phone`,`mail`,`fidelity_pt`,`image`)"+" VALUES (NULL, '"+c.getUsername()+"', '"+c.getPassword()+"', '"+c.getFirst_name()+"', '"+c.getLast_name()+"', '"+c.getCity()+"', '"+c.getPhone()+"', '"+c.getMail()+"', '"+c.getFidelity_pt()+"', '"+c.getImage()+"');";
ste.executeUpdate(requete);
        System.out.println("elment inste");
    }
    
    public void deleteClient(int client_id) throws SQLException{
        String requete="DELETE FROM client WHERE client_id='"+client_id+"'";
        ste.executeUpdate(requete);
    }
    
    public void updateClient(int client_id, String username, String password, String first_name, String last_name, String city, int phone, String mail,int fidelity_pt,String image) throws SQLException {
        String requete = "UPDATE client SET `username`='" + username + "',`password`='" + password + "',`first_name`='" + first_name + "',`last_name`='" + last_name + "',`city`='" + city + "',`phone`='" + phone + "',`mail`='" + mail + "',`fidelity_pt`='"+fidelity_pt+"',`image`='"+image+"' WHERE client_id='" + client_id + "'";
        ste.executeUpdate(requete);

    }
    
    public boolean isAuthenticated(String username,String pwd) throws SQLException {
        List<client> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from client ");
        client cl = null;
           while (res.next()) {
            cl = new client( res.getString(2), res.getString(3));
            if((username.equals(cl.getUsername()))&&(pwd.equals(cl.getPassword())))
                return true;
        }
        return false;
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
          
          public boolean validcity(String city) throws SQLException {
            if((city.length()>=0)||(city.length()<=25)){return true;}
                             return false;}
          
          public boolean validphone(String phone) throws SQLException {
            if (phone.length()!=8){return false;}
        
            for (int i = 0; i < phone.length(); i++) {
  char c = phone.charAt(i);
  if (!((c >= '0' && c <= '9'))){return false;}
          }return true;}
    
    public List<client> readAll() throws SQLException
    {List<client> list=new ArrayList<>();
    ResultSet res=ste.executeQuery("select * from client");
    client per=null;
    while (res.next()) {            
      per=new client(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getInt(7),res.getString(8),res.getInt(9),res.getString(10));
      list.add(per);
        }
    return list;
    } 
    
     public List<client> readAll2(String username) throws SQLException
    {List<client> list=new ArrayList<>();
    ResultSet res=ste.executeQuery("select * from client where username='"+username+"'");
    client per=null;
    while (res.next()) {            
      per=new client(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getInt(7),res.getString(8),res.getInt(9),res.getString(10));
      list.add(per);
        }
    return list;
    } 
     
     public void delClient(String username) throws SQLException{
        String requete="DELETE FROM client WHERE username='"+username+"'";
        ste.executeUpdate(requete);
    }
     
     public List<client> getdata(String username) throws SQLException{
             List<client> list=new ArrayList<>();
            // client c = new client();
             ResultSet res=ste.executeQuery("select * from client where username='"+username+"'");
                 client c=null;

             while(res.next()){
            //  c=new client(res.getString(3),res.getString(4)),res.getString(5),res.getString(6),res.getInt(7),res.getString(8)); 
                   c=new client(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getInt(7),res.getString(8),res.getInt(9),res.getString(10));


              
             
             list.add(c);
             
             }
          return list;
             
          }
     
     
     public void upClient(String username,client c) throws SQLException {
        String requete = "UPDATE client SET `password`='" + c.getPassword() + "',`first_name`='" + c.getFirst_name() + "',`last_name`='" + c.getLast_name() + "',`city`='" + c.getCity() + "',`phone`='" + c.getPhone() + "',`mail`='" + c.getMail() + "' WHERE username='" + username+ "'";
        ste.executeUpdate(requete);}
    
     
   
    
}
