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
public class ClientJoinServiceJoinAskService {
    private String clientFirstName;
    private String clientLastName;
    private String serviceName;
    private java.sql.Date dateAskService;
    private String startedAt;
    private int price;
    private int idAskService;
    private String statusAskService;
    private String descriptionAskService;

    public String getClientFirstName() {
        return clientFirstName;
    }

    public String getClientLastName() {
        return clientLastName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public Date getDateAskService() {
        return dateAskService;
    }

    public String getStartedAt() {
        return startedAt;
    }

    public int getPrice() {
        return price;
    }

    public int getIdAskService() {
        return idAskService;
    }

    public void setClientFirstName(String clientFirstName) {
        this.clientFirstName = clientFirstName;
    }

    public void setClientLastName(String clientLastName) {
        this.clientLastName = clientLastName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public void setDateAskService(Date dateAskService) {
        this.dateAskService = dateAskService;
    }

    public void setStartedAt(String startedAt) {
        this.startedAt = startedAt;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setIdAskService(int idAskService) {
        this.idAskService = idAskService;
    }

    public void setStatusAskService(String statusAskService) {
        this.statusAskService = statusAskService;
    }

    public void setDescriptionAskService(String descriptionAskService) {
        this.descriptionAskService = descriptionAskService;
    }

    public String getStatusAskService() {
        return statusAskService;
    }

    public String getDescriptionAskService() {
        return descriptionAskService;
    }

    public ClientJoinServiceJoinAskService() {
    }

    public ClientJoinServiceJoinAskService(String clientFirstName, String clientLastName, String serviceName, Date dateAskService, String startedAt, int price, int idAskService) {
        this.clientFirstName = clientFirstName;
        this.clientLastName = clientLastName;
        this.serviceName = serviceName;
        this.dateAskService = dateAskService;
        this.startedAt = startedAt;
        this.price = price;
        this.idAskService = idAskService;
    }

    public ClientJoinServiceJoinAskService(String clientFirstName, String clientLastName, String serviceName, Date dateAskService, String startedAt, int price, int idAskService, String statusAskService, String descriptionAskService) {
        this.clientFirstName = clientFirstName;
        this.clientLastName = clientLastName;
        this.serviceName = serviceName;
        this.dateAskService = dateAskService;
        this.startedAt = startedAt;
        this.price = price;
        this.idAskService = idAskService;
        this.statusAskService = statusAskService;
        this.descriptionAskService = descriptionAskService;
    }
    
    
}
