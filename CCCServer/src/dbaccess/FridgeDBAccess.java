/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbaccess;

import dbConnection.DBConnection;
import dbConnection.DBHandler;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Customer;
import model.Fridge;

/**
 *
 * @author supun-pc
 */
public class FridgeDBAccess {

    public static int addFridge(Fridge fridge) throws ClassNotFoundException, SQLException, RemoteException {

        String query = "insert into Fridge values(?,?,?,?,?,?,?,?)";

        return DBHandler.setData(query, DBConnection.getDBConnection(), fridge.getCustID(), fridge.getFridgeID(), fridge.getCscID(), fridge.getStorageDate(), fridge.getLocationName(), fridge.getFridgeNumber(), fridge.getCscNumber(), fridge.getMatrixNumber());
    }

    public int searchRef(String name, String cscno) throws ClassNotFoundException, SQLException {
        String query = "select count(CscID) from Fridge where LocationName=? and MatrixNo=?";
        ResultSet data = DBHandler.getData(query, DBConnection.getDBConnection(), name, cscno);
        if (data.next()) {
            return data.getInt(1);
        } else {
            return 0;
        }
    }

    public int searchCount() throws ClassNotFoundException, SQLException {
        String query = "select count(*) from Fridge ";
        ResultSet data = DBHandler.getData(query, DBConnection.getDBConnection());
        if (data.next()) {
            return data.getInt(1);
        } else {
            return 0;
        }
    }

    public static Fridge[] viewAllFridge() throws ClassNotFoundException, SQLException {
        String sql = "Select * From Fridge";
        ResultSet rst = DBHandler.getData(sql, DBConnection.getDBConnection());
        int size = 0;
        while (rst.next()) {
            size++;
        }

        Fridge[] fridgeList = new Fridge[size];
        rst.beforeFirst();
        for (int i = 0; rst.next(); i++) {
            fridgeList[i] = new Fridge(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7), rst.getString(8));

        }
        return fridgeList;
    }

    public static int deleteFridge(String clientID) throws SQLException, ClassNotFoundException {
        String query = "delete from Fridge where FridgeID=?";
        Connection connection = DBConnection.getDBConnection();
        return DBHandler.setData(query, connection, clientID);

    }

    public String[] getAllSid() throws ClassNotFoundException, SQLException {
        String query = "select StorageID from Fridge";
        ResultSet data = DBHandler.getData(query, DBConnection.getDBConnection());
        String[] array = null;
        int x = 0;
        while (data.next()) {
            x++;
        }
        array = new String[x];
        data.beforeFirst();
        for (int i = 0; data.next(); i++) {
            array[i] = data.getString(1);
        }
        return array;
    }

    public Fridge getSearchFridgeDetails(String StorageID) throws ClassNotFoundException, SQLException {
        String query = "select * from Fridge where StorageID=?";
        ResultSet rst = DBHandler.getData(query, DBConnection.getDBConnection(), StorageID);
        Fridge storage = null;
        if (rst.next()) {
            storage = new Fridge(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7), rst.getString(8));
        }
        return storage;
    }

    public Fridge[] getCidFridgeDetails(String CustID) throws ClassNotFoundException, SQLException {
        String query = "select * from Fridge where CustID=?";
        ResultSet rst = DBHandler.getData(query, DBConnection.getDBConnection(), CustID);
        Fridge[] storage = null;
        int x = 0;
        while (rst.next()) {
            x++;
        }
        storage = new Fridge[x];
        rst.beforeFirst();
        for (int i = 0; rst.next(); i++) {
            storage[i] = new Fridge(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7), rst.getString(8));

        }
        return storage;
    }

    public String[] getCustomerSid(String CustID) throws SQLException, ClassNotFoundException {
        String query = "select StorageID from Fridge where CustID=?";
        ResultSet data = DBHandler.getData(query, DBConnection.getDBConnection(), CustID);
        int x = 0;
        String[] details = null;
        while (data.next()) {
            x++;
        }
        details = new String[x];
        data.beforeFirst();
        for (int i = 0; data.next(); i++) {
            details[i] = data.getString(1);
        }
        return details;
    }

    public String getStoredDate(String StorageID) throws ClassNotFoundException, SQLException {
        String query = "select storedate from Fridge where StorageID=?";
        ResultSet data = DBHandler.getData(query, DBConnection.getDBConnection(), StorageID);
        if (data.next()) {
            return data.getString(1);
        } else {
            return null;
        }
    }
    
    public int deleteDetail(String StorageID) throws SQLException, ClassNotFoundException {
        String query = "delete from Fridge where StorageID=?";
        return DBHandler.setData(query, DBConnection.getDBConnection(), StorageID);
    }
    
    public Fridge[] getAllSample() throws SQLException, ClassNotFoundException {
        String query = "select * from Fridge";
        ResultSet rst = DBHandler.getData(query, DBConnection.getDBConnection());
        Fridge[] storage = null;
        int x = 0;
        while (rst.next()) {
            x++;
        }
        storage = new Fridge[x];
        rst.beforeFirst();
        for (int i = 0; rst.next(); i++) {
            storage[i] = new Fridge(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7), rst.getString(8));
        }
        return storage;

    }

}
