/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilis;
import java.sql.*;

/**
 *
 * @author remo
 */
public class Datasource {

    private final String url = "jdbc:mysql://localhost:3306/piz";
    private final String user = "root";
    private final String pwd = "";
    
    private Connection cnx;
    private static Datasource instance;
    
    private Datasource() {
        try {
            cnx = DriverManager.getConnection(url, user, pwd);
            System.out.println("database connected");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public Connection getCnx() {
        return cnx;
    }
    
    
    public static Datasource getInstance() {
        if(instance == null){
            instance = new Datasource();
        }
        return instance;
    }
    
    
    
    
    
}
