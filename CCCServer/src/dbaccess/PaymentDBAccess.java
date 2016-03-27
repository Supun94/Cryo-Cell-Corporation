/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbaccess;

import dbConnection.DBConnection;
import dbConnection.DBHandler;
import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Fridge;
import model.Payment;

/**
 *
 * @author supun-pc
 */
public class PaymentDBAccess {

    public int addPayment(Payment payment) throws SQLException, ClassNotFoundException, RemoteException {
        String query = "insert into Payment values(?,?,?,?,?,?,?,?,?,?)";
        return DBHandler.setData(query, DBConnection.getDBConnection(), payment.getInvoiceID(), payment.getCustID(), payment.getStorageID(), payment.getPaymentDate(), payment.getPaymentType(), payment.getPaymentOption(), payment.getAnnualFee(), payment.getPaymentAmount(), payment.getDueDate(), payment.getDescription());
    }

    public static Payment[] viewAllPayment() throws ClassNotFoundException, SQLException {
        String sql = "Select * From Payment";
        ResultSet rst = DBHandler.getData(sql, DBConnection.getDBConnection());
        int size = 0;
        while (rst.next()) {
            size++;
        }

        Payment[] paymentList = new Payment[size];
        rst.beforeFirst();
        for (int i = 0; rst.next(); i++) {
            paymentList[i] = new Payment(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getDouble(7), rst.getDouble(8), rst.getString(9), rst.getString(10));

        }
        return paymentList;
    }

    public Payment getSelectedPayment(String StorageID) throws SQLException, ClassNotFoundException {
        String query = "select * from Payment where StorageID=? order by PaymentDate desc";
        ResultSet data = DBHandler.getData(query, DBConnection.getDBConnection(), StorageID);
        Payment payment = null;
        if (data.next()) {
            payment = new Payment(data.getString(1), data.getString(2), data.getString(3), data.getString(4), data.getString(5), data.getString(6), data.getDouble(7), data.getDouble(8), data.getString(9), data.getString(10));
        }
        return payment;
    }

    public boolean isDue(String date) throws SQLException, ClassNotFoundException {
        String query = "select curDate()>? ";
        ResultSet data = DBHandler.getData(query, DBConnection.getDBConnection(), date);
        data.next();
        if (data.getInt(1) == 1) {
            return true;
        } else {
            return false;
        }
    }

    public Payment[] getAllSidPayments(String StorageID) throws SQLException, ClassNotFoundException {
        String query = "select * from Payment where StorageID=?";
        ResultSet data = DBHandler.getData(query, DBConnection.getDBConnection(), StorageID);
        Payment[] payments = null;
        int x = 0;
        while (data.next()) {
            x++;
        }
        payments = new Payment[x];
        data.beforeFirst();
        for (int i = 0; data.next(); i++) {
            payments[i] = new Payment(data.getString("StorageID"), data.getString("PaymentDate"), data.getString("PaymentType"), data.getDouble("PaymentAmount"), data.getString("Description"));
        }
        return payments;
    }

    public boolean isPaymentAvailable(String StorageID) throws ClassNotFoundException, SQLException {
        String query = "select CustID from Payment where StorageID=? and Description='full payment'";
        ResultSet data = DBHandler.getData(query, DBConnection.getDBConnection(), StorageID);
        return data.next();
    }

    public double getTotalAmount(String StorageID) throws SQLException, ClassNotFoundException {
        String query = "select PaymentAmount from Payment where StorageID=? and Description!='Testing'";
        ResultSet data = DBHandler.getData(query, DBConnection.getDBConnection(), StorageID);
        double total = 0;
        while (data.next()) {
            total = total + data.getDouble(1);
        }
        return total;
    }

    public Payment[] getAllDatePayments(String date) throws SQLException, ClassNotFoundException {
        String query = "select * from Payment where PaymentDate=?";
        ResultSet data = DBHandler.getData(query, DBConnection.getDBConnection(), date);
        Payment[] payment = null;
        int x = 0;
        while (data.next()) {
            x++;
        }
        payment = new Payment[x];
        data.beforeFirst();
        for (int i = 0; data.next(); i++) {
            payment[i] = new Payment(data.getString(1), data.getString(2), data.getString(3), data.getString(4), data.getString(5), data.getString(6), data.getDouble(7), data.getDouble(8), data.getString(9), data.getString(10));
        }
        return payment;
    }

    public Payment[] getAllPayments(String StorageID) throws SQLException, ClassNotFoundException {
        String query = "select * from Payment where StorageID=?";
        ResultSet data = DBHandler.getData(query, DBConnection.getDBConnection(), StorageID);
        Payment[] payment = null;
        int x = 0;
        while (data.next()) {
            x++;
        }
        payment = new Payment[x];
        data.beforeFirst();
        for (int i = 0; data.next(); i++) {
            payment[i] = new Payment(data.getString(1), data.getString(2), data.getString(3), data.getString(4), data.getString(5), data.getString(6), data.getDouble(7), data.getDouble(8), data.getString(9), data.getString(10));
        }
        return payment;
    }

    public Payment[] getAllCidPayments(String cid) throws SQLException, ClassNotFoundException {
        String query = "select * from Payment where CustID=?";
        ResultSet data = DBHandler.getData(query, DBConnection.getDBConnection(), cid);
        Payment[] payment = null;
        int x = 0;
        while (data.next()) {
            x++;
        }
        payment = new Payment[x];
        data.beforeFirst();
        for (int i = 0; data.next(); i++) {
            payment[i] = new Payment(data.getString(1), data.getString(2), data.getString(3), data.getString(4), data.getString(5), data.getString(6), data.getDouble(7), data.getDouble(8), data.getString(9), data.getString(10));
        }
        return payment;
    }
}
