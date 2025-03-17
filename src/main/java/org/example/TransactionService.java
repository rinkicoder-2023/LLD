package org.example;

import java.util.*;


public class TransactionService {

    private final InstrumentServiceFactory instrumentServiceFactory;
    private final Map<String, Transaction> transactionHistory;

    public TransactionService(InstrumentServiceFactory instrumentServiceFactory) {
        this.instrumentServiceFactory = instrumentServiceFactory;
        this.transactionHistory = new HashMap<>();
    }

    // Method to process a payment
    public Transaction makePayment(String senderUserId, String receiverUserId, double amount, String serviceType) {
        InstrumentService instrumentService = instrumentServiceFactory.getInstrumentService(serviceType);

        // Fetch the sender's debit instrument and receiver's credit instrument
        InstrumentEntity senderInstrument = instrumentService.getUserInstrumentsList(senderUserId).get(0);
        InstrumentEntity receiverInstrument = instrumentService.getUserInstruments(receiverUserId).get(0);

        // Check if both instruments exist and if sender has sufficient balance
        if (senderInstrument == null || receiverInstrument == null) {
            throw new IllegalArgumentException("Sender or receiver instrument not found.");
        }

        if (senderInstrument.getBalance() < amount) {
            throw new IllegalArgumentException("Insufficient balance in sender's account.");
        }

        // Log the transaction details
        System.out.println("Initiating payment:");
        System.out.println("Amount to be debited from " + senderUserId + ": " + amount);
        System.out.println("Amount to be credited to " + receiverUserId + ": " + amount);

        // Create a transaction
        Transaction transaction = new Transaction(senderUserId, receiverUserId, amount);

        // Deduct the amount from the sender's instrument and add it to the receiver's instrument
        senderInstrument.deductAmount(amount);
        receiverInstrument.addAmount(amount);

        // Log the updated balances
        System.out.println("Updated balance for " + senderUserId + ": " + senderInstrument.getBalance());
        System.out.println("Updated balance for " + receiverUserId + ": " + receiverInstrument.getBalance());

        // Set transaction status to "COMPLETED"
        transaction.setTransactionStatus("COMPLETED");

        // Store the transaction in the history
        transactionHistory.put(transaction.getTransactionId(), transaction);

        // Log the transaction completion
        System.out.println("Transaction completed with ID: " + transaction.getTransactionId());
        System.out.println("Transaction Status: " + transaction.getTransactionStatus());

        return transaction;
    }

    // Method to fetch transaction history
    public List<Transaction> getTransactionHistory() {
        return new ArrayList<>(transactionHistory.values());
    }
}
