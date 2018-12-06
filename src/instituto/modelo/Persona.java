/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instituto.modelo;

/**
 *
 * @author azu15
 */
public class Persona {
   private int idPersona;
   private String nombreApellido;
   private long dni;
   private String celular;

    public Persona(String nombreApellido, long dni, String celular) {
        this.nombreApellido = nombreApellido;
        this.dni = dni;
        this.celular = celular;
    }
    
    public Persona() {
      //Constructor vacio: para inicializar un objeto vacio y luego a traves de los setter, darle valores a sus atributos// 
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) { //seter: es un metodo que se encarga de darle un valor a un atributo//
        this.idPersona = idPersona;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public long getDni() { // getter: devuelve el valor de un atributo//
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
   
   
}
