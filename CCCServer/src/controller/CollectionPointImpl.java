/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dbaccess.CollectionPointDBAccess;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import model.CollectionPoint;
import observeble.CollectionPointObserverble;
import observeble.CustomerObserverble;
import pool.IdPool;
import reservation.CollectionPointReserver;

/**
 *
 * @author supun-pc
 */
public class CollectionPointImpl extends UnicastRemoteObject implements CollectionPointController {

    private CollectionPointDBAccess collectionPointDBAccess = new CollectionPointDBAccess();
    private static CollectionPointObserverble customerObserverble = new CollectionPointObserverble();
    private static CollectionPointReserver reserver = new CollectionPointReserver();
    private static IdPool customerIdPool = new IdPool();

    public CollectionPointImpl() throws RemoteException {

    }

    @Override
    public int addCollection(CollectionPoint collectionPoint) throws RemoteException, SQLException, ClassNotFoundException {
        int addCollection = collectionPointDBAccess.addCollectionPoint(collectionPoint);
        if (addCollection > 0) {
            customerObserverble.notifyObservers("Added Customer " + collectionPoint.getCustID());
        }
        return addCollection;

    }

    @Override
    public CollectionPoint[] showCollectionPoint() throws RemoteException, SQLException, ClassNotFoundException {
        return collectionPointDBAccess.getAllCollections();
    }

}
