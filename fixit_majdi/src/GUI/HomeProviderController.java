package GUI;

import Entity.Ad;
import Entity.CurrentProvider;
import Service.ServiceAd;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import static java.sql.Types.NULL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.auth.AccessToken;
/**
 * FXML Controller class
 *
 * @author asus
 */
public class HomeProviderController implements Initializable {

    private Facebook facebook;
    int x = NULL;
    @FXML
    private ImageView Home;
    @FXML
    private Label label_username_prov;
    @FXML
    private Button btn_logout;
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
    private Button btn_addAd;
    @FXML
    private Button btn_updateAd;
    @FXML
    private Button btn_deleteAd;
    @FXML
    private TextField tf_title;

    @FXML
    private TextArea txtArea_desc;
    @FXML
    private DatePicker tf_avail;
    @FXML
    private Button btn_conf_updating;
    @FXML
    private Label verif_title;
    @FXML
    private Label verif_availability;
    @FXML
    private Button btn_share;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        label_username_prov.setText(CurrentProvider.username);
        
        ServiceAd s = new ServiceAd();

        ArrayList<Ad> ads;
        try {
            ads = (ArrayList<Ad>) s.readAdById(CurrentProvider.provider_id);
            ObservableList<Ad> data = FXCollections.observableArrayList(ads);
            C_title.setCellValueFactory(new PropertyValueFactory<>("ad_name"));
            C_availability.setCellValueFactory(new PropertyValueFactory<>("availability"));
            C_desc.setCellValueFactory(new PropertyValueFactory<>("description"));
            C_pubAt.setCellValueFactory(new PropertyValueFactory<>("published_at"));
            table_ad_prov.setItems(data);
        } catch (SQLException ex) {
            Logger.getLogger(ShowAdController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void optionsClicked(MouseEvent event) {
    }

    @FXML
    private void NotifBClicked(MouseEvent event) {
    }

    @FXML
    private void MessageClicked(MouseEvent event) {
    }

    @FXML
    private void BackHome(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeProvider.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void log_out(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AutheProvider.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void add_ad(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CreatAd.fxml"));
        Parent root = loader.load();   
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void update_ad(ActionEvent event) throws SQLException {
        if (table_ad_prov.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Update an ad!");
            alert.setContentText("you have to select an Ad !");
            alert.showAndWait();
        } else {
            ServiceAd s = new ServiceAd();
            Ad ads = table_ad_prov.getSelectionModel().getSelectedItem();
            int id = ads.getAd_id();
            ads = s.getAdById(id);
            tf_title.setText(ads.getAd_name());
            SimpleDateFormat dateFormater;
            dateFormater = new SimpleDateFormat("yyyy-MM-dd");
            tf_avail.setValue(ads.getAvailability().toLocalDate());
            txtArea_desc.setText(ads.getDescription());
            this.x = id;
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

                ArrayList<Ad> ads;
                ads = (ArrayList<Ad>) s.readAdById(CurrentProvider.provider_id);
                ObservableList<Ad> data = FXCollections.observableArrayList(ads);
                C_title.setCellValueFactory(new PropertyValueFactory<>("ad_name"));
                C_availability.setCellValueFactory(new PropertyValueFactory<>("availability"));
                C_desc.setCellValueFactory(new PropertyValueFactory<>("description"));
                C_pubAt.setCellValueFactory(new PropertyValueFactory<>("published_at"));
                table_ad_prov.setItems(data);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Delete an ad!");
            alert.setContentText("you have to select an Ad !");
            alert.showAndWait();
        }

    }
    
    public static final LocalDate NOW_LOCAL_DATE (){
        String date = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(date , formatter);
        return localDate;}

    @FXML
    private void confirm_updating(ActionEvent event) throws ParseException, SQLException, InterruptedException {
         
         if(tf_title.getText().isEmpty() || tf_avail.getValue()==null){
         Alert alert1 = new Alert(Alert.AlertType.ERROR);
         alert1.setTitle("Update an ad!");
         alert1.setContentText("you have to select an Ad !");
         alert1.showAndWait();}
        
         else{
        
            if(!validname(tf_title.getText())){
               verif_title.setText("can't use numbers for title ");}
            
           else if(tf_avail.getValue().isBefore(NOW_LOCAL_DATE ())){
               verif_availability.setText("error chek your date !");}
            

            else{Ad ad = new Ad();
                ad.setAd_name(tf_title.getText());
                ad.setAvailability(Date.valueOf(tf_avail.getValue()));
                ad.setDescription(txtArea_desc.getText());
                ad.setAd_id(table_ad_prov.getSelectionModel().getSelectedItem().getAd_id());

                ServiceAd s=new ServiceAd();
                s.updateAd(x,ad);
       
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Update an ad!");
                alert.setContentText("Your Ad has been uploaded !");
                alert.showAndWait(); 
                ArrayList<Ad> ads;
                ads = (ArrayList<Ad>) s.readAdById(CurrentProvider.provider_id);
                ObservableList<Ad> data = FXCollections.observableArrayList(ads);
                C_title.setCellValueFactory(new PropertyValueFactory<>("ad_name"));
                C_availability.setCellValueFactory(new PropertyValueFactory<>("availability"));
                C_desc.setCellValueFactory(new PropertyValueFactory<>("description"));
                C_pubAt.setCellValueFactory(new PropertyValueFactory<>("published_at"));
                table_ad_prov.setItems(data);
                tf_title.clear();
                tf_avail.setValue(null);
                txtArea_desc.clear();
                verif_availability.setVisible(false);
                verif_title.setVisible(false);
        }}
      

        }

    @FXML
    private void search_ad_provider(KeyEvent event) {
    }

    @FXML
    private void share_on(ActionEvent event) throws FacebookException, SQLException {
     
        if(!table_ad_prov.getSelectionModel().isEmpty()){
            ServiceAd s = new ServiceAd();
            Ad ads = table_ad_prov.getSelectionModel().getSelectedItem();
            int id = ads.getAd_id();
            ads = s.getAdById(id);
        facebook = new FacebookFactory().getInstance();  
        facebook.setOAuthAppId("", "");
        String accessTokenString = "EAANyeAN4F9QBADDcanhqAQkFZCe4KX2DlWD7c3do8af9axe2jeBUBVbUwkCXoDW4tFSj11gwU4ynDb1HQtD13oVZBJrRuNpYtLMmwxtiKlTD3iVZCZBWUtuIYe8MX9MYyw37kmzs9vzl7Jjn2nSptRrMOmJMOeJlqLz0SHWBmRyucIgfrWwVNgoa5fZCRWoaZATHFCwLlf24SeSZAdYWLMs";
        AccessToken accessToken = new AccessToken(accessTokenString);
        facebook.setOAuthAccessToken(accessToken);
       
        try{
            
        facebook.postStatusMessage(ads.getAd_name()+ " is available in: "+ ads.getAvailability() +"\n Description: " + ads.getDescription());
        
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Deja partager.");
        alert.setHeaderText(null);
        alert.setContentText("Ad  "+ads.getAd_name()+ " has already been sharing!");
        alert.showAndWait();
        }
        catch(FacebookException fex){System.out.println(fex);}

        this.x=id;
    }
        else{
         Alert alert1 = new Alert(Alert.AlertType.ERROR);
         alert1.setTitle("Share an ad!");
         alert1.setContentText("you have to select an Ad !");
         alert1.showAndWait();  
        }
 }
    
        public boolean validname(String name) throws SQLException {
            if (name.length()==0){return false;}
        
            for (int i = 0; i < name.length(); i++) {
    char c = name.charAt(i);
    if (!(((c >= 'a' && c <= 'z'))||((c >= 'A' && c <= 'Z'))||(c==' '))){return false;}
          }return true;}

}
