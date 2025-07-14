
package vista;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import javax.swing.JOptionPane;
import org.bson.Document;


public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        JUsuarios = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jPassword = new javax.swing.JPasswordField();
        btnIngresarSistema = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgenes/imagen/logo2.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(146, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 410));

        jPanel3.setBackground(new java.awt.Color(255, 0, 0));

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Bienvenido al sistema sismico");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jLabel3)
                .addContainerGap(120, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 460, 70));

        JUsuarios.setBackground(new java.awt.Color(255, 0, 0));
        JUsuarios.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        JUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        JUsuarios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Tecnico", "Cientifico", "Operador" }));
        JUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JUsuariosActionPerformed(evt);
            }
        });
        jPanel1.add(JUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 290, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel2.setText("Password:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, -1, -1));

        jPassword.setForeground(new java.awt.Color(204, 204, 255));
        jPassword.setText("jPasswordField1");
        jPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordActionPerformed(evt);
            }
        });
        jPanel1.add(jPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, 210, -1));

        btnIngresarSistema.setBackground(new java.awt.Color(255, 0, 0));
        btnIngresarSistema.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnIngresarSistema.setText("INGRESAR");
        btnIngresarSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarSistemaActionPerformed(evt);
            }
        });
        jPanel1.add(btnIngresarSistema, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 310, 140, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JUsuariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JUsuariosActionPerformed

    private void jPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordActionPerformed

    private void btnIngresarSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarSistemaActionPerformed
    String usuarioSeleccionado = JUsuarios.getSelectedItem().toString().trim();
    String passwordIngresada = new String(jPassword.getPassword()).trim();

    try {
        MongoClient mongo = new MongoClient("localhost", 27017);
        DB baseDatos = mongo.getDB("sistema_sismico");
        DBCollection coleccion = baseDatos.getCollection("usuarios");

        
        BasicDBObject query = new BasicDBObject();
        query.put("usuario", usuarioSeleccionado);

       
        com.mongodb.DBCursor cursor = coleccion.find(query);

        if (cursor.hasNext()) {
            com.mongodb.DBObject usuarioEncontrado = cursor.next();
            String passwordReal = (String) usuarioEncontrado.get("password");

            if (passwordIngresada.equals(passwordReal)) {
                
                switch (usuarioSeleccionado) {
                    case "Admin":
                        VentanaAdmin admin = new VentanaAdmin();
                        admin.setVisible(true);
                        this.dispose();
                        break;
                    case "Tecnico":
                        VentanaTecnico tecnico = new VentanaTecnico();
                        tecnico.setVisible(true);
                        this.dispose();
                        break;
                    case "Cientifico":
                        VentanaCientifico cientifico = new VentanaCientifico();
                        cientifico.setVisible(true);
                        this.dispose();
                        break;
                    case "Operador":
                        VentanaOperador operador = new VentanaOperador();
                        operador.setVisible(true);
                        this.dispose();
                        break;
                }
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "⚠ Contraseña incorrecta para " + usuarioSeleccionado);
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "❌ Usuario no encontrado en MongoDB");
        }

        mongo.close();

    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, "❌ Error al conectar a MongoDB: " + e.getMessage());
    }
    }//GEN-LAST:event_btnIngresarSistemaActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JUsuarios;
    private javax.swing.JButton btnIngresarSistema;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPassword;
    // End of variables declaration//GEN-END:variables
}
