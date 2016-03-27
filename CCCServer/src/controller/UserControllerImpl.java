/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dbaccess.UserDBAccess;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import model.Admin;

/**
 *
 * @author supun-pc
 */
public class UserControllerImpl extends UnicastRemoteObject implements UserController{
    
    private UserDBAccess dBAccess=new UserDBAccess();
    
    public UserControllerImpl() throws RemoteException{
        
    }

    @Override
    public int getUserPrivilage(String userName, String password) throws RemoteException, SQLException, ClassNotFoundException {
        return dBAccess.getUserPrivilage(userName, password);
    }

    @Override
    public int addUser(Admin user) throws RemoteException, SQLException, ClassNotFoundException {
        return dBAccess.addUser(user);
    }

    @Override
    public int removeUser(String name, String password) throws RemoteException, SQLException, ClassNotFoundException {
        return dBAccess.removeUser(name, password);
    }

    @Override
    public int searchUserName(String userName) throws RemoteException, SQLException, ClassNotFoundException {
        return dBAccess.searchUserName(userName);
    }

    @Override
    public String[] getAllUsers() throws RemoteException, SQLException, ClassNotFoundException {
        return dBAccess.getAllUsers();
    }

    @Override
    public int deleteUser(String username) throws RemoteException, SQLException, ClassNotFoundException {
        return dBAccess.deleteUser(username);
    }

    @Override
    public int updatepassword(Admin user) throws RemoteException, SQLException, ClassNotFoundException {
        return dBAccess.updatepassword(user);
    }

    @Override
    public String getPassword(String username) throws RemoteException, SQLException, ClassNotFoundException {
        return dBAccess.getPassword(username);
    }

    @Override
    public Admin[] getAllUserPeople() throws RemoteException, SQLException, ClassNotFoundException {
        return dBAccess.getAllUserPeople();
    }
    
    
    
    
    
}
