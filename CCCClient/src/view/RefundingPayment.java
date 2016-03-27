/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import connector.ServerConnector;
import controller.CustomerController;
import controller.FridgeController;
import controller.PaymentController;
import controller.RefundController;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.Customer;
import model.Payment;
import model.Refund;

/**
 *
 * @author supun-pc
 */
public class RefundingPayment extends javax.swing.JInternalFrame {

    private static JTextField searchComboText;
    private static String[] searchComboList;

    /**
     * Creates new form RefundingPayment
     */
    public RefundingPayment() {

        try {
            initComponents();
            fillCombo();
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH) + 1;
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            String date = year + "-" + month + "-" + day;
            dateText.setText(date);
            searchComboText.addKeyListener(new KeyAdapter() {
                public void keyReleased(KeyEvent evt) {
                    try {
                        String detail = (String) searchCombo.getSelectedItem();
                        PaymentController paymentController = ServerConnector.getServerConnector().getPaymentController();
                        Payment selectedPayment = paymentController.getSelectedPayment(detail);

                        if (selectedPayment != null) {
                         //   refundButton.setEnabled(true);
                            CustomerController customerController = ServerConnector.getServerConnector().getCustomerController();
                            Customer searchByCid = customerController.searchByCid(selectedPayment.getCustID());
                            nicText.setText(searchByCid.getNic());
                            nameText.setText(searchByCid.getFirstName() + " " + searchByCid.getLastName());
                            if (selectedPayment.getPaymentOption().equals("Installment")) {
                                double totalAmount = paymentController.getTotalAmount(detail);
                                valueText.setText(Double.toString(totalAmount));
                                double amount = (int) (totalAmount / 2);
                                paymentText.setText(Double.toString(amount));
                            } else {
                                double annualfee = selectedPayment.getAnnualFee();
                                valueText.setText(Double.toString(annualfee));
                                annualfee = (int) (annualfee / 2);
                                paymentText.setText(Double.toString(annualfee));
                            }
                        } else {
                       //     refundButton.setEnabled(false);
                            nicText.setText("");
                            nameText.setText("");
                            valueText.setText("");
                            paymentText.setText("");
                        }
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(RefundingPayment.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(RefundingPayment.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (NotBoundException ex) {
                        Logger.getLogger(RefundingPayment.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (MalformedURLException ex) {
                        Logger.getLogger(RefundingPayment.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (RemoteException ex) {
                        Logger.getLogger(RefundingPayment.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
        } catch (RemoteException ex) {
            Logger.getLogger(RefundingPayment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(RefundingPayment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(RefundingPayment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RefundingPayment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RefundingPayment.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        nameText = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        paymentText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        searchCombo = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        refundButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        nicText = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        valueText = new javax.swing.JTextField();
        dateText = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setText("Name");

        paymentText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentTextActionPerformed(evt);
            }
        });

        jLabel3.setText("NIC");

        searchCombo.setEditable(true);
        searchCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchComboActionPerformed(evt);
            }
        });

        jLabel6.setText("Date");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Payment Refunding Form");

        cancelButton.setText("Refund");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jLabel7.setText("Present Value");

        refundButton.setText("Cancel");
        refundButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refundButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("SID");

        jLabel5.setText("Refund Amount");

        valueText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valueTextActionPerformed(evt);
            }
        });

        dateText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateTextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 144, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(208, 208, 208))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(nameText, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(nicText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(valueText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchCombo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(dateText, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                                .addComponent(paymentText, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
                            .addComponent(refundButton, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(searchCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nicText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(valueText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(paymentText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(refundButton)
                    .addComponent(cancelButton))
                .addContainerGap())
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

    private void paymentTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paymentTextActionPerformed

    private void searchComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchComboActionPerformed
        try {
            String detail = (String) searchCombo.getSelectedItem();
            PaymentController paymentController = ServerConnector.getServerConnector().getPaymentController();
            Payment selectedPayment = paymentController.getSelectedPayment(detail);

            if (selectedPayment != null) {
                refundButton.setEnabled(true);
                CustomerController customerController = ServerConnector.getServerConnector().getCustomerController();
                Customer searchByCid = customerController.searchByCid(selectedPayment.getCustID());
                nicText.setText(searchByCid.getNic());
                System.out.println(searchByCid.getNic());
                System.out.println(searchByCid.getFirstName());
                nameText.setText(searchByCid.getFirstName() + " " + searchByCid.getLastName());
                if (selectedPayment.getPaymentOption().equals("Installment")) {
                    double totalAmount = paymentController.getTotalAmount(detail);
                    valueText.setText(Double.toString(totalAmount));
                    double amount = (int) (totalAmount / 2);
                    paymentText.setText(Double.toString(amount));
                } else {
                    double annualfee = selectedPayment.getAnnualFee();
                    valueText.setText(Double.toString(annualfee));
                    annualfee = (int) (annualfee / 2);
                    paymentText.setText(Double.toString(annualfee));
                }
            } else {
                refundButton.setEnabled(false);
                nicText.setText("");
                nameText.setText("");
                valueText.setText("");
                paymentText.setText("");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RefundingPayment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RefundingPayment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(RefundingPayment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(RefundingPayment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(RefundingPayment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchComboActionPerformed

    private void refundButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refundButtonActionPerformed
//        try {
//            Refund refund = new Refund((String) searchCombo.getSelectedItem(), nicText.getText(), dateText.getText(), Double.parseDouble(paymentText.getText()));
//            RefundController refundController = ServerConnector.getServerConnector().getRefundController();
//            try {
//                int addRefund = refundController.addRefund(refund);
//                if (addRefund > 0) {
//                    JOptionPane.showMessageDialog(this, "Refunded Payment Added Successfully");
//                    FridgeController storageController = ServerConnector.getServerConnector().getFridgeController();
//                    storageController.deleteStorage((String) searchCombo.getSelectedItem());
//                } else {
//                    JOptionPane.showMessageDialog(this, "Refunded Payment Added Failed");
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(RefundingPayment.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (ClassNotFoundException ex) {
//                Logger.getLogger(RefundingPayment.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } catch (NotBoundException ex) {
//            Logger.getLogger(RefundingPayment.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (MalformedURLException ex) {
//            Logger.getLogger(RefundingPayment.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (RemoteException ex) {
//            Logger.getLogger(RefundingPayment.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_refundButtonActionPerformed

    private void valueTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valueTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valueTextActionPerformed

    private void dateTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateTextActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        try {
            Refund refund = new Refund((String) searchCombo.getSelectedItem(), nicText.getText(), dateText.getText(), Double.parseDouble(paymentText.getText()));
            RefundController refundController = ServerConnector.getServerConnector().getRefundController();
            try {
                int addRefund = refundController.addRefund(refund);
                if (addRefund > 0) {
                    JOptionPane.showMessageDialog(this, "Refunded Payment Added Successfully");
                    FridgeController storageController = ServerConnector.getServerConnector().getFridgeController();
                    storageController.deleteStorage((String) searchCombo.getSelectedItem());
                } else {
                    JOptionPane.showMessageDialog(this, "Refunded Payment Added Failed");
                }
            } catch (SQLException ex) {
                Logger.getLogger(RefundingPayment.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(RefundingPayment.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (NotBoundException ex) {
            Logger.getLogger(RefundingPayment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(RefundingPayment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(RefundingPayment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cancelButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField dateText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nameText;
    private javax.swing.JTextField nicText;
    private javax.swing.JTextField paymentText;
    private javax.swing.JButton refundButton;
    private javax.swing.JComboBox searchCombo;
    private javax.swing.JTextField valueText;
    // End of variables declaration//GEN-END:variables

    public void fillCombo() throws RemoteException, NotBoundException, MalformedURLException, SQLException, ClassNotFoundException {
        FridgeController storageController = ServerConnector.getServerConnector().getFridgeController();
        String[] allCidNic = storageController.getAllSid();
        searchCombo.removeAllItems();
        if (allCidNic != null) {
            for (int i = 0; i < allCidNic.length; i++) {
                searchCombo.addItem(allCidNic[i]);
            }

        }

        searchComboText = (JTextField) searchCombo.getEditor().getEditorComponent();
        searchComboList = new String[searchCombo.getItemCount()];
        for (int i = 0; i < searchComboList.length; i++) {
            searchComboList[i] = (String) searchCombo.getItemAt(i);
        }

        searchComboText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent evt) {
                String txt = searchComboText.getText();
                searchCombo.removeAllItems();
                searchCombo.hidePopup();

                for (int i = 0; i < searchComboList.length; i++) {
                    if (searchComboList[i].toUpperCase().contains(txt.toUpperCase())) {
                        searchCombo.addItem(searchComboList[i]);
                    }
                }
                searchComboText.setText(txt);
                searchCombo.showPopup();
            }
        });

    }

}
