/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entity.HeaderFooter;
import Entity.PDFCreator;
import Entity.Service;
import Service.ServiceService;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfPageEvent;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import javafx.stage.Stage;
import static java.sql.Types.NULL;
import java.util.List;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class ReadServicesController implements Initializable {
    private int x = NULL;
    @FXML
    private TableView<Service> allservice;
    @FXML
    private TableColumn<Service, Integer> allid;
    @FXML
    private TableColumn<Service, String> allcategory;
    @FXML
    private TableColumn<Service, String> allname;
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
        allid.setCellFactory(TextFieldTableCell.forTableColumn());
               allcategory.setCellFactory(TextFieldTableCell.forTableColumn()); 
               allname.setCellFactory(TextFieldTableCell.forTableColumn()); 
                initColumns();
                loadData();
        // TODO
    }   
     private void initColumns() {

        allid.setCellValueFactory(new PropertyValueFactory<>("name"));
        allcategory.setCellValueFactory(new PropertyValueFactory<>("categoryName"));
        allname.setCellValueFactory(new PropertyValueFactory<>("Picture"));

    }

    private void loadData() {
         ObservableList<Service> data = null;
        try {
            data = FXCollections.observableArrayList(new ServiceService().readAll5());
        } catch (SQLException e) {
            e.printStackTrace();
        
        }
        allservice.setItems(data);
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
        FileInputStream input = new FileInputStream("C:\\wamp\\www\\"+title+"");
        Image imagee = new Image(input);
        //ImageView  = new ImageView();
        image.setImage(imagee);    
        
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
          loadData();
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
                  Parent root = FXMLLoader.load(getClass().getResource("../GUI/readServices.fxml"));
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
            writer.setPageEvent((PdfPageEvent) ev);
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
  /*  private void Logout(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);       
                alert.setTitle("Boîte de dialogue de confirmation");
                alert.setHeaderText(null);
                alert.setContentText("Êtes-vous sûr de vouloir quitter");
                Optional<ButtonType> action = alert.showAndWait();
                if (action.get() == ButtonType.OK)  {
                     
                     FXMLLoader loader = new FXMLLoader(getClass().getResource("page0.fxml"));
                       
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
                    ((Node) (event.getSource())).getScene().getWindow().hide();} 
    } */
    
    public boolean validname(String name) throws SQLException {
            if (name.length()==0){return false;}
        
            for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (!(((c >= 'a' && c <= 'z'))||((c >= 'A' && c <= 'Z'))||(c==' '))){return false;}
                }return true;}
}
