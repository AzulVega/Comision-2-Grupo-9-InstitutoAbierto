
package instituto.controlador;
import instituto.modelo.Conexion;
import instituto.modelo.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author azu15
 */
public class PersonaData {
    private Connection connection = null; //va el NULL????? // es el paquete
    private Conexion conexion; // es la clase 

    public PersonaData(Conexion conexion) {
        
        try {
        connection = conexion.getConexion(); //connection se van a asignarle la conexion a la base de datos 
            } catch (SQLExepcion ex) {
                System.out.println("Error al obtener la conexion"); //si no se puede obtener la conexion, te tira un cartel con error-
               }
            }

    public void guardarPersona(Persona persona) {
        
        try { //sirve para ejecutar un bloque del codigo y en caso de que haya un problema, muestra el mje que hay en el catch
            
            String sql = "INSERT INTO persona (nombre_apellido, dni, celular) VALUES ( ? , ? , ? );";
            
          try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
                ps.setString(1, persona.getNombreApellido());
                ps.setLong(2, persona.getDni());
                ps.setString(3, persona.getCelular());
                
                ps.executeUpdate(); //para que se ejecute el statement
                ps.close(); // lo cierra
           }
          
        } catch (SQLException ex) {
            System.out.println("Error al guardar una persona: " + ex.getMessage());
        }
    }
    
    
        public void eliminarPersona(int idPersona) { 
            
        try{
       
           String sql = "DELETE FROM persona WHERE id_persona = ? ;";
            
           PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, idPersona); //toma un id persona por parametro y lo elimina
                
                ps.executeUpdate(); //para que se ejecute el statement
                ps.close(); // lo cierra
           }
          
         catch (SQLException ex) {
            System.out.println("Error al eliminar una persona: " + ex.getMessage());
        }
 
}
    
        public void actualizarPersona(Persona persona) { 
            
        try{
       
           String sql = "UPDATE persona SET nombre_apellido = ?, dni = ?, celular = ?;";
            
           PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, persona.getNombreApellido());
                ps.setLong(2, persona.getDni());
                ps.setString(3, persona.getCelular());
                
                ps.executeUpdate(); //para que se ejecute el statement
                ps.close(); // lo cierra
           }
          
         catch (SQLException ex) {
            System.out.println("Error al actualizar una persona: " + ex.getMessage());
        }
 
}  
        
        public Persona buscarPersona(int idPersona){ //Es un getter porque devuelve a la persona 
        
        Persona persona = null; //Si la persona no tiene valor, se va a intentar seleccion una persona utilizando el id.
        try {
            
            String sql = "SELECT * FROM persona WHERE id_persona =?;";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, idPersona);
                
                
                ResultSet resultSet = ps.executeQuery(); //????wtf. Para que sirve el resulset
                
                while(resultSet.next()){  //??????
                    persona = new Persona();
                    
                    persona.setId(resultSet.getInt("id_persona"));
                    persona.setNombreApellido(resultSet.getString("nombre_apellido"));
                    persona.setDni(resultSet.getLong("dni"));
                    persona.setCelular(resultSet.getString("celular"));
                }
            }

        } catch (SQLException ex) {
            System.out.println("Error al buscar un persona: " + ex.getMessage());
        }
        
        return persona;  //va a retornar la persona buscada a traves del id
    }
    
}
