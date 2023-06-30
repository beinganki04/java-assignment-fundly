package org.java;

import java.util.Date;

public class Loan {
    private String loanId;
    private String customerId;
    private String lenderId;
    private double amount;
    private double remainingAmount;
    private Date paymentDate;
    private int interestPerDay;
    private Date dueDate;
    private double penaltyPerDay;

    public Loan(String loanId, String customerId, String lenderId, double amount, double remainingAmount,
                Date paymentDate, int interestPerDay, Date dueDate, double penaltyPerDay) {
        this.loanId = loanId;
        this.customerId = customerId;
        this.lenderId = lenderId;
        this.amount = amount;
        this.remainingAmount = remainingAmount;
        this.paymentDate = paymentDate;
        this.interestPerDay = interestPerDay;
        this.dueDate = dueDate;
        this.penaltyPerDay = penaltyPerDay;
    }

    // Getters and setters

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getLenderId() {
        return lenderId;
    }

    public void setLenderId(String lenderId) {
        this.lenderId = lenderId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getRemainingAmount() {
        return remainingAmount;
    }

    public void setRemainingAmount(double remainingAmount) {
        this.remainingAmount = remainingAmount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public int getInterestPerDay() {
        return interestPerDay;
    }

    public void setInterestPerDay(int interestPerDay) {
        this.interestPerDay = interestPerDay;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public double getPenaltyPerDay() {
        return penaltyPerDay;
    }

    public void setPenaltyPerDay(double penaltyPerDay) {
        this.penaltyPerDay = penaltyPerDay;
    }
}
