/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Certification;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import services.certificationcrud;

/**
 * FXML Controller class
 *
 * @author BEDOUI
 */
public class ModificationController implements Initializable {

    @FXML
    private Label Id_entreprise;
    @FXML
    private TextField a;
    @FXML
    private TextField b;
    @FXML
    private TextField c;
    @FXML
    private TextField e;
    @FXML
    private Button modif1;
    @FXML
    private Button back2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void modifier(ActionEvent event) {
        certificationcrud ce = new certificationcrud();
         ce.modifier(new Certification(Integer.parseInt(e.getText()) ,Integer.parseInt(a.getText()), b.getText(),c.getText()));
       
    }

    @FXML
    private void backreclamation(ActionEvent event) {
         try{
           back2.getScene().getWindow().hide();
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
    }
    

