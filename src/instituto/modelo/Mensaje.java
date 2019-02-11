/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instituto.modelo;
import java.util.Date;

/**
 *
 * @author azu15
 */
public class Mensaje {
    private int idMensaje;
    private Date fechaMensaje;
    private String textoMensaje;
    private Persona persona;

    public Mensaje(Date fechaMensaje, String textoMensaje, Persona persona) {
        this.fechaMensaje = fechaMensaje;
        this.textoMensaje = textoMensaje;
        this.persona = persona;
    }
    
      public Mensaje() {
        
    }

    public Mensaje(int idMensaje,Date fechaMensaje, String textoMensaje, Persona persona) {
        this.idMensaje = idMensaje;
        this.fechaMensaje = fechaMensaje;
        this.textoMensaje = textoMensaje;
    }
      
     
      
    public int getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(int idMensaje) {
        this.idMensaje = idMensaje;
    }

    public Date getFechaMensaje() {
        return fechaMensaje;
    }

    public void setFechaMensaje(Date fechaMensaje) {
        this.fechaMensaje = fechaMensaje;
    }

    public String getTextoMensaje() {
        return textoMensaje;
    }

    public void setTextoMensaje(String textoMensaje) {
        this.textoMensaje = textoMensaje;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    
    
}
