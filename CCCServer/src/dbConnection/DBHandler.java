/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Malshika
 */
public class DBHandler {

    public static int setData(String query, Connection connection, Object... obj) throws SQLException {
        PreparedStatement prepareStatement = connection.prepareStatement(query);
        for (int i = 0; i < obj.length; i++) {
            prepareStatement.setObject(i + 1, obj[i]);
        }
        return prepareStatement.executeUpdate();
    }

    public static ResultSet getData(String query, Connection connection, Object... obj) throws SQLException {
        PreparedStatement prepareStatement = connection.prepareStatement(query);
        for (int i = 0; i < obj.length; i++) {
            prepareStatement.setObject(i + 1, obj[i]);
        }
        return prepareStatement.executeQuery();
    }
}
