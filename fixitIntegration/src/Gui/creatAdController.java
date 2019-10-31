/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entity.Ad;
import Service.ServiceAd;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import static java.sql.Types.NULL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class creatAdController implements Initializable {

    @FXML
    private ImageView backgrAddAd;
    @FXML
    private ImageView frameAddAd;
    @FXML
    private TextField tfAdName;
    @FXML
    private Text text1;
    @FXML
    private Text text2;
    @FXML
    private Button btnAttImage;
    @FXML
    private Text text3;
    @FXML
    private TextArea tfdescription;
    @FXML
    private Button btnAdd;
    @FXML
    private DatePicker pAvailablity;
    @FXML
    private ImageView logoAddAd;
    @FXML
    private Button btn_backHomeprovider;
    @FXML
    private Label verif_img;
    @FXML
    private Label textUpImg;
    @FXML
    private Label verif_title;
    @FXML
    private Label verif_availability;

    private int idProvider;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
   public void setId(int idProvider) {

        this.idProvider = idProvider;

    }
    @FXML
    private void attach_image(ActionEvent event) {
                Stage primary = new Stage();
        
        FileChooser filechooser = new FileChooser();
        filechooser.setTitle("choose an Image");
        filechooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
        File file = filechooser.showOpenDialog(primary);
        String path ="C:\\wamp64\\www\\imageAd";

        if(file!=null)
        {
        textUpImg.setVisible(true);
        textUpImg.setText(file.getName());
        verif_img.setText("has been uploaded !");
            try {
                Files.copy(file.toPath(),new File(path+"\\"+file.getName()).toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{verif_img.setText("no image uploaded !");}
    }

    @FXML
    private void creatAd(ActionEvent event) throws SQLException {
                if (pAvailablity.getValue()==null || tfAdName.getText().length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("add an ad!");
            alert.setHeaderText("ERROR !");
            alert.setContentText("some field are empty !!");
            alert.showAndWait();}

         
          else{ 
             
         if(!validname(tfAdName.getText())){
             verif_title.setText("can't use numbers for title ");}
            
         else if(pAvailablity.getValue().isBefore(NOW_LOCAL_DATE ())){
             verif_availability.setText("error chek your date !");}
         else{
        java.util.Date date = new java.util.Date();
        long time = date.getTime();
        java.sql.Timestamp ts = new Timestamp(time);
        Ad ad = new Ad();
        ad.setAd_name(tfAdName.getText());
        ad.setAvailability(Date.valueOf(pAvailablity.getValue()));
        ad.setDescription(tfdescription.getText());
        ad.setImage(textUpImg.getText());
        ad.setAd_id(NULL);
        ad.setProvider_id(idProvider);
        ad.setPublished_at(ts);

         ServiceAd s = new ServiceAd();
         s.createAd(ad);         
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("add an ad!");
         alert.setHeaderText("Alert !");
         alert.setContentText("Ad has been added!");
         alert.showAndWait();
        tfAdName.clear();
        tfdescription.clear();
        pAvailablity.setValue(null);
        textUpImg.setVisible(false);
        verif_img.setVisible(false);
                
         }}
    }

    @FXML
    private void back_HomeProvider(ActionEvent event) throws IOException {
         
           ((Node) (event.getSource())).getScene().getWindow().hide();
    }
    
       public boolean validname(String name) throws SQLException {
            if (name.length()==0){return false;}
        
            for (int i = 0; i < name.length(); i++) {
    char c = name.charAt(i);
    if (!(((c >= 'a' && c <= 'z'))||((c >= 'A' && c <= 'Z'))||(c==' '))){return false;}
          }return true;}
       
        public static final LocalDate NOW_LOCAL_DATE (){
        String date = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(date , formatter);
        return localDate;}
}
