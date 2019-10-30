package Service;



import DataBase.*;
import java.sql.*;
import Entity.SponsoredAd;
public class ServiceSponsorship {
    
    private final Connection con=DataBase.getInstance().getConnection();
    
    private Statement ste;
    
    public ServiceSponsorship(){
    
        try {
            ste = con.createStatement();

        } catch (SQLException ex) {

            System.out.println(ex);
        }
    }
    
    public void createSponsoredAd(SponsoredAd ad) throws SQLException{
        String req="INSERT INTO `sponorad`(`sponoredAdId`, `providerid`, `adName`, `introText`, `adImage`, `destinationUrl`) VALUES (NULL,'"+ad.getsponsoredAdId()+"','"+ad.getsponsoredId()+"','"+ad.getadName()+"','"+ad.getadImage()+"','"+ad.getdestinationURL()+"');";
        ste.executeUpdate(req);
        System.out.println("sponsored ad inserted");
    }
    
    public void updateSponsoredAd(SponsoredAd ad , int id) throws SQLException{
        String req="UPDATE `sponorad` SET `adName`='"+ad.getadName()+"',`introText`='"+ad.getintroText()+"',`adImage`='"+ad.getadImage()+"',`destinationUrl`='"+ad.getdestinationURL()+"' WHERE `sponoredAdId`='"+id+"'";
        ste.executeUpdate(req);
    }
    
    public void removeSponsoredAd(int id) throws SQLException{
        String req="DELETE FROM `sponorad` WHERE `sponsoredAdId`="+id+";";
        ste.executeQuery(req);
    }
    
    }

