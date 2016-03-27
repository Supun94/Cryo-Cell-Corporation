/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dbaccess.LocationDBAccess;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

/**
 *
 * @author supun-pc
 */
public class LocationControllerImpl extends UnicastRemoteObject implements LocationController{

    private LocationDBAccess locationDbAccess=new LocationDBAccess();
    public LocationControllerImpl()throws RemoteException{
    
    }
    
    @Override
    public String getLocationIdentifier(String name) throws SQLException, ClassNotFoundException, RemoteException {
        return locationDbAccess.getLocationIdentifier(name);
    }

    @Override
    public String getFirstLocation() throws SQLException, ClassNotFoundException, RemoteException {
        return locationDbAccess.getFirstLocation();
    }
    
}
