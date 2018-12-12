/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instituto.controlador;

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

  