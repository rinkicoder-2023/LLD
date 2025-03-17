package org.example;

import java.util.UUID;

public class Transaction {
    private String transactionId;
    private String senderUserId;
    private String receiverUserId;
    private double amount;
    private String transactionStatus;

    public Transaction(String senderUserId, String receiverUserId, double amount) {
        this.transactionId = UUID.randomUUID().toString(); // Generate a unique transaction ID
        this.senderUserId = senderUserId;
        this.receiverUserId = receiverUserId;
        this.amount = amount;
        this.transactionStatus = "PENDING"; // Initial status can be "PENDING"
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getSenderUserId() {
        return senderUserId;
    }

    public String getReceiverUserId() {
        return receiverUserId;
    }

    public double getAmount() {
        return amount;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }
}

