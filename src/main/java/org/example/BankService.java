package org.example;

import java.util.ArrayList;
import java.util.List;

public class BankService extends InstrumentService{
    @Override
    public InstrumentEntity addInstrument(InstrumentEntity instrument) {
        userInstruments.computeIfAbsent(instrument.getUserId(), k -> new ArrayList<>()).add(instrument);
        return instrument;
    }

    @Override
    public List<InstrumentEntity> getUserInstruments(String userId) {
        return getUserInstrumentsList(userId);
    }
}
