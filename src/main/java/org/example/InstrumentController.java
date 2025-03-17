package org.example;

import java.util.*;

public class InstrumentController {

    private final InstrumentServiceFactory serviceFactory = new InstrumentServiceFactory();

    public InstrumentEntity addInstrument(String serviceType, InstrumentEntity instrument) {
        InstrumentService instrumentService = serviceFactory.getInstrumentService(serviceType);
        return instrumentService.addInstrument(instrument);
    }

    public List<InstrumentEntity> getUserInstruments(String serviceType, String userId) {
        InstrumentService instrumentService = serviceFactory.getInstrumentService(serviceType);
        return instrumentService.getUserInstruments(userId);
    }


}

