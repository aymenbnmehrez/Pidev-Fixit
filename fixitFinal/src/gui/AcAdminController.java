/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import ENTITE.Service;
import ENTITE.client;
import ENTITE.provider;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;
import service.ServiceClient;
import service.serviceProvider;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class AcAdminController implements Initializable {
    
     @FXML
    private TableView<client> clientList;
    @FXML
    private TableColumn<client, Integer> cphone;
    @FXML
    private TableColumn<client, String> cfirst_name;  
    @FXML
    private TableColumn<client, String> clast_name;  
    @FXML
    private TableColumn<client, String> ccity;
    
    @FXML
    private TableView<provider> providerList;
    @FXML
    private TableColumn<provider, Integer> pphone;
    @FXML
    private TableColumn<provider, String> pfirst_name;  
    @FXML
    private TableColumn<provider, String> plast_name;  
    @FXML
    private TableColumn<provider, String> pcity;  
    @FXML
    private TableColumn<provider, Integer> pconfirm;
    @FXML
    private TableColumn<provider, String> pexp;
     

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    cfirst_name.setCellFactory(TextFieldTableCell.forTableColumn());
    clast_name.setCellFactory(TextFieldTableCell.forTableColumn());
    ccity.setCellFactory(TextFieldTableCell.forTableColumn());
    cphone.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    initColumns();
    loadData();
    
    pfirst_name.setCellFactory(TextFieldTableCell.forTableColumn());
    plast_name.setCellFactory(TextFieldTableCell.forTableColumn());
    pcity.setCellFactory(TextFieldTableCell.forTableColumn());
    pphone.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    pconfirm.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    pexp.setCellFactory(TextFieldTableCell.forTableColumn());


    pinitColumns();
    ploadData();
    
    }  
    
    private void initColumns() {

        cfirst_name.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        clast_name.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        cphone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        ccity.setCellValueFactory(new PropertyValueFactory<>("city"));
    }
    
    private void pinitColumns() {

        pfirst_name.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        plast_name.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        pphone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        pcity.setCellValueFactory(new PropertyValueFactory<>("city"));
        pconfirm.setCellValueFactory(new PropertyValueFactory<>("confirmation"));
        pexp.setCellValueFactory(new PropertyValueFactory<>("experience"));


    }
    
    private void loadData() {
         ObservableList<client> data = null;
        try {
            data = FXCollections.observableArrayList(new ServiceClient().readAll());
        } catch (SQLException e) {
            e.printStackTrace();
        
        }clientList.setItems(data);
    }
    
    private void ploadData() {
         ObservableList<provider> info = null;
        try {
            info = FXCollections.observableArrayList(new serviceProvider().readAll());
        } catch (SQLException e) {
            e.printStackTrace();
        
        }providerList.setItems(info);
    }
    
    @FXML
    private void ConfirmProvider(ActionEvent event) {
        provider s = providerList.getSelectionModel().getSelectedItem();
    serviceProvider sf = new serviceProvider();
    String username = s.getUsername();
        try {
           {
                sf.confirm(username);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
          ploadData();
    }
    
    
    @FXML
    private void deleteProvider(ActionEvent event) {
        provider s = providerList.getSelectionModel().getSelectedItem();
    serviceProvider sf = new serviceProvider();
    String username = s.getUsername();
        try {
           {
        sf.delProvider(username);                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
          ploadData();
    }

     @FXML
    private void deleteClient(ActionEvent event) {
        client s = clientList.getSelectionModel().getSelectedItem();
    ServiceClient sf = new ServiceClient();
    String username = s.getUsername();
        try {
           {
        sf.delClient(username);                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
          loadData();
    }







}
    
  
