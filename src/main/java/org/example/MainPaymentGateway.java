package org.example;

import java.util.List;

public class MainPaymentGateway {

        public static void main(String[] args) {
            InstrumentServiceFactory serviceFactory = new InstrumentServiceFactory();
            TransactionService transactionService = new TransactionService(serviceFactory);
            TransactionController transactionController = new TransactionController(transactionService);

            // Create some example instruments
            InstrumentEntity senderInstrument = new BankInstrument("user123", "1234567890", "IFSC001", 5000); // Sender with balance 5000
            InstrumentEntity receiverInstrument = new BankInstrument("user456", "0987654321", "IFSC002", 1000); // Receiver with balance 1000

            InstrumentService instrumentService = serviceFactory.getInstrumentService("bank");

            // Add instruments to the service
            instrumentService.addInstrument(senderInstrument);
            instrumentService.addInstrument(receiverInstrument);
            System.out.println("----- get all instruments-------"+ instrumentService.getUserInstruments("user123"));

            // Make a payment
            Transaction transaction = transactionController.makePayment("user123", "user456", 1000, "bank");
            System.out.println("Transaction ID: " + transaction.getTransactionId());
            System.out.println("Transaction Status: " + transaction.getTransactionStatus());

            // Get transaction history
            List<Transaction> history = transactionController.getTransactionHistory();
            for (Transaction t : history) {
                System.out.println("Transaction ID: " + t.getTransactionId() + ", Status: " + t.getTransactionStatus());
            }
        }

}
