package instituto.vistas;

import instituto.controlador.CursoData;
import instituto.controlador.MatriculaData;
import instituto.controlador.PersonaData;
import instituto.modelo.Conexion;
import instituto.modelo.Curso;
import instituto.modelo.Matricula;
import instituto.modelo.Persona;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;


public class InscribirmeCurso extends javax.swing.JFrame {

    
    ArrayList<String> listaDeCursos = new ArrayList();

    public InscribirmeCurso() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setSize(800, 600);
        this.setResizable(false);
        llenarComboBox(); // EN EL CONTRUCTOR DE LA CLASE LLAMO A EL METODO LLENAR COMBO BOX PARA QUE CUANDO SE VEA ESA COMBO BOX YA TENGA TODOS LOS NOMBRES DE LOS CURSOS.
    }
    
    Conexion conexion = new Conexion();
    CursoData cursoData = new CursoData(conexion);
    PersonaData personaData = new PersonaData(conexion);
    MatriculaData matriculaData = new MatriculaData(conexion);
    
    public ArrayList<String> obtenerNombreCursos(){    
    ArrayList<Curso> cursos = cursoData.obtenerCursos(); // AQUI BUSCA LA LISTA DE TODOS LOS CURSOS QUE HAYA EN LA BASE DE DATOS(EL CURSODATA VA A LA BASE DE DATOS Y BUSCA TODOS LOS CURSOS Y LOS METE EN UNA IISTA DE CURSOS)
  
        for(int i=0; i < cursos.size(); i++){ // LO QUE HACE ES CON ESA LISTA DE CURSOS (CURSOS DE TIPO CURSOS) POR CADA UNO DE ELLOS LE PIDE EL NOMRBRE 
           String nombreCurso = cursos.get(i).getNombre();// ACA LE PIDE EL NOMBRE CON EL GETTTER GETNOMBRE
           listaDeCursos.add(nombreCurso); // A LA LSITA DE STRING (LISTADECRUSOS) LE AGREGO CADA UNO DE LOS NOMBRE DE LOS CURSOS
        }
    return listaDeCursos;
    }

    
    public void llenarComboBox(){
        listaDeCursos = this.obtenerNombreCursos(); // ACA LLENO ESA LISTA DE NOMBRES CON TODOS LOS NOMBRES DE LOS CURSOS
        
        for(String nombreCurso:listaDeCursos){
            jcbCursos.addItem(nombreCurso); // AGREGO ITEMS A LA COMBO BOX CON TODOS LOS NOMBRES DE LOS CURSOS
        }
    }
    
    public boolean personaValida(int id){
        ArrayList<Integer> personasValidas = personaData.todosLosIdPersona();
        
        for(int i = 0;i < personasValidas.size();i++){
            int x = personasValidas.get(i);
            if(x == id){
                return true;
            }
        }
        return false;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jcbCursos = new javax.swing.JComboBox<>();
        jtfAlumno = new javax.swing.JTextField();
        jbVolverAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(83, 146, 191));

        jPanel1.setBackground(new java.awt.Color(28, 134, 192));

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 20)); // NOI18N
        jLabel1.setText("Seleccione el curso al que desea inscribirse ");

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 18)); // NOI18N
        jLabel2.setText("CURSO");

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 18)); // NOI18N
        jLabel3.setText("ID ALUMNO");

        jButton1.setBackground(new java.awt.Color(158, 198, 255));
        jButton1.setText("Inscribirme");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jcbCursos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jcbCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbCursosActionPerformed(evt);
            }
        });

        jtfAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfAlumnoActionPerformed(evt);
            }
        });

        jbVolverAtras.setBackground(new java.awt.Color(158, 198, 255));
        jbVolverAtras.setText("Volver Atras");
        jbVolverAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVolverAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jcbCursos, 0, 462, Short.MAX_VALUE)
                    .addComponent(jtfAlumno))
                .addGap(48, 48, 48))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(138, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jbVolverAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(118, 118, 118))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(148, 148, 148))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel1)
                .addGap(71, 71, 71)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(118, 118, 118)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbVolverAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(88, 88, 88))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String alumno = jtfAlumno.getText();
        if(!alumno.isEmpty()){
              Date fechita = new Date(); // ESTO ME DA LA FECHA ACTUAL OSEA LA QUE TIENE LA COMPUTADORA EN ESTE MOMENTO
              java.sql.Date fechaEnSql = new java.sql.Date(fechita.getTime()); // ESTO CAMBIA LA FECHA DE JAVA A FECHA DE SQL (PARA QUE SE PUEDA CARGAR EN LA BASE DE DATOS) SQL NO TOMA EL TIPO DE FECHA DE JAVA POR ESO NECESITA LA SQL DATE
              String cursoSeleccionado = (String)jcbCursos.getSelectedItem(); // ESTO ME DA EL NOMBRE DEL CURSO SELECCIONADO EN LA COMBO BOX
              Curso curso = cursoData.buscarCursoPorNombre(cursoSeleccionado); // ACA BUSCO EN LA BASE DE DATOS EL CURSO CON EL NOMBRE SELECCIONADO
              Double costo = curso.getCosto(); // ACA CON EL CURSO YA ENCONTRADO, LE PIDO EL COSTO
              int idPersona = Integer.parseInt(jtfAlumno.getText()); // ACA TOMA EL VALOR QUE LE PASAS EN EL CAMPO "NUMERO DE ALUMNO " Y BUSCA EN LA BASE DE DATOS UNA PERSONA CON ESE NUMERO (ID)  
              Persona persona = personaData.buscarPersona(idPersona); // BUSCA EN LA BASE DE DATOS CON EL ID YA ENCONTRADO ARRIBA

              if(personaValida(idPersona) == false){
                JOptionPane.showMessageDialog(rootPane, "El ID ingresado es invalido");  
              }else{
                    if(cursoData.hayDisponibilidad(curso.getIdCurso())){
                          Matricula matricula = new Matricula (fechaEnSql,costo,persona,curso); // CREA UN OBJETO MATRICULA CON TODOS LOS DATOS NECESARIOS
                          matriculaData.crearMatricula(matricula); // CARGA EN LA BASE DE DATOS EN LA TABLA MATRICULA UNA NUEVA MATRICULA (INSCRIPCION A MATERIA)
                          JOptionPane.showMessageDialog(rootPane, "Te has matriculado correctamente");
                          MenuPrincipal menu = new MenuPrincipal();
                          menu.setVisible(true);
                          dispose();
                  }else{
                     JOptionPane.showMessageDialog(rootPane, "Este curso ya no posee cupos disponibles"); 
                  } 
              }  
        }else{
             JOptionPane.showMessageDialog(rootPane, "Por favor, completa todos los campos para poder inscribirte a un curso"); 
        }

        
         
          
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jcbCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbCursosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbCursosActionPerformed

    private void jtfAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfAlumnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfAlumnoActionPerformed

    private void jbVolverAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVolverAtrasActionPerformed
        Cursos cursos = new Cursos();
        cursos.setVisible(true);
        this.dispose(); 
    }//GEN-LAST:event_jbVolverAtrasActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InscribirmeCurso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbVolverAtras;
    private javax.swing.JComboBox<String> jcbCursos;
    private javax.swing.JTextField jtfAlumno;
    // End of variables declaration//GEN-END:variables
}
