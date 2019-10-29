/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Db.DataSource;
import Entity.AskService;
import Entity.Cclaim;
import Entity.Client;
import Entity.ClientComment;
import Entity.Comment;
import Entity.Pclaim;
import Entity.Provider;
import Entity.Service;
import Service.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
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
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import javafx.util.converter.IntegerStringConverter;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class ClientController implements Initializable {

    @FXML
    private Pane pn_all, pn_ask, pn_request, pn_gard, pn_plumb, pn_elect, pn_edit, pn_profile, pn_claim;
    @FXML
    private JFXButton btn_ask, btn_request, btn_gard, btn_plumb, btn_elect, btn_share, btn_claim, btn_profile, btn_edit, btn_delete, btn_share1;
    @FXML
    private JFXComboBox<String> cb_serv, cb_serv1, cb_start, cb_start1;
    @FXML
    private JFXDatePicker dp_as, dp_as1;
//    @FXML
//    private JFXTimePicker tp_as, tp_as1;
    @FXML
    private JFXTextField tf_dur, tf_dur1, tf_filter;
    @FXML
    private JFXTextArea tx_desc, tx_desc1;
    @FXML
    private TableView<AskService> table;

    @FXML
    private TableColumn<AskService, String> cl_name;
    @FXML
    private TableColumn<AskService, java.sql.Date> cl_date;
    @FXML
    private TableColumn<AskService, String> cl_status;

    int idAskService;
    ObservableList<String> list = FXCollections.observableArrayList("change a faucet", "water leak repair");
    ObservableList<String> listStart = FXCollections.observableArrayList("08:00 GMT", "09:00 GMT", "10:00 GMT", "11:00 GMT", "12:00 GMT", "13:00 GMT", "14:00 GMT", "15:00 GMT", "16:00 GMT");
    @FXML

    private Label name;

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
    private ImageView checked;
    @FXML
    private TextArea claimDescription;
    @FXML
    private Button SendClaimBtn;
    private RadioButton claimFromC;
    private RadioButton ClaimFromP;

    @FXML
    private Label champObligatoire;
    @FXML
    private JFXSpinner load;
    @FXML
    private AnchorPane Annonce;
    private AnchorPane paneComments;
    @FXML
    private MenuButton MenuBtn;
    @FXML
    private MenuItem SprimComment;
    @FXML
    private TextArea comment;
    @FXML
    private VBox vBoxComments;
    @FXML
    private Label Likes;
    @FXML
    private TableColumn<ClientComment, String> adname;
    @FXML
    private TableColumn<ClientComment, String> Clients;
    @FXML
    private TableColumn<ClientComment, String> Comments;
    @FXML
    private TableView<ClientComment> tableComment;
    private String username;
    @FXML
    private ImageView Photo;
    @FXML
    private ImageView LikeBtn;
    int nbClick = 0;
    @FXML
    private MenuItem Details;
    @FXML
    private JFXButton Details1;

    @FXML
    public void handleButtonAction(ActionEvent event) throws SQLException {

        if (event.getSource() == btn_ask) {
            pn_ask.toFront();
        } else if (event.getSource() == btn_request) {
            pn_request.toFront();
        } else if (event.getSource() == btn_gard) {
            pn_gard.toFront();
        } else if (event.getSource() == btn_plumb) {
            pn_plumb.toFront();
        } else if (event.getSource() == btn_elect) {
            pn_elect.toFront();
        } else if (event.getSource() == btn_profile) {
            DisplayComments(); // tab
            pn_profile.toFront();
        } else if (event.getSource() == btn_claim) {
            pn_claim.toFront();
        } else {
            pn_all.toFront();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            displayTab();
        } catch (SQLException ex) {
        }
        cb_serv.setItems(list);
        cb_start.setItems(listStart);
        cb_serv1.setItems(list);
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

        ////display commentaires
        try {
            //// likes
            AfficherLikes();
            AfficherRating();
        } catch (SQLException ex) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    public void getNameClient(ActionEvent event) throws SQLException {
        ServiceClient sevc = new ServiceClient();
        List<Client> list = new ArrayList<>();
        list = sevc.displayClient2(username);
        Client a = list.get(0);

        System.out.println(a.getLast_name());
    }

    public String setUser(String username) {

        this.username = username;
        return this.username;
    }

    //behi win chtaffichi les differen ad ?nrmlmnt fou9 list des comments
    public void DisplayComments() throws SQLException {
        ServiceClientComment scc = new ServiceClientComment();
        ArrayList list = (ArrayList) scc.getDataClientJoinComment(1);//hné t3adi l'id ta3 l'ad li t7eb taffichila les commentaire li teb3inha
        ObservableList<ClientComment> data = FXCollections.observableArrayList(list);
        //  Clients.setCellFactory(TextFieldTableCell.forTableColumn());
        //  Comments.setCellFactory(TextFieldTableCell.forTableColumn());
        adname.setCellValueFactory(new PropertyValueFactory<>("AdsName"));
        Clients.setCellValueFactory(cellData -> Bindings.createStringBinding(
                () -> cellData.getValue().getClientFirstname() + " " + cellData.getValue().getClientLastname()));//mech hakka  o??u,i jarb tra
        Comments.setCellValueFactory(new PropertyValueFactory<>("comment"));
        tableComment.setItems(data);
        //  loadData(); 
    }

    private void loadData() {
        ObservableList<ClientComment> data = null;

        try {
            data = FXCollections.observableArrayList(new ServiceComment().AffichClientComments());
        } catch (SQLException ex) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
        tableComment.setItems(data);
 //tra zidli button ba7dha tableau  done
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

        ServiceAskService sas = new ServiceAskService();
        try {
            sas.addAskService(as);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        displayTab();

    }

    public void date(ActionEvent event) {
        String str = cb_serv.getValue();
        System.out.println(str);
    }

    public void displayTab() throws SQLException {
        ServiceAskService es = new ServiceAskService();
        ArrayList list = (ArrayList) es.getDataAskServiceRequest2();
        ObservableList<AskService> data = FXCollections.observableArrayList(list);
        cl_name.setCellValueFactory(new PropertyValueFactory<>("duration"));
        cl_date.setCellValueFactory(new PropertyValueFactory<>("date"));
        cl_status.setCellValueFactory(new PropertyValueFactory<>("description"));
        // cl_id.setCellValueFactory(new PropertyValueFactory<>("ask_service_id"));

        table.setItems(data);

    }

    @FXML
    public void deleteAskService(ActionEvent event) throws SQLException {
//        EventServices es = new EventServices();
//                es.delete(show_event.getSelectionModel().getSelectedItem().getId());
//                afficher();
        if (!table.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("delete request");
            alert.setHeaderText("do you really want to delete this request ?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                ServiceAskService sas = new ServiceAskService();
                sas.deleteAskService(table.getSelectionModel().getSelectedItem().getAsk_service_id());
                displayTab();
            }
        }
    }

    @FXML
    public void openEditAskService(ActionEvent event) throws SQLException {
//        EventServices es = new EventServices();
//                es.delete(show_event.getSelectionModel().getSelectedItem().getId());
//                afficher();
        if (!table.getSelectionModel().isEmpty()) {

            pn_edit.toFront();
            int id = table.getSelectionModel().getSelectedItem().getAsk_service_id();
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

    public void filterAskService(String oldValue, String newValue) throws SQLException {
        ServiceAskService sas = new ServiceAskService();
        ObservableList<AskService> filteredList = FXCollections.observableArrayList();
        if (tf_filter.getText() == null || (newValue.length() < oldValue.length()) || newValue == null) {
            displayTab();
        } else {

            newValue = newValue.toUpperCase();

            for (AskService as : table.getItems()) {

                String filtertitre = as.getDescription();
                String filtertitred = as.getDuration();

                if (filtertitre.toUpperCase().contains(newValue)) {
                    filteredList.add(as);
                } else if (filtertitred.toUpperCase().contains(newValue)) {
                    filteredList.add(as);

                }
                table.setItems(filteredList);

            }
        }
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
    }

    public void AfficherRating() throws SQLException {
        ServiceRating sr = new ServiceRating();
        double Rating = sr.AfficheRating("aymenbm");
        lblRating.setText(Double.toString(Rating));

    }

    @FXML
    private void Rated(MouseEvent event) throws SQLException {

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
                Rating = Rating + 5;
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
                Rating = Rating + 4;
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
                Rating = Rating + 3;
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
                Rating = Rating + 2;
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
                Rating = Rating + 1;
                sr.AjoutRating(username, Rating);
                lblRating.setText(String.valueOf(Rating));
                checked.opacityProperty().setValue(1);
                break;
            }
        }

    }

    @FXML
    private void SendClaim(MouseEvent event) throws SQLException, InterruptedException {

        if (claimDescription.getText().isEmpty()) {
            champObligatoire.opacityProperty().setValue(1);
        } else {

            ServiceCclaim srC = new ServiceCclaim();
            int rslt = srC.ajouterReclamation(claimDescription.getText(), setUser(username));
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

    @FXML
    private void SendComment(MouseEvent event) throws SQLException {
        ServiceComment sc = new ServiceComment();
        sc.ajouterCommentaire(comment.getText(), setUser(username));
        DisplayComments();
    }

    @FXML
    private void suprimComment(ActionEvent event) {

        String c = comment.getText();
        ServiceComment sc = new ServiceComment();
        // sc.SupprimerCommentaire();
        // behi fazt lbutton hedhi na3rfhech zidni button 3adiya jfx button kenk saba jphonnix
    }

    @FXML
    private void ModifComment(ActionEvent event) throws SQLException {
        setUser(username);
        ServiceComment sc = new ServiceComment();
        String c = comment.getText();
        sc.ModifierCommentaire(username, c);

    }

    public void AfficherLikes() throws SQLException {
        ServiceComment sc = new ServiceComment();
        int nb = sc.AfficheLike(username);
        Likes.setText(Integer.toString(nb));

    }

    @FXML
    private void AddLike() throws SQLException {
        nbClick++;
        if (nbClick == 0) {
            setUser(username);
            ServiceComment sc = new ServiceComment();
            sc.AjoutLike("metal");
            AfficherLikes();
        } else {
            LikeBtn.isDisable();
        }
//
    }

    @FXML
    public void getIdAd(ActionEvent event){
        if(!tableComment.getSelectionModel().isEmpty()){
            System.out.println(tableComment.getSelectionModel().getSelectedItem().getAdId());
        }
    }
    //warini fct chbi genera wa7dda o5ra

    @FXML
    private void getIdAd(Event event) {
    }
}
