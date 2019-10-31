/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Db.DataSource;
import Entity.Client;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author aymen
 */
public class ServiceClient {

    Connection con = DataSource.getInstance().getConnection();
    private Statement ste;

    public ServiceClient() {
        try {
            ste = con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    
    public void updateClient(int id,String userName,String pwd,String firstName,String lastName,String adress,int phone,String mail) throws SQLException{
        String requete = "UPDATE `client` SET `username`='" + userName + "',`password`='" + pwd + "',`first_name`='" + firstName + "',`last_name`='" + lastName + "',`adress`='" + adress + "',`phone`='" + phone + "',`mail`='" + mail + "' WHERE client_id='" + id + "'";
        ste.executeUpdate(requete);
    }
  
// public void displayClientUsername(String username) throws SQLException {
//        ResultSet res = ste.executeQuery("select * from client where username='"+username+"'");
//        Client cl = null;
//            cl = new Client(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getInt(7), res.getString(8));
//            System.out.println("id client : "+cl.getClient_id()+" username : "+cl.getUsername()+" pwd : "+cl.getPassword()+" first name : "+cl.getFirst_name()+" last name : "+cl.getLast_name()+" adress : "+cl.getAdress()+" phone : "+cl.getPhone()+" mail :"+cl.getMail());
//   
//            
//    }

 
    public void addClient(Client c) throws SQLException {
        String requete = "INSERT INTO `client` (`client_id`, `username`, `password`, `first_name`, `last_name`, `adress`, `phone`, `mail`) VALUES (NULL, '" + c.getUsername() + "', '" + c.getPassword() + "', '" + c.getFirst_name() + "', '" + c.getLast_name() + "', '" + c.getAddress()+ "', '" + c.getPhone() + "', '" + c.getMail() + "');";
        ste.executeUpdate(requete);
    }

    public List<Client> displayClient() throws SQLException {
        List<Client> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from client");
        Client cl = null;
        while (res.next()) {
            cl = new Client(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getInt(7), res.getString(8));
            System.out.println("id client : "+cl.getClient_id()+" username : "+cl.getUsername()+" pwd : "+cl.getPassword()+" first name : "+cl.getFirst_name()+" last name : "+cl.getLast_name()+" adress : "+cl.getAddress()+" phone : "+cl.getPhone()+" mail :"+cl.getMail());
        }
        return list;
    }
   
// public void displayClientUsername(String username) throws SQLException {
//        ResultSet res = ste.executeQuery("select * from client where username='"+username+"'");
//        Client cl = null;
//            cl = new Client(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getInt(7), res.getString(8));
//            System.out.println("id client : "+cl.getClient_id()+" username : "+cl.getUsername()+" pwd : "+cl.getPassword()+" first name : "+cl.getFirst_name()+" last name : "+cl.getLast_name()+" adress : "+cl.getAdress()+" phone : "+cl.getPhone()+" mail :"+cl.getMail());
//   
//            
//    }
 public List<Client> displayClient2(String username) throws SQLException {
        List<Client> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from client where username='"+username+"'");
        Client cl = null;
        while (res.next()) {
            cl = new Client(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getInt(7), res.getString(8));
//            System.out.println("id client : "+cl.getClient_id()+" username : "+cl.getUsername()+" pwd : "+cl.getPassword()+" first name : "+cl.getFirst_name()+" last name : "+cl.getLast_name()+" adress : "+cl.getAdress()+" phone : "+cl.getPhone()+" mail :"+cl.getMail());
            list.add(cl);
        }
        return list;
    }
public String getnameClient (String usrname) throws SQLException{
     
        ResultSet res = ste.executeQuery("select first_name,last_name from client where username= "+usrname);
        String c1,c2,c3 = null;
           while(res.next()){
            c1 = res.getString("first_name");
            c2= res.getString("last_name");
            c3=c1+c2;}
          return c3;  
}
    public void ajouterClient(Client c) throws SQLException{
    String requete = "INSERT INTO `client` (`client_id`,`username`,`password`, `first_name`, `last_name`,`address`,`phone`,`mail`,`fidelity_pt`,`image`)"+" VALUES (NULL, '"+c.getUsername()+"', '"+c.getPassword()+"', '"+c.getFirst_name()+"', '"+c.getLast_name()+"', '"+c.getAddress()+"', '"+c.getPhone()+"', '"+c.getMail()+"', '"+c.getFidelity_pt()+"', '"+c.getImage()+"');";
ste.executeUpdate(requete);
        System.out.println("elment inste");
    }
    
    public void deleteClient(int client_id) throws SQLException{
        String requete="DELETE FROM client WHERE client_id='"+client_id+"'";
        ste.executeUpdate(requete);
    }
    
    public void updateClient(int client_id, String username, String password, String first_name, String last_name, String city, int phone, String mail,int fidelity_pt,String image) throws SQLException {
        String requete = "UPDATE client SET `username`='" + username + "',`password`='" + password + "',`first_name`='" + first_name + "',`last_name`='" + last_name + "',`address`='" + city + "',`phone`='" + phone + "',`mail`='" + mail + "',`fidelity_pt`='"+fidelity_pt+"',`image`='"+image+"' WHERE client_id='" + client_id + "'";
        ste.executeUpdate(requete);

    }
    
    public boolean isAuthenticated(String username,String pwd) throws SQLException {
        List<Client> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from client ");
        Client cl = null;
           while (res.next()) {
            cl = new Client( res.getString(2), res.getString(3));
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
    
    public List<Client> readAll() throws SQLException
    {List<Client> list=new ArrayList<>();
    ResultSet res=ste.executeQuery("select * from client");
    Client per=null;
    while (res.next()) {            
      per=new Client(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getInt(7),res.getString(8),res.getInt(9),res.getString(10));
      list.add(per);
        }
    return list;
    } 
    
     public List<Client> readAll2(String username) throws SQLException
    {List<Client> list=new ArrayList<>();
    ResultSet res=ste.executeQuery("select * from client where username='"+username+"'");
    Client per=null;
    while (res.next()) {            
      per=new Client(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getInt(7),res.getString(8),res.getInt(9),res.getString(10));
      list.add(per);
        }
    return list;
    } 
     
     public void delClient(String username) throws SQLException{
        String requete="DELETE FROM client WHERE username='"+username+"'";
        ste.executeUpdate(requete);
    }
     
     public List<Client> getdata(String username) throws SQLException{
             List<Client> list=new ArrayList<>();
            // client c = new client();
             ResultSet res=ste.executeQuery("select * from client where username='"+username+"'");
                 Client c=null;

             while(res.next()){
            //  c=new client(res.getString(3),res.getString(4)),res.getString(5),res.getString(6),res.getInt(7),res.getString(8)); 
                   c=new Client(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getInt(7),res.getString(8),res.getInt(9),res.getString(10));


              
             
             list.add(c);
             
             }
          return list;
             
          }
     
     
     public void upClient(String username,Client c) throws SQLException {
        String requete = "UPDATE client SET `password`='" + c.getPassword() + "',`first_name`='" + c.getFirst_name() + "',`last_name`='" + c.getLast_name() + "',`address`='" + c.getAddress() + "',`phone`='" + c.getPhone() + "',`mail`='" + c.getMail() + "' WHERE username='" + username+ "'";
        ste.executeUpdate(requete);}
    
 
}
