/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observeble;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import observer.CustomerObserver;

/**
 *
 * @author supun-pc
 */
public class CustomerObserverble {
    private List<CustomerObserver>observerList=new ArrayList<CustomerObserver>();
    
    public boolean addCustomerObserver(CustomerObserver observer) {
        return observerList.add(observer);
    }

    public boolean removeCustomerObserver(CustomerObserver observer) {
        return observerList.remove(observer);
    }

    public void notifyObservers(String message) throws RemoteException {
        for (CustomerObserver customerObserver : observerList) {
            new NotifyCustomerObserver(customerObserver, message).start();
        }
    }

    class NotifyCustomerObserver extends Thread {

        private CustomerObserver observer;
        private String message;

        public NotifyCustomerObserver() {
        }

        public NotifyCustomerObserver(CustomerObserver observer, String message) {
            this.observer = observer;
            this.message = message;
        }

        @Override
        public void run() {
            try {
                observer.update(message);
            } catch (RemoteException ex) {
                Logger.getLogger(CustomerObserverble.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
