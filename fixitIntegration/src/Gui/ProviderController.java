/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entity.AskService;
import Entity.ClientComment;
import Entity.ClientJoinServiceJoinAskService;
import Entity.Provider;
import Service.ServiceAskService;
import Service.ServiceClientJoinServiceJoinAskService;
import Service.ServicePclaim;
import Service.ServiceProvider;
import Service.ServiceRating;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class ProviderController implements Initializable {

    private String username;
    private int idP;
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
    private JFXButton btn_request;
    @FXML
    private JFXButton btn_profile;
    @FXML
    private AnchorPane pn_all;
    @FXML
    private JFXButton btn_confirm;
    @FXML
    private JFXTextField tf_filter;
    @FXML
    private JFXButton btn_delete;
    @FXML
    private Pane pn_profile;
    @FXML
    private ImageView Photo;
    @FXML
    private Label name1;
    @FXML
    private AnchorPane Annonce;
    @FXML
    private VBox vBoxComments;
    @FXML
    private TableView<ClientComment> tableComment;
    @FXML
    private TableColumn<ClientComment, String> adname;
    @FXML
    private TableColumn<ClientComment, String> Clients;
    @FXML
    private TableColumn<ClientComment, String> Comments;
    @FXML
    private MenuButton MenuBtn;
    @FXML
    private MenuItem SprimComment;
    @FXML
    private MenuItem Details;
    @FXML
    private TextArea comment;
    @FXML
    private ImageView LikeBtn;
    @FXML
    private Label Likes;
    @FXML
    private MenuItem DeleteBtn;
    @FXML
    private MenuItem UpdateBtn;
    @FXML
    private ImageView star2;
    @FXML
    private ImageView star3;
    @FXML
    private ImageView star4;
    @FXML
    private ImageView star5;
    @FXML
    private ImageView star1;
    @FXML
    private Label lblRating;
    @FXML
    private JFXButton btn_claim;
    @FXML
    private Pane pn_claim;
    @FXML
    private TextArea claimDescription;
    @FXML
    private Label champObligatoire;
    @FXML
    private JFXButton SendClaimBtn;
    @FXML
    private JFXSpinner load;
    @FXML
    private JFXButton Sign_out;

    /**
     * Initializes the controller class.
     */
    public void setUser(String username) {

        this.username = username;

    }
    public void setIdP(int idP){
    this.idP=idP;
    
}

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        try {
//            displayTabProvider();
//            // TODO
//        } catch (SQLException ex) {
//            Logger.getLogger(ProviderController.class.getName()).log(Level.SEVERE, null, ex);
//        }
ServiceRating sr=new ServiceRating();
    }

    @FXML
    public void handleButtonAction(ActionEvent event) throws SQLException, IOException {

        if (event.getSource() == btn_search) {
            displayTabProvider();
            pn_search.toFront();
       
        } else if (event.getSource() == btn_profile) {
            getRating();
           // AfficherRating();
            pn_profile.toFront();
        } else if (event.getSource() == btn_claim) {
            pn_claim.toFront();
        } else if(event.getSource()== Sign_out){
           Parent loader = FXMLLoader.load(getClass().getResource("Login.fxml"));

            Scene scene = new Scene(loader);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            ((Node) (event.getSource())).getScene().getWindow().hide();
        }
        else {
            pn_all.toFront();
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
    @FXML
    public void confirmAskService(ActionEvent event) throws SQLException{
        ServiceAskService sa = new ServiceAskService();
        if(!tableProvider.getSelectionModel().isEmpty()){
            sa.confirmAskService(tableProvider.getSelectionModel().getSelectedItem().getIdAskService());
              }
    }

    @FXML
    private void SendComment(MouseEvent event) {
    }

    @FXML
    private void suprimComment(ActionEvent event) {
    }

    @FXML
    private void ModifComment(ActionEvent event) {
    }

    @FXML
    private void getIdAd(ActionEvent event) {
    }

    @FXML
    private void Rated(ActionEvent event) {
    }

   

    @FXML
    private void DeleteAction(ActionEvent event) throws IOException {
          ServiceProvider sp =new ServiceProvider();
        try{
            sp.delProvider(username);
        }catch (SQLException ex){
            System.out.println(ex);
            
        }
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
    }

    @FXML
    private void EditAction(ActionEvent event) throws IOException, SQLException {
        System.out.println(idP);
           FXMLLoader loader = new FXMLLoader(getClass().getResource("modifProvider.fxml"));
            Parent root = loader.load();
           Gui.ModifProviderController controlleer = loader.<Gui.ModifProviderController>getController();
               ServiceProvider sevc = new ServiceProvider();       //getting client_id of the authentificated client
        List<Provider> listC = new ArrayList<>();
        listC = sevc.getdata(username);
        Provider c = listC.get(0);
      

           controlleer.setInfo(c.getFirst_name(),c.getLast_name(),c.getPassword(),c.getAddress(),c.getMail(),c.getPhone());

            Scene scene = new Scene(root);
            Stage stage = new Stage();
             stage.setScene(scene);
            stage.show();
    }

    @FXML
    private void SettingsAction(ActionEvent event) {
    }


    @FXML
    private void SendClaim(MouseEvent event) throws SQLException, InterruptedException {
        ServicePclaim srP=new ServicePclaim();
       int rslt= srP.ajouterReclamation(claimDescription.getText(),username);
        if (rslt==1){
         champObligatoire.opacityProperty().setValue(1);
         champObligatoire.setText("Claim is sent successfully" );}
        else {
             champObligatoire.opacityProperty().setValue(1);
         champObligatoire.setText("Connexion Error" );
    }
        
}
public void getRating() throws SQLException{
    ServiceRating sr=new ServiceRating();
    Image activate = new Image("Gui/images/etoileOn.png");
        Image validated = new Image("Gui/images/etoileSelect.png");
        double x=sr.AfficheRating2(username);
    if(x==10){
      star1.setImage(activate);
                star2.setImage(activate);
                star3.setImage(activate);
                star4.setImage(activate);
                star5.setImage(activate);   
    }else if(x<10&&x>8){
      star1.setImage(activate);
                star2.setImage(activate);
                star3.setImage(activate);
                star4.setImage(activate);
                star5.setImage(validated);   
    }else if(x<8&&x>6){
        star1.setImage(activate);
                star2.setImage(activate);
                star3.setImage(activate);
                star4.setImage(validated);
                star5.setImage(validated); 
    }else if(x<6&&x>4){
        star1.setImage(activate);
                star2.setImage(validated);
                star3.setImage(validated);
                star4.setImage(validated);
                star5.setImage(validated); 
    }else if(x<4&&x>2){
        star1.setImage(activate);
                star2.setImage(activate);
                star3.setImage(validated);
                star4.setImage(validated);
                star5.setImage(validated); 
    }else if(x<2){
        star1.setImage(activate);
                star2.setImage(validated);
                star3.setImage(validated);
                star4.setImage(validated);
                star5.setImage(validated); 
    }else{
        star1.setImage(validated);
                star2.setImage(validated);
                star3.setImage(validated);
                star4.setImage(validated);
                star5.setImage(validated); 
    }
        
        
    
}

}
