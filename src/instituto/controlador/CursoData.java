/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instituto.controlador;

import instituto.modelo.Conexion;
import instituto.modelo.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author azu15
 */
public class CursoData {

    private Connection connection = null; //va nuulll??
    private Conexion conexion;
    
    public CursoData(Conexion conexion) {
         
        try {
            this.conexion = conexion;
            connection = conexion.getConexion();
            
            
        } catch (SQLException ex) {
            System.out.println("Error al obtener la conexion");
            }
        }

    public void guardarCurso (Curso curso){
       
        try {
            
                String sql = "INSERT INTO curso (nombre, descripcion, id_responsable_curso, cupo_de_alumnos, costo) VALUES ( ? , ? , ? , ? , ? );";

                    PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                        ps.setString(1, curso.getNombre());
                        ps.setString(2, curso.getDescripcion());
                        ps.setInt(3, curso.getIdResponsableCurso());
                        ps.setInt(4, curso.getCupoDeAlumnos());
                        ps.setDouble(5, curso.getCosto());
                        

                        ps.executeUpdate();

                        ps.close(); 
                        
        } catch (SQLException ex) {
            System.out.println("Error al guardar un curso: " + ex.getMessage());
          }
        }
        
        public void actualizarCurso (Curso curso){ //actualiza los datos de un curso a traves del id que se lo pasas por parametro
        
        try {
            
            String sql = "UPDATE curso SET nombre = ?, descripcion = ?, id_responsable_curso = ?, cupo_de_alumnos = ?, costo = ? WHERE id_curso = ?;";

                    PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                        
                       
                        ps.setString(1, curso.getNombre());
                        ps.setString(2, curso.getDescripcion());
                        ps.setInt(3, curso.getIdResponsableCurso());
                        ps.setInt(4, curso.getCupoDeAlumnos());
                        ps.setDouble(5, curso.getCosto());
                        ps.setInt(6, curso.getIdCurso());
                        
                        ps.executeUpdate();
                        
                        ps.close();
      
                    
    
        } catch (SQLException ex) {
            System.out.println("Error al actualizar datos de un curso: " + ex.getMessage());
        }
    }
        
        public void eliminarCurso(int idCurso) {
        
        try {
            String sql = "DELETE FROM curso WHERE id_curso =?;"; // envia una consulta donde elimina el curso con el id que obtumo por parametro
       
             PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); {
                ps.setInt(1, idCurso);
                
                
                ps.executeUpdate();
                ps.close();
            }
        } catch (SQLException ex) {
            System.out.println("Error al eliminar un curso; " + ex.getMessage());
        }
    }

       public ArrayList <Curso> buscarCursos(String nombre){ 
        
        Curso curso = null;
        ArrayList <Curso> cursos = new ArrayList<>();
        try {
            
            String sql = "SELECT * FROM curso WHERE nombre LIKE ?;";

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, "%"+nombre+"%");
            
            ResultSet rs = ps.executeQuery();
           
            
            while(rs.next()){
                curso = new Curso();
                
                curso.setIdCurso(rs.getInt("id_Curso"));
                curso.setNombre(rs.getString("nombre"));
                curso.setDescripcion(rs.getString("descripcion"));
                curso.setIdResponsableCurso(rs.getInt("id_responsable_curso"));
                curso.setCupoDeAlumnos(rs.getInt("cupo_de_alumnos"));
                curso.setCosto(rs.getDouble("costo"));
                cursos.add(curso);
            }      
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al buscar una persona: " + ex.getMessage());
        }
        
        return cursos;
    } 
        
    }
