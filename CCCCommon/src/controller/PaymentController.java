/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import model.Payment;

/**
 *
 * @author supun-pc
 */
public interface PaymentController extends Remote {

    public int addPayment(Payment payment) throws SQLException, ClassNotFoundException, RemoteException;

    public Payment[] viewAllPayment() throws SQLException, ClassNotFoundException, RemoteException;

    public Payment getSelectedPayment(String sid) throws SQLException, ClassNotFoundException, RemoteException;

    public boolean isDue(String date) throws SQLException, ClassNotFoundException, RemoteException;

    public Payment[] getAllSidPayments(String sid) throws SQLException, ClassNotFoundException, RemoteException;

    public boolean isPaymentAvailable(String sid) throws ClassNotFoundException, SQLException, RemoteException;

    public double getTotalAmount(String sid) throws SQLException, ClassNotFoundException, RemoteException;

    public Payment[] getAllDatePayments(String date) throws SQLException, ClassNotFoundException, RemoteException;

    public Payment[] getAllPayments(String sid) throws SQLException, ClassNotFoundException, RemoteException;

    public Payment[] getAllCidPayments(String cid) throws SQLException, ClassNotFoundException, RemoteException;
}
