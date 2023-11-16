/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Form.Student;


import javax.swing.JOptionPane;
import Communication.Communication;
import Domain.School;
import Domain.Student;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author SoniXx
 */
public class FrmChangeStudent extends javax.swing.JFrame {

    Student studentToChange;
    List<School> schoolList;
    School chosenSchool;
    
    /**
     * Creates new form FrmChangeStudent
     */
    public FrmChangeStudent() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    public FrmChangeStudent(Student student) {
        initComponents();
        //initData() initialized data inside school combo box
        initData();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        studentToChange = student;
        //Ova metoda popunjava polja podacima o učeniku i školi.
        fillFields();
        //Ova metoda isključuje polja kako se podaci ne bi mogli menjati.
        disableFields();

    }

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
        firstNameField = new javax.swing.JTextField();
        lastNameField = new javax.swing.JTextField();
        changeButton = new javax.swing.JButton();
        gradeField = new javax.swing.JComboBox<Integer>();
        gradeField.setModel(new javax.swing.DefaultComboBoxModel<>(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8 }));
        schoolField = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        addressField = new javax.swing.JTextField();
        phoneField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Ime:");

        jLabel2.setText("Prezime:");

        jLabel3.setText("Razred:");

        changeButton.setText("Sačuvaj");
        changeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeButtonActionPerformed(evt);
            }
        });

        schoolField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        schoolField.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                schoolFieldItemStateChanged(evt);
            }
        });

        jLabel4.setText("Škola:");

        jButton2.setText("Omogući Izmenu");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jLabel5.setText("Adresa škole:");

        jLabel6.setText("Telefon škole:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(phoneField))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(38, 38, 38))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(16, 16, 16)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addGap(22, 22, 22)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lastNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                            .addComponent(firstNameField)
                            .addComponent(gradeField, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(schoolField, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addressField, javax.swing.GroupLayout.Alignment.LEADING))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addComponent(changeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(66, 66, 66))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(gradeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(schoolField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(changeButton))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void changeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeButtonActionPerformed
        if(validateData().isEmpty()){
            studentToChange.setFirstName(firstNameField.getText());
            studentToChange.setLastName(lastNameField.getText());
            studentToChange.setGrade((int)gradeField.getSelectedItem());
            studentToChange.setSchool(chosenSchool);
            try {
                Communication.getInstance().editStudent(studentToChange);
                JOptionPane.showMessageDialog(this, "Učenik je uspešno izmenjen.");
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(FrmChangeStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this,validateData());
        }
    }//GEN-LAST:event_changeButtonActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        enableFields();
    }//GEN-LAST:event_jButton2MouseClicked

    private void schoolFieldItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_schoolFieldItemStateChanged
        try {
            chosenSchool = Communication.getInstance().getSchool(schoolList.get(schoolField.getSelectedIndex()));
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(FrmChangeStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        addressField.setText(chosenSchool.getAddress());
        phoneField.setText(chosenSchool.getPhone());
    }//GEN-LAST:event_schoolFieldItemStateChanged

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
            java.util.logging.Logger.getLogger(FrmChangeStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmChangeStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmChangeStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmChangeStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmChangeStudent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressField;
    private javax.swing.JButton changeButton;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JComboBox<Integer> gradeField;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JTextField phoneField;
    private javax.swing.JComboBox<String> schoolField;
    // End of variables declaration//GEN-END:variables

    private String validateData() {
        String errorMessage = "";
        if(firstNameField.getText().isEmpty()){
            errorMessage += "Ime ne sme biti prazno!\n";
        }
        if(lastNameField.getText().isEmpty()){
            errorMessage += "Prezime ne sme biti prazno!\n";
        }
        
        return errorMessage;
    }

    private void fillFields() {
        firstNameField.setText(studentToChange.getFirstName());
        lastNameField.setText(studentToChange.getLastName());
        gradeField.setSelectedIndex(studentToChange.getGrade()-1);
        schoolField.setSelectedItem(studentToChange.getSchool().getName());
        addressField.setText(studentToChange.getSchool().getAddress());
        phoneField.setText(studentToChange.getSchool().getPhone());
    }

    private void disableFields() {
        firstNameField.setEditable(false);
        lastNameField.setEditable(false);
        gradeField.setEnabled(false);
        schoolField.setEnabled(false);
        addressField.setEditable(false);
        phoneField.setEditable(false);
    }

    private void initData() {
        try {
            schoolList = Communication.getInstance().getAllSchools();
            for(School school:schoolList)
                schoolField.addItem(school.getName());
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(FrmChangeStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    private void enableFields() {
        firstNameField.setEditable(true);
        lastNameField.setEditable(true);
        gradeField.setEnabled(true);
        schoolField.setEnabled(true);
    }
}
