/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import model.Fridge;

/**
 *
 * @author supun-pc
 */
public interface FridgeController extends Remote{
    
    public int addFridge(Fridge fridge) throws RemoteException, SQLException, ClassNotFoundException;
    public int searchRef(String name,String cscno) throws ClassNotFoundException, SQLException,RemoteException;
    public int searchCount() throws ClassNotFoundException, SQLException,RemoteException;
    public Fridge[] viewAllStorage() throws ClassNotFoundException, SQLException,RemoteException;
    public int deleteStorage(String id) throws ClassNotFoundException, SQLException,RemoteException;
    
     public String[] getAllSid() throws ClassNotFoundException, SQLException, RemoteException;

    public Fridge getSearchStorageDetails(String sid) throws ClassNotFoundException, SQLException, RemoteException;

    public Fridge[] getCidStorageDetails(String cid) throws ClassNotFoundException, SQLException, RemoteException;

    public String[] getCustomerSid(String cid) throws SQLException, ClassNotFoundException, RemoteException;

    public String getStoredDate(String sid) throws ClassNotFoundException, SQLException, RemoteException;

    public Fridge[] getAllSample() throws SQLException, ClassNotFoundException, RemoteException;

}
