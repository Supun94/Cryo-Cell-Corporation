/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbaccess;

import controller.UserController;
import dbConnection.DBConnection;
import dbConnection.DBHandler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Admin;

/**
 *
 * @author supun-pc
 */
public class UserDBAccess {
    
     public static int getUserPrivilage(String userName, String password) throws ClassNotFoundException, SQLException {
        String sql = "select privilage from user where userName = ? and password = password(?)";
        PreparedStatement prepareStatement = DBConnection.getDBConnection().prepareStatement(sql);
        prepareStatement.setString(1, userName);
        prepareStatement.setString(2, password);
        ResultSet rst = prepareStatement.executeQuery();
        if (rst.next()) {
            return rst.getInt(1);
        } else {
            return -1;
        }

    }
    
    
    public static int addUser(Admin user) throws ClassNotFoundException, SQLException{
        String sql = "insert into user values(?,password(?),?)";
        PreparedStatement prepareStatement = DBConnection.getDBConnection().prepareStatement(sql);
        prepareStatement.setString(1, user.getUserName());
        prepareStatement.setString(2, user.getPassword());
        prepareStatement.setInt(3, user.getPrivi());
        
        return prepareStatement.executeUpdate();
    }
     public static int removeUser(String name, String password) throws ClassNotFoundException, SQLException {
       String sql="delete from user where userName=? && password=password(?)";
       PreparedStatement preparedStatement=DBConnection.getDBConnection().prepareStatement(sql);
       preparedStatement.setString(1, name);
       preparedStatement.setObject(2, password);
       return preparedStatement.executeUpdate();
    }

    public static int searchUserName(String userName) throws SQLException, ClassNotFoundException {
        String sql="select * from user where userName=?";
        PreparedStatement preparedStatement=DBConnection.getDBConnection().prepareStatement(sql);
        preparedStatement.setString(1, userName);
        ResultSet rst=preparedStatement.executeQuery();
        if(rst.next()){
            return 0;
        }else{
            return 1;
        }
    }
    
     public static String[] getAllUsers() throws SQLException, SQLException {
         try {
             String sql = "Select username From user";
             ResultSet rst = DBHandler.getData(sql, DBConnection.getDBConnection());
             int size = 0;
             while (rst.next()) {
                 size++;
             }
             if (size > 0) {
                 String[] usernameList = new String[size];
                 rst.beforeFirst();
                 for (int i = 0; rst.next(); i++) {
                     usernameList[i] = rst.getString("username");
                 }
                 return usernameList;
             } else {
                 return null;
             }} catch (SQLException ex) {
             Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;
    }
     
     
     public static int deleteUser(String username) throws SQLException, ClassNotFoundException {
        String query = "delete from User where username=?";
        Connection connection = DBConnection.getDBConnection();
        return DBHandler.setData(query, connection, username);
    }
    
     public static int updatepassword(Admin user) throws ClassNotFoundException, SQLException {
        String query = "update User set password=password(?) where username=?";
        Connection connection = null;
        try {
            connection = DBConnection.getDBConnection();
            connection.setAutoCommit(false);
            return DBHandler.setData(query, connection, user.getPassword(), user.getUserName());
        } catch (ClassNotFoundException classNotFoundException) {
            connection.rollback();
            throw classNotFoundException;
        } catch (SQLException sQLException) {
            connection.rollback();
            throw sQLException;
        }finally{
        connection.setAutoCommit(true);
        }


    }
     
     
     public static String getPassword(String username) throws ClassNotFoundException, SQLException {
        String query = "select password from User where username=?";
        Connection connection = DBConnection.getDBConnection();
        ResultSet data = DBHandler.getData(query, connection, username);
        if (data.next()) {
            return data.getString(1);
        }
        return null;
    }
     
     
      public static Admin[] getAllUserPeople() throws ClassNotFoundException, SQLException {
        String sql = "Select * From user";
        ResultSet rst = DBHandler.getData(sql, DBConnection.getDBConnection());
        int size = 0;
        while (rst.next()) {
            size++;
        }

        Admin[] userList = new Admin[size];
        rst.beforeFirst();
        for (int i = 0; rst.next(); i++) {
            userList[i] = new Admin(rst.getString("username"), rst.getString("password"), rst.getInt("privilage"));
        }
        return userList;
    }
     
    
}
