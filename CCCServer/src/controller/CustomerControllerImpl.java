/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dbaccess.CustomerDBAccess;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customer;
import observeble.CustomerObserverble;
import pool.IdPool;
import reservation.CustomerReserver;

/**
 *
 * @author supun-pc
 */
public class CustomerControllerImpl extends UnicastRemoteObject implements CustomerController {

    private CustomerDBAccess customerDBAccess = new CustomerDBAccess();
    private static CustomerObserverble customerObserverble = new CustomerObserverble();
    private static CustomerReserver reserver = new CustomerReserver();
    private static IdPool customerIdPool = new IdPool();

    public CustomerControllerImpl() throws RemoteException {

    }

    @Override
    public int addCustomer(Customer customer) throws RemoteException, SQLException, ClassNotFoundException {
        int addCustomer = customerDBAccess.addCustomer(customer);
        if (addCustomer > 0) {
            customerObserverble.notifyObservers("Added Customer " + customer.getNic());
        }
        return addCustomer;
    }

    @Override
    public Customer[] showCustomer() throws RemoteException, SQLException, ClassNotFoundException {
        return customerDBAccess.getAllCustomers();
    }

    @Override
    public Customer[] getNameDetails(String name) throws RemoteException, SQLException, ClassNotFoundException {
        return customerDBAccess.getCustomers(name);
    }

    @Override
    public Customer[] getCIDDetails(String name) throws RemoteException, SQLException, ClassNotFoundException {
        return customerDBAccess.getCustomersCID(name);
    }

    @Override
    public String[][] getAllCidNic() throws RemoteException, SQLException, ClassNotFoundException {
        return customerDBAccess.getAllCidNIC();
    }

    @Override
    public Customer searchByCid(String cid) throws RemoteException, SQLException, ClassNotFoundException {
        return customerDBAccess.searchByCid(cid);
    }

    @Override
    public Customer searchByNic(String nic) throws RemoteException, SQLException, ClassNotFoundException {
        return customerDBAccess.searchByNic(nic);
    }

}
