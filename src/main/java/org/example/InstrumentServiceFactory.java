package org.example;

public class InstrumentServiceFactory {

    public InstrumentService getInstrumentService(String serviceType) {
        if ("bank".equalsIgnoreCase(serviceType)) {
            return new BankService();
        } else if ("card".equalsIgnoreCase(serviceType)) {
            return new CardService();
        } else {
            throw new IllegalArgumentException("Invalid service type: " + serviceType);
        }
    }
}

