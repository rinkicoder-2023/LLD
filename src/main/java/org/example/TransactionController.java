package org.example;

import java.util.*;

public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public Transaction makePayment(String senderUserId, String receiverUserId, double amount, String serviceType) {
        return transactionService.makePayment(senderUserId, receiverUserId, amount, serviceType);
    }

    public List<Transaction> getTransactionHistory() {
        return transactionService.getTransactionHistory();
    }
}
