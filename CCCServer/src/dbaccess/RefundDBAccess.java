/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbaccess;

import dbConnection.DBConnection;
import dbConnection.DBHandler;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Refund;

/**
 *
 * @author supun-pc
 */
public class RefundDBAccess {
    
    public int addRefund(Refund refund) throws SQLException, ClassNotFoundException {
        String query = "insert into Refund values(?,?,?,?)";
        return DBHandler.setData(query, DBConnection.getDBConnection(), refund.getSampleID(), refund.getNic(), refund.getRefunddate(), refund.getAmount());
    }

    public Refund[] getAllDateRefunds(String date) throws ClassNotFoundException, SQLException {
        String query = "select * from Refund where RefundDate=?";
        ResultSet data = DBHandler.getData(query, DBConnection.getDBConnection(), date);
        Refund[] refunds;
        int x = 0;
        while (data.next()) {
            x++;
        }
        refunds = new Refund[x];
        data.beforeFirst();
        for (int i = 0; data.next(); i++) {
            refunds[i] = new Refund(data.getString(1), data.getString(2), data.getString(3), data.getDouble(4));
        }
        return refunds;
    }

    public Refund[] getAllSidRefunds(String date) throws ClassNotFoundException, SQLException {
        String query = "select * from Refund where StorageID=?";
        ResultSet data = DBHandler.getData(query, DBConnection.getDBConnection(), date);
        Refund[] refunds;
        int x = 0;
        while (data.next()) {
            x++;
        }
        refunds = new Refund[x];
        data.beforeFirst();
        for (int i = 0; data.next(); i++) {
            refunds[i] = new Refund(data.getString(1), data.getString(2), data.getString(3), data.getDouble(4));
        }
        return refunds;
    }

    public Refund[] getAllNicRefunds(String date) throws ClassNotFoundException, SQLException {
        String query = "select * from Refund where CustID=?";
        ResultSet data = DBHandler.getData(query, DBConnection.getDBConnection(), date);
        Refund[] refunds;
        int x = 0;
        while (data.next()) {
            x++;
        }
        refunds = new Refund[x];
        data.beforeFirst();
        for (int i = 0; data.next(); i++) {
            refunds[i] = new Refund(data.getString(1), data.getString(2), data.getString(3), data.getDouble(4));
        }
        return refunds;
    }
    
    
}
