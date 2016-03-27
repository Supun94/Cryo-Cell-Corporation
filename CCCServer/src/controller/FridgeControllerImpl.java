/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dbaccess.FridgeDBAccess;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import model.Fridge;
import observeble.FridgeObserverble;
import pool.IdPool;
import reservation.FridgeReserver;

/**
 *
 * @author supun-pc
 */
public class FridgeControllerImpl extends UnicastRemoteObject implements FridgeController{

    
    private FridgeDBAccess fridgeDBAccess = new FridgeDBAccess();
    private static FridgeObserverble fridgeObserverble = new FridgeObserverble();
    private static FridgeReserver reserver = new FridgeReserver();
    private static IdPool customerIdPool = new IdPool();
    
    
    public FridgeControllerImpl() throws RemoteException{
        
    }
    
    @Override
    public int addFridge(Fridge fridge) throws RemoteException, SQLException, ClassNotFoundException {
        int addFridge = fridgeDBAccess.addFridge(fridge);
        if (addFridge > 0) {
            fridgeObserverble.notifyObservers("Added Fridge " + fridge.getFridgeID());
        }
        return addFridge;
    }

    @Override
    public int searchRef(String name, String cscno) throws ClassNotFoundException, SQLException, RemoteException {
        return fridgeDBAccess.searchRef(name, cscno);
    }

    @Override
    public int searchCount() throws ClassNotFoundException, SQLException, RemoteException {
         return fridgeDBAccess.searchCount();
    }

    @Override
    public Fridge[] viewAllStorage() throws ClassNotFoundException, SQLException, RemoteException {
       return fridgeDBAccess.viewAllFridge();
    }

    

    @Override
    public String[] getAllSid() throws ClassNotFoundException, SQLException, RemoteException {
        return fridgeDBAccess.getAllSid();
    }

    @Override
    public Fridge getSearchStorageDetails(String sid) throws ClassNotFoundException, SQLException, RemoteException {
        return fridgeDBAccess.getSearchFridgeDetails(sid);
    }

    @Override
    public Fridge[] getCidStorageDetails(String cid) throws ClassNotFoundException, SQLException, RemoteException {
        return fridgeDBAccess.getCidFridgeDetails(cid);
    }

    @Override
    public String[] getCustomerSid(String cid) throws SQLException, ClassNotFoundException, RemoteException {
        return fridgeDBAccess.getCustomerSid(cid);
    }

    @Override
    public String getStoredDate(String sid) throws ClassNotFoundException, SQLException, RemoteException {
        return fridgeDBAccess.getStoredDate(sid);
    }


    @Override
    public int deleteStorage(String sid) throws ClassNotFoundException, SQLException, RemoteException {
        return fridgeDBAccess.deleteDetail(sid);
    }

    @Override
    public Fridge[] getAllSample() throws SQLException, ClassNotFoundException, RemoteException {
        return fridgeDBAccess.getAllSample();
    }
    
}
