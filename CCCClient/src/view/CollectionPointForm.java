/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import connector.ServerConnector;
import controller.CollectionPointController;
import controller.CustomerController;
import controller.IdController;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.CollectionPoint;
import model.Customer;
import static view.MainFrame.desktopPane;

/**
 *
 * @author supun
 */
public class CollectionPointForm extends javax.swing.JInternalFrame {

    JLabel jLabel;
    static String nic;
    private static JTextField searchComboText;
    private static String[] searchComboList;
    String idText;

    /**
     * Creates new form AddCustomerDetails
     */
    public CollectionPointForm() {

        try {
            initComponents();
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            DateFormat dateFormat1 = new SimpleDateFormat("HH:mm:ss");
            Date date = new Date();
            
            Calendar cal = Calendar.getInstance();
            System.out.println(dateFormat.format(cal.getTime()));
            System.out.println(dateFormat.format(date));
            dateLabel.setDate(date);
            timeLabel1.setText(dateFormat1.format(cal.getTime()));
            
            fillCombo();
            searchComboText = (JTextField) jComboBox1.getEditor().getEditorComponent();
            
            searchComboText.addKeyListener(new KeyAdapter() {
                public void keyReleased(KeyEvent evt) {
                    //setNextEnabled();
                    String detail = (String) jComboBox1.getSelectedItem();
                    if (detail != null) {
                        if (detail.matches("^[cC][0-9]*$")) {
                            try {
                                try {
                                    CustomerController customerController = ServerConnector.getServerConnector().getCustomerController();
                                    try {
                                        Customer allCustomers = customerController.searchByCid(detail);
                                        if (allCustomers != null) {
                                            customerNameText.setText(allCustomers.getFirstName() + " " + allCustomers.getLastName());
                                        } else {
                                            customerNameText.setText("");
                                        }
                                    } catch (SQLException ex) {
                                        Logger.getLogger(CollectionPointForm.class.getName()).log(Level.SEVERE, null, ex);
                                    } catch (ClassNotFoundException ex) {
                                        Logger.getLogger(CollectionPointForm.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                } catch (NotBoundException ex) {
                                    Logger.getLogger(CollectionPointForm.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (MalformedURLException ex) {
                                    Logger.getLogger(CollectionPointForm.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            } catch (RemoteException ex) {
                                Logger.getLogger(CollectionPointForm.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                        } else if (detail.matches("^[0-9]{9}[vV]$")) {
                            try {
                                try {
                                    CustomerController customerController = ServerConnector.getServerConnector().getCustomerController();
                                    Customer allCustomers = customerController.searchByNic(detail);
                                    if (allCustomers != null) {
                                        customerNameText.setText(allCustomers.getFirstName() + " " + allCustomers.getLastName());
                                    } else {
                                        customerNameText.setText("");
                                    }
                                } catch (SQLException ex) {
                                    Logger.getLogger(CollectionPointForm.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (ClassNotFoundException ex) {
                                    Logger.getLogger(CollectionPointForm.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (NotBoundException ex) {
                                    Logger.getLogger(CollectionPointForm.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (MalformedURLException ex) {
                                    Logger.getLogger(CollectionPointForm.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            } catch (RemoteException ex) {
                                Logger.getLogger(CollectionPointForm.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            customerNameText.setText("");
                        }
                    }
                }
            });
        } catch (RemoteException ex) {
            Logger.getLogger(CollectionPointForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(CollectionPointForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(CollectionPointForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CollectionPointForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CollectionPointForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        addressTextArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        c1RadioButton = new javax.swing.JRadioButton();
        c2RadioButton = new javax.swing.JRadioButton();
        c3RadioButton = new javax.swing.JRadioButton();
        timeLabel1 = new javax.swing.JLabel();
        dateLabel = new com.toedter.calendar.JDateChooser();
        jComboBox1 = new javax.swing.JComboBox();
        customerNameText = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setBackground(java.awt.Color.white);

        jPanel1.setBackground(java.awt.Color.white);

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setText("Address");

        nameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextFieldActionPerformed(evt);
            }
        });
        nameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nameTextFieldKeyReleased(evt);
            }
        });

        jLabel2.setText("Collection Point Name");

        jButton1.setText("Next");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel10.setText("Courier Firm ");

        addressTextArea.setColumns(20);
        addressTextArea.setRows(5);
        jScrollPane1.setViewportView(addressTextArea);

        jLabel1.setBackground(java.awt.Color.white);
        jLabel1.setFont(new java.awt.Font("Droid Serif", 0, 36)); // NOI18N
        jLabel1.setText("Collection Point Form");

        jLabel8.setText("Customer ID");

        buttonGroup1.add(c1RadioButton);
        c1RadioButton.setText("DHL");
        c1RadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c1RadioButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(c2RadioButton);
        c2RadioButton.setText("FedEx");

        buttonGroup1.add(c3RadioButton);
        c3RadioButton.setText("UPS");

        timeLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        dateLabel.setEnabled(false);
        dateLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jComboBox1.setEditable(true);

        customerNameText.setEditable(false);
        customerNameText.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel9.setText("Customer Name");

        jLabel11.setText("Pick Up Date");

        jLabel12.setText("Pick Up Time");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(302, 302, 302)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(c1RadioButton)
                        .addGap(18, 18, 18)
                        .addComponent(c2RadioButton)
                        .addGap(18, 18, 18)
                        .addComponent(c3RadioButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(customerNameText, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                            .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 24, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                            .addComponent(timeLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(customerNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timeLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(c1RadioButton)
                        .addComponent(c2RadioButton)
                        .addComponent(c3RadioButton)))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void c1RadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c1RadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c1RadioButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            DateFormat dateFormat1 = new SimpleDateFormat("HH:mm:ss");
            Date date = new Date();

            Calendar cal = Calendar.getInstance();
            System.out.println(dateFormat.format(cal.getTime()));
            System.out.println(dateFormat.format(date));

            CollectionPoint collectionPoint = new CollectionPoint(jComboBox1.getSelectedItem().toString(), nameTextField.getText(), addressTextArea.getText(), date, dateFormat1.format(cal.getTime()), firmMethod());
            CollectionPointController collectionPointController = ServerConnector.getServerConnector().getCollectionPointController();
            int addCollection = collectionPointController.addCollection(collectionPoint);
            if (addCollection > 0) {
                JOptionPane.showMessageDialog(this, "Added Successfully");
                idText= jComboBox1.getSelectedItem().toString();
                desktopPane.removeAll();
                StorageForm storageForm = new StorageForm();
                storageForm.setSize(desktopPane.getSize());
                desktopPane.add(storageForm);
                storageForm.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(this, "not Added");
            }

        } catch (NotBoundException ex) {
            Logger.getLogger(CollectionPointForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(CollectionPointForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(CollectionPointForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CollectionPointForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CollectionPointForm.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void nameTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameTextFieldKeyReleased

    }//GEN-LAST:event_nameTextFieldKeyReleased

    private void nameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextFieldActionPerformed

    }//GEN-LAST:event_nameTextFieldActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea addressTextArea;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton c1RadioButton;
    private javax.swing.JRadioButton c2RadioButton;
    private javax.swing.JRadioButton c3RadioButton;
    private javax.swing.JTextField customerNameText;
    private com.toedter.calendar.JDateChooser dateLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    public static javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextField nameTextField;
    private javax.swing.JLabel timeLabel1;
    // End of variables declaration//GEN-END:variables

    private String firmMethod() {
        if (c1RadioButton.isSelected()) {
            return "DHL";
        } else if (c2RadioButton.isSelected()) {
            return "FedEx";
        } else {
            return "UPS";
        }
    }

    public void fillCombo() throws RemoteException, NotBoundException, MalformedURLException, SQLException, ClassNotFoundException {
        CustomerController customerController = ServerConnector.getServerConnector().getCustomerController();
        String[][] allCidNic = customerController.getAllCidNic();
        jComboBox1.removeAllItems();
        if (allCidNic != null) {
            for (int i = 0; i < allCidNic.length; i++) {
                jComboBox1.addItem(allCidNic[i][0]);
            }
            for (int i = 0; i < allCidNic.length; i++) {
                //jComboBox1.addItem(allCidNic[i][1]);
            }

        }
        searchComboText = (JTextField) jComboBox1.getEditor().getEditorComponent();
        searchComboList = new String[jComboBox1.getItemCount()];
        for (int i = 0; i < searchComboList.length; i++) {
            searchComboList[i] = (String) jComboBox1.getItemAt(i);
        }

        searchComboText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent evt) {
                String txt = searchComboText.getText();
                jComboBox1.removeAllItems();
                jComboBox1.hidePopup();

                for (int i = 0; i < searchComboList.length; i++) {
                    if (searchComboList[i].toUpperCase().contains(txt.toUpperCase())) {
                        jComboBox1.addItem(searchComboList[i]);
                    }
                }
                searchComboText.setText(txt);
                jComboBox1.showPopup();
            }
        });

    }

//     public void setNextEnabled() {
//        boolean b = customerNameText.getText().isEmpty() || pointText.getText().isEmpty() || addressText.getText().isEmpty();
//        nextButton.setEnabled(!b);
//
//    }
}
