/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instituto.controlador;

import instituto.modelo.Conexion;
import instituto.modelo.Curso;
import instituto.modelo.Matricula;
import instituto.modelo.Persona;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author azu15
 */
public class MatriculaData {
    
    
    private Connection connection = null; //es el objeto a traves del cual materiaDATA se va a poder realizar las operraciones sobre la table materia en la base de dtos
    private Conexion conexion;
   
    public MatriculaData(Conexion conexion) { //atributo del tipo connection va a ser iniciaizado desde el constructor de materia data
         
        try {
            this.conexion = conexion;
            connection = conexion.getConexion();
            
            
        } catch (SQLException ex) {
            System.out.println("Error al obtener la conexion");
        }
    }
  
    public void crearMatricula(Matricula matricula){
        try {
            
                String sql = "INSERT INTO matricula (fecha_de_inscripcion,costo,persona_id,curso_id) VALUES ( ? , ? , ? , ? );";

                    try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                        ps.setDate(1, (Date)matricula.getFechaDeInscripcion());
                        ps.setDouble(2, matricula.getCosto());
                        ps.setInt(3, matricula.getPersona().getIdPersona());
                        ps.setInt(4,matricula.getCurso().getIdCurso());
                        
                        ps.executeUpdate();
                        ps.close();
                    }
    
        } catch (SQLException ex) {
            System.out.println("Error al crear una matricula: " + ex.getMessage());
        }
    }
    
    public void eliminarMatricula(int idMatricula) {
        
        try {
            String sql = "DELETE FROM matricula WHERE id_matricula =?;"; // envia una consulta donde elimina el cliente con el id que obtumo por parametro
       
             PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); {
                ps.setInt(1, idMatricula);
                
                
                ps.executeUpdate();
                ps.close();
            }
        } catch (SQLException ex) {
            System.out.println("Error al eliminar una matricula; " + ex.getMessage());
        }
        
    }
    
    public void actualizarMatricula (Matricula matricula){ //actualiza los datos de una persona a traves del id que se lo pasas por parametro
        
        try {
            
            String sql = "UPDATE matricula SET costo = ?;";

                    PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                        
                       
                        ps.setDouble(1, matricula.getCosto());
                        
                        ps.executeUpdate();
                        
                        ps.close();
      
                    
    
        } catch (SQLException ex) {
            System.out.println("Error al actualizar datos de una matricula: " + ex.getMessage());
        }
    }
    
    public ArrayList<String> obtenerAlumnosPorCurso (int idCurso){
        
        ArrayList<String> alumnosEnCurso = new ArrayList();
        
        try {
            
            String sql = "SELECT nombre_apellido FROM matricula INNER JOIN persona WHERE matricula.persona_id = persona.id_persona  AND curso_id = ?;";

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idCurso);
           
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                    
                String nombre;
                
                nombre = rs.getString("nombre_apellido");
                alumnosEnCurso.add(nombre);
            
            }      
            ps.close();
            

        } catch (SQLException ex) {
            System.out.println("Error al buscar alumnos de un determinado curso: " + ex.getMessage());
        }
        
        return alumnosEnCurso;        
    }
    
  
  }

  