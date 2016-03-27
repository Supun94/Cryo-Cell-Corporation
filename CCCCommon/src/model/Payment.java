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
public class Payment implements Serializable {

    private String invoiceID;
    private String custID;
    private String storageID;
    private String paymentDate;
    private String paymentType;
    private String paymentOption;
    private double annualFee;
    private double paymentAmount;
    private String dueDate;
    private String description;

    public Payment() {
    }

    public Payment(String invoiceID, String custID, String storageID, String paymentDate, String paymentType, String paymentOption, double annualFee, double paymentAmount, String dueDate, String description) {
        this.invoiceID = invoiceID;
        this.custID = custID;
        this.storageID = storageID;
        this.paymentDate = paymentDate;
        this.paymentType = paymentType;
        this.paymentOption = paymentOption;
        this.annualFee = annualFee;
        this.paymentAmount = paymentAmount;
        this.dueDate = dueDate;
        this.description = description;
    }

    public Payment(String storageID, String paymentDate, String paymentType, double paymentAmount, String description) {
        this.storageID = storageID;
        this.paymentDate = paymentDate;
        this.paymentType = paymentType;
        this.paymentAmount = paymentAmount;
        this.description = description;
    }
    
    
    /**
     * @return the invoiceID
     */
    public String getInvoiceID() {
        return invoiceID;
    }

    /**
     * @param invoiceID the invoiceID to set
     */
    public void setInvoiceID(String invoiceID) {
        this.invoiceID = invoiceID;
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
     * @return the storageID
     */
    public String getStorageID() {
        return storageID;
    }

    /**
     * @param storageID the storageID to set
     */
    public void setStorageID(String storageID) {
        this.storageID = storageID;
    }

    /**
     * @return the paymentDate
     */
    public String getPaymentDate() {
        return paymentDate;
    }

    /**
     * @param paymentDate the paymentDate to set
     */
    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    /**
     * @return the paymentType
     */
    public String getPaymentType() {
        return paymentType;
    }

    /**
     * @param paymentType the paymentType to set
     */
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    /**
     * @return the paymentOption
     */
    public String getPaymentOption() {
        return paymentOption;
    }

    /**
     * @param paymentOption the paymentOption to set
     */
    public void setPaymentOption(String paymentOption) {
        this.paymentOption = paymentOption;
    }

    /**
     * @return the annualFee
     */
    public double getAnnualFee() {
        return annualFee;
    }

    /**
     * @param annualFee the annualFee to set
     */
    public void setAnnualFee(double annualFee) {
        this.annualFee = annualFee;
    }

    /**
     * @return the paymentAmount
     */
    public double getPaymentAmount() {
        return paymentAmount;
    }

    /**
     * @param paymentAmount the paymentAmount to set
     */
    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    /**
     * @return the dueDate
     */
    public String getDueDate() {
        return dueDate;
    }

    /**
     * @param dueDate the dueDate to set
     */
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
