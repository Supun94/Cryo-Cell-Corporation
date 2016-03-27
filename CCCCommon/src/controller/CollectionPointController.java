/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import model.CollectionPoint;
import model.Customer;

/**
 *
 * @author supun-pc
 */
public interface CollectionPointController extends Remote{
    public int addCollection(CollectionPoint collectionPoint) throws RemoteException, SQLException, ClassNotFoundException;
    public CollectionPoint[] showCollectionPoint() throws RemoteException, SQLException, ClassNotFoundException;
    
    
}
