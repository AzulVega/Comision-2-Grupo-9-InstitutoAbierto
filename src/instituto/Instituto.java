/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instituto;


import instituto.controlador.CursoData;
import instituto.modelo.Conexion;
import instituto.modelo.Curso;
import static java.nio.file.Files.list;
import java.util.ArrayList;
import static java.util.Collections.list;




/**
 *
 * @author azu15
 */
public class Instituto {
     
    public static void main(String[] args) {
        
Conexion connection = new Conexion();

ArrayList <Curso> cursos = new <Curso>(list);

CursoData cd = new CursoData(connection);

cd.buscarCursos(cursos);

}
    }