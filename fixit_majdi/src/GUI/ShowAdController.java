/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DataBase.DataBase;
import Entity.Ad;
import Entity.Ads;
import Service.*;
import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import static java.sql.Types.NULL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ShowAdController implements Initializable {

    private Connection con;
    int x = NULL;
    @FXML
    private TableView<Ad> TableAd;
    @FXML
    private TableColumn<Ad, String> C_title;
    @FXML
    private TableColumn<Ad, Date> C_availability;
    @FXML
    private TableColumn<Ad, Timestamp> C_published;
    @FXML
    private Button btnBackHomeClient;
    @FXML
    private Label tf_titre;
    @FXML
    private Label tf_firstName;
    @FXML
    private Label tf_lastName;
    @FXML
    private Label tf_addr;
    @FXML
    private Label tf_availability;
    @FXML
    private Label tf_phone;
    @FXML
    private Label tf_mail;
    @FXML
    private Label tf_rate;
    @FXML
    private Label tf_publishedAt;
    @FXML
    private Label txt_Titre;
    @FXML
    private Label txt_firstName;
    @FXML
    private Label txt_lastName;
    @FXML
    private Label txt_addr;
    @FXML
    private Label txt_availability;
    @FXML
    private Label txt_phone;
    @FXML
    private Label txt_mail;
    @FXML
    private Label txt_rate;
    @FXML
    private Label txt_publishedAt;
    @FXML
    private ImageView image_ad;
    @FXML
    private TableColumn<Ad, String> C_description;
    @FXML
    private TextField searchInput;
    @FXML
    private TextArea tf_description;
    @FXML
    private Label txt_rate1;
   
    

    public ShowAdController() {
        con = (Connection) DataBase.getInstance().getConnection();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ServiceAd s = new ServiceAd();

        ArrayList<Ad> ads;
        try {
            ads = (ArrayList<Ad>) s.readAll();
            ObservableList<Ad> data = FXCollections.observableArrayList(ads);
            C_title.setCellValueFactory(new PropertyValueFactory<>("ad_name"));
            C_availability.setCellValueFactory(new PropertyValueFactory<>("availability"));
            C_description.setCellValueFactory(new PropertyValueFactory<>("description"));
            C_published.setCellValueFactory(new PropertyValueFactory<>("published_at"));
            TableAd.setItems(data);
        } catch (SQLException ex) {
            Logger.getLogger(ShowAdController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void backHomeClient(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
//
//    private void refreshShowAd(ActionEvent event) {
//
//        ServiceAd s = new ServiceAd();
//
//        ArrayList<Ad> ads;
//        try {
//            ads = (ArrayList<Ad>) s.readAll();
//            ObservableList<Ad> data = FXCollections.observableArrayList(ads);
//            C_title.setCellValueFactory(new PropertyValueFactory<>("ad_name"));
//            C_availability.setCellValueFactory(new PropertyValueFactory<>("availability"));
//            C_description.setCellValueFactory(new PropertyValueFactory<>("description"));
//            C_published.setCellValueFactory(new PropertyValueFactory<>("published_at"));
//            TableAd.setItems(data);
//        } catch (SQLException ex) {
//            Logger.getLogger(ShowAdController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    @FXML
    private void select_ad(MouseEvent event) throws SQLException {
        ServiceAd s = new ServiceAd();
        Ad ads = TableAd.getSelectionModel().getSelectedItem();
        if (TableAd.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Alert!");
            alert.setContentText("you have to select an Ad for more details ! !");
            alert.showAndWait();
        } else {
            int id = ads.getAd_id();
            ads = s.getAdById(id);
            tf_titre.setText(ads.getAd_name());
            SimpleDateFormat dateFormater;
            dateFormater = new SimpleDateFormat("yyyy-MM-dd");
            tf_availability.setText(dateFormater.format(ads.getAvailability()));
            tf_description.setText(ads.getDescription());
            tf_publishedAt.setText(ads.getPublished_at().toString());
            tf_firstName.setText(ads.getFirst_name());
            tf_lastName.setText(ads.getLast_name());
            tf_addr.setText(ads.getCity());
            tf_phone.setText(String.valueOf(ads.getPhone()));
            tf_mail.setText(ads.getMail());
            tf_rate.setText(String.valueOf(ads.getRating()));
            
            this.x = id;
            

            String req = "select image from ad where ad_id=" + id;
            try {
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(req);
                if (rs.next()) {
                    String title = rs.getString("image");
                    System.out.println(title);

                    Image image = new Image("file:C:/wamp64/www/imageAd/" + title);
                     image_ad.setImage(image);
                    /*ImageView view = new ImageView();
                   
                    Stage imageShow = new Stage();

                    Group root = new Group();
                    Scene scene = new Scene(root);
                    HBox box = new HBox();
                    box.getChildren().setAll(view);
                    root.getChildren().setAll(box);

                    imageShow.setTitle("Ad Image");
                    imageShow.setHeight(500.0);
                    imageShow.setWidth(350.0);
                    imageShow.centerOnScreen();
                    imageShow.setScene(scene);
                    imageShow.showAndWait();*/
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    @FXML
    private void searchTable(KeyEvent event) throws SQLException {
        String s= searchInput.getText();
        ObservableList<Ad> data = null;
        data = FXCollections.observableArrayList(new ServiceAd().filtrerAd(s));
            C_title.setCellValueFactory(new PropertyValueFactory<>("ad_name"));
            C_availability.setCellValueFactory(new PropertyValueFactory<>("availability"));
            C_description.setCellValueFactory(new PropertyValueFactory<>("description"));
            C_published.setCellValueFactory(new PropertyValueFactory<>("published_at"));
            TableAd.setItems(data);
    }

}
