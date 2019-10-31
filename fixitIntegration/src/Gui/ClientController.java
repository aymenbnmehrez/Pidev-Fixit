/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Db.DataSource;
import Entity.Ad;
import Entity.Ads;
import Entity.AskService;
import Entity.Client;
import Entity.Service;
import Entity.ServiceJoinAskService;
import Service.ServiceAd;
import Service.ServiceAskService;
import Service.ServiceClient;
import Service.ServiceService;
import Service.ServiceServiceJoinAskService;
import Service.serviceProviderJoinAd;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
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
import static java.sql.Types.NULL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class ClientController implements Initializable {

    int x=NULL;
    private com.mysql.jdbc.Connection con;
    @FXML
    private Pane pn_all, pn_ask, pn_request, pn_gard, pn_plumb, pn_elect, pn_edit,pn_show_ads;
    @FXML
    private JFXButton btn_ask, btn_request, btn_gard, btn_plumb, btn_elect, btn_back, btn_back2, btn_back3,btn_show_ads;
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
    private JFXButton btn_share2;
    @FXML
    private JFXButton btn_share21;
    @FXML
    private JFXButton btn_delete;
    @FXML
    private JFXButton btn_edit;
    @FXML
    private JFXButton btn_pay;
    @FXML
    private JFXButton btn_share1;
    @FXML
    private JFXButton btn_share;
    @FXML
    private TableView<Ad> TableAd;
    @FXML
    private TableColumn<Ad, String> C_title;
    @FXML
    private TableColumn<Ad, String> C_availability;
    @FXML
    private TableColumn<Ad, String> C_description;
    @FXML
    private TableColumn<Ad, String> C_published;
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
    private Label txt_publishedAt;
    @FXML
    private ImageView image_ad;
    @FXML
    private TextArea tf_description;
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
    private Label txt_phone;
    @FXML
    private Label txt_rate1;
    @FXML
    private Label txt_rate;
    @FXML
    private Label txt_mail;
    @FXML
    private TextField searchInput;
    @FXML
    private Label tf_titre;
    @FXML
    private Label name;
   

    @FXML
    public void handleButtonAction(ActionEvent event) throws SQLException {

        if ((event.getSource() == btn_ask) || (event.getSource() == btn_back) || (event.getSource() == btn_back2) || (event.getSource() == btn_back3)) {
            pn_ask.toFront();
        } else if (event.getSource() == btn_request) {
            System.out.println(getClientIdAthenticated());
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
        } else if (event.getSource() == btn_show_ads) {
            displayAds();
            pn_show_ads.toFront();
        }  
        else {
            pn_all.toFront();
        }

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
    public void displayPaiement(ActionEvent event) throws IOException ,SQLException{
        if (!table.getSelectionModel().isEmpty()) {
            ServiceAskService sas = new ServiceAskService();
            AskService as = new AskService();
            List<AskService> list = new ArrayList<>();
            list=sas.getAskServiceById(table.getSelectionModel().getSelectedItem().getAskServiceId());
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
    
    
    public void displayAds(){
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
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
       @FXML
    private void select_ad(MouseEvent event) throws SQLException {
        con = (com.mysql.jdbc.Connection) DataSource.getInstance().getConnection();
        if (TableAd.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Alert!");
            alert.setContentText("you have to select an Ad for more details ! !");
            alert.showAndWait();
        } else {
            serviceProviderJoinAd sp=new serviceProviderJoinAd();
            Ads ads =new Ads();
            ads = sp.getAdById(TableAd.getSelectionModel().getSelectedItem().getAd_id());
            tf_titre.setText(ads.getAd_name());
            SimpleDateFormat dateFormater;
            dateFormater = new SimpleDateFormat("yyyy-MM-dd");
            tf_availability.setText(dateFormater.format(ads.getAvailability()));
            tf_description.setText(ads.getDescription());
            tf_publishedAt.setText(ads.getPublished_at().toString());
            tf_firstName.setText(ads.getFirst_name());
            tf_lastName.setText(ads.getLast_name());
            tf_addr.setText(ads.getAdress());
            tf_phone.setText(String.valueOf(ads.getPhone()));
            tf_mail.setText(ads.getMail());
            tf_rate.setText(String.valueOf(ads.getRating()));
            
           
            

            String req = "select image from ad where ad_id=" + TableAd.getSelectionModel().getSelectedItem().getAd_id();
            try {
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(req);
                if (rs.next()) {
                    String title = rs.getString("image");
                    System.out.println(title);

                    Image image = new Image("file:C:/wamp64/www/imageAd/" + title);
                     image_ad.setImage(image);
    }}catch (SQLException e) {
                e.printStackTrace();
            }
        }}

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

 
}
