/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package serverutilities;


import controller.RemoteFactoryImpl;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import static log4j.Log4j.log;


/**
 *
 * @author Supun
 */
public class ServerStart {
    public static void main(String[] args) {
        try {
            Registry cccRegistry = LocateRegistry.createRegistry(5051);
            cccRegistry.rebind("Server",new RemoteFactoryImpl());
            System.out.println("Server Start...");
            log.info("Server Start...");
        } catch (RemoteException ex) {
            Logger.getLogger(ServerStart.class.getName()).log(Level.SEVERE, null, ex);
            log.error(ex);
        }
        
    }
}
