/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instituto.controlador;

import instituto.modelo.Conexion;
import instituto.modelo.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author azu15
 */
public class PersonaData {
    private Connection connection = null; 
    private Conexion conexion;
    
    public PersonaData (Conexion conexion){
        
        try {
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            Logger.getLogger(PersonaData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void guardarPersona (Persona persona){ //guarda los datos de una persona, no se le agrega el id porque se crea solo (autoincrementable)
            try {
            
                String sql = "INSERT INTO persona (nombre_apellido, dni, celular) VALUES ( ? , ? , ? );";

                    try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                        ps.setString(1, persona.getNombreApellido());
                        ps.setString(2, persona.getDni());
                        ps.setString(3, persona.getCelular());
                        
                        ps.executeUpdate();
                        ps.close();
                    }
    
        } catch (SQLException ex) {
            System.out.println("Error al guardar una persona: " + ex.getMessage());
        }
    }
    
    public void eliminarPersona(int idPersona) {
        
        try {
            String sql = "DELETE FROM persona WHERE id_persona =?;"; // envia una consulta donde elimina el cliente con el id que obtumo por parametro
       
             PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); {
                ps.setInt(1, idPersona);
                
                
                ps.executeUpdate();
                ps.close();
            }
        } catch (SQLException ex) {
            System.out.println("Error al eliminar una persona; " + ex.getMessage());
        }
    }
    
    public void actualizarPersona (Persona persona){ //actualiza los datos de una persona a traves del id que se lo pasas por parametro
        
        try {
            
            String sql = "UPDATE persona SET nombre_apellido = ?, dni = ?, celular = ? WHERE id_persona = ?;";

                    PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                        
                       
                        ps.setString(1, persona.getNombreApellido());
                        ps.setString(2, persona.getDni());
                        ps.setString(3, persona.getCelular());
                        ps.setInt(4, persona.getIdPersona());
                        
                        ps.executeUpdate();
                        
                        ps.close();
      
                    
    
        } catch (SQLException ex) {
            System.out.println("Error al actualizar datos de una persona: " + ex.getMessage());
        }
    }
    
    public Persona buscarPersona(int idPersona){
        
        Persona persona = null;
        
        try {
            
            String sql = "SELECT * FROM persona WHERE id_persona =?;";

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idPersona);
           
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                persona = new Persona();
                
                persona.setIdPersona(rs.getInt("id_Persona"));
                persona.setNombreApellido(rs.getString("nombre_apellido"));
                persona.setDni(rs.getString("dni"));
                persona.setCelular(rs.getString("celular"));
            
            }      
            ps.close();
            

        } catch (SQLException ex) {
            System.out.println("Error al buscar una persona: " + ex.getMessage());
        }
        
        return persona;
    }
    
    public ArrayList <Persona> buscarPersonas(String nombreApellido){ //se usa string nombre y apellido para obtener el listado de nombres??
        
        Persona persona = null;
        ArrayList <Persona> personas = new ArrayList<>();
        try {
            
            String sql = "SELECT * FROM persona WHERE nombre_apellido LIKE ? OR id LIKE ?;";

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, "%"+nombreApellido+"%");
            ps.setString(2, "%"+nombreApellido+"%");
            
            ResultSet rs=ps.executeQuery();
           
            
            while(rs.next()){
                persona = new Persona();
                
                persona.setIdPersona(rs.getInt("id_Persona"));
                persona.setNombreApellido(rs.getString("nombre_apellido"));
                persona.setDni(rs.getString("dni"));
                persona.setCelular(rs.getString("celular"));
                personas.add(persona);
            }      
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al buscar una persona: " + ex.getMessage());
        }
        
        return personas;
    }
    
    public ArrayList<Integer> todosLosIdPersona(){
        ArrayList<Integer> ids = new ArrayList();
            try {
            
                String sql = "SELECT id_persona FROM persona;";

                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);


                ResultSet rs = ps.executeQuery();


                while(rs.next()){
                    int idPersona;

                    idPersona = rs.getInt("id_persona");

                    ids.add(idPersona);
                }  

                ps.close();
            }
            catch (SQLException ex) {
                System.out.println("Error al obtener todos los ids " + ex.getMessage());
            }
        
            return ids;
        }
}
