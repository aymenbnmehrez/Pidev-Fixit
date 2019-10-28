/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import static com.itextpdf.text.Element.TITLE;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import entite.HeaderFooter;
import entite.PDFCreator;
import entite.Service;
import static fixit.Fixit.PDF_EXTENSION;
import static fixit.Fixit.getDataObjectList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
import service.ServiceFixit;
import utils.DataSource;
import entite.HeaderFooter;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class ReadallsController implements Initializable {
    private int x = NULL;
    @FXML
    private TableView<Service> allservice;
    @FXML
    private TableColumn<Service, String> allid;
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
       private static final String TITL = "TestReport";
    public static final String PDF_EXTENSION = ".pdf";
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    private int Id_service;
    private int Id_category;
    @FXML
    private TextField rechercherfiled;

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

        allid.setCellValueFactory(new PropertyValueFactory<>("name_service"));
        allcategory.setCellValueFactory(new PropertyValueFactory<>("name_category"));
        allname.setCellValueFactory(new PropertyValueFactory<>("picture_category"));

    }

    private void loadData() {
         ObservableList<Service> data = null;
        try {
            data = FXCollections.observableArrayList(new ServiceFixit().readAll());
        } catch (SQLException e) {
            e.printStackTrace();
        
        }
        allservice.setItems(data);
    }

   

    @FXML
    private void AddService(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("../GUI/addservice.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }


    @FXML
    private void DeleteService(ActionEvent event) {
        Service s = allservice.getSelectionModel().getSelectedItem();
    ServiceFixit sf = new ServiceFixit();
    String name_service = s.getName_service();
   // int Id_service = s.getId_service();
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Boîte de dialogue de confirmation");
            alert.setHeaderText(null);
            alert.setContentText("Êtes-vous sûr de vouloir supprimer"+s.getName_service());
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
    private void update1(MouseEvent event) throws FileNotFoundException {
        
        
        ServiceFixit sa = new ServiceFixit();

        Service p = allservice.getSelectionModel().getSelectedItem();
        Id_service = p.getId_service();
        this.x= p.getId_service();
        modnom.setText(p.getName_service());
          System.out.println(p.getId_category());
          System.out.println("aaaaaaaaaaaaaa"+p.getId_service());
        modid.setText(String.valueOf(p.getId_category()));
             Service s = allservice.getSelectionModel().getSelectedItem();
      
        ServiceFixit sf = new ServiceFixit();
        int id = s.getId_category();
        String title=s.getPicture_category();
        FileInputStream input = new FileInputStream("C:\\wamp\\www\\"+title+"");
        Image image = new Image(input);
        ImageView view = new ImageView();
        view.setImage(image);
        Stage imageShow = new Stage();

        Group root = new Group();
        Scene scene = new Scene(root);
        HBox box = new HBox();
        box.getChildren().setAll(view);
        root.getChildren().setAll(box);

        imageShow.setTitle("L'mage de service");
        imageShow.setHeight(300.0);
        imageShow.setWidth(300.0);
        imageShow.centerOnScreen();
        imageShow.setScene(scene);
        imageShow.showAndWait();
     

        
       
        
    }
    
    @FXML
    private void updateserv(ActionEvent event) throws SQLException, IOException {
      
               ServiceFixit sa = new ServiceFixit();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Boîte de dialogue de confirmation");
            alert.setHeaderText(null);
            alert.setContentText("Êtes-vous sûr de vouloir modifier ce sevice");
            Optional<ButtonType> action = alert.showAndWait();
            if (action.get() == ButtonType.OK)
               sa.updateService(this.x,modnom.getText(),Integer.valueOf(modid.getText()));
               System.out.println(modid.getLength());
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/readalls.fxml"));
       Scene scene = new Scene(root);
      Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
               
               
            }

    @FXML
    private void rechercherService(ActionEvent event) throws SQLException {
        String s= rechercherfiled.getText();
        ObservableList<Service> data = null;
        data = FXCollections.observableArrayList(new ServiceFixit().filtreService(s));
        allid.setCellValueFactory(new PropertyValueFactory<>("name_service"));
        allcategory.setCellValueFactory(new PropertyValueFactory<>("name_category"));
        allname.setCellValueFactory(new PropertyValueFactory<>("picture_category"));
    
        allservice.setItems(data);
    }

    @FXML
    private void PDF(ActionEvent event) throws SQLException {
     
        ServiceFixit serviceFixit=new ServiceFixit();
        List<Service> dataObjList =serviceFixit.readAll();
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
    private void Logout(ActionEvent event) throws IOException {
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
                  
                }
    }


    
   
     
    

     

