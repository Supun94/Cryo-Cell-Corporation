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
public class CollectionPoint implements Serializable{
    
    private String custID;
    private String name;
    private String address;
    private Date requestDate;
    private String requestTime;
    private String courierFirm;

    public CollectionPoint() {
    }

    public CollectionPoint(String custID, String name, String address, Date requestDate, String requestTime, String courierFirm) {
        this.custID = custID;
        this.name = name;
        this.address = address;
        this.requestDate = requestDate;
        this.requestTime = requestTime;
        this.courierFirm = courierFirm;
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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the requestDate
     */
    public Date getRequestDate() {
        return requestDate;
    }

    /**
     * @param requestDate the requestDate to set
     */
    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    /**
     * @return the requestTime
     */
    public String getRequestTime() {
        return requestTime;
    }

    /**
     * @param requestTime the requestTime to set
     */
    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    /**
     * @return the courierFirm
     */
    public String getCourierFirm() {
        return courierFirm;
    }

    /**
     * @param courierFirm the courierFirm to set
     */
    public void setCourierFirm(String courierFirm) {
        this.courierFirm = courierFirm;
    }

    
    
}
