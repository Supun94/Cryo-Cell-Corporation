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
public class Refund implements Serializable {

    private String sampleID;
    private String nic;
    private String refunddate;
    private double amount;

    public Refund() {
    }

    public Refund(String sampleID, String nic, String refunddate, double amount) {
        this.sampleID = sampleID;
        this.nic = nic;
        this.refunddate = refunddate;
        this.amount = amount;
    }

    /**
     * @return the sampleID
     */
    public String getSampleID() {
        return sampleID;
    }

    /**
     * @param sampleID the sampleID to set
     */
    public void setSampleID(String sampleID) {
        this.sampleID = sampleID;
    }

    /**
     * @return the nic
     */
    public String getNic() {
        return nic;
    }

    /**
     * @param nic the nic to set
     */
    public void setNic(String nic) {
        this.nic = nic;
    }

    /**
     * @return the refunddate
     */
    public String getRefunddate() {
        return refunddate;
    }

    /**
     * @param refunddate the refunddate to set
     */
    public void setRefunddate(String refunddate) {
        this.refunddate = refunddate;
    }

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

}
