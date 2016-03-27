/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import view.ViewAllCustomer;

/**
 *
 * @author supun-pc
 */
public class CustomerObserverImpl extends UnicastRemoteObject implements CustomerObserver{

    private ViewAllCustomer allCustomer;
    
    public CustomerObserverImpl(ViewAllCustomer allCustomer)throws RemoteException{
        this.allCustomer=allCustomer;
     }
    
    @Override
    public void update(String message) throws RemoteException {
        allCustomer.setMessage(message);
    }
    
}
