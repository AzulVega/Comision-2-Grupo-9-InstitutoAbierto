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
public class Curso {
   private int idCurso; // lo unico que es privado son los atributos 
   private String nombre;
   private String descripcion;
   private int idResponsableCurso;
   private int cupoDeAlumnos;
   private double costo;

    public Curso(String nombre, String descripcion, int idResponsableCurso, int cupoDeAlumnos, double costo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.idResponsableCurso = idResponsableCurso;
        this.cupoDeAlumnos = cupoDeAlumnos;
        this.costo = costo;
    }
    
    public Curso() {
        // los metodos son todos publicos para que puedas acceder desde otras clases 
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdResponsableCurso() {
        return idResponsableCurso;
    }

    public void setIdResponsableCurso(int idResponsableCurso) {
        this.idResponsableCurso = idResponsableCurso;
    }

    public int getCupoDeAlumnos() {
        return cupoDeAlumnos;
    }

    public void setCupoDeAlumnos(int cupoDeAlumnos) {
        this.cupoDeAlumnos = cupoDeAlumnos;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
   
   
}
