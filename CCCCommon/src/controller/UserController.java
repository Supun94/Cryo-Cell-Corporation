/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import model.Admin;

/**
 *
 * @author supun-pc
 */
public interface UserController extends Remote{
    
    
    public int getUserPrivilage(String userName, String password) throws RemoteException, SQLException, ClassNotFoundException;
    public int addUser(Admin user) throws RemoteException, SQLException, ClassNotFoundException;
    public int removeUser(String name, String password) throws RemoteException, SQLException, ClassNotFoundException;
    public int searchUserName(String userName) throws RemoteException, SQLException, ClassNotFoundException;
    public String[] getAllUsers() throws RemoteException, SQLException, ClassNotFoundException;
    public int deleteUser(String username)  throws RemoteException, SQLException, ClassNotFoundException;
    public int updatepassword(Admin user)  throws RemoteException, SQLException, ClassNotFoundException;
    public String getPassword(String username) throws RemoteException, SQLException, ClassNotFoundException;
    public Admin[] getAllUserPeople() throws RemoteException, SQLException, ClassNotFoundException;



}
