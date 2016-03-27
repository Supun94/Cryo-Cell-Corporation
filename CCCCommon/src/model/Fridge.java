/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author supun-pc
 */
public class Fridge implements Serializable {

    private String custID;
    private String fridgeID;
    private String cscID;
    private String storageDate;
    private String locationName;
    private String fridgeNumber;
    private String cscNumber;
    private String matrixNumber;

    public Fridge() {
    }

    public Fridge(String custID, String fridgeID, String cscID, String storageDate, String locationName, String fridgeNumber, String cscNumber, String matrixNumber) {
        this.custID = custID;
        this.fridgeID = fridgeID;
        this.cscID = cscID;
        this.storageDate = storageDate;
        this.locationName = locationName;
        this.fridgeNumber = fridgeNumber;
        this.cscNumber = cscNumber;
        this.matrixNumber = matrixNumber;
    }

    /**
     * @return the custID
     */
    public String getCustID() {
        return custID;
    }

    /**
     * @param custID the custID to set
     */
    public void setCustID(String custID) {
        this.custID = custID;
    }

    /**
     * @return the fridgeID
     */
    public String getFridgeID() {
        return fridgeID;
    }

    /**
     * @param fridgeID the fridgeID to set
     */
    public void setFridgeID(String fridgeID) {
        this.fridgeID = fridgeID;
    }

    /**
     * @return the cscID
     */
    public String getCscID() {
        return cscID;
    }

    /**
     * @param cscID the cscID to set
     */
    public void setCscID(String cscID) {
        this.cscID = cscID;
    }

    /**
     * @return the storageDate
     */
    public String getStorageDate() {
        return storageDate;
    }

    /**
     * @param storageDate the storageDate to set
     */
    public void setStorageDate(String storageDate) {
        this.storageDate = storageDate;
    }

    /**
     * @return the locationName
     */
    public String getLocationName() {
        return locationName;
    }

    /**
     * @param locationName the locationName to set
     */
    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    /**
     * @return the fridgeNumber
     */
    public String getFridgeNumber() {
        return fridgeNumber;
    }

    /**
     * @param fridgeNumber the fridgeNumber to set
     */
    public void setFridgeNumber(String fridgeNumber) {
        this.fridgeNumber = fridgeNumber;
    }

    /**
     * @return the cscNumber
     */
    public String getCscNumber() {
        return cscNumber;
    }

    /**
     * @param cscNumber the cscNumber to set
     */
    public void setCscNumber(String cscNumber) {
        this.cscNumber = cscNumber;
    }

    /**
     * @return the matrixNumber
     */
    public String getMatrixNumber() {
        return matrixNumber;
    }

    /**
     * @param matrixNumber the matrixNumber to set
     */
    public void setMatrixNumber(String matrixNumber) {
        this.matrixNumber = matrixNumber;
    }

    
}
