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

/**
 *
 * @author supun-pc
 */
public class IdDbAccess {
    public static String getLastCustID() throws SQLException, ClassNotFoundException {
        String query = "select CustID from Customer order by 1 desc limit 1";
        ResultSet rst = DBHandler.getData(query, DBConnection.getDBConnection());
        if (rst.next()) {
            return rst.getString(1);
        }
        return null;
    }
    
    public static String getLastInvoiceID() throws SQLException, ClassNotFoundException {
        String query = "select InvoiceID from Payment order by 1 desc limit 1";
        ResultSet rst = DBHandler.getData(query, DBConnection.getDBConnection());
        if (rst.next()) {
            return rst.getString(1);
        }
        return null;
    }
    
    
    public String getLastSID() throws SQLException, ClassNotFoundException {
        String query = "select count(*) from Fridge";
        ResultSet data = DBHandler.getData(query, DBConnection.getDBConnection());
        if (data.next()) {
            return Integer.toString(data.getInt(1));
        } else {
            return "0";
        }
    }
}
