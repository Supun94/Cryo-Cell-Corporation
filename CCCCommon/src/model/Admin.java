/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author supun-pc
 */
public class Admin implements Serializable{
    //attributes of the admin class
    private String userName;
    private String password;

    private int privi;
    public Admin() {
    }

    public Admin(String userName, String password, int privi) {
        this.userName = userName;
        this.password = password;
        this.privi = privi;
    }

    

    
    public Admin(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
   
    public int getPrivi() {
        return privi;
    }

    public void setPrivi(int privi) {
        this.privi = privi;
    }
}
