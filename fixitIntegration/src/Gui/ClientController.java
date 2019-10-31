/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Db.DataSource;
import Entity.AskService;
import Entity.Client;
import Entity.ClientComment;
import Entity.Service;
import Entity.ServiceJoinAskService;
import Service.ServiceAskService;
import Service.ServiceCclaim;
import Service.ServiceClient;
import Service.ServiceClientComment;
import Service.ServiceComment;
import Service.ServiceRating;
import Service.ServiceService;
import Service.ServiceServiceJoinAskService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
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
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class ClientController implements Initializable {

    int nbClick = 0;
    @FXML
    private Pane pn_all, pn_ask, pn_request, pn_gard, pn_plumb, pn_elect, pn_edit;
    @FXML
    private JFXButton btn_ask, btn_request, btn_gard, btn_plumb, btn_elect, btn_back, btn_back2, btn_back3;
    @FXML
    private JFXComboBox<String> cb_serv, cb_serv1, cb_start, cb_start1, cb_servGard, cb_startGard, cb_servElect, cb_startElect;
    @FXML
    private JFXDatePicker dp_as, dp_as1, dp_asGard, dp_asElect;
//    @FXML
//    private JFXTimePicker tp_as, tp_as1;
    @FXML
    private JFXTextField tf_dur, tf_dur1, tf_filter, tf_durGard, tf_durElect, tf_price, tf_priceGard, tf_priceElect, tf_price1;
    @FXML
    private JFXTextArea tx_desc, tx_desc1, tx_descGard, tx_descElect;
    @FXML
    private TableView<ServiceJoinAskService> table;

    @FXML
    private TableColumn<ServiceJoinAskService, String> cl_name;
    @FXML
    private TableColumn<ServiceJoinAskService, java.sql.Date> cl_date;
    @FXML
    private TableColumn<ServiceJoinAskService, String> cl_started_at;
    @FXML
    private TableColumn<ServiceJoinAskService, String> cl_status;

    int idAskService;
    ObservableList<String> listPlumb = FXCollections.observableArrayList("change a faucet", "water leak repair");
    ObservableList<String> listGard = FXCollections.observableArrayList("cut a tree", "storing wood");
    ObservableList<String> listElect = FXCollections.observableArrayList("electrical outlet installation", "change a light bulb");
    ObservableList<String> listAll = FXCollections.observableArrayList("cut a tree", "storing wood", "change a faucet", "water leak repair", "electrical outlet installation", "change a light bulb");

    ObservableList<String> listStart = FXCollections.observableArrayList("08:00 GMT", "09:00 GMT", "10:00 GMT", "11:00 GMT", "12:00 GMT", "13:00 GMT", "14:00 GMT", "15:00 GMT", "16:00 GMT");

    private int categoryId;
    @FXML
    private JFXButton btn_share21;
    @FXML
    private JFXButton btn_share2;
    @FXML
    private JFXButton btn_share1;
    @FXML
    private JFXButton btn_share;
    @FXML
    private JFXButton btn_delete;
    @FXML
    private JFXButton btn_edit;
    @FXML
    private JFXButton btn_pay;
    @FXML
    private Label name;
    @FXML
    private JFXButton btn_profile;
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
    private Pane pn_profile;
    @FXML
    private ImageView Photo;
    @FXML
    private Label name1;
    private ImageView star2;
    private ImageView star3;
    private ImageView star4;
    private ImageView star5;
    private ImageView star1;
    private Label lblRating;
    private ImageView checked;
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
    private Pane pn_Ads;
    @FXML
    private Label idAd_lbl;
    @FXML
    private JFXButton Sign_out;

    @FXML
    public void handleButtonAction(ActionEvent event) throws SQLException, IOException {

        if ((event.getSource() == btn_ask) || (event.getSource() == btn_back) || (event.getSource() == btn_back2) || (event.getSource() == btn_back3)) {
            pn_ask.toFront();
        } else if (event.getSource() == btn_request) {
            displayTab();
            pn_request.toFront();
        } else if (event.getSource() == btn_gard) {
            cb_servGard.setItems(listGard);
            categoryId = 10;
            pn_gard.toFront();
        } else if (event.getSource() == btn_plumb) {
            cb_serv.setItems(listPlumb);
            categoryId = 20;
            pn_plumb.toFront();
        } else if (event.getSource() == btn_elect) {
            cb_servElect.setItems(listElect);
            categoryId = 30;
            pn_elect.toFront();
        } else if (event.getSource() == btn_profile) {
            DisplayComments();
            AfficherLikes();
           // AfficherRating();
            pn_profile.toFront();
        } else if (event.getSource() == btn_claim) {
            pn_claim.toFront();
        } else if (event.getSource() == Sign_out){
             Parent loader = FXMLLoader.load(getClass().getResource("Login.fxml"));

            Scene scene = new Scene(loader);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            ((Node) (event.getSource())).getScene().getWindow().hide();
        }
        else 
        {
            pn_all.toFront();
        }

    }

 /*   public void AfficherRating() throws SQLException {
        ServiceRating sr = new ServiceRating();
        double Rating = sr.AfficheRating(username);
        lblRating.setText(Double.toString(Rating));

    }*/

    public void displayTab() throws SQLException {
        ServiceServiceJoinAskService sjas = new ServiceServiceJoinAskService();
        ArrayList list = (ArrayList) sjas.getDataAskService2(getClientIdAthenticated());
        ObservableList<ServiceJoinAskService> data = FXCollections.observableArrayList(list);
        cl_name.setCellValueFactory(new PropertyValueFactory<>("nameService"));
        cl_date.setCellValueFactory(new PropertyValueFactory<>("dateAskService"));
        cl_started_at.setCellValueFactory(new PropertyValueFactory<>("startedAskService"));
        cl_status.setCellValueFactory(new PropertyValueFactory<>("status"));

        // cl_id.setCellValueFactory(new PropertyValueFactory<>("ask_service_id"));
        table.setItems(data);

    }

    public void DisplayComments() throws SQLException {
        ServiceClientComment scc = new ServiceClientComment();
        ArrayList list = (ArrayList) scc.getDataClientJoinComment(1);
        ObservableList<ClientComment> data = FXCollections.observableArrayList(list);
        adname.setCellValueFactory(new PropertyValueFactory<>("AdsName"));
        Clients.setCellValueFactory(cellData -> Bindings.createStringBinding(
                () -> cellData.getValue().getClientFirstname() + " " + cellData.getValue().getClientLastname()));
        Comments.setCellValueFactory(new PropertyValueFactory<>("comment"));
        tableComment.setItems(data);
        //  loadData(); 
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

//        try {
//            displayTab();
//        } catch (SQLException ex) {
//        }
        cb_startGard.setItems(listStart);
        cb_startElect.setItems(listStart);
        cb_start.setItems(listStart);
        cb_serv1.setItems(listAll);
        cb_start1.setItems(listStart);
        ServiceAskService sas = new ServiceAskService();
        tf_filter.textProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {

                try {
                    filterAskService((String) oldValue, (String) newValue);
                } catch (SQLException ex) {
                    Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

//    @FXML
//    public void getNameClient(ActionEvent event) throws SQLException {
//        ServiceClient sevc = new ServiceClient();
//        List<Client> list = new ArrayList<>();
//        list = sevc.displayClient2(username);
//        Client a = list.get(0);
//
//        System.out.println(a.getLast_name());
//    }
    private String username;

    public void setUser(String username) {

        this.username = username;

    }

    public String getUser() {
        return username;
    }

    @FXML
    public void shareAskService() throws SQLException {

        String serviceName = cb_serv.getValue();

        ServiceService sers = new ServiceService();
        List<Service> list = new ArrayList<>();         //getting service_id selected
        list = sers.getIdService(serviceName);
        Service s = list.get(0);
        int idService = s.getService_id();
        //  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        ServiceClient sevc = new ServiceClient();       //getting client_id of the authentificated client
        List<Client> listC = new ArrayList<>();
        listC = sevc.displayClient2(username);
        Client c = listC.get(0);
        int idClient = c.getClient_id();

        LocalDate date = dp_as.getValue();
        Date datee = Date.valueOf(date);
        AskService as = new AskService();
        as.setService_id(idService);
        as.setDate(datee);
        as.setDuration(tf_dur.getText());
        as.setDescription(tx_desc.getText());
        as.setClient_id(idClient);
        as.setStarted_at(cb_start.getValue());
        as.setPrice(Integer.parseInt(tf_price.getText()));

        ServiceAskService sas = new ServiceAskService();
        try {
            sas.addAskService(as);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        displayTab();
        pn_request.toFront();

    }

    @FXML
    public void shareAskServiceGard() throws SQLException {

        String serviceName = cb_servGard.getValue();

        ServiceService sers = new ServiceService();
        List<Service> list = new ArrayList<>();         //getting service_id selected
        list = sers.getIdService(serviceName);
        Service s = list.get(0);
        int idService = s.getService_id();
        //  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        ServiceClient sevc = new ServiceClient();       //getting client_id of the authentificated client
        List<Client> listC = new ArrayList<>();
        listC = sevc.displayClient2(username);
        Client c = listC.get(0);
        int idClient = c.getClient_id();

        LocalDate date = dp_asGard.getValue();
        Date datee = Date.valueOf(date);
        AskService as = new AskService();
        as.setService_id(idService);
        as.setDate(datee);
        as.setDuration(tf_durGard.getText());
        as.setDescription(tx_descGard.getText());
        as.setClient_id(idClient);
        as.setStarted_at(cb_startGard.getValue());
        as.setPrice(Integer.parseInt(tf_priceGard.getText()));

        ServiceAskService sas = new ServiceAskService();
        try {
            sas.addAskService(as);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        displayTab();
        pn_request.toFront();
    }

    @FXML
    public void shareAskServiceElect() throws SQLException {

        String serviceName = cb_servElect.getValue();

        ServiceService sers = new ServiceService();
        List<Service> list = new ArrayList<>();         //getting service_id selected
        list = sers.getIdService(serviceName);
        Service s = list.get(0);
        int idService = s.getService_id();
        //  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        ServiceClient sevc = new ServiceClient();       //getting client_id of the authentificated client
        List<Client> listC = new ArrayList<>();
        listC = sevc.displayClient2(username);
        Client c = listC.get(0);
        int idClient = c.getClient_id();

        LocalDate date = dp_asElect.getValue();
        Date datee = Date.valueOf(date);
        AskService as = new AskService();
        as.setService_id(idService);
        as.setDate(datee);
        as.setDuration(tf_durElect.getText());
        as.setDescription(tx_descElect.getText());
        as.setClient_id(idClient);
        as.setStarted_at(cb_startElect.getValue());
        as.setPrice(Integer.parseInt(tf_priceElect.getText()));

        ServiceAskService sas = new ServiceAskService();
        try {
            sas.addAskService(as);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        displayTab();
        pn_request.toFront();

    }

    public void date(ActionEvent event) {
        String str = cb_serv.getValue();
        System.out.println(str);
    }

    @FXML
    public void deleteAskService(ActionEvent event) throws SQLException {

        if (!table.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("delete request");
            alert.setHeaderText("do you really want to delete this request ?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                ServiceAskService sas = new ServiceAskService();
                sas.deleteAskService(table.getSelectionModel().getSelectedItem().getAskServiceId());
                displayTab();
            }
        }
    }

    @FXML
    public void openEditAskService(ActionEvent event) throws SQLException {
//        EventServices es = new EventServices();
////                es.delete(show_event.getSelectionModel().getSelectedItem().getId());
////                afficher();
        if (!table.getSelectionModel().isEmpty()) {

            pn_edit.toFront();
            int id = table.getSelectionModel().getSelectedItem().getAskServiceId();
            setIdToEdit(id);
            setDataToEditPane();
        }

    }

    public void setIdToEdit(int id) {

        this.idAskService = id;
    }
//    public int returnIndexComboBox(String started_at){
//        for(int i =1;i<listStart.size();i++){
//            if(started_at.equals(list.get(i)))
//                return i;
//        }
//        return 0;
//    }

    public void setDataToEditPane() throws SQLException {
        List<AskService> list = new ArrayList<>();

        ServiceAskService sas = new ServiceAskService();
        AskService as = new AskService();
        list = sas.getAskServiceById(idAskService);
        as = list.get(0);

        dp_as1.setValue(as.getDate().toLocalDate());
        cb_start1.getSelectionModel().select(as.getStarted_at());
        tf_dur1.setText(as.getDuration());
        tx_desc1.setText(as.getDescription());
        tf_price1.setText(String.valueOf(as.getPrice()));
    }

    @FXML
    public void editAskService(ActionEvent event) throws SQLException {
        String serviceName = cb_serv1.getValue();

        ServiceService sers = new ServiceService();
        List<Service> list = new ArrayList<>();         //getting service_id selected
        list = sers.getIdService(serviceName);
        Service s = list.get(0);
        int idService = s.getService_id();

        ServiceClient sevc = new ServiceClient();       //getting client_id of the authentificated client
        List<Client> listC = new ArrayList<>();
        listC = sevc.displayClient2(username);
        Client c = listC.get(0);
        int idClient = c.getClient_id();

        ServiceAskService sas = new ServiceAskService();
        AskService as = new AskService();
        LocalDate date = dp_as1.getValue();
        Date datee = Date.valueOf(date);
        as.setDate(datee);
        as.setDuration(tf_dur1.getText());
        as.setDescription(tx_desc1.getText());
        as.setClient_id(idClient);
        as.setStarted_at(cb_start1.getValue());
        as.setService_id(idService);

        sas.editAskService(as, idAskService);
        displayTab();
        pn_request.toFront();

    }

    public int getClientIdAthenticated() throws SQLException {
        ServiceClient sevc = new ServiceClient();       //getting client_id of the authentificated client
        List<Client> listC = new ArrayList<>();
        listC = sevc.displayClient2(username);
        Client c = listC.get(0);
        int idClient = c.getClient_id();
        return idClient;

    }

    public void filterAskService(String oldValue, String newValue) throws SQLException {
        ServiceServiceJoinAskService sas = new ServiceServiceJoinAskService();
        ObservableList<ServiceJoinAskService> filteredList = FXCollections.observableArrayList();
        if (tf_filter.getText() == null || (newValue.length() < oldValue.length()) || newValue == null) {
            displayTab();
        } else {

            newValue = newValue.toUpperCase();

            for (ServiceJoinAskService as : table.getItems()) {

                String filtertitre = as.getNameService();
                String filtertitred = as.getStatus();

                if (filtertitre.toUpperCase().contains(newValue)) {
                    filteredList.add(as);
                } else if (filtertitred.toUpperCase().contains(newValue)) {
                    filteredList.add(as);

                }
                table.setItems(filteredList);

            }

        }
    }

    @FXML
    public void displayPaiement(ActionEvent event) throws IOException, SQLException {
        if (!table.getSelectionModel().isEmpty()) {
            ServiceAskService sas = new ServiceAskService();
            AskService as = new AskService();
            List<AskService> list = new ArrayList<>();
            list = sas.getAskServiceById(table.getSelectionModel().getSelectedItem().getAskServiceId());
            as = list.get(0);
            int price = as.getPrice();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Paiment.fxml"));
            Parent root = loader.load();
            PaimentController controller = loader.<PaimentController>getController();
            controller.setPrice(price);
            controller.setId(table.getSelectionModel().getSelectedItem().getAskServiceId());
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

        }

    }
    //    }

//    private void addButtonToTable() {
//        TableColumn<AskService, Void> colBtn = new TableColumn("Button Column");
//
//        Callback<TableColumn<AskService, Void>, TableCell<AskService, Void>> cellFactory = new Callback<TableColumn<AskService, Void>, TableCell<AskService, Void>>() {
//            @Override
//            public TableCell<AskService, Void> call(final TableColumn<AskService, Void> param) {
//                final TableCell<AskService, Void> cell = new TableCell<AskService, Void>() {
//
//                    private final JFXButton btn_delete = new JFXButton("Delete");
//
//                    {
//                        btn_delete.setOnAction((ActionEvent event) -> {
////                            AskService data = getTableView().getItems().get(getIndex());
////                            System.out.println("selectedData: " + data);
//                            int index = table.getSelectionModel().getSelectedIndex();
//                            System.out.println(index);
//                            Object btn = btn_delete.getUserData();
//                            System.out.println(btn);
//
//                            ServiceAskService sas = new ServiceAskService();
////                            try {
////                                sas.deleteAskService(table.getSelectionModel().getSelectedItem().getDescription());
////                            } catch (SQLException ex) {
////                            }
//
//                            Item item = tbvCitation.getItems().get(row);
//
//                            String x = colBtn.getCellObservableValue(item).getValue();
//                            System.out.println(x);
//                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//                            alert.setTitle("delete request");
//                            alert.setHeaderText("This is a test.");
//                            alert.setResizable(false);
//                            alert.setContentText("Select okay or cancel this alert.");
//                            //s  alert.showAndWait();
//                            Optional<ButtonType> result = alert.showAndWait();
//                            ButtonType button = result.orElse(ButtonType.CANCEL);
////                            if (button == ButtonType.OK) {
////                                try {
////                                    sas.deleteAskService();
////                                } catch (SQLException ex) {
////                                }
////                            } else {
////                                System.out.println("canceled");
////                            }
//                        });
//                    }
//
//                    @Override
//                    public void updateItem(Void item, boolean empty) {
//                        super.updateItem(item, empty);
//                        if (empty) {
//                            setGraphic(null);
//                        } else {
//                            setGraphic(btn_delete);
//                        }
//                    }
//                };
//                return cell;
//            }
//        };
//
//        colBtn.setCellFactory(cellFactory);
//
//        table.getColumns().add(colBtn);
//
//    }
    @FXML
    public void SendClaim(MouseEvent event) throws SQLException, InterruptedException {
        ServiceCclaim srC = new ServiceCclaim();
        // int rslt = srC.ajouterReclamation(claimDescription.getText(), setUser(username));
        int rslt = srC.ajouterReclamation(claimDescription.getText(), username);
        if (claimDescription.getText().isEmpty()) {
            champObligatoire.opacityProperty().setValue(1);
        } else {

            if (rslt == 1) {
                champObligatoire.opacityProperty().setValue(1);
                champObligatoire.setText("Claim is sent successfully");
            } else {
                champObligatoire.opacityProperty().setValue(1);
                champObligatoire.setText("Connexion Error");
            }
            claimDescription.clear();
        }
    }

   /* private void Rated(MouseEvent event) throws SQLException {
        ServiceRating sr = new ServiceRating();
        double Rating = sr.AfficheRating(username);
        Image activate = new Image("GUI/Images/etoileOn.png");
        Image validated = new Image("GUI/Images/etoileSelect.png");

        while (star5.isPressed() || star4.isPressed() || star3.isPressed() || star2.isPressed() || star1.isPressed()) {
            if (star5.isPressed()) {
                System.out.println("star5 selected");
                star1.setImage(activate);
                star2.setImage(activate);
                star3.setImage(activate);
                star4.setImage(activate);
                star5.setImage(activate);
                Rating = (Rating + 5)/5;
                sr.AjoutRating(username, Rating);
                lblRating.setText(String.valueOf(Rating));
                checked.opacityProperty().setValue(1);
                break;
            } else if (star4.isPressed()) {   //win tableau N? 
                System.out.println("star4 selected");
                star1.setImage(activate);
                star2.setImage(activate);
                star3.setImage(activate);
                star4.setImage(activate);
                star5.setImage(validated);
                Rating =( Rating + 4)/5;
                sr.AjoutRating(username, Rating);
                lblRating.setText(String.valueOf(Rating));
                checked.opacityProperty().setValue(1);
                break;
            } else if (star3.isPressed()) {
                System.out.println("star3 selected");
                star1.setImage(activate);
                star2.setImage(activate);
                star3.setImage(activate);
                star4.setImage(validated);
                star5.setImage(validated);
                Rating = (Rating + 3)/5;
                sr.AjoutRating(username, Rating);
                lblRating.setText(String.valueOf(Rating));
                checked.opacityProperty().setValue(1);
                break;
            } else if (star2.isPressed()) {
                System.out.println("star2 selected");
                star1.setImage(activate);
                star2.setImage(activate);
                star3.setImage(validated);
                star4.setImage(validated);
                star5.setImage(validated);
                Rating = (Rating + 2)/5;
                sr.AjoutRating(username, Rating);
                lblRating.setText(String.valueOf(Rating));
                checked.opacityProperty().setValue(1);
                break;
            } else if (star1.isPressed()) {
                System.out.println("star selected");
                star1.setImage(activate);
                star2.setImage(validated);
                star3.setImage(validated);
                star4.setImage(validated);
                star5.setImage(validated);
                Rating = (Rating + 1)/5;
                sr.AjoutRating(username, Rating);
                lblRating.setText(String.valueOf(Rating));
                checked.opacityProperty().setValue(1);
                break;
            }
        }
    }*/

    @FXML
    private void SendComment(MouseEvent event) throws SQLException {
        if (!comment.getText().isEmpty()) {
            ServiceComment sc = new ServiceComment();
            //  sc.ajouterCommentaire(comment.getText(), setUser(username));
            sc.ajouterCommentaire(comment.getText(), getClientIdAthenticated());
            DisplayComments();
        }
    }

    @FXML
    private void suprimComment(ActionEvent event) throws SQLException {
        ServiceComment sc = new ServiceComment();
        if(!tableComment.getSelectionModel().isEmpty()){
        sc.SupprimerCommentaire(tableComment.getSelectionModel().getSelectedItem().getCommentId());
        DisplayComments();}
    }

    @FXML
    private void ModifComment(ActionEvent event) throws SQLException, IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifComment.fxml"));
            Parent root = loader.load();
               ModifCommentController controller = loader.<ModifCommentController>getController();
            controller.setComment(tableComment.getSelectionModel().getSelectedItem().getComment());
            controller.setIdComment(tableComment.getSelectionModel().getSelectedItem().getCommentId());
            System.out.println(tableComment.getSelectionModel().getSelectedItem().getCommentId());
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            stage.getIcons().add(new Image("/Gui/images/log.png"));
            
            
        setUser(username);
        int idComment;
        idComment = tableComment.getSelectionModel().getSelectedItem().getCommentId();
       // int idAd = getIdAd(event);
      
         
    }

    public void AfficherLikes() throws SQLException {
        ServiceComment sc = new ServiceComment();
        int nb = sc.AfficheLike(username);
        Likes.setText(Integer.toString(nb));

    }

    @FXML
    private int getIdAd(ActionEvent event) {
        int idAd = 0;
        if (!tableComment.getSelectionModel().isEmpty()) {
            idAd = tableComment.getSelectionModel().getSelectedItem().getAdId();
            pn_Ads.toFront();
            idAd_lbl.setText(Integer.toString(idAd));
        }
        System.out.println(idAd);
        return idAd;
    }

    @FXML
    private void AddLike(MouseEvent event) throws SQLException {
        nbClick++;
        if (nbClick == 0) {
            setUser(username);
            ServiceComment sc = new ServiceComment();
            sc.AjoutLike("metal");
            AfficherLikes();
        } else {
            LikeBtn.isDisable();
        }
    }

    @FXML
    private void DeleteAction(ActionEvent event) throws IOException {

        ServiceClient sp = new ServiceClient();
        try {
            sp.delClient(username);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));

            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (SQLException ex) {
            System.out.println(ex);

        }
    }

    @FXML
    private void EditAction(ActionEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("modifClient.fxml"));
        Parent root = loader.load();
        ModifClientController controlleerr = loader.<ModifClientController>getController();
        controlleerr.setUser(username);
        ServiceClient sevc = new ServiceClient();       //getting client_id of the authentificated client
        List<Client> listC = new ArrayList<>();
        listC = sevc.getdata(username);
        Client c = listC.get(0);

        controlleerr.setInfo(c.getFirst_name(), c.getLast_name(), c.getPassword(), c.getAddress(), c.getMail(), c.getPhone());
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void SettingsAction(ActionEvent event) {
    }

    @FXML
    private void Rated(ActionEvent event) throws IOException {
           FXMLLoader loader = new FXMLLoader(getClass().getResource("Rate.fxml"));
        Parent root = loader.load();
       RateController controlleerr = loader.<RateController>getController();
        controlleerr.setIdP(tableComment.getSelectionModel().getSelectedItem().getProvider_id());
        ServiceClient sevc = new ServiceClient();  
          Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        
    }
}
