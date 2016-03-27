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
import model.CollectionPoint;
import model.Customer;

/**
 *
 * @author supun-pc
 */
public class CollectionPointDBAccess {

    public static int addCollectionPoint(CollectionPoint collectionPoint) throws ClassNotFoundException, SQLException, RemoteException {

        Connection connection = null;
        try {
            connection = DBConnection.getDBConnection();
            connection.setAutoCommit(false);
            String query = "insert into CollectionPoint values(?,?,?,?,?,?)";
            int setData = DBHandler.setData(query, connection, collectionPoint.getCustID(), collectionPoint.getName(), collectionPoint.getAddress(), collectionPoint.getRequestDate(), collectionPoint.getRequestTime(), collectionPoint.getCourierFirm());

            if (setData > 0) {
                return 1;
            } else {
                return -1;
            }
        } catch (ClassNotFoundException classNotFoundException) {
            connection.rollback();
            throw classNotFoundException;
        } catch (SQLException sQLException) {
            connection.rollback();
            throw sQLException;
        } finally {
            connection.setAutoCommit(true);
        }
    }

    public static CollectionPoint[] getAllCollections() throws ClassNotFoundException, SQLException {
        String sql = "Select * From CollectionPoint";
        ResultSet rst = DBHandler.getData(sql, DBConnection.getDBConnection());
        int size = 0;
        while (rst.next()) {
            size++;
        }

        CollectionPoint[] collectionList = new CollectionPoint[size];
        rst.beforeFirst();
        for (int i = 0; rst.next(); i++) {
            collectionList[i] = new CollectionPoint(rst.getString(1), rst.getString(2), rst.getString(3), rst.getDate(4), rst.getString(5), rst.getString(6));

        }
        return collectionList;
    }

}
