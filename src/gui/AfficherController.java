/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.pdf.PdfWriter;
import entities.Certification;
import java.awt.Desktop;
import java.io.FileOutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import javax.swing.text.Document;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import services.certificationcrud;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import java.io.File;
import utilis.Datasource;


/**
 * FXML Controller class
 *
 * @author BEDOUI
 */
public class AfficherController implements Initializable {

    @FXML
    private TableView<Certification> table_view;
    @FXML
    private TableColumn<Certification, Integer> a;
    @FXML
    private TableColumn<Certification, Integer> b;
    @FXML
    private TableColumn<Certification, String> c;
    @FXML
    private TableColumn<Certification, String> d;
    @FXML
    private Button back3;
    @FXML
    private TextField idddd;
    @FXML
    private Button supp;
    @FXML
    private TextField rechercher;
    private final  ObservableList<Certification> liste = FXCollections.observableArrayList();
    @FXML
    private Button pdf;
    @FXML
    private TextField Tit;
    @FXML
    private TextField Type_c;
    @FXML
    private Button Modif;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Certification t=new Certification();
        certificationcrud ce=new certificationcrud();
        List Certification=ce.afficher();
        ObservableList liste=FXCollections.observableArrayList(Certification);
        table_view.setItems(liste);
        a.setCellValueFactory(new PropertyValueFactory<>("Id_user"));
        b.setCellValueFactory(new PropertyValueFactory<>("Id_certif"));
        c.setCellValueFactory(new PropertyValueFactory<>("Titre"));
        d.setCellValueFactory(new PropertyValueFactory<>("Type_certif"));
          
       
       
       
                FilteredList<Certification> filteredData = new FilteredList<>(liste, b -> true);
		
		rechercher.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(new Predicate<Certification>() {
                            public boolean test(Certification Certification) {
                                
                                if (newValue == null || newValue.isEmpty()) {
                                    return true;
                                }
                                
                                String lowerCaseFilter = newValue.toLowerCase();
                                
                                if (Certification.getType_certif().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
                                    return true; 
                                } else if (Certification.getTitre().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                                    return true; 
                                }
                             //   else if (Certification.getTitre_Rep().toLowerCase().indexOf(lowerCaseFilter) != -1)
                               //     return true;
                              
                                else
                                    return false; 
                            }
                        });
		});
		
		SortedList<Certification> sortedData = new SortedList<>(filteredData);
	
		sortedData.comparatorProperty().bind( table_view.comparatorProperty());
		
		 table_view.setItems(sortedData);
    }    

     
    public void showBox(){
        Certification t=new Certification();
        certificationcrud ce=new certificationcrud();
        List Certification=ce.afficher();
        ObservableList list=FXCollections.observableArrayList(Certification);
        table_view.setItems(list);
        a.setCellValueFactory(new PropertyValueFactory<>("Id_user"));
        b.setCellValueFactory(new PropertyValueFactory<>("Id_certif"));
        c.setCellValueFactory(new PropertyValueFactory<>("Titre"));
        d.setCellValueFactory(new PropertyValueFactory<>("Type_certif"));
        
    }
    @FXML
    private void selectdl(MouseEvent event) {
         Certification evt = table_view.getSelectionModel().getSelectedItem();
            String a = Integer.toString(evt.getId_certif());
        idddd.setText(a);
        
        Tit.setText(evt.getTitre());
        Type_c.setText(evt.getType_certif());
    }

    @FXML
    private void back3(ActionEvent event) {
               try{
           back3.getScene().getWindow().hide();
            Parent root =FXMLLoader.load(getClass().getResource("../GUI/certification.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
                
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @FXML
    private void handleButtonActionsupprimer(ActionEvent event) {
        certificationcrud re = new certificationcrud();

        re.supprimer(Integer.parseInt(idddd.getText()));
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Votre evenement est supprimé  avec succees");
        alert.setHeaderText("Evenement supprimé");
                alert.showAndWait();
                   List Certification=re.afficher();
        ObservableList list=FXCollections.observableArrayList(Certification);
        table_view.setItems(list);
        a.setCellValueFactory(new PropertyValueFactory<>("Id_certif"));
        b.setCellValueFactory(new PropertyValueFactory<>("Id_user"));
        c.setCellValueFactory(new PropertyValueFactory<>("Titre"));
        d.setCellValueFactory(new PropertyValueFactory<>("Type_certif"));
        idddd.clear();
    }

   @FXML
    private void pdf(ActionEvent event){ //throws IOException {
       
    try { 
                 
              
                com.itextpdf.text.Document doc = new com.itextpdf.text.Document() {} ;
                PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\BEDOUI\\Desktop\\a.pdf"));
                doc.open();
                
                
                doc.add(new Paragraph(" "));
               doc.add(new Paragraph("liste des certification : "));
               doc.add(new Paragraph(" "));
                
                
//                 Paragraph p =new Paragraph();
//                p.add("liste de produit");
//              
//                
//                 
//                
//                
//             doc.add(p);
             
                 PdfPTable t = new PdfPTable(4);
                 t.setWidthPercentage(100);
            PdfPCell c = new PdfPCell(new Phrase("Id_certif"));
            c.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            c.setBackgroundColor(BaseColor.GRAY);
            t.addCell(c);
             c = new PdfPCell(new Phrase("Id_user"));
             c.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            c.setBackgroundColor(BaseColor.GRAY);
            t.addCell(c);
              c = new PdfPCell(new Phrase("Titre"));
              c.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            c.setBackgroundColor(BaseColor.GRAY);
            t.addCell(c);
              c = new PdfPCell(new Phrase("Type_certif"));
              c.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            c.setBackgroundColor(BaseColor.GRAY);
            t.addCell(c);
//             c = new PdfPCell(new Phrase("nom"));
//              c.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
//            c.setBackgroundColor(BaseColor.GRAY);
//            t.addCell(c);
            
            
            doc.add(t);
               
            
              Connection conn = Datasource.getInstance().getCnx();
            String query = "select * from certification";
            Statement stmt = null;
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            Paragraph p3 = null;
                PdfPTable table = new PdfPTable(4);
                 table.setWidthPercentage(100);
               while(rs.next()){ 
           
//                 
//            PdfPCell  c1 = new PdfPCell(new Phrase(rs.getString("id_rec")));
//            c1.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
//            c1.setBackgroundColor(BaseColor.WHITE);
//            table.addCell(c1);
                 
          PdfPCell   c1 = new PdfPCell(new Phrase(rs.getString("Id_certif")));
             c1.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            c1.setBackgroundColor(BaseColor.WHITE);
            table.addCell(c1);
            
               c1 = new PdfPCell(new Phrase(rs.getString("Id_user")));
             c1.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            c1.setBackgroundColor(BaseColor.WHITE);
            table.addCell(c1);
                 
             c1 = new PdfPCell(new Phrase(rs.getString("Titre")));
             c1.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            c1.setBackgroundColor(BaseColor.WHITE);
            table.addCell(c1);
             c1 = new PdfPCell(new Phrase(rs.getString("Type_certif")));
             c1.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            c1.setBackgroundColor(BaseColor.WHITE);
            table.addCell(c1);
//            
//             c1 = new PdfPCell(new Phrase(rs.getString("nom")));
//             c1.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
//            c1.setBackgroundColor(BaseColor.WHITE);
//            table.addCell(c1);
             
               }
               
         // table.setHeaderRows(1);
//         ObservableList<Produit> list = (ObservableList<Produit>) ps.afficherProduit();
 //  colids.setCellValueFactory(new PropertyValueFactory<Produit,Integer>("id"));
//      colprix.setCellValueFactory(new PropertyValueFactory<Produit,Integer>("prix"));
//      colquan.setCellValueFactory(new PropertyValueFactory<Produit,Integer>("quantite"));
//      date_exp.setCellValueFactory(new PropertyValueFactory<Produit,Date>("date_exp"));
//      coltype.setCellValueFactory(new PropertyValueFactory<Produit,String>("type"));
//     
//        tab_s.setItems(list);
       
//        table.addCell("");
//   table.addCell("1.1");
//             table.addCell("1.2");
//               table.addCell("2.1");
//                table.addCell("2.2");
//                 table.addCell("2.3");
               doc.add(table);
                
                doc.close();
                Desktop.getDesktop().open(new File("C:\\Users\\BEDOUI\\Desktop\\a.pdf"));
             } catch (Exception e) {
          System.err.print(e);
             }
    
  
    
    }

    @FXML
    private void Modif(ActionEvent event) {
        
        certificationcrud ce =new certificationcrud();
        Certification c = new Certification();
        int id=Integer.parseInt(idddd.getText());
        c.setId_certif(id);
        c.setTitre(Tit.getText());
        c.setType_certif(Type_c.getText());
        
        ce.modifier(c);
        showBox();
    }
  
    
    
    
    
}
