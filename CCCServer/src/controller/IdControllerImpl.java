/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dbaccess.IdDbAccess;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import model.ID;
import pool.IDGen;
import pool.IdPool;
import pool.SampleIdPool;

/**
 *
 * @author supun-pc
 */
public class IdControllerImpl extends UnicastRemoteObject implements IdController {
    private IdDbAccess idDbAccess=new IdDbAccess();
    private static IdPool idPool=new IdPool();
    private static SampleIdPool sampleIdPool=new SampleIdPool();
    
    public IdControllerImpl() throws RemoteException{
    
    }

    @Override
    public String getLastCustID() throws RemoteException, SQLException, ClassNotFoundException {
        return idDbAccess.getLastCustID();
    }

    @Override
    public String getNextCustID() throws SQLException, ClassNotFoundException, RemoteException {
        ID id = idPool.getId();
        System.out.println(id);
        if (id == null) {
            String lastCustomerID = getLastCustID();
            if(lastCustomerID==null){
                lastCustomerID="C000";
            }
            System.out.println("Last "+lastCustomerID);
            String nextId = IDGen.nextId(lastCustomerID);
            System.out.println("Next "+nextId);
            ID newID = new ID(nextId);
            idPool.addId(newID);
            return newID.getId();
        }
        System.out.println("Final"+id.getId());
        return id.getId();
    }

    @Override
    public void releaseCustID(String id) throws SQLException, ClassNotFoundException, RemoteException {
         idPool.releaseID(id);
    }

    @Override
    public void removeCustID(String id) throws SQLException, ClassNotFoundException, RemoteException {
        idPool.removeID(id);
    }

    @Override
    public String getLastSID() throws RemoteException, SQLException, ClassNotFoundException {
        return idDbAccess.getLastSID();
    }

    @Override
    public String getNextSid() throws SQLException, ClassNotFoundException, RemoteException {
        ID id = sampleIdPool.getId();
        System.out.println(id);
        if (id == null) {
            String lastCustomerID = getLastSID();
            System.out.println("Last "+lastCustomerID);
            String nextId = lastCustomerID;
            System.out.println("Next "+nextId);
            ID newID = new ID(nextId);
            sampleIdPool.addId(newID);
            return newID.getId();
        }
        System.out.println("Final"+id.getId());
        return id.getId();
    }

    @Override
    public void releaseSid(String id) throws SQLException, ClassNotFoundException, RemoteException {
        sampleIdPool.releaseID(id);
    }

    @Override
    public void removeSid(String id) throws SQLException, ClassNotFoundException, RemoteException {
        sampleIdPool.removeID(id);
    }

    @Override
    public String getLastInvoiceID() throws RemoteException, SQLException, ClassNotFoundException {
        return idDbAccess.getLastInvoiceID();
    }

    @Override
    public String getNextInvoiceID() throws SQLException, ClassNotFoundException, RemoteException {
        ID id = idPool.getId();
        System.out.println(id);
        if (id == null) {
            String lastCustomerID = getLastInvoiceID();
            if(lastCustomerID==null){
                lastCustomerID="I000";
            }
            System.out.println("Last "+lastCustomerID);
            String nextId = IDGen.nextId(lastCustomerID);
            System.out.println("Next "+nextId);
            ID newID = new ID(nextId);
            idPool.addId(newID);
            return newID.getId();
        }
        System.out.println("Final"+id.getId());
        return id.getId();
    }

    @Override
    public void releaseInvoiceID(String id) throws SQLException, ClassNotFoundException, RemoteException {
        idPool.releaseID(id);
    }

    @Override
    public void removeInvoiceID(String id) throws SQLException, ClassNotFoundException, RemoteException {
        idPool.removeID(id);
    }
    
    
    
}
