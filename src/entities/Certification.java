/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;




/**
 *
 * @author medal
 */
public class Certification {
    private int Id_certif;
    private int Id_user;
    private String Titre;
    private String Type_certif;

    public Certification(int Id_certif, int Id_user, String Titre, String Type_certif) {
        this.Id_certif = Id_certif;
        this.Id_user = Id_user;
        this.Titre = Titre;
        this.Type_certif = Type_certif;
    }

    public Certification() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_certif() {
        return Id_certif;
    }

    public int getId_user() {
        return Id_user;
    }

    public String getTitre() {
        return Titre;
    }

    public String getType_certif() {
        return Type_certif;
    }

    public void setId_certif(int Id_certif) {
        this.Id_certif = Id_certif;
    }

    public void setId_user(int Id_user) {
        this.Id_user = Id_user;
    }

    public void setTitre(String Titre) {
        this.Titre = Titre;
    }

    public void setType_certif(String Type_certif) {
        this.Type_certif = Type_certif;
    }

    @Override
    public String toString() {
        return "Certification{" + "Id_certif=" + Id_certif + ", Id_user=" + Id_user + ", Titre=" + Titre + ", Type_certif=" + Type_certif + '}';
    }
  

      

    

    
}
