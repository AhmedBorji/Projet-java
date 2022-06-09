/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Certification;
import entities.question;
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
public class questioncrud implements Icertification<question> {
    



    private Connection conn;
    private Statement ste;
    private PreparedStatement pste;

    public questioncrud() {
        conn = Datasource.getInstance().getCnx();
    }
 
   
   private int Id_Q;
    private int Id_certif;
    private String Question;
    private String rep1;
    private String rep2;
    private String rep3;
    private String Rep_correct;
    private int Score;
    private int Resultat;
    
         
   
    @Override
    public void ajouter(question q) {
         String req = "INSERT INTO `question` (`Id_Q`,`Id_certif` ,`rep1`,`rep2`,`rep3`,`Rep_correct`,`Score`,`Resultat`) VALUE (?,?,?,?,?,?,?,?,?)";
        try {
            pste = conn.prepareStatement(req);
            pste.setInt(1,q.getId_Q());
            pste.setInt(2,q.getId_certif());
            pste.setString(3,q.getQuestion());
            pste.setString(4,q.getRep1());
            pste.setString(5,q.getRep2());
            pste.setString(6,q.getRep3());
            pste.setString(7,q.getRep_correct());
            pste.setInt(8,q.getScore());
            pste.setInt(9,q.getResultat());
            
            
           
            pste.executeUpdate();
            System.out.println("question créée");
        } catch (SQLException ex) {
            Logger.getLogger(questioncrud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    @Override
    public void modifier( int Id_Q ,question q)    {
     
 
        String req = "UPDATE `question,` SET "
                +"`Id_Q`=?,`Titre`=?,`Type_certif`=?"
                + "WHERE Id_Q = '" + Id_Q + "'";
    
        try {
           
            pste = conn.prepareStatement(req);
            pste.setInt(1,q.getId_Q());
            pste.setInt(2,q.getId_certif());
            pste.setString(3,q.getQuestion());
            pste.setString(4,q.getRep1());
            pste.setString(5,q.getRep2());
            pste.setString(6,q.getRep3());
            pste.setString(7,q.getRep_correct());
            pste.setInt(8,q.getScore());
            pste.setInt(9,q.getResultat());
            
             
            pste.executeUpdate();
            System.out.println("question modifier");
        } catch (SQLException ex) {
            System.err.println("fdsgfdgfds");
        }
    }
    @Override
    public void supprimer(int Id_Q )  {
      String delete = "DELETE FROM question  where Id_Q = ?";
        try {
            pste = conn.prepareStatement(delete);
            pste.setInt(1,Id_certif);
            pste.executeUpdate();
       
        } catch (SQLException ex) {
                  
            Logger.getLogger(questioncrud.class.getName()).log(Level.SEVERE, null, ex);        
       
        }
    
    }

    @Override
    public List<question> afficher() {
        List<question> question;
        question = new ArrayList<>();
        String req = "SELECT * FROM `question`";
        
        try {

            ste = conn.createStatement();
            ResultSet rs = ste.executeQuery(req);
            
            while(rs.next()){
                question q = new question();
                q.setId_Q(rs.getInt(1));
                
                q.setId_certif (rs.getInt(2));
                q.setQuestion(rs.getString(3));
                q.setRep1( rs.getString(4));
                q.setRep2( rs.getString(5));
                q.setRep3( rs.getString(6));
                q.setRep_correct( rs.getString(7));
                q.setScore (rs.getInt(8));
                q.setResultat (rs.getInt(9));

                
              
              
                 question.add(q) ;                                        
                                                   
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(questioncrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return question;
    }

    
  

            
         

 

    
    
  

  

  
}
