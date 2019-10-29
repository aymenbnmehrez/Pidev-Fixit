/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import Entity.Provider;
/**
 *
 * @author asus
 */
public class CurrentProvider {
    
    public static int provider_id,like_nb,phone;
    public static String username ; 
    public static String first_name,last_name,city,mail,image;
    public static float rating;

    public CurrentProvider() {
    } 

    public CurrentProvider(Provider p) {
        provider_id=p.getProvider_id();
        username=p.getUsername();
        first_name=p.getFirst_name();
        last_name=p.getLast_name();
        city=p.getCity();
        phone=p.getPhone();
        mail=p.getMail();
        rating=p.getRating();
        image=p.getImage();
        like_nb=p.getLike_nb();

    }

    
}
