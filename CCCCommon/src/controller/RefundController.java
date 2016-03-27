/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import model.Refund;

/**
 *
 * @author supun-pc
 */
public interface RefundController extends Remote {

    public int addRefund(Refund refund) throws SQLException, ClassNotFoundException, RemoteException;

    public Refund[] getAllDateRefunds(String date) throws ClassNotFoundException, SQLException, RemoteException;

    public Refund[] getAllSidRefunds(String date) throws ClassNotFoundException, SQLException, RemoteException;

    public Refund[] getAllNicRefunds(String date) throws ClassNotFoundException, SQLException, RemoteException;

}
