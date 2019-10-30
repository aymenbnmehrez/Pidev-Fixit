/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author aymen
 */
public class Pclaim {
     private int Id_claimP;
    private int Id_provider;
     private String description;

    public Pclaim( String description) {
       
        this.description = description;
    }

    public Pclaim() {
    }

     
    public int getId_claimP() {
        return Id_claimP;
    }

    public void setId_claimP(int Id_claimP) {
        this.Id_claimP = Id_claimP;
    }

    public int getId_provider() {
        return Id_provider;
    }

    public void setId_provider(int Id_provider) {
        this.Id_provider = Id_provider;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Pclaim{" + "Id_claimP=" + Id_claimP + ", Id_provider=" + Id_provider + ", description=" + description + '}';
    }

    
}
