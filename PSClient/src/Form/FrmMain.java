package Form;

import Form.Student.FrmAddStudent;
import Form.Student.FrmAllStudent;
import Form.Teacher.FrmAddTeacher;
import Form.Teacher.FrmAllTeacher;
import Form.Trip.FrmAddTrip;
import Form.Trip.FrmAllTrip;
import java.awt.event.ActionListener;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;


public class FrmMain extends javax.swing.JFrame {

    /**
     * Creates new form FrmMain
     */
    Socket socket = null;
    public FrmMain() {
        super("Projekat PS - Pocetna forma");
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    FrmMain(String firstname, String lastname) {
        super("Projekat PS - Pocetna forma");
        initComponents();
        lblCurrentUser.setText(firstname + " " + lastname);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCurrentUser = new javax.swing.JLabel();
        jmenuBarMain = new javax.swing.JMenuBar();
        jmenuProduct = new javax.swing.JMenu();
        jmiProductNew = new javax.swing.JMenuItem();
        jmiProductShowAll = new javax.swing.JMenuItem();
        jmenuInvoice = new javax.swing.JMenu();
        jmiInvoiceNew = new javax.swing.JMenuItem();
        jTeacherShowAll = new javax.swing.JMenuItem();
        jmenuStudent = new javax.swing.JMenu();
        jStudentNew = new javax.swing.JMenuItem();
        jStudentShowAll = new javax.swing.JMenuItem();
        jmenuAbout = new javax.swing.JMenu();
        jmiAboutSoftware = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblCurrentUser.setText("jLabel1");

        jmenuProduct.setText("Trip");
        jmenuProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuProductActionPerformed(evt);
            }
        });

        jmiProductNew.setText("New");
        jmiProductNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiProductNewActionPerformed(evt);
            }
        });
        jmenuProduct.add(jmiProductNew);

        jmiProductShowAll.setText("Show all");
        jmiProductShowAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiProductShowAllActionPerformed(evt);
            }
        });
        jmenuProduct.add(jmiProductShowAll);

        jmenuBarMain.add(jmenuProduct);

        jmenuInvoice.setText("Teacher");
        jmenuInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuInvoiceActionPerformed(evt);
            }
        });

        jmiInvoiceNew.setText("New");
        jmiInvoiceNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiInvoiceNewActionPerformed(evt);
            }
        });
        jmenuInvoice.add(jmiInvoiceNew);

        jTeacherShowAll.setText("Show All");
        jTeacherShowAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTeacherShowAllActionPerformed(evt);
            }
        });
        jmenuInvoice.add(jTeacherShowAll);

        jmenuBarMain.add(jmenuInvoice);

        jmenuStudent.setText("Student");

        jStudentNew.setText("New");
        jStudentNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jStudentNewActionPerformed(evt);
            }
        });
        jmenuStudent.add(jStudentNew);

        jStudentShowAll.setText("Show All");
        jStudentShowAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jStudentShowAllActionPerformed(evt);
            }
        });
        jmenuStudent.add(jStudentShowAll);

        jmenuBarMain.add(jmenuStudent);

        jmenuAbout.setText("About");

        jmiAboutSoftware.setText("Software");
        jmenuAbout.add(jmiAboutSoftware);

        jmenuBarMain.add(jmenuAbout);

        setJMenuBar(jmenuBarMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCurrentUser, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCurrentUser)
                .addContainerGap(254, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmenuProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuProductActionPerformed
    }//GEN-LAST:event_jmenuProductActionPerformed

    private void jmenuInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuInvoiceActionPerformed

    }//GEN-LAST:event_jmenuInvoiceActionPerformed

    private void jmiProductNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiProductNewActionPerformed
       (new FrmAddTrip()).setVisible(true);
    }//GEN-LAST:event_jmiProductNewActionPerformed

    private void jmiInvoiceNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiInvoiceNewActionPerformed
        (new FrmAddTeacher()).setVisible(true);
    }//GEN-LAST:event_jmiInvoiceNewActionPerformed

    private void jmiProductShowAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiProductShowAllActionPerformed
        (new FrmAllTrip()).setVisible(true);
    }//GEN-LAST:event_jmiProductShowAllActionPerformed

    private void jStudentNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jStudentNewActionPerformed
        (new FrmAddStudent()).setVisible(true);
    }//GEN-LAST:event_jStudentNewActionPerformed

    private void jTeacherShowAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTeacherShowAllActionPerformed
        (new FrmAllTeacher()).setVisible(true);
    }//GEN-LAST:event_jTeacherShowAllActionPerformed

    private void jStudentShowAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jStudentShowAllActionPerformed
        (new FrmAllStudent()).setVisible(true);
    }//GEN-LAST:event_jStudentShowAllActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jStudentNew;
    private javax.swing.JMenuItem jStudentShowAll;
    private javax.swing.JMenuItem jTeacherShowAll;
    private javax.swing.JMenu jmenuAbout;
    private javax.swing.JMenuBar jmenuBarMain;
    private javax.swing.JMenu jmenuInvoice;
    private javax.swing.JMenu jmenuProduct;
    private javax.swing.JMenu jmenuStudent;
    private javax.swing.JMenuItem jmiAboutSoftware;
    private javax.swing.JMenuItem jmiInvoiceNew;
    private javax.swing.JMenuItem jmiProductNew;
    private javax.swing.JMenuItem jmiProductShowAll;
    private javax.swing.JLabel lblCurrentUser;
    // End of variables declaration//GEN-END:variables

    public void jmiProductNewAddActionListener(ActionListener actionListener) {
        jmiProductNew.addActionListener(actionListener);
    }

    public void jmiProductShowAllActionListener(ActionListener actionListener) {
        jmiProductShowAll.addActionListener(actionListener);
    }

    public JLabel getLblCurrentUser() {
        return lblCurrentUser;
    }

    public JMenuItem getJmiInvoiceNew() {
        return jmiInvoiceNew;
    }
    
}
