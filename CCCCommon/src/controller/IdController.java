/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

/**
 *
 * @author supun-pc
 */
public interface IdController extends Remote  {
    
    public String getLastCustID() throws RemoteException, SQLException, ClassNotFoundException;
    
    public String getNextCustID() throws SQLException, ClassNotFoundException, RemoteException;

    public void releaseCustID(String id) throws SQLException, ClassNotFoundException, RemoteException;

    public void removeCustID(String id) throws SQLException, ClassNotFoundException, RemoteException;
    
    
    public String getLastInvoiceID() throws RemoteException, SQLException, ClassNotFoundException;
    
    public String getNextInvoiceID() throws SQLException, ClassNotFoundException, RemoteException;

    public void releaseInvoiceID(String id) throws SQLException, ClassNotFoundException, RemoteException;

    public void removeInvoiceID(String id) throws SQLException, ClassNotFoundException, RemoteException;
    
    
    
    
    
    public String getLastSID() throws RemoteException,SQLException,ClassNotFoundException;
    public String getNextSid() throws SQLException, ClassNotFoundException, RemoteException;

    public void releaseSid(String id) throws SQLException, ClassNotFoundException, RemoteException;

    public void removeSid(String id) throws SQLException, ClassNotFoundException, RemoteException;
    
}
