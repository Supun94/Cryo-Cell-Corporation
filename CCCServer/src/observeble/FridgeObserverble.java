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
import observer.FridgeObserver;

/**
 *
 * @author supun-pc
 */
public class FridgeObserverble {
    private List<FridgeObserver>observerList=new ArrayList<FridgeObserver>();
    
    public boolean addCustomerObserver(FridgeObserver observer) {
        return observerList.add(observer);
    }

    public boolean removeCustomerObserver(CustomerObserver observer) {
        return observerList.remove(observer);
    }

    public void notifyObservers(String message) throws RemoteException {
        for (FridgeObserver customerObserver : observerList) {
            new NotifyCustomerObserver(customerObserver, message).start();
        }
    }

    class NotifyCustomerObserver extends Thread {

        private FridgeObserver observer;
        private String message;

        public NotifyCustomerObserver() {
        }

        public NotifyCustomerObserver(FridgeObserver observer, String message) {
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
