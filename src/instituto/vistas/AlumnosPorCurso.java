
package instituto.vistas;

import instituto.controlador.CursoData;
import instituto.modelo.Conexion;
import instituto.modelo.Curso;
import java.util.ArrayList;


public class AlumnosPorCurso extends javax.swing.JFrame {
    
    ArrayList<String> listaDeCursos = new ArrayList();
    Conexion conexion = new Conexion();
    CursoData cursoData = new CursoData(conexion);
    private String nombreCurso;
    
    public AlumnosPorCurso() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setSize(800, 600);
        this.setResizable(false);
        llenarComboBox();
    }
    
  
    public ArrayList<String> obtenerNombreCursos(){    
    ArrayList<Curso> cursos = cursoData.obtenerCursos(); // AQUI BUSCA LA LISTA DE TODOS LOS CURSOS QUE HAYA EN LA BASE DE DATOS(EL CURSODATA VA A LA BASE DE DATOS Y BUSCA TODOS LOS CURSOS Y LOS METE EN UNA IISTA DE CURSOS)
  
    for(int i=0; i < cursos.size(); i++){ // LO QUE HACE ES CON ESA LISTA DE CURSOS (CURSOS DE TIPO CURSOS) POR CADA UNO DE ELLOS LE PIDE EL NOMRBRE 
       nombreCurso = cursos.get(i).getNombre();// ACA LE PIDE EL NOMBRE CON EL GETTTER GETNOMBRE
       
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
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jcbCursos = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jbAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(28, 134, 192));

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 18)); // NOI18N
        jLabel1.setText("Seleccione un curso para acceder al listado de alumnos:");

        jcbCursos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jcbCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbCursosActionPerformed(evt);
            }
        });

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jbAtras.setText("Atrás");
        jbAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(122, 122, 122))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
                            .addComponent(jcbCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jcbCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 248, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70))
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

    private void jcbCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbCursosActionPerformed

    }//GEN-LAST:event_jcbCursosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ListaDeAlumnosPorCurso listaDeAlumnosPorCurso = new ListaDeAlumnosPorCurso();
        listaDeAlumnosPorCurso.setVisible(true);
        String cursoSeleccionado = (String)jcbCursos.getSelectedItem();
        listaDeAlumnosPorCurso.setNombreCurso(cursoSeleccionado);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jbAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAtrasActionPerformed
      MenuPrincipal menuPrincipal = new MenuPrincipal();
      menuPrincipal.setVisible(true);
      this.dispose();
    }//GEN-LAST:event_jbAtrasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AlumnosPorCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlumnosPorCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlumnosPorCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlumnosPorCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlumnosPorCurso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbAtras;
    private javax.swing.JComboBox<String> jcbCursos;
    // End of variables declaration//GEN-END:variables
}
