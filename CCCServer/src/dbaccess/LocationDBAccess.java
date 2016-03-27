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
public class LocationDBAccess {
    
     public String getLocationIdentifier(String name) throws SQLException, ClassNotFoundException {
        String query = "select LocationIdentifier from FridgeLocation where LocationName=?";
        ResultSet data = DBHandler.getData(query, DBConnection.getDBConnection(), name);
        if (data.next()) {
            return data.getString(1);
        } else {
            return null;
        }
    }
    
    public String getFirstLocation() throws SQLException, ClassNotFoundException {
        String query = "select LocationName from FridgeLocation limit 1";
        ResultSet data = DBHandler.getData(query, DBConnection.getDBConnection());
        if (data.next()) {
            return data.getString(1);
        } else {
            return null;
        }
    }
    
}
