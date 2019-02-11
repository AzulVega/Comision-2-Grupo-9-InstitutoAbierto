/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instituto.controlador;

import instituto.modelo.Conexion;
import instituto.modelo.Mensaje;
import instituto.modelo.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;

/**
 *
 * @author azu15
 */
public class MensajeData {
     private Connection connection = null; 
    private Conexion conexion;
   
    public MensajeData(Conexion conexion) { 
         
        try {
            this.conexion = conexion;
            connection = conexion.getConexion();
            
            
        } catch (SQLException ex) {
            System.out.println("Error al obtener la conexion");
        }
    }
    
    public void guardarMensaje(Mensaje mensaje){
        try {
            
                String sql = "INSERT INTO mensaje (fecha_mensaje, texto_mensaje, persona_id) VALUES ( ? , ? , ? );";

                    try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                        ps.setDate(1, (Date)mensaje.getFechaMensaje());
                        ps.setString(2, mensaje.getTextoMensaje());
                        ps.setInt(3, mensaje.getPersona().getIdPersona());
                        
                        
                        ps.executeUpdate();
                        ps.close();
                    }
    
        } catch (SQLException ex) {
            System.out.println("Error al guardar un mensaje: " + ex.getMessage());
        }
    }
    
     public ArrayList<Mensaje> obtenerMensajes(){ 
           ArrayList<Mensaje> mensajes = new ArrayList<Mensaje>();
        
        try {
            
            String sql = "SELECT * FROM mensaje;";

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ResultSet rs = ps.executeQuery();
            Mensaje mensaje; 
            
            while(rs.next()){
                mensaje = new Mensaje();
                
                mensaje.setIdMensaje(rs.getInt("id_mensaje"));
                mensaje.setFechaMensaje(rs.getDate("fecha_mensaje"));
                mensaje.setTextoMensaje(rs.getString("texto_mensaje"));
                
                
                PersonaData pd = new PersonaData(conexion);
                Persona persona = pd.buscarPersona(rs.getInt("persona_id"));
                mensaje.setPersona(persona);
                
                mensajes.add(mensaje);
            }      
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al obtener los mensajes: " + ex.getMessage());
        }
        
        return mensajes;
      }
     
     
     }