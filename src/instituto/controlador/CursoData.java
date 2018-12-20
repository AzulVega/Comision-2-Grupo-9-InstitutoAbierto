
package instituto.controlador;

import instituto.modelo.Conexion;
import instituto.modelo.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author azu15
 */
public class CursoData {

    private Connection connection = null; //va nuulll??
    private Conexion conexion;
    
    public CursoData(Conexion conexion) { //atributo del tipo connection va a ser iniciaizado desde el constructor de materia data
         
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

                        ResultSet rs = ps.getGeneratedKeys();
                        
                        if (rs.next()) {
                            curso.setIdCurso(rs.getInt(1));
                        } else {
                            System.out.println("No se pudo obtener el id luego de insertar un curso");
                        }
                        
                        ps.close(); 
                        
        } catch (SQLException ex) {
            System.out.println("Error al guardar un curso: " + ex.getMessage());
          }
        }
        
    public void actualizarCurso (Curso curso){ //actualiza todos los datos de un curso a traves del id que se lo pasas por parametro, menos el id que es autoincrementable
        
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
        
    public Curso buscarCurso(int idCurso){
        
        Curso curso = null;
        
        try {
            
            String sql = "SELECT * FROM curso WHERE id_curso =?;";

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idCurso);
           
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                curso = new Curso();
                
                curso.setIdCurso(rs.getInt("id_curso"));
                curso.setNombre(rs.getString("nombre"));
                curso.setDescripcion(rs.getString("descripcion"));
                curso.setIdResponsableCurso(rs.getInt("id_responsable_curso"));
                curso.setCupoDeAlumnos(rs.getInt("cupo_de_alumnos"));
                curso.setCosto(rs.getDouble("costo"));
            
            }      
            ps.close();
            

        } catch (SQLException ex) {
            System.out.println("Error al buscar un curso: " + ex.getMessage());
        }
        
        return curso;
    }

    public ArrayList<Curso> obtenerCursos(){ 
           ArrayList<Curso> cursos = new ArrayList<Curso>();
        
        try {
            
            String sql = "SELECT * FROM curso;";

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ResultSet rs = ps.executeQuery();
            Curso curso; 
            
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
            System.out.println("Error al obtener los cursos: " + ex.getMessage());
        }
        
        return cursos;
    }
    
    public Curso buscarCursoPorNombre (String nombreCurso){
        
        Curso curso = null;
        
        try {
            
            String sql = "SELECT * FROM curso WHERE nombre = ?;";

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, nombreCurso);
           
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                curso = new Curso();
                
                curso.setIdCurso(rs.getInt("id_curso"));
                curso.setNombre(rs.getString("nombre"));
                curso.setDescripcion(rs.getString("descripcion"));
                curso.setIdResponsableCurso(rs.getInt("id_responsable_curso"));
                curso.setCupoDeAlumnos(rs.getInt("cupo_de_alumnos"));
                curso.setCosto(rs.getDouble("costo"));
            
            }      
            ps.close();
            

        } catch (SQLException ex) {
            System.out.println("Error al buscar un curso: " + ex.getMessage());
        }
        
        return curso;
    }
    
       /* public int cantidadDeInscriptos(int cursoId){ 
           int cupos = 0;
           
          try {
            String SQL = "SELECT curso_id, COUNT(*) FROM matricula GROUP BY curso_id WHERE curso_id = ?;";

            PreparedStatement ps = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, cursoId);
            
            ResultSet rs = ps.executeQuery();
            
            cupos = rs.getInt("COUNT(*)");
        
          
            } catch (SQLException ex) {
            System.out.println("Error al buscar un curso: " + ex.getMessage());
            }
          
          
          return cupos;
          
          }*/
    
    public boolean hayDisponibilidad(int cursoId){
        int cupo = 0;
        int cantidadDeInscriptos =0;
        
        try{
        
        String sql = "SELECT COUNT (*) FROM curso, matricula WHERE curso.id_curso = matricula.curso_id AND curso.id_curso = ? ;";
         PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
         ps.setInt(1,cursoId);
         ResultSet rs = ps.executeQuery();
         
         
         rs.next();
         
         
         cantidadDeInscriptos = rs.getInt(1);

         
         
         
         sql = "SELECT cupo_de_alumnos FROM curso WHERE curso.id_curso = ? ;";
         
         ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
         ps.setInt(1,cursoId);
         rs = ps.executeQuery();
         
         if (rs.next()) {
           cupo = rs.getInt(1);
         }
         
         
         
        }catch (SQLException ex) {
            System.out.println("Error al buscar un curso: " + ex.getMessage());
        }
        
        return cantidadDeInscriptos < cupo;
        
    }
        

    
 
    }