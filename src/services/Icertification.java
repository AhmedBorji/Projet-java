/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;

/**
 *
 * @author remo
 */
public interface Icertification<T> {
    void ajouter(T entity);
    void modifier(int Id_certif,T entity);
    void supprimer(int Id_certif);
    List<T> afficher();
}
