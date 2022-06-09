/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Certification;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import utilis.Datasource;
/**
 *
 * @author medal
 */
public class certificationcrud implements Icertification<Certification> {
    



    private Connection conn;
    private Statement ste;
    private PreparedStatement pste;

    public certificationcrud() {
        conn = Datasource.getInstance().getCnx();
    }
 
   
    private int Id_certif ;
    private int Id_user;
    private String Titre;
    private String Type_certif;
    
         
   
    @Override
    public void ajouter(Certification u) {
         String req = "INSERT INTO `certification` (`Titre`,`Type_certif`) VALUE (?,?)";
        try {
            pste = conn.prepareStatement(req);
            //pste.setInt(1,u.getId_certif());
            //pste.setInt(2,u.getId_user());
            pste.setString(1,u.getTitre());
            pste.setString(2,u.getType_certif());
            
           
            pste.executeUpdate();
            System.out.println("certification créée");
        } catch (SQLException ex) {
            Logger.getLogger(certificationcrud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    //@Override
    public void modifier(Certification u)    {
     
 
        String req = "UPDATE `certification` SET "
                +"`Titre`=?,`Type_certif`=?"
                + "WHERE Id_certif =? ";
    
        try {
           
            pste = conn.prepareStatement(req);
            //pste.setInt(1,u.getId_certif());
          //  pste.setInt(1,u.getId_user());
            pste.setString(1,u.getTitre());
            pste.setString(2,u.getType_certif());
            pste.setInt(3,u.getId_certif());
             
            pste.executeUpdate();
            System.out.println("Certification modifier");
        } catch (SQLException ex) {
            System.err.println("fdsgfdgfds");
        }
    }
    @Override
    public void supprimer(int Id_certif )  {
      String delete = "DELETE FROM certification  where Id_certif = ?";
        try {
            pste = conn.prepareStatement(delete);
            pste.setInt(1,Id_certif);
            pste.executeUpdate();
       
        } catch (SQLException ex) {
                  
            Logger.getLogger(certificationcrud.class.getName()).log(Level.SEVERE, null, ex);        
       
        }
    
    }

    @Override
    public List<Certification> afficher() {
        List<Certification> certification;
        certification = new ArrayList<>();
        String req = "SELECT * FROM `certification`";
        
        try {

            ste = conn.createStatement();
            ResultSet rs = ste.executeQuery(req);
            
            while(rs.next()){
                Certification u = new Certification();
                u.setId_certif(rs.getInt(1));
                
                u.setId_user (rs.getInt(2));
                u.setTitre(rs.getString(3));
                u.setType_certif( rs.getString(4));
              
              
                 certification.add(u) ;                                        
                                                   
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(certificationcrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return certification;
    }

    @Override
    public void modifier(int Id_certif, Certification entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
  

            
         

 

    
    
  

  

  
}
