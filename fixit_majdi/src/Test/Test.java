package Test;

import Service.*;
import Entity.Ad;
import java.sql.*;

import java.text.*;
import java.util.Date;
import java.util.List;


public class Test {

    public static void main(String[] args) throws ParseException, SQLException {

          Date date=new Date();
          long time =date.getTime();
          java.sql.Timestamp ts=new Timestamp(time);
          
          
        //Ad ad1 = new Ad(2,"annonce de bricolage", "25-06-2020", "test description",ts,"image1.jpg");
       // Ad ad4 = new Ad(8,"annonce de informatique", "03-11-2019", "test description3",ts,"image4.jpg");


        ServiceAd s = new ServiceAd();
//        try {
//          s.createAd(ad1);
//          s.createAd(ad4);
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }

        List<Ad> list1 = null;

        try {
            list1 = s.readAll();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        System.out.println(list1);

        //  s.deleteAd(4);
//        try {
//            s.updateAd(8, sqlDate1);
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }

        list1 = s.readAll();
        System.out.println(list1);

    }
}
