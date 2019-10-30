/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import javafx.collections.ObservableList;

/**
 *
 * @author aymen
 */
public class Category {
    private int category_id;
    private String name;
    private String description;
    private String picture_category;
    public static ObservableList<Category> observableListLocataire;
    

    public Category() {
    }

    public Category(int category_id, String name, String description) {
        this.category_id = category_id;
        this.name = name;
        this.description = description;
        this.picture_category = picture_category;
    }

    public int getCategory_id() {
        return category_id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
