/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instituto.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author azu15
 */
public class Conexion { 
    
    private String  url;
    private String usuario;
    private String password;
    private Connection conexion; 
    
    
    
    public Conexion(String url, String usuario, String password) throws ClassNotFoundException { //lanzar classnotfoundexception
        
        this.url = url;
        this.usuario = usuario;
        this.password = password;

     }
    
    public Connection getConexion() throws ClassNotFoundException, SQLException {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            return conexion = DriverManager.getConnection(url,usuario,password);
           
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void setEnabled(boolean b) { //setando el valor disponible 
        System.out.println("Error en la clase conexion");
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
