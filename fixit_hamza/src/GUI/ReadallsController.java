/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import entite.Service;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
import service.ServiceFixit;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class ReadallsController implements Initializable {

    @FXML
    private TableView<Service> allservice;
    @FXML
    private TableColumn<Service, Integer> allid;
    @FXML
    private TableColumn<Service, Integer> allcategory;
    @FXML
    private TableColumn<Service, String> allname;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                
             allid.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
                allcategory.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
               allname.setCellFactory(TextFieldTableCell.forTableColumn());
                initColumns();
                loadData();
        // TODO
        
    }    

    private void initColumns() {

        allid.setCellValueFactory(new PropertyValueFactory<>("Id_service"));
        allcategory.setCellValueFactory(new PropertyValueFactory<>("Id_category"));
        allname.setCellValueFactory(new PropertyValueFactory<>("name_service"));

    }

    private void loadData() {
         ObservableList<Service> data = null;
        try {
            data = FXCollections.observableArrayList(new ServiceFixit().readAll());
        } catch (SQLException e) {
            e.printStackTrace();
        
        }allservice.setItems(data);
    }

   /* private void AddService(KeyEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("../GUI/addservice.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }*/

    @FXML
    private void AddService(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("../GUI/addservice.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

   /* @FXML
    private void modsuppService(KeyEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("../GUI/update.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    } */

    @FXML
    private void DeleteService(ActionEvent event) {
        Service s = allservice.getSelectionModel().getSelectedItem();
    ServiceFixit sf = new ServiceFixit();
    int Id_service = s.getId_service();
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Boîte de dialogue de confirmation");
            alert.setHeaderText(null);
            alert.setContentText("Êtes-vous sûr de vouloir supprimer"+s.getName_service());
            Optional<ButtonType> action = alert.showAndWait();
            if (action.get() == ButtonType.OK) {
                sf.deleteService(Id_service);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
          loadData();
    }
    
}
