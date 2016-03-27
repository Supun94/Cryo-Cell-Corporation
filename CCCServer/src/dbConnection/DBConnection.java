/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author supun-pc
 */
public class DBConnection {
    public static Connection getDBConnection() throws ClassNotFoundException, SQLException{
       Class.forName("com.mysql.jdbc.Driver");
       Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/ccc","root","mysql");
       return  conn;
    }
}
