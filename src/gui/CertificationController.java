/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import application.MainView;
import com.sun.org.glassfish.gmbal.Description;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import services.certificationcrud;
import entities.Certification;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author BEDOUI
 */
public class CertificationController implements Initializable {

    @FXML
    private Label Id_entreprise2;
    @FXML
    private TextField Id_user;
    @FXML
    private TextField Id_certif;
    @FXML
    private TextField Titre;
    @FXML
    private TextField Type_certif;
    @FXML
    private Button btnajouter;
    @FXML
    private Button modif;
    @FXML
    private Button afficher;
    @FXML
    private Button back1;
    @FXML
    private TextField ids;
    @FXML
    private Button quiz;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouter(ActionEvent event) {
          if(Titre.getText().trim().isEmpty()||Type_certif.getText().trim().isEmpty())
        {
              Alert fail= new Alert(Alert.AlertType.INFORMATION);
                fail.setHeaderText("failure");
                fail.setContentText("you havent typed something");
                fail.showAndWait();
            
        }
              else
            
        {
            Certification c=new Certification();
            certificationcrud ce = new certificationcrud();
            //int i=Integer.parseInt(Id_user.getText());
                   //int j=Integer.parseInt(Id_certif.getText());
                   
           //c.setId_user(i);
           //c.setId_certif(j);
           c.setTitre(Titre.getText());
           c.setType_certif(Type_certif.getText());
           
     
           // if(btnajouter.getText().equals("ajouter"))
            //{
              ce.ajouter(c);
              
              Alert fail= new Alert(Alert.AlertType.INFORMATION);
                fail.setHeaderText("ajout avec succées");
                fail.setContentText("ajout terminé");
                fail.showAndWait();
       
    //}
    }
      /*  reclamationcrud re = new reclamationcrud();

           re.ajouter(new Reclamation(Integer.parseInt(id_us.getText()),Integer.parseInt(id_entre.getText()),Type_re.getText(),Description.getText(),Titre_Rep.getText()));
  */
    }

    @FXML
    private void supprimer(ActionEvent event) {
        certificationcrud ce = new certificationcrud();

        ce.supprimer(Integer.parseInt(ids.getText()));
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Votre certification est supprimé  avec succees");
        alert.setHeaderText("certiifcation supprimé");
               alert.showAndWait();
    }

    @FXML
    private void modifier(ActionEvent event) throws Exception{

        try{
           modif.getScene().getWindow().hide();
            Parent root =FXMLLoader.load(getClass().getResource("../GUI/modification.fxml"));
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
    private void afficher(ActionEvent event) throws Exception{
        try{
           afficher.getScene().getWindow().hide();
            Parent root =FXMLLoader.load(getClass().getResource("../gui/afficher.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
                
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @FXML
    private void backmenu(ActionEvent event) {
         try{
           back1.getScene().getWindow().hide();
            Parent root =FXMLLoader.load(getClass().getResource("../GUI/menu.fxml"));
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
    private void quiz(ActionEvent event) {
        MainView mainV = new MainView();
		mainV.setMainView(); //call MainView
    }
    }
    

