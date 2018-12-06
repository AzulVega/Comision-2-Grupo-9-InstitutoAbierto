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
public class Matricula {
    private int idMatricula;
    private Date fechaDeInscripcion;
    private double costo;
    private Persona persona;
    private Curso curso;

    public Matricula(Date fechaDeInscripcion, double costo, Persona persona, Curso curso) {
        this.fechaDeInscripcion = fechaDeInscripcion;
        this.costo = costo;
        this.persona = persona;
        this.curso = curso;
    }
    
    public Matricula() {
        
    }

    public int getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(int idMatricula) {
        this.idMatricula = idMatricula;
    }

    public Date getFechaDeInscripcion() {
        return fechaDeInscripcion;
    }

    public void setFechaDeInscripcion(Date fechaDeInscripcion) {
        this.fechaDeInscripcion = fechaDeInscripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

}

    