/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

/**
 *
 * @author asus
 */
public class Category {
    private int Id_category;

    public Category() {
    }
    private String name_category,picture_category;
    private String description_category; 

    @Override
    public String toString() {
        return "Category{" + "Id_category=" + Id_category + ", name_category=" + name_category + ", picture_category=" + picture_category + ", description_category=" + description_category + '}';
    }

    public int getId_category() {
        return Id_category;
    }

    public void setId_category(int Id_category) {
        this.Id_category = Id_category;
    }

    public String getName_category() {
        return name_category;
    }

    public void setName_category(String name_category) {
        this.name_category = name_category;
    }

    public String getPicture_category() {
        return picture_category;
    }

    public void setPicture_category(String picture_category) {
        this.picture_category = picture_category;
    }

    public String getDescription_category() {
        return description_category;
    }

    public void setDescription_category(String description_category) {
        this.description_category = description_category;
    }

    public Category(int Id_category, String name_category, String picture_category) {
        this.Id_category = Id_category;
        this.name_category = name_category;
        this.picture_category = picture_category;
    }

    public Category(int Id_category, String name_category, String picture_category, String description_category) {
        this.Id_category = Id_category;
        this.name_category = name_category;
        this.picture_category = picture_category;
        this.description_category = description_category;
    }

    

   

   
    }
    
    
    

