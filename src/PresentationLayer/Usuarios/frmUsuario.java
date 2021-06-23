/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer.Usuarios;

import BusinessModelLayer.Contacto;
import BusinessModelLayer.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author FOSTER
 */
public class frmUsuario extends javax.swing.JInternalFrame {

    String nombre;
    private Usuario usuario = new Usuario();

    /**
     * Creates new form formulario
     */
    public frmUsuario() {
        initComponents();

        jTableUsuarios.setModel(new Usuario().GetAllModel());
        jTableUsuarios.getColumnModel().getColumn(6).setMaxWidth(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btnActualizar = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btnNuevo = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnModificar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnEliminar = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btnOrdenar = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableUsuarios = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Usuarios");
        setMinimumSize(new java.awt.Dimension(525, 382));
        setPreferredSize(new java.awt.Dimension(525, 382));
        setVisible(true);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btnActualizar.setText("Actualizar");
        btnActualizar.setFocusable(false);
        btnActualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnActualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnActualizar);
        jToolBar1.add(jSeparator4);

        btnNuevo.setText("Nuevo");
        btnNuevo.setFocusable(false);
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNuevo);
        jToolBar1.add(jSeparator2);

        btnModificar.setText("Modificar");
        btnModificar.setFocusable(false);
        btnModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnModificar);
        jToolBar1.add(jSeparator1);

        btnEliminar.setText("Eliminar");
        btnEliminar.setFocusable(false);
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEliminar);
        jToolBar1.add(jSeparator3);

        btnOrdenar.setText("Ordenar Asc");
        btnOrdenar.setFocusable(false);
        btnOrdenar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOrdenar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnOrdenar);
        jToolBar1.add(jSeparator5);

        btnBuscar.setText("Buscar");
        btnBuscar.setFocusable(false);
        btnBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnBuscar);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(513, 403));

        jTableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableUsuarios);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        frmNuevoUsuario obj = new frmNuevoUsuario();
        obj.setTitle("Nuevo Usuario");
        obj.setModal(true);
        obj.setLocationRelativeTo(null);
        obj.setVisible(true);
        jTableUsuarios.setModel(new Usuario().GetAllModel());
        jTableUsuarios.getColumnModel().getColumn(6).setMaxWidth(0);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        if (jTableUsuarios.getSelectedRow() >= 0) {
            int idUsuario = (int) jTableUsuarios.getValueAt(jTableUsuarios.getSelectedRow(), 0);
            String Sucursal = (String) jTableUsuarios.getValueAt(jTableUsuarios.getSelectedRow(), 3);
            frmNuevoUsuario obj = new frmNuevoUsuario(idUsuario, Sucursal);
            obj.setTitle("Modificar Usuario");
            obj.setModal(true);
            obj.setLocationRelativeTo(null);
            obj.setVisible(true);
            jTableUsuarios.setModel(new Usuario().GetAllModel());
            jTableUsuarios.getColumnModel().getColumn(6).setMaxWidth(0);
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        if (jTableUsuarios.getSelectedRow() >= 0) {
            int idUsuario = (int) jTableUsuarios.getValueAt(jTableUsuarios.getSelectedRow(), 0);
            int idContacto = (int) jTableUsuarios.getValueAt(jTableUsuarios.getSelectedRow(), 6);
            Usuario usuario = new Usuario();
            Contacto contacto = new Contacto();
            usuario.setIdUsuario(idUsuario);
            contacto.setIdContacto(idContacto);
            if (usuario.Delete() && contacto.Delete()) {
                JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente!");
                jTableUsuarios.setModel(new Usuario().GetAllModel());
                jTableUsuarios.getColumnModel().getColumn(6).setMaxWidth(0);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona una fila");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        jTableUsuarios.setModel(new Usuario().GetAllModel());
        jTableUsuarios.getColumnModel().getColumn(6).setMaxWidth(0);
        //txtBuscar.setText("");
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarActionPerformed
        // TODO add your handling code here:
        jTableUsuarios.setModel(new Usuario().Asc());
        jTableUsuarios.getColumnModel().getColumn(6).setMaxWidth(0);
    }//GEN-LAST:event_btnOrdenarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        frmBuscar obj = new frmBuscar();
        obj.setTitle("Buscar por Usuario");
        obj.setModal(true);
        obj.setLocationRelativeTo(null);
        obj.setVisible(true);
    }//GEN-LAST:event_btnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnOrdenar;
    public static javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    public static javax.swing.JTable jTableUsuarios;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
