/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import model.Customer;

/**
 *
 * @author supun-pc
 */
public interface CustomerController extends Remote {

    public int addCustomer(Customer customer) throws RemoteException, SQLException, ClassNotFoundException;

    public Customer[] showCustomer() throws RemoteException, SQLException, ClassNotFoundException;

    public Customer[] getNameDetails(String name) throws RemoteException, SQLException, ClassNotFoundException;

    public Customer[] getCIDDetails(String name) throws RemoteException, SQLException, ClassNotFoundException;

    public String[][] getAllCidNic() throws RemoteException, SQLException, ClassNotFoundException;

    public Customer searchByCid(String cid) throws RemoteException, SQLException, ClassNotFoundException;

    public Customer searchByNic(String nic) throws RemoteException, SQLException, ClassNotFoundException;
}
