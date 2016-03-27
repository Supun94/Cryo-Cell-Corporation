/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dbaccess.PaymentDBAccess;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import model.Payment;

/**
 *
 * @author supun-pc
 */
public class PaymentControllerImpl extends UnicastRemoteObject implements PaymentController{

    private PaymentDBAccess paymentDbAccess=new PaymentDBAccess();
    
    public PaymentControllerImpl() throws RemoteException{
    
    }
    
    @Override
    public int addPayment(Payment payment) throws SQLException, ClassNotFoundException, RemoteException {
        return paymentDbAccess.addPayment(payment);
    }

    @Override
    public Payment[] viewAllPayment() throws SQLException, ClassNotFoundException, RemoteException {
        return paymentDbAccess.viewAllPayment();
    }

    @Override
    public Payment getSelectedPayment(String sid) throws SQLException, ClassNotFoundException, RemoteException {
        return paymentDbAccess.getSelectedPayment(sid);
    }

    @Override
    public boolean isDue(String date) throws SQLException, ClassNotFoundException, RemoteException {
        return paymentDbAccess.isDue(date);
    }

    @Override
    public Payment[] getAllSidPayments(String sid) throws SQLException, ClassNotFoundException, RemoteException {
        return paymentDbAccess.getAllSidPayments(sid);
    }

    @Override
    public boolean isPaymentAvailable(String sid) throws ClassNotFoundException, SQLException, RemoteException {
        return paymentDbAccess.isPaymentAvailable(sid);
    }

    @Override
    public double getTotalAmount(String sid) throws SQLException, ClassNotFoundException, RemoteException {
        return paymentDbAccess.getTotalAmount(sid);
    }

    @Override
    public Payment[] getAllDatePayments(String date) throws SQLException, ClassNotFoundException, RemoteException {
        return paymentDbAccess.getAllDatePayments(date);
    }

    @Override
    public Payment[] getAllPayments(String sampleID) throws SQLException, ClassNotFoundException, RemoteException {
        return paymentDbAccess.getAllPayments(sampleID);
    }

    @Override
    public Payment[] getAllCidPayments(String custID) throws SQLException, ClassNotFoundException, RemoteException {
        return paymentDbAccess.getAllCidPayments(custID);
    }
    
}
