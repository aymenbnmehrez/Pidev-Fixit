/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entity.Ad;
import Entity.AskService;
import Entity.ClientJoinServiceJoinAskService;

import Entity.Provider;
import static Gui.creatAdController.NOW_LOCAL_DATE;
import Service.ServiceAd;
import Service.ServiceAskService;
import Service.ServiceClientJoinServiceJoinAskService;
import Service.ServiceProvider;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.sun.javafx.beans.IDProperty;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.auth.AccessToken;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import static java.sql.Types.NULL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class ProviderController implements Initializable {

    private Facebook facebook;
    int x = NULL;
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
    @FXML
    private JFXButton btn_request;
    @FXML
    private JFXButton btn_My_ads;
    @FXML
    private AnchorPane pn_all;
    @FXML
    private JFXButton btn_confirm;
    @FXML
    private JFXTextField tf_filter;
    @FXML
    private JFXButton btn_delete;
    @FXML
    private Pane My_Ads;
    @FXML
    private TableView<Ad> table_ad_prov;
    @FXML
    private TableColumn<Ad, String> C_title;
    @FXML
    private TableColumn<Ad, Date> C_availability;
    @FXML
    private TableColumn<Ad, String> C_desc;
    @FXML
    private TableColumn<Ad, Timestamp> C_pubAt;
    @FXML
    private TextField tf_title;
    @FXML
    private DatePicker tf_avail;
    @FXML
    private TextArea txtArea_desc;
    @FXML
    private Button btn_conf_updating;
    @FXML
    private Button btn_addAd;
    @FXML
    private Button btn_updateAd;
    @FXML
    private Button btn_deleteAd;
    @FXML
    private Button btn_share;
    @FXML
    private Label verif_title;
    @FXML
    private Label verif_availability;
    private int idProvider;
    /**
     * Initializes the controller class.
     */
    public void setUser(String idProvider) {

        this.username = username;

    }
     public void setId(int idProvider) {

        this.idProvider = idProvider;

    }

    public int getProviderIdAthenticated() throws SQLException {
        ServiceProvider sevc = new ServiceProvider();       //getting client_id of the authentificated client
        List<Provider> listC = new ArrayList<>();
        listC = sevc.displayProvider(username);
        Provider c = listC.get(0);
        int idProvider = c.getProvider_id();
        return idProvider;

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
        } else if (event.getSource() == btn_My_ads) {
            displayMyAds();
            My_Ads.toFront();
        }

    }

    public void displayTabProvider() throws SQLException {
        ServiceClientJoinServiceJoinAskService scsa = new ServiceClientJoinServiceJoinAskService();
        ArrayList list = (ArrayList) scsa.getDataTabProvider();
        ObservableList<ClientJoinServiceJoinAskService> data = FXCollections.observableArrayList(list);

        cl_client.setCellValueFactory(cellData -> Bindings.createStringBinding(
                () -> cellData.getValue().getClientFirstName() + " " + cellData.getValue().getClientLastName()));
        cl_service.setCellValueFactory(new PropertyValueFactory<>("serviceName"));
        cl_date.setCellValueFactory(new PropertyValueFactory<>("dateAskService"));
        cl_started_at.setCellValueFactory(new PropertyValueFactory<>("startedAt"));
        cl_price.setCellValueFactory(new PropertyValueFactory<>(("price").toString()));
        // cl_id.setCellValueFactory(new PropertyValueFactory<>("ask_service_id"));
        tableProvider.setItems(data);

    }

    @FXML
    public void confirmAskService(ActionEvent event) throws SQLException {
        ServiceAskService sa = new ServiceAskService();
        if (!tableProvider.getSelectionModel().isEmpty()) {
            sa.confirmAskService(tableProvider.getSelectionModel().getSelectedItem().getIdAskService());
        }
    }

    @FXML
    private void confirm_updating(ActionEvent event) throws SQLException {
        if (tf_title.getText().isEmpty() || tf_avail.getValue() == null) {
            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Update an ad!");
            alert1.setContentText("you have to select an Ad !");
            alert1.showAndWait();
        } else {

            if (!validname(tf_title.getText())) {
                verif_title.setText("can't use numbers for title ");
            } else if (tf_avail.getValue().isBefore(NOW_LOCAL_DATE())) {
                verif_availability.setText("error chek your date !");
            } else {
                Ad ad = new Ad();
                ad.setAd_name(tf_title.getText());
                ad.setAvailability(Date.valueOf(tf_avail.getValue()));
                ad.setDescription(txtArea_desc.getText());
                ad.setAd_id(table_ad_prov.getSelectionModel().getSelectedItem().getAd_id());

                ServiceAd s = new ServiceAd();
                s.updateAd(table_ad_prov.getSelectionModel().getSelectedItem().getAd_id(), ad);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Update an ad!");
                alert.setContentText("Your Ad has been updated !");
                alert.showAndWait();
                displayMyAds();
                txtArea_desc.clear();
                tf_title.clear();
                tf_avail.setVisible(false);
                verif_availability.setVisible(false);
                verif_title.setVisible(false);
            }
        }
    }

    @FXML
    private void add_ad(ActionEvent event) throws IOException, SQLException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("CreatAd.fxml"));
        Parent root = loader.load();
        creatAdController controller = loader.<creatAdController>getController();
        controller.setId(idProvider);
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void update_ad(ActionEvent event) throws SQLException {
        if (table_ad_prov.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Update an ad!");
            alert.setContentText("you have to select an Ad !");
            alert.showAndWait();
        } else {

            tf_title.setText(table_ad_prov.getSelectionModel().getSelectedItem().getAd_name());
            tf_avail.setValue(table_ad_prov.getSelectionModel().getSelectedItem().getAvailability().toLocalDate());
            txtArea_desc.setText(table_ad_prov.getSelectionModel().getSelectedItem().getDescription());
        }
    }

    @FXML
    private void delete_ad(ActionEvent event) throws SQLException {
        if (!table_ad_prov.getSelectionModel().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Alert");
            alert.setContentText("Are you sure to delete this Ad ? ");
            Optional<ButtonType> action = alert.showAndWait();
            if (action.get() == ButtonType.OK) {
                ServiceAd s = new ServiceAd();
                s.deleteAd(table_ad_prov.getSelectionModel().getSelectedItem().getAd_id());

              displayMyAds();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Delete an ad!");
            alert.setContentText("you have to select an Ad !");
            alert.showAndWait();
        }
    }

    @FXML
    private void share_on(ActionEvent event) throws SQLException {
        if (!table_ad_prov.getSelectionModel().isEmpty()) {
            Ad ads = new Ad(table_ad_prov.getSelectionModel().getSelectedItem().getAd_name(),table_ad_prov.getSelectionModel().getSelectedItem().getAvailability(),table_ad_prov.getSelectionModel().getSelectedItem().getDescription());
     
            facebook = new FacebookFactory().getInstance();
            facebook.setOAuthAppId("", "");
            String accessTokenString = "EAANyeAN4F9QBAC4EoCHnPQ0D74nmAfiPoKDS5noryqYPLCTZBp1vhEXCoogaqkageEm3glPCOHIwi6vXXRZCa4C1bHR0OibwNzvofmvxp9uEH1iBkN2ov5cIZBZB6R3k2hku1zzZAMZATgWBqpTBmhrKQ6AO7csmIpeJUwd5aQKuZAHTnlLaV8LcRZAe0Vsb0jUZD";
            AccessToken accessToken = new AccessToken(accessTokenString);
            facebook.setOAuthAccessToken(accessToken);

            try {

                facebook.postStatusMessage(ads.getAd_name() + " is available in: " + ads.getAvailability() + "\n Description: " + ads.getDescription());

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Share on Facebook ");
                alert.setHeaderText(null);
                alert.setContentText("Ad  " + ads.getAd_name() + " has been shared on Facebook!");
                alert.showAndWait();
            } catch (FacebookException fex) {
                System.out.println(fex);
            }

        } else {
            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Share an ad!");
            alert1.setContentText("you have to select an Ad !");
            alert1.showAndWait();
        }
    }

    public void displayMyAds() {

        ServiceAd s = new ServiceAd();

        ArrayList<Ad> ads;
        try {
            ads = (ArrayList<Ad>) s.readAdById(idProvider);
            ObservableList<Ad> data = FXCollections.observableArrayList(ads);
            C_title.setCellValueFactory(new PropertyValueFactory<>("ad_name"));
            C_availability.setCellValueFactory(new PropertyValueFactory<>("availability"));
            C_desc.setCellValueFactory(new PropertyValueFactory<>("description"));
            C_pubAt.setCellValueFactory(new PropertyValueFactory<>("published_at"));
            table_ad_prov.setItems(data);
        } catch (SQLException ex) {
            Logger.getLogger(ProviderController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean validname(String name) throws SQLException {
        if (name.length() == 0) {
            return false;
        }

        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (!(((c >= 'a' && c <= 'z')) || ((c >= 'A' && c <= 'Z')) || (c == ' '))) {
                return false;
            }
        }
        return true;
    }
}
