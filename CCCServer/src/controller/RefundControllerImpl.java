/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dbaccess.RefundDBAccess;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import model.Refund;

/**
 *
 * @author supun-pc
 */
public class RefundControllerImpl extends UnicastRemoteObject implements RefundController{
    
    private RefundDBAccess refundDbAccess=new RefundDBAccess();
    public RefundControllerImpl()throws RemoteException{
    
    }
    
    @Override
    public int addRefund(Refund refund) throws SQLException, ClassNotFoundException, RemoteException {
        return refundDbAccess.addRefund(refund);
    }

    @Override
    public Refund[] getAllDateRefunds(String date) throws ClassNotFoundException, SQLException, RemoteException {
        return refundDbAccess.getAllDateRefunds(date);
    }

    @Override
    public Refund[] getAllSidRefunds(String date) throws ClassNotFoundException, SQLException, RemoteException {
        return refundDbAccess.getAllSidRefunds(date);
    }

    @Override
    public Refund[] getAllNicRefunds(String date) throws ClassNotFoundException, SQLException, RemoteException {
        return refundDbAccess.getAllNicRefunds(date);
    }
    
}
