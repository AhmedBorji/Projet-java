/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alphateam;

import entities.Certification;
import java.util.Date;
import utilis.Datasource;
import services.certificationcrud;

/**
 *
 * @author medal
 */
public class alphateam {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
  // TODO code application logic here
        Datasource data =Datasource.getInstance();
        Datasource data2 =Datasource.getInstance();
        System.out.println(data.hashCode()+"-"+data2.hashCode());
          
        
        certificationcrud us = new certificationcrud();
     Certification u=new Certification(105535,101010,"AAAAAAAAAAAAA","ZZZZZZZZZZZZ");
     Certification u2=new Certification(12345678,303030,"AAAAA","TTTTTTTTTTTT");
     Certification u3=new Certification(87321,404040,"RRRRRRRRRRRRRRR","BBBBBBBBB");
     Certification u4=new Certification(75502135,505050,"yyyyyyyyyyyyy","KKKKKKKKKKK");
     Certification u5=new Certification(96512135,606060,"MMMMMMMMMM","LLLLLLLLLLLLLLLLL");
     //Date d = new Date("19/02/2020");
     
     
     us.ajouter(u);
     // us.modifier(12502135,u);
      
     //us.supprimer(12345678);
       //ps.modifier(p);
    System.out.print(us.afficher()+"certification:");
    }
    
}
