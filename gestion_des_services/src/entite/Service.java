/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.sql.Statement;
import java.util.List;
import service.*;

/**
 *
 * @author asus
 */
public class Service {
    private int Id_service,Id_category;
    private String name_service; 
    private String name_category;
    private String picture_category;
    private String description_category;

    public Service(int Id_service, String name_service, String name_category, String picture_category) {
        this.Id_service = Id_service;
        this.name_service = name_service;
        this.name_category = name_category;
        this.picture_category = picture_category;
    }
    
    
    public Service(String name_service, int Id_category, String picture_category) {
        this.name_service = name_service;
        this.Id_category = Id_category;
        this.picture_category = picture_category;
    }

    public Service(int Id_service, int Id_category, String name_service, String name_category, String picture_category) {
        this.Id_service = Id_service;
        this.Id_category = Id_category;
        this.name_service = name_service;
        this.name_category = name_category;
        this.picture_category = picture_category;
        this.description_category = description_category;
    

    
    }
 public Service(int Id_service, String name_service, int Id_category) {
        this.Id_service = Id_service;
        this.name_service = name_service;
        this.Id_category = Id_category;}
 
   
    
    public Service() {
    }

    public Service(int Id_service) {
        this.Id_service = Id_service;
    }

    @Override
    public String toString() {
        return "Service{" + "Id_service=" + Id_service + ", Id_category=" + Id_category + ", name_service=" + name_service + '}';
    }

    public int getId_service() {
        return Id_service;
    }

    public void setId_service(int Id_service) {
        this.Id_service = Id_service;
    }

    public int getId_category() {
        return Id_category;
    }

    public void setId_category(int Id_category) {
        this.Id_category = Id_category;
    }

    public String getName_service() {
        return name_service;
    }

    public void setName_service(String name_service) {
        this.name_service = name_service;
    }

    public Service(int Id_service, int Id_category) {
        this.Id_service = Id_service;
        this.Id_category = Id_category;
    }
    
    public Service(int Id_service, int Id_category, String name_service) {
        this.Id_service = Id_service;
        this.Id_category = Id_category;
        this.name_service = name_service;
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
     public Service(int Id_category, String name_service) {
        this.Id_category = Id_category;
        this.name_service = name_service;
    }  

   
    }
     


