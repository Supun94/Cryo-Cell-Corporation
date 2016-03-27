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

/**
 *
 * @author supun-pc
 */
public class CustomerDBAccess {

    public static int addCustomer(Customer customer) throws ClassNotFoundException, SQLException, RemoteException {

        Connection connection = null;
        try {
            connection = DBConnection.getDBConnection();
            connection.setAutoCommit(false);
            String query = "insert into Customer values(?,?,?,?,?,?,?,?,?)";
            int setData = DBHandler.setData(query, connection, customer.getCustID(), customer.getNic(), customer.getFirstName(), customer.getLastName(), customer.getDob(), customer.getAddress(), customer.getContactNo(), customer.getEmail(), customer.getGender());

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

    public static Customer[] getAllCustomers() throws ClassNotFoundException, SQLException {
        String sql = "Select * From Customer";
        ResultSet rst = DBHandler.getData(sql, DBConnection.getDBConnection());
        int size = 0;
        while (rst.next()) {
            size++;
        }

        Customer[] customerList = new Customer[size];
        rst.beforeFirst();
        for (int i = 0; rst.next(); i++) {
            customerList[i] = new Customer(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getDate(5), rst.getString(6), rst.getString(7), rst.getString(8), rst.getString(9));

        }
        return customerList;
    }

    public static Customer[] getCustomers(String name) throws ClassNotFoundException, SQLException {
        String query = "Select*from Customer where Nic='" + name + "'";
        ResultSet rst = DBHandler.getData(query, DBConnection.getDBConnection());
        int size = 0;
        while (rst.next()) {
            size++;
        }

        Customer[] customerList = new Customer[size];
        rst.beforeFirst();
        for (int i = 0; rst.next(); i++) {
            customerList[i] = new Customer(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getDate(5), rst.getString(6), rst.getString(7), rst.getString(8), rst.getString(9));
        }
        return customerList;

    }

    public Customer[] getCustomersCID(String name) throws ClassNotFoundException, SQLException {
        String query = "Select*from Customer where CustID='" + name + "'";
        ResultSet rst = DBHandler.getData(query, DBConnection.getDBConnection());
        int size = 0;
        while (rst.next()) {
            size++;
        }

        Customer[] customerList = new Customer[size];
        rst.beforeFirst();
        for (int i = 0; rst.next(); i++) {
            customerList[i] = new Customer(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getDate(5), rst.getString(6), rst.getString(7), rst.getString(8), rst.getString(9));
        }
        return customerList;
    }

    public String[][] getAllCidNIC() throws ClassNotFoundException, SQLException {
        String query = "select CustID,Nic from Customer";
        ResultSet data = DBHandler.getData(query, DBConnection.getDBConnection());
        int x = 0;
        while (data.next()) {
            x++;
        }
        String[][] array = new String[x][2];
        data.beforeFirst();
        for (int i = 0; data.next(); i++) {
            array[i][0] = data.getString(1);
            array[i][1] = data.getString(2);
        }
        return array;
    }

      public Customer searchByCid(String cid) throws SQLException, ClassNotFoundException {
        String query = "select * from Customer where CustID=?";
        ResultSet data = DBHandler.getData(query, DBConnection.getDBConnection(), cid);
        Customer customer = null;
        if (data.next()) {
            customer = new Customer(data.getString(1), data.getString(2), data.getString(3), data.getString(4), data.getDate(5), data.getString(6), data.getString(7), data.getString(8), data.getString(9));
        }
        return customer;
    }
      
      public Customer searchByNic(String nic) throws SQLException, ClassNotFoundException {
        String query = "select * from Customer where Nic=?";
        ResultSet data = DBHandler.getData(query, DBConnection.getDBConnection(), nic);
        Customer customer = null;
        if (data.next()) {
            customer = new Customer(data.getString(1), data.getString(2), data.getString(3), data.getString(4), data.getDate(5), data.getString(6), data.getString(7), data.getString(8), data.getString(9));
        }
        return customer;
    }
    
    
}
