/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entity.AskService;
import Entity.ClientJoinServiceJoinAskService;
import Service.ServiceAskService;
import Service.ServiceClientJoinServiceJoinAskService;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class ProviderController implements Initializable {

    private String username;
    @FXML
    private TableView<ClientJoinServiceJoinAskService> tableProvider;

    @FXML
    private TableColumn<ClientJoinServiceJoinAskService, String> cl_client;
    @FXML
    private TableColumn<ClientJoinServiceJoinAskService, String> cl_service;
    @FXML
    private TableColumn<ClientJoinServiceJoinAskService, java.sql.Date> cl_date;
    @FXML
    private TableColumn<ClientJoinServiceJoinAskService, String> cl_started_at;
    @FXML
    private TableColumn<ClientJoinServiceJoinAskService, Integer> cl_price;
    @FXML
    private JFXButton btn_search;
    @FXML
    private Pane pn_search;

    /**
     * Initializes the controller class.
     */
    public void setUser(String username) {

        this.username = username;

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        try {
//            displayTabProvider();
//            // TODO
//        } catch (SQLException ex) {
//            Logger.getLogger(ProviderController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    @FXML
    public void handleButtonAction(ActionEvent event) throws SQLException {

        if (event.getSource() == btn_search) {
            displayTabProvider();
            pn_search.toFront();
        }

    }

    public void displayTabProvider() throws SQLException {
        ServiceClientJoinServiceJoinAskService scsa = new ServiceClientJoinServiceJoinAskService();
        ArrayList list = (ArrayList) scsa.getDataTabProvider();
        ObservableList<ClientJoinServiceJoinAskService> data = FXCollections.observableArrayList(list);
        
        cl_client.setCellValueFactory(cellData -> Bindings.createStringBinding(
                () -> cellData.getValue().getClientFirstName()+ " " + cellData.getValue().getClientLastName()));
        cl_service.setCellValueFactory(new PropertyValueFactory<>("serviceName"));
        cl_date.setCellValueFactory(new PropertyValueFactory<>("dateAskService"));
        cl_started_at.setCellValueFactory(new PropertyValueFactory<>("startedAt"));
        cl_price.setCellValueFactory(new PropertyValueFactory<>(("price").toString()));
        // cl_id.setCellValueFactory(new PropertyValueFactory<>("ask_service_id"));
        tableProvider.setItems(data);

    }
    public void confirmAskService(ActionEvent event) throws SQLException{
        ServiceAskService sa = new ServiceAskService();
        if(!tableProvider.getSelectionModel().isEmpty()){
            sa.confirmAskService(tableProvider.getSelectionModel().getSelectedItem().getIdAskService());
              }
    }
}
