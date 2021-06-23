/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer.Usuarios;

import BusinessModelLayer.Contacto;
import BusinessModelLayer.Entidad;
import BusinessModelLayer.Localidad;
import BusinessModelLayer.Municipio;
import BusinessModelLayer.Sucursal;
import BusinessModelLayer.Usuario;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author FOSTER
 */
public class frmNuevoUsuario extends javax.swing.JDialog {

    int idUsuario = 0;
    private String v;
    private String v2;
    private String v3;
    private String v4;
    private Usuario usuario = new Usuario();
    private Sucursal sucursal = new Sucursal();
    private Contacto contacto = new Contacto();
    private Municipio municipio = new Municipio();
    private Localidad localidad = new Localidad();
    private Entidad entidades = new Entidad();
    private LinkedList<Integer> idContacto = new LinkedList<>();
    private ArrayList<Integer> idEntidad = new ArrayList<>();
    private ArrayList<Integer> idMunicipio = new ArrayList<>();
    private ArrayList<Integer> idLocalidad = new ArrayList<>();
    private LinkedList<Integer> idSucursal = new LinkedList<>();

    /**
     * Creates new form frmNuevoProducto
     */
    public frmNuevoUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public frmNuevoUsuario() {
        initComponents();
        llenarSucursal();

        cobSucursal.addItemListener(event -> {
            if (event.getStateChange() == ItemEvent.SELECTED) {

                v3 = (event.getItem().toString());

            }
        });

        v3 = cobSucursal.getSelectedItem().toString();
        cobEntidad.addItemListener(event -> {
            if (event.getStateChange() == ItemEvent.SELECTED) {
                cobMunicipio.removeAllItems();
                v = (event.getItem().toString());
                llenarMunicipio();

            }
        });

        cobMunicipio.addItemListener(event -> {
            if (event.getStateChange() == ItemEvent.SELECTED) {
                if (event.getItem().toString().isEmpty()) {
                    cobLocalidad.removeAllItems();
                } else {
                    cobLocalidad.removeAllItems();
                    v2 = (event.getItem().toString());
                    llenarComboLocalidad();
                }
            }
        });

        cobLocalidad.addItemListener(event -> {
            if (event.getStateChange() == ItemEvent.SELECTED) {

                v4 = (event.getItem().toString());

            }
        });

        cobEntidad.setSelectedItem(entidades.getEntidad());
        llenarEntidad();
    }

    public frmNuevoUsuario(int idUsuario, String Sucursal) {
        initComponents();

        this.idUsuario = idUsuario;

        usuario.setIdUsuario(idUsuario);
        usuario.GetById();

        llenarSucursal();
        cobSucursal.addItemListener(event -> {
            if (event.getStateChange() == ItemEvent.SELECTED) {

                v3 = (event.getItem().toString());

            }
        });

        cobSucursal.setSelectedItem(Sucursal);
        txtNombre.setText(usuario.getNombre());
        txtTipoUsuario.setText(usuario.getTipo());
        txtUsuario.setText(usuario.getUsuario());
        txtContraseña.setText(usuario.getPassword());

        cobEntidad.addItemListener(event -> {
            if (event.getStateChange() == ItemEvent.SELECTED) {
                cobMunicipio.removeAllItems();
                v = (event.getItem().toString());
                llenarMunicipio();
            }
        });

        cobMunicipio.addItemListener(event -> {
            if (event.getStateChange() == ItemEvent.SELECTED) {
                if (event.getItem().toString().isEmpty()) {
                    cobLocalidad.removeAllItems();
                } else {
                    cobLocalidad.removeAllItems();
                    v2 = (event.getItem().toString());
                    llenarComboLocalidad();
                }
            }
        });

        cobLocalidad.addItemListener(event -> {
            if (event.getStateChange() == ItemEvent.SELECTED) {

                v4 = (event.getItem().toString());

            }
        });

        llenarEntidad();
        contacto.setIdContacto(usuario.getIdContacto());
        contacto.GetById();
        txtCodPostal.setText(String.valueOf(contacto.getCodigoPostal()));
        txtCalle.setText(contacto.getCalle());
        txtTel.setText(contacto.getTelefono());

        municipio.setIdMunicipio(contacto.getIdMunicipio());
        municipio.GetById();
        cobMunicipio.setSelectedItem(municipio.getMunicipio());

        entidades.setIdEntidad(contacto.getIdEntidad());
        entidades.GetById();
        cobEntidad.setSelectedItem(entidades.getEntidad());

        localidad.setIdLocalidad(contacto.getIdLocalidad());
        localidad.GetById();
        cobLocalidad.setSelectedItem(localidad.getLocalidad());

    }

    /*
    public void cboFar() {
        DefaultTableModel res = categorias.GetAllModel();
        for (int i = 0; i < res.getRowCount(); i++) {
            cboCat.addItem(String.valueOf(res.getValueAt(i, 1)));
            idCategoria.add(Integer.parseInt(String.valueOf(res.getValueAt(i, 0))));
        }
    }
     */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtTel = new javax.swing.JTextField();
        btnOk = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtCalle = new javax.swing.JTextField();
        cobEntidad = new javax.swing.JComboBox<>();
        cobLocalidad = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCodPostal = new javax.swing.JTextField();
        cobMunicipio = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtTipoUsuario = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JTextField();
        cobSucursal = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);

        jLabel1.setText("Nombre:");

        jLabel2.setText("Entidad:");

        jLabel3.setText("Telefono:");

        jLabel4.setText("Calle:");

        txtTel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelKeyTyped(evt);
            }
        });

        btnOk.setText("Guardar");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel5.setText("Municipio:");

        cobEntidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cobEntidadActionPerformed(evt);
            }
        });

        jLabel6.setText("Localidad:");

        jLabel7.setText("Codigo Postal:");

        txtCodPostal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodPostalKeyTyped(evt);
            }
        });

        jLabel8.setText("Tipo de Usuario:");

        jLabel9.setText("Sucursal:");

        jLabel10.setText("Usuario:");

        jLabel11.setText("Contraseña:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtContraseña))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(txtUsuario))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(18, 18, 18)
                                        .addComponent(cobSucursal, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(cobMunicipio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(25, 25, 25)
                                        .addComponent(cobEntidad, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(cobLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCodPostal, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtNombre))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtTel)
                                        .addGap(19, 19, 19)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(btnOk)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar)
                        .addGap(10, 10, 10)))
                .addGap(61, 61, 61))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cobSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cobEntidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cobMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cobLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCodPostal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOk)
                    .addComponent(btnCancelar))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed

        if (idUsuario == 0) {
            if (new Contacto(0, Integer.parseInt(txtCodPostal.getText()),
                    txtCalle.getText(),
                    txtTel.getText(),
                    idEntidad.get(cobEntidad.getSelectedIndex()),
                    idMunicipio.get(cobMunicipio.getSelectedIndex()),
                    (int) localidad.Row4(v4).get(0)).Add()) {
                llenarArryListIdContacto();
            }
            if (new Usuario(0, (int) usuario.Row3(v3).get(0), idContacto.getLast(), txtTipoUsuario.getText(), txtNombre.getText(), txtUsuario.getText(), txtContraseña.getText()).Add()) {
                JOptionPane.showMessageDialog(null, "Usuario agregado correctamente!");
                this.dispose();
            }
        } else {
            usuario.setNombre(txtNombre.getText());
            usuario.setUsuario(txtUsuario.getText());
            usuario.setTipo(txtTipoUsuario.getText());
            usuario.setIdSucursal((int) usuario.Row3(cobSucursal.getSelectedItem().toString()).get(0));
            usuario.setPassword(txtContraseña.getText());
            contacto.setCodigoPostal(Integer.parseInt(txtCodPostal.getText()));
            contacto.setCalle(txtCalle.getText());
            contacto.setTelefono(txtTel.getText());
            contacto.setIdEntidad(idEntidad.get(cobEntidad.getSelectedIndex()));
            contacto.setIdMunicipio(idMunicipio.get(cobMunicipio.getSelectedIndex()));
            contacto.setIdLocalidad((int) localidad.Row4(v4).get(0));
            if (usuario.Update() && contacto.Update()) {
                JOptionPane.showMessageDialog(null, "Usuario actualizado correctamente!");
                this.dispose();
            }

        }

    }//GEN-LAST:event_btnOkActionPerformed
    public void llenarArryListIdContacto() {
        DefaultTableModel res = contacto.GetAllModel();
        for (int i = 0; i < res.getRowCount(); i++) {
            idContacto.add(Integer.parseInt(String.valueOf(res.getValueAt(i, 0))));
        }

    }

    public void llenarEntidad() {
        DefaultTableModel res = entidades.GetAllModel();
        // DefaultTableModel res2 = municipio.GetAllModel();
        for (int i = 0; i < res.getRowCount(); i++) {
            cobEntidad.addItem(String.valueOf(res.getValueAt(i, 1)));
            idEntidad.add(Integer.parseInt(String.valueOf(res.getValueAt(i, 0))));
        }

    }

    public void llenarSucursal() {
        // cboFar.addItem("" + producto.co().get(0));
        for (int i = 0; i < usuario.Row().size(); i++) {
            cobSucursal.addItem(usuario.Row().get(i).toString());

        }
    }

    public void llenarMunicipio() {
        idMunicipio.clear();
        DefaultTableModel res2 = municipio.GetAllModelCob(v);
        for (int i = 0; i < res2.getRowCount(); i++) {
            cobMunicipio.addItem(String.valueOf(res2.getValueAt(i, 1)));
            idMunicipio.add(Integer.parseInt(String.valueOf(res2.getValueAt(i, 0))));
        }
    }

    public void llenarMunicipio2() {
        DefaultTableModel res2 = municipio.GetAllModel();
        for (int i = 0; i < res2.getRowCount(); i++) {
            cobMunicipio.addItem(String.valueOf(res2.getValueAt(i, 1)));
            idMunicipio.add(Integer.parseInt(String.valueOf(res2.getValueAt(i, 0))));
        }
    }

    public void llenarComboLocalidad() {
        DefaultTableModel res = localidad.GetAllModelCob(v2);

        for (int i = 0; i < res.getRowCount(); i++) {
            cobLocalidad.addItem(String.valueOf(res.getValueAt(i, 1)));
            idLocalidad.add(Integer.parseInt(String.valueOf(res.getValueAt(i, 0))));
        }
    }

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtTelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtTelKeyTyped

    private void cobEntidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cobEntidadActionPerformed
        // TODO add your handling code here:
        if (idMunicipio.isEmpty()) {
            cobLocalidad.removeAllItems();
        }
    }//GEN-LAST:event_cobEntidadActionPerformed

    private void txtCodPostalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodPostalKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCodPostalKeyTyped

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
            java.util.logging.Logger.getLogger(frmNuevoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmNuevoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmNuevoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmNuevoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmNuevoUsuario dialog = new frmNuevoUsuario(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnOk;
    private javax.swing.JComboBox<String> cobEntidad;
    private javax.swing.JComboBox<String> cobLocalidad;
    private javax.swing.JComboBox<String> cobMunicipio;
    private javax.swing.JComboBox<String> cobSucursal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtCalle;
    private javax.swing.JTextField txtCodPostal;
    private javax.swing.JTextField txtContraseña;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTel;
    private javax.swing.JTextField txtTipoUsuario;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
