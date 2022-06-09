/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import java.sql.SQLException;
import entities.Certification;
import java.util.List;
/**
 *
 * @author remo
 */
public interface certificationservice {
    void ajouter(Certification certification) throws SQLException;;
    void modifier(int Id_certif,Certification certification) throws SQLException;;
    void supprimer(int Id_certif) throws SQLException;;
    List<Certification> afficher() throws SQLException;;
}
