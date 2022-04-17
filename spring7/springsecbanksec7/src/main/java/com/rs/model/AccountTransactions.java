package com.rs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * created by rs 4/12/2022.
 */
@Entity
@Table(name="account_transactions")
public class AccountTransactions {

    @Id
    @Column(name="transaction_id")
    private String transactionId;
    @Column(name="account_number")
    private String accountNumber;
    @Column(name="customer_id")
    private int customerId;
    @Column(name="transaction_dt")
    private String transactionDt;
    @Column(name="transaction_summary")
    private String transactionSummary;
    @Column(name="transaction_type")
    private String transactionType;
    @Column(name="transaction_amt")
    private int transactionAmt;
    @Column(name="closing_balance")
    private int closingBalance;
    @Column(name="create_dt")
    private String createDt;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getTransactionDt() {
        return transactionDt;
    }

    public void setTransactionDt(String transactionDt) {
        this.transactionDt = transactionDt;
    }

    public String getTransactionSummary() {
        return transactionSummary;
    }

    public void setTransactionSummary(String transactionSummary) {
        this.transactionSummary = transactionSummary;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public int getTransactionAmt() {
        return transactionAmt;
    }

    public void setTransactionAmt(int transactionAmt) {
        this.transactionAmt = transactionAmt;
    }


    public String getCreateDt() {
        return createDt;
    }

    public void setCreateDt(String createDt) {
        this.createDt = createDt;
    }

    public int getClosingBalance() {
        return closingBalance;
    }

    public void setClosingBalance(int closingBalance) {
        this.closingBalance = closingBalance;
    }
}
