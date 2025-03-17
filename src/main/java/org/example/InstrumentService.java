package org.example;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class InstrumentService {
    protected static final Map<String, List<InstrumentEntity>> userInstruments = new HashMap<>();

    public abstract InstrumentEntity addInstrument(InstrumentEntity instrument);

    public abstract List<InstrumentEntity> getUserInstruments(String userId);

    protected List<InstrumentEntity> getUserInstrumentsList(String userId) {
        return userInstruments.getOrDefault(userId, Collections.emptyList());
    }

}