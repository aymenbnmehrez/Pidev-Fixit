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
public class Cclaim {
    private int claim_id;
    private int client_id;
    private String description;

    public Cclaim() {
    }

    public Cclaim( String description) {
     
        this.description = description;
    }

    public int getClaim_id() {
        return claim_id;
    }

    public int getClient_id() {
        return client_id;
    }

    public String getDescription() {
        return description;
    }

    public void setClaim_id(int claim_id) {
        this.claim_id = claim_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Cclaim{" + "claim_id=" + claim_id + ", client_id=" + client_id + ", description=" + description + '}';
    }
    
}
