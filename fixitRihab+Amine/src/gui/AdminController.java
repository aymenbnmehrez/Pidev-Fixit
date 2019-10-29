/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entity.Client;
import Entity.Provider;
import Entity.Service;
import Service.ServiceClient;
import Service.ServiceProvider;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.converter.IntegerStringConverter;

/**
 * FXML Controller class
 *
 * @author Koala girl
 */
public class AdminController implements Initializable {

    @FXML
    private JFXButton ServicesBtn;
    @FXML
    private Pane Claims;
    @FXML
    private JFXButton ProvidersListBtn;
    @FXML
    private JFXButton ClientListBtn;
    @FXML
    private AnchorPane pn_all;
    @FXML
    private Pane Clients_pn;
    @FXML
    private Pane Jobbers_pn;
    @FXML
    private TableView<Provider> providerList;
    @FXML
    private TableColumn<Provider, String> pfirst_name;
    @FXML
    private TableColumn<Provider, String> plast_name;
    @FXML
    private TableColumn<Provider, String> padd;
    @FXML
    private TableColumn<Provider, Integer> pphone;
    @FXML
    private TableColumn<Provider, String> pexp;
    @FXML
    private TableColumn<Provider, Integer> pconfirm;
    @FXML
    private JFXButton btn_deleteRequest;
    @FXML
    private JFXButton AcceptRequest;
    @FXML
    private Pane Services;
    @FXML
    private TableView<Service> TableServices;
    @FXML
    private TableColumn<Service, String> ServiceName;
    @FXML
    private TableColumn<Service, String> Category;
    @FXML
    private TableColumn<Service, String> Pictures;
    @FXML
    private JFXButton btn_deleteService;
    @FXML
    private JFXButton btn_editService;
    @FXML
    private JFXButton btn_addService;
    @FXML
    private Label name;
    @FXML
    private TableView<Client> clientList;
    @FXML
    private TableColumn<Client, String> cfirst_name;
    @FXML
    private TableColumn<Client, String> clast_name;
    @FXML
    private TableColumn<Client, String> cadd;
    @FXML
    private TableColumn<Client, Integer> cphone;
    @FXML
    private JFXButton ClaimsBtn;
    @FXML
    private TableColumn<?, ?> PclaimsColumn;
    @FXML
    private TableColumn<?, ?> ProvidersColumn;
    @FXML
    private TableColumn<?, ?> CClaimColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         cfirst_name.setCellFactory(TextFieldTableCell.forTableColumn());
    clast_name.setCellFactory(TextFieldTableCell.forTableColumn());
    cadd.setCellFactory(TextFieldTableCell.forTableColumn());
    cphone.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    initColumns();
    loadData();
    
    pfirst_name.setCellFactory(TextFieldTableCell.forTableColumn());
    plast_name.setCellFactory(TextFieldTableCell.forTableColumn());
    padd.setCellFactory(TextFieldTableCell.forTableColumn());
    pphone.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    pconfirm.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    pexp.setCellFactory(TextFieldTableCell.forTableColumn());


    pinitColumns();
    ploadData();
    }    

    @FXML
    private void handleButtonAction(ActionEvent event) {
         if (event.getSource() == ClaimsBtn) {
            Claims.toFront();
        } else if (event.getSource() == ClientListBtn) {
            Clients_pn.toFront();
        } else if (event.getSource() == ProvidersListBtn) {
            Jobbers_pn.toFront();
        }
         else if (event.getSource() == ServicesBtn) {
            Services.toFront();
        }
    }

    @FXML
    private void deleteAskService(ActionEvent event) {
    }


    @FXML
    private void openEditAskService(ActionEvent event) {
    }
   private void initColumns() {

        cfirst_name.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        clast_name.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        cphone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        cadd.setCellValueFactory(new PropertyValueFactory<>("address"));
    }
    
    private void pinitColumns() {

        pfirst_name.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        plast_name.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        pphone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        padd.setCellValueFactory(new PropertyValueFactory<>("address"));
        pconfirm.setCellValueFactory(new PropertyValueFactory<>("confirmation"));
        pexp.setCellValueFactory(new PropertyValueFactory<>("experience"));


    }
    
    private void loadData() {
         ObservableList<Client> data = null;
        try {
            data = FXCollections.observableArrayList(new ServiceClient().readAll());
        } catch (SQLException e) {
            e.printStackTrace();
        
        }clientList.setItems(data);
    }
    
    private void ploadData() {
         ObservableList<Provider> info = null;
        try {
            info = FXCollections.observableArrayList(new ServiceProvider().readAll());
        } catch (SQLException e) {
            e.printStackTrace();
        
        }providerList.setItems(info);
    }
    
    @FXML
    private void ConfirmProvider(ActionEvent event) {
        Provider s = providerList.getSelectionModel().getSelectedItem();
    ServiceProvider sf = new ServiceProvider();
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
        Provider s = providerList.getSelectionModel().getSelectedItem();
    ServiceProvider sf = new ServiceProvider();
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
        Client s = clientList.getSelectionModel().getSelectedItem();
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
}}
