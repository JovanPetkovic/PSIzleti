/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Form.Trip;

import Form.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import Communication.Communication;
import Domain.Teacher;
import javax.swing.JFrame;

/**
 *
 * @author SoniXx
 */
public class FrmAddTripTeacher extends javax.swing.JFrame {

    FrmAddTrip addTrip;
    FrmChangeTrip changeTrip;
    List<Teacher> allTeachers;
    List<Teacher> selectedTeachers;
    
    /**
     * Creates new form FrmAddTripTeacher
     */
    public FrmAddTripTeacher() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    public FrmAddTripTeacher(FrmAddTrip frm) {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addTrip = frm;
        changeTrip = null;
        selectedTeachers = new ArrayList<>();
        fillTeacherTable();
    }
    
    public FrmAddTripTeacher(FrmChangeTrip frm, List<Teacher> teachers) {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        changeTrip = frm;
        addTrip = null;
        selectedTeachers = teachers;
        fillTeacherTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        allTeacherTable = new javax.swing.JTable();
        addButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        selectedTeacherTable = new javax.swing.JTable();
        saveButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        allTeacherTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Ime", "Prezime"
            }
        ));
        jScrollPane1.setViewportView(allTeacherTable);

        addButton.setText("Dodaj nastavnika");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        removeButton.setText("Izbaci nastavnika");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        selectedTeacherTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Ime", "Prezime"
            }
        ));
        jScrollPane2.setViewportView(selectedTeacherTable);

        saveButton.setText("Sacuvaj");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        backButton.setText("Nazad");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(addButton)
                        .addGap(44, 44, 44)
                        .addComponent(removeButton)
                        .addGap(0, 60, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(saveButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backButton)
                .addGap(88, 88, 88))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(removeButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(backButton))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        Teacher teacher = allTeachers.get(allTeacherTable.getSelectedRow());
        selectedTeachers.add(teacher);
        allTeachers.remove(allTeacherTable.getSelectedRow());
        DefaultTableModel dtm;
        dtm = (DefaultTableModel) selectedTeacherTable.getModel();
        dtm.addRow(new Object[] {teacher.getFirstName(),teacher.getLastName()});
        dtm = (DefaultTableModel) allTeacherTable.getModel();
        dtm.removeRow(allTeacherTable.getSelectedRow());
        
    }//GEN-LAST:event_addButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        Teacher teacher = selectedTeachers.get(selectedTeacherTable.getSelectedRow());
        allTeachers.add(teacher);
        selectedTeachers.remove(selectedTeacherTable.getSelectedRow());
        DefaultTableModel dtm;
        dtm = (DefaultTableModel) allTeacherTable.getModel();
        dtm.addRow(new Object[] {teacher.getFirstName(),teacher.getLastName()});
        dtm = (DefaultTableModel) selectedTeacherTable.getModel();
        dtm.removeRow(selectedTeacherTable.getSelectedRow());
    }//GEN-LAST:event_removeButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_backButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        if(addTrip!=null){
            addTrip.saveTeachers(selectedTeachers);
            this.dispose();
        }
        else{
            changeTrip.saveTeachers(selectedTeachers);
            this.dispose();
        }
    }//GEN-LAST:event_saveButtonActionPerformed

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
            java.util.logging.Logger.getLogger(FrmAddTripTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAddTripTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAddTripTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAddTripTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAddTripTeacher().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTable allTeacherTable;
    private javax.swing.JButton backButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JTable selectedTeacherTable;
    // End of variables declaration//GEN-END:variables

    private void fillTeacherTable() {
        DefaultTableModel dtm = (DefaultTableModel) allTeacherTable.getModel();
        DefaultTableModel dtm2 = (DefaultTableModel) selectedTeacherTable.getModel();
        for(int i = 0; i<dtm.getRowCount();i++)
            dtm.removeRow(0);
        try {
            allTeachers = Communication.getInstance().getAllTeachers();
            List<Teacher> dummyTeachers = new ArrayList<>();
            dummyTeachers.addAll(allTeachers);
            for(Teacher teacher:dummyTeachers){
                if(!selectedTeachers.contains(teacher)){
                    dtm.addRow(new Object[] {teacher.getFirstName(),teacher.getLastName()});
                }
                else{
                    dtm2.addRow(new Object[] {teacher.getFirstName(),teacher.getLastName()});
                    allTeachers.remove(teacher);
                }    
            }
        } catch (Exception ex) {
            Logger.getLogger(FrmAddTripTeacher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
