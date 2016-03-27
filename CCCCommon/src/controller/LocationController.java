/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

/**
 *
 * @author supun-pc
 */
public interface LocationController extends Remote{
    public String getLocationIdentifier(String name)throws SQLException,ClassNotFoundException,RemoteException;
    public String getFirstLocation() throws SQLException, ClassNotFoundException,RemoteException;
}
