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
