package org.example;

public abstract class InstrumentEntity {

    private final String instrumentId;
    private final String userId;
    private final InstrumentType type;
    private double balance;

    public InstrumentEntity(String userId, InstrumentType type, double balance) {
        this.instrumentId = java.util.UUID.randomUUID().toString();
        this.userId = userId;
        this.type = type;
        this.balance = balance;
    }

    public String getInstrumentId() { return instrumentId; }
    public String getUserId() { return userId; }
    public InstrumentType getType() { return type; }

    public abstract String getDetails();

    @Override
    public String toString() {
        return "Instrument{id='" + instrumentId + "', userId='" + userId +
                "', type=" + type + ", details='" + getDetails() + "'}";
    }

    public double getBalance() {
        return balance;
    }

    public void deductAmount(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("Invalid deduction amount.");
        }
    }

    public void addAmount(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            throw new IllegalArgumentException("Invalid addition amount.");
        }
    }
}
