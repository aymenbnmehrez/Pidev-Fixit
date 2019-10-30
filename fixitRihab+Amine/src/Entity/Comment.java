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
public class Comment {
     private int Id_comment;
    private int client_id;
    private String description;

    public Comment(int client_id, String description) {
        this.client_id = client_id;
        this.description = description;
    }

    public Comment(String description) {
        this.description = description;
    }

    
    
    public int getId_comment() {
        return Id_comment;
    }

    public void setId_comment(int Id_comment) {
        this.Id_comment = Id_comment;
    }

    public int getId_client() {
        return client_id;
    }

    public void setId_client(int Id_client) {
        this.client_id = Id_client;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Comment{" + "Id_comment=" + Id_comment + ", Id_client=" + client_id + ", description=" + description + '}';
    }
    
    
    
}
