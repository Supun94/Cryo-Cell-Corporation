/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Supun
 */
public class RemoteFactoryImpl extends UnicastRemoteObject implements RemoteFactory {

    public RemoteFactoryImpl() throws RemoteException {

    }

    @Override
    public CustomerController getCustomerController() throws RemoteException {
        return new CustomerControllerImpl();
    }

    @Override
    public IdController getIdController() throws RemoteException {
        return new IdControllerImpl();
    }

    @Override
    public CollectionPointController getCollectionPointController() throws RemoteException {
        return new CollectionPointImpl();
    }

    @Override
    public FridgeController getFridgeController() throws RemoteException {
        return new FridgeControllerImpl();
    }

    @Override
    public LocationController getLocationController() throws RemoteException {
        return new LocationControllerImpl();
    }

    @Override
    public PaymentController getPaymentController() throws RemoteException {
        return new PaymentControllerImpl();
    }

    @Override
    public UserController getUserController() throws RemoteException {
        return new UserControllerImpl();
    }

    @Override
    public RefundController getRefundController() throws RemoteException {
        return new RefundControllerImpl();
    }

}
