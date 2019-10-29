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
    private boolean isconfirmed;
    private boolean isnotconfirmed;
    private boolean  iscanceled;
    private boolean  isfinished;
    private String started_at;



    public boolean isIsconfirmed() {
        return isconfirmed;
    }

    public void setIsconfirmed(boolean isconfirmed) {
        this.isconfirmed = isconfirmed;
    }

    public void setIsnotconfimed(boolean isnotconfirmed) {
        this.isnotconfirmed = isnotconfirmed;
    }

    public AskService(int ask_service_id, int service_id, java.sql.Date date, String duration, String description, int client_id, boolean isconfirmed, boolean isnotconfirmed, boolean iscanceled, boolean isfinished) {
        this.ask_service_id = ask_service_id;
        this.service_id = service_id;
        this.date = date;
        this.duration = duration;
        this.description = description;
        this.client_id = client_id;
        this.isconfirmed = isconfirmed;
        this.isnotconfirmed = isnotconfirmed;
        this.iscanceled = iscanceled;
        this.isfinished = isfinished;
    }

    public AskService(int ask_service_id, java.sql.Date date, String duration, String description) {
        this.ask_service_id = ask_service_id;
        this.date = date;
        this.duration = duration;
        this.description = description;
    }
    public void setIscanceled(boolean iscanceled) {
        this.iscanceled = iscanceled;
    }

    public void setIsfinished(boolean isfinished) {
        this.isfinished = isfinished;
    }

    public boolean isIsnotconfirmed() {
        return isnotconfirmed;
    }

    public boolean isIscanceled() {
        return iscanceled;
    }

    public boolean isIsfinished() {
        return isfinished;
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

  

    public AskService(int ask_service_id, int service_id, java.sql.Date date, String duration, String description, int client_id) {
        this.ask_service_id = ask_service_id;
        this.service_id = service_id;
        this.date = date;
        this.duration = duration;
        this.description = description;
        this.client_id = client_id;
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

    public AskService(int ask_service_id, int service_id, java.sql.Date date, String duration, String description, int client_id, boolean isconfirmed, boolean isnotconfirmed, boolean iscanceled, boolean isfinished, String started_at) {
        this.ask_service_id = ask_service_id;
        this.service_id = service_id;
        this.date = date;
        this.duration = duration;
        this.description = description;
        this.client_id = client_id;
        this.isconfirmed = isconfirmed;
        this.isnotconfirmed = isnotconfirmed;
        this.iscanceled = iscanceled;
        this.isfinished = isfinished;
        this.started_at = started_at;
    }

    public AskService(java.sql.Date date, String duration, String description) {
        this.date = date;
        this.duration = duration;
        this.description = description;
    }

    public AskService(java.sql.Date date, boolean isconfirmed, boolean isnotconfirmed, boolean iscanceled, boolean isfinished) {
        this.date = date;
        this.isconfirmed = isconfirmed;
        this.isnotconfirmed = isnotconfirmed;
        this.iscanceled = iscanceled;
        this.isfinished = isfinished;
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

  
}
