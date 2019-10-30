/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

/**
 *
 * @author aymen
 */
public class AskService {
    private int ask_service_id;
    private int service_id;
    private java.sql.Date date;
    private String duration;
    private String description;
    private int client_id;
    private String started_at;
    private String status;
    private int price;



   

    public AskService(int ask_service_id, int service_id, java.sql.Date date, String duration, String description, int client_id) {
        this.ask_service_id = ask_service_id;
        this.service_id = service_id;
        this.date = date;
        this.duration = duration;
        this.description = description;
        this.client_id = client_id;

    }

    public AskService(int ask_service_id, java.sql.Date date, String duration, String description) {
        this.ask_service_id = ask_service_id;
        this.date = date;
        this.duration = duration;
        this.description = description;
    }
  

    public void setAsk_service_id(int ask_service_id) {
        this.ask_service_id = ask_service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public AskService(int service_id, Date date, String duration, String description, String started_at) {
        this.service_id = service_id;
        this.date = date;
        this.duration = duration;
        this.description = description;
        this.started_at = started_at;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

 

    public int getAsk_service_id() {
        return ask_service_id;
    }

    public int getService_id() {
        return service_id;
    }

    public java.sql.Date getDate() {
        return date;
    }

    public String getDuration() {
        return duration;
    }

    public String getDescription() {
        return description;
    }

    public int getClient_id() {
        return client_id;
    }

  

  

    public String getStarted_at() {
        return started_at;
    }

    public AskService(int service_id, java.sql.Date date, String duration, String description, int client_id, String started_at) {
        this.service_id = service_id;
        this.date = date;
        this.duration = duration;
        this.description = description;
        this.client_id = client_id;
        this.started_at = started_at;
    }

    public AskService(int ask_service_id, int service_id, java.sql.Date date, String duration, String description, int client_id, String started_at) {
        this.ask_service_id = ask_service_id;
        this.service_id = service_id;
        this.date = date;
        this.duration = duration;
        this.description = description;
        this.client_id = client_id;
        this.started_at = started_at;
    }

    public AskService(java.sql.Date date, String duration, String description) {
        this.date = date;
        this.duration = duration;
        this.description = description;
    }


    public void setStarted_at(String started_at) {
        this.started_at = started_at;
    }

    public AskService() {
    }

    public AskService(int service_id, String duration, String description, int client_id, String started_at) {
        this.service_id = service_id;
        this.duration = duration;
        this.description = description;
        this.client_id = client_id;
        this.started_at = started_at;
    }

    public String getStatus() {
        return status;
    }

    public AskService(int ask_service_id, int service_id, Date date, String duration, String description, int client_id, String started_at, String status) {
        this.ask_service_id = ask_service_id;
        this.service_id = service_id;
        this.date = date;
        this.duration = duration;
        this.description = description;
        this.client_id = client_id;
        this.started_at = started_at;
        this.status = status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public AskService(int ask_service_id, Date date, String duration, String description, String started_at, int price) {
        this.ask_service_id = ask_service_id;
        this.date = date;
        this.duration = duration;
        this.description = description;
        this.started_at = started_at;
        this.price = price;
    }

  
}
