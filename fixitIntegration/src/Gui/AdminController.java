/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entity.Cclaim;
import Entity.Client;
import Entity.HeaderFooter;
import Entity.PDFCreator;
import Entity.Pclaim;
import Entity.Provider;
import Entity.Service;

import Service.ServiceClient;
import Service.ServiceProvider;
import Service.ServiceService;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import static java.sql.Types.NULL;
import java.util.List;
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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

/**
 * FXML Controller class
 *
 * @author Koala girl
 */
public class AdminController implements Initializable {
private int x = NULL;
    @FXML
    private JFXButton ServicesBtn;
    @FXML
    private Pane Claims;
    @FXML
    private JFXButton ProvidersListBtn;
    @FXML
    private JFXButton ClientListBtn;
    @FXML
    private AnchorPane pn_all;
    @FXML
    private Pane Clients_pn;
    @FXML
    private Pane Jobbers_pn;
    @FXML
    private TableView<Provider> providerList;
    @FXML
    private TableColumn<Provider, String> pfirst_name;
    @FXML
    private TableColumn<Provider, String> plast_name;
    @FXML
    private TableColumn<Provider, String> padd;
    @FXML
    private TableColumn<Provider, Integer> pphone;
    @FXML
    private TableColumn<Provider, String> pexp;
    @FXML
    private TableColumn<Provider, Integer> pconfirm;
    @FXML
    private JFXButton btn_deleteRequest;
    @FXML
    private JFXButton AcceptRequest;
    @FXML
    private Pane Services;
    @FXML
    private Label name;
    @FXML
    private TableView<Client> clientList;
    @FXML
    private TableColumn<Client, String> cfirst_name;
    @FXML
    private TableColumn<Client, String> clast_name;
    @FXML
    private TableColumn<Client, String> cadd;
    @FXML
    private TableColumn<Client, Integer> cphone;
    @FXML
    private JFXButton ClaimsBtn;
    @FXML
    private TableColumn<Pclaim, String> PclaimsColumn;
    @FXML
    private TableColumn<Pclaim, String> ProvidersColumn;
    @FXML
    private TableColumn<Cclaim, String> CClaimColumn;
    @FXML
    private Button updateservice;
    @FXML
    private TextField modid;
    @FXML
    private TextField modnom;
    @FXML
    private TextField rechercherfiled;
    @FXML
    private ImageView image;
    @FXML
    private TableView<Service> allservice;
    @FXML
    private TableColumn<Service,Integer> allid;
    @FXML
    private TableColumn<Service, String> allcategory;
    @FXML
    private TableColumn<Service, String> allname;
    @FXML
    private Label verif1;
 
     private static final String TITL = "TestReport";
    public static final String PDF_EXTENSION = ".pdf";
    private int Id_service;
    private int Id_category;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         cfirst_name.setCellFactory(TextFieldTableCell.forTableColumn());
    clast_name.setCellFactory(TextFieldTableCell.forTableColumn());
    cadd.setCellFactory(TextFieldTableCell.forTableColumn());
    cphone.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    initColumns();
    loadData();
    
    pfirst_name.setCellFactory(TextFieldTableCell.forTableColumn());
    plast_name.setCellFactory(TextFieldTableCell.forTableColumn());
    padd.setCellFactory(TextFieldTableCell.forTableColumn());
    pphone.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    pconfirm.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    pexp.setCellFactory(TextFieldTableCell.forTableColumn());


    pinitColumns();
    ploadData();
       
             SinitColumns();
                SloadData();
        // TODO
    }   
     private void SinitColumns() {

        allid.setCellValueFactory(new PropertyValueFactory<>("name"));
        allcategory.setCellValueFactory(new PropertyValueFactory<>("categoryName"));
        allname.setCellValueFactory(new PropertyValueFactory<>("picture_category"));

    }

    private void SloadData() {
         ObservableList<Service> data = null;
        try {
            data = FXCollections.observableArrayList(new ServiceService().readAll5());
        } catch (SQLException e) {
            e.printStackTrace();
        
        }
        allservice.setItems(data);
    }
    @FXML
    private void handleButtonAction(ActionEvent event) {
         if (event.getSource() == ClaimsBtn) {
            Claims.toFront();
        } else if (event.getSource() == ClientListBtn) {
            Clients_pn.toFront();
        } else if (event.getSource() == ProvidersListBtn) {
            Jobbers_pn.toFront();
        }
         else if (event.getSource() == ServicesBtn) {
            Services.toFront();
        }
    }

    @FXML
    private void deleteAskService(ActionEvent event) {
    }


    @FXML
    private void openEditAskService(ActionEvent event) {
    }
   private void initColumns() {

        cfirst_name.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        clast_name.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        cphone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        cadd.setCellValueFactory(new PropertyValueFactory<>("address"));
    }
    
    private void pinitColumns() {

        pfirst_name.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        plast_name.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        pphone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        padd.setCellValueFactory(new PropertyValueFactory<>("address"));
        pconfirm.setCellValueFactory(new PropertyValueFactory<>("confirmation"));
        pexp.setCellValueFactory(new PropertyValueFactory<>("experience"));


    }
    
    private void loadData() {
         ObservableList<Client> data = null;
        try {
            data = FXCollections.observableArrayList(new ServiceClient().readAll());
        } catch (SQLException e) {
            e.printStackTrace();
        
        }clientList.setItems(data);
    }
    
    private void ploadData() {
         ObservableList<Provider> info = null;
        try {
            info = FXCollections.observableArrayList(new ServiceProvider().readAll());
        } catch (SQLException e) {
            e.printStackTrace();
        
        }providerList.setItems(info);
    }
    
    @FXML
    private void ConfirmProvider(ActionEvent event) {
        Provider s = providerList.getSelectionModel().getSelectedItem();
    ServiceProvider sf = new ServiceProvider();
    String username = s.getUsername();
        try {
           {
                sf.confirm(providerList.getSelectionModel().getSelectedItem().getMail(),providerList.getSelectionModel().getSelectedItem().getUsername());
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
          ploadData();
    }
    
    
    @FXML
    private void deleteProvider(ActionEvent event) {
        Provider s = providerList.getSelectionModel().getSelectedItem();
    ServiceProvider sf = new ServiceProvider();
    String username = s.getUsername();
        try {
           {
        sf.delProvider(username);                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
          ploadData();
    }

     @FXML
    private void deleteClient(ActionEvent event) {
        Client s = clientList.getSelectionModel().getSelectedItem();
    ServiceClient sf = new ServiceClient();
    String username = s.getUsername();
        try {
           {
        sf.delClient(username);                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
          loadData(); 
}

    @FXML
    private void AddService(ActionEvent event) throws IOException {
          Parent root = FXMLLoader.load(getClass().getResource("../GUI/AddService.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    
    }

    @FXML
    private void DeleteService(ActionEvent event) {
              Service s = allservice.getSelectionModel().getSelectedItem();
    ServiceService sf = new ServiceService();
    String name_service = s.getName();
   // int Id_service = s.getId_service();
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Boîte de dialogue de confirmation");
            alert.setHeaderText(null);
            alert.setContentText("Êtes-vous sûr de vouloir supprimer"+s.getName());
            Optional<ButtonType> action = alert.showAndWait();
            if (action.get() == ButtonType.OK) {
                sf.deleteService(name_service);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
          SloadData();
    }

    @FXML
    private void updateserv(ActionEvent event) throws SQLException, IOException {
         ServiceService sa = new ServiceService();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Boîte de dialogue de confirmation");
            alert.setHeaderText(null);
            alert.setContentText("Êtes-vous sûr de vouloir modifier ce sevice");
            Optional<ButtonType> action = alert.showAndWait();
            if (action.get() == ButtonType.OK)
                
              
             if(!validname(modnom.getText())){
                  verif1.setText("nom non valide ");}
             else
             {
                  sa.updateService(this.x,modnom.getText(),Integer.valueOf(modid.getText()));
                  System.out.println(modid.getLength());
                  Parent root = FXMLLoader.load(getClass().getResource("../GUI/Admin.fxml"));
                  Scene scene = new Scene(root);
                  Stage stage = new Stage();
                  stage.setScene(scene);
                  stage.show();
                  ((Node) (event.getSource())).getScene().getWindow().hide();}
              
    }

    @FXML
    private void rechercherService(KeyEvent event) throws SQLException {
          String s= rechercherfiled.getText();
        ObservableList<Service> data = null;
        data = FXCollections.observableArrayList(new ServiceService().filtreService(s));
        allid.setCellValueFactory(new PropertyValueFactory<>("name"));
        allcategory.setCellValueFactory(new PropertyValueFactory<>("categoryName"));
        allname.setCellValueFactory(new PropertyValueFactory<>("picture_category"));
    
        allservice.setItems(data);
    }

    @FXML
    private void PDF(ActionEvent event) throws SQLException {
         ServiceService serviceFixit=new ServiceService();
        List<Service> dataObjList =serviceFixit.readAll5();
        Document document = null;
        try {
        //Document is not auto-closable hence need to close it separately
            document = new Document(PageSize.A4);            
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(
                    new File(TITL + PDF_EXTENSION)));
            HeaderFooter ev =new HeaderFooter();
            ev.setHeader("Test Report");
            writer.setPageEvent(ev);
            document.open();
            PDFCreator.addMetaData(document, TITL);
            PDFCreator.addTitlePage(document, TITL);
            PDFCreator.addContent(document, dataObjList);
        }catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("FileNotFoundException occurs.." + e.getMessage());
        }finally{
            if(null != document){
                document.close();
            }}
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
                 alert.setTitle("prendre les informations du service en PDF");
                 alert.setHeaderText("informations enregistré");
         Optional<ButtonType> action = alert.showAndWait();
            if (action.get() == ButtonType.OK) 
                
                 System.out.println("PDF");
          
    }

    @FXML
    private void update1(MouseEvent event) throws FileNotFoundException {
         Service p = allservice.getSelectionModel().getSelectedItem();
        Id_service = p.getService_id();
        this.x= p.getService_id();
        modnom.setText(p.getName());
          System.out.println(p.getCategory_id());
          System.out.println("aaaaaaaaaaaaaa"+p.getService_id());
        modid.setText(String.valueOf(p.getCategory_id()));
             Service s = allservice.getSelectionModel().getSelectedItem();
      
        ServiceService sf = new ServiceService();
        int id = s.getCategory_id();
        String title=s.getPicture_category();
        FileInputStream input = new FileInputStream("C:\\wamp64\\www\\"+title+"");
        Image imagee = new Image(input);
        //ImageView  = new ImageView();
        image.setImage(imagee);    
    }
     public boolean validname(String name) throws SQLException {
            if (name.length()==0){return false;}
        
            for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (!(((c >= 'a' && c <= 'z'))||((c >= 'A' && c <= 'Z'))||(c==' '))){return false;}
                }return true;}
}
