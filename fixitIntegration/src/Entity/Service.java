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
public class Service {
    private int service_id;
    private int category_id;
    private String name;
    private String categoryName;
    private String picture_category;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Service(int service_id, int category_id, String name, String categoryName, String picture_category) {
        this.service_id = service_id;
        this.category_id = category_id;
        this.name = name;
        this.categoryName = categoryName;
        this.picture_category = picture_category;
    }

    public Service(int category_id, String name, String categoryName, String picture_category) {
        this.category_id = category_id;
        this.name = name;
        this.categoryName = categoryName;
        this.picture_category = picture_category;
    }

    public Service(int service_id, String name, String categoryName) {
        this.service_id = service_id;
        this.name = name;
        this.categoryName = categoryName;
    }

    public String getPicture_category() {
        return picture_category;
    }

    public void setPicture_category(String picture_category) {
        this.picture_category = picture_category;
    }

    public Service(int category_id, String name) {
        this.category_id = category_id;
        this.name = name;
    }
    

    public Service(int service_id, int category_id, String name) {
        this.service_id = service_id;
        this.category_id = category_id;
        this.name = name;
    }

    public int getService_id() {
        return service_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public String getName() {
        return name;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public Service() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public Service(String name) {
        this.name = name;
    }
    
    
}
