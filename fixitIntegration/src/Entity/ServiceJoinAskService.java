/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Date;

/**
 *
 * @author aymen
 */
public class ServiceJoinAskService {

    private int askServiceId;
    private int clientId;
    private String nameService;
    private java.sql.Date dateAskService;
    private String startedAskService;
    private String status;

    public int getAskServiceId() {
        return askServiceId;
    }

    public int getClientId() {
        return clientId;
    }

    public String getNameService() {
        return nameService;
    }

    public String getStatus() {
        return status;
    }

    public Date getDateAskService() {
        return dateAskService;
    }

    public String getStartedAskService() {
        return startedAskService;
    }

   

    public void setAskServiceId(int askServiceId) {
        this.askServiceId = askServiceId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public void setDateAskService(Date dateAskService) {
        this.dateAskService = dateAskService;
    }

    public void setStartedAskService(String startedAskService) {
        this.startedAskService = startedAskService;
    }

 

    public ServiceJoinAskService() {
    }

    public ServiceJoinAskService(int askServiceId, String nameService, Date dateAskService, String startedAskService) {
        this.askServiceId = askServiceId;
        this.nameService = nameService;
        this.dateAskService = dateAskService;
        this.startedAskService = startedAskService;

    }

    public ServiceJoinAskService(String nameService, Date dateAskService, String startedAskService) {
        this.nameService = nameService;
        this.dateAskService = dateAskService;
        this.startedAskService = startedAskService;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ServiceJoinAskService(int askServiceId, int clientId, String nameService, Date dateAskService, String startedAskService, String status) {
        this.askServiceId = askServiceId;
        this.clientId = clientId;
        this.nameService = nameService;
        this.dateAskService = dateAskService;
        this.startedAskService = startedAskService;
        this.status = status;
    }

    public ServiceJoinAskService(int askServiceId, String nameService, Date dateAskService, String startedAskService, String status) {
        this.askServiceId = askServiceId;
        this.nameService = nameService;
        this.dateAskService = dateAskService;
        this.startedAskService = startedAskService;
        this.status = status;
    }

}
