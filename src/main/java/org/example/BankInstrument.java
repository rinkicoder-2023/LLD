package org.example;

public class BankInstrument extends InstrumentEntity {
    private final String bankAccount;
    private final String ifscCode;

    public BankInstrument(String userId, String bankAccount, String ifscCode, double balance) {
        super(userId, InstrumentType.BANK, balance);
        this.bankAccount = bankAccount;
        this.ifscCode = ifscCode;
    }

    @Override
    public String getDetails() {
        return "Bank Account: " + bankAccount;
    }
}