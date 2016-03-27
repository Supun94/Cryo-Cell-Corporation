/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package connector;


import controller.CollectionPointController;
import controller.CustomerController;
import controller.FridgeController;
import controller.IdController;
import controller.LocationController;
import controller.PaymentController;
import controller.RefundController;
import controller.RemoteFactory;
import controller.UserController;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *
 * @author Supun
 */  
public class ServerConnector {

    private static ServerConnector connector;
    private static RemoteFactory remoteFactory;
    private CustomerController customerController;
    private CollectionPointController collectionPointController;
    private LocationController locationController;
    private FridgeController fridgeController;
    private IdController idController;
    private PaymentController paymentController;
    private UserController userController;
    private RefundController refundController;
  

    private ServerConnector() throws NotBoundException, MalformedURLException, RemoteException {
        if (remoteFactory == null) {
            remoteFactory = (RemoteFactory) Naming.lookup("rmi://localhost:5051/Server");
        }
    }

    public static ServerConnector getServerConnector() throws NotBoundException, MalformedURLException, RemoteException {
        if (connector == null) {
            connector = new ServerConnector();
        }
        return connector;
    }

    public CustomerController getCustomerController() throws RemoteException {
        if (customerController == null) {
            customerController = remoteFactory.getCustomerController();
        }
        return customerController;

    }
    
    public CollectionPointController getCollectionPointController() throws RemoteException {
        if (collectionPointController == null) {
            collectionPointController = remoteFactory.getCollectionPointController();
        }
        return collectionPointController;

    }
    
    public FridgeController getFridgeController() throws RemoteException {
        if (fridgeController == null) {
            fridgeController = remoteFactory.getFridgeController();
        }
        return fridgeController;

    }
    public PaymentController getPaymentController() throws RemoteException{
        if (paymentController == null) {
            paymentController = remoteFactory.getPaymentController();
        }
        return paymentController;
    }
   public LocationController getLocationController() throws RemoteException {
        if (locationController == null) {
            locationController = remoteFactory.getLocationController();
        }
        return locationController;

    }
    
   public UserController getUserController() throws RemoteException {
        if (userController == null) {
            userController = remoteFactory.getUserController();
        }
        return userController;

    }
    
   public RefundController getRefundController () throws RemoteException{
       if (refundController == null) {
            refundController = remoteFactory.getRefundController();
        }
        return refundController;
   }
   
   
    public IdController getIdController() throws RemoteException{
        if(idController==null){
            idController=remoteFactory.getIdController();
        }
        return  idController;
    }
//
//    public StudentController getStudentController() throws RemoteException {
//        if (studentController == null) {
//            studentController = remoteFactory.getStudentController();
//        }
//        return studentController;
//
//    }
//    
//    public ForumController getForumController() throws RemoteException {
//        if (forumController == null) {
//            forumController = remoteFactory.getForumController();
//        }
//        return forumController;
//
//    }
//    
//        public ExamController getExamController() throws RemoteException {
//        if (examController == null) {
//            examController = remoteFactory.getExamController();
//        }
//        return examController;
//
//    }

}
