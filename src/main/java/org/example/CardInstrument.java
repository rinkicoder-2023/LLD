package org.example;

public class CardInstrument extends InstrumentEntity {
    private final String cardNumber;
    private final String cvvNumber;

    public CardInstrument(String userId, String cardNumber, String cvvNumber, double balance) {
        super(userId, InstrumentType.BANK, balance);
        this.cardNumber = cardNumber;
        this.cvvNumber = cvvNumber;
    }

    @Override
    public String getDetails() {
        return "Card: ****" + cardNumber.substring(cardNumber.length() - 4);
    }
}