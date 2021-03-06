package org.optaplanner.examples.nurserostering.domain;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class ShiftDateDeserialize extends KeyDeserializer {

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public ShiftDate deserializeKey(String key, DeserializationContext ctxt) throws IOException {
        if(key == null) return null;
        ShiftDate shiftDate = new ShiftDate();
        shiftDate.setDateString(key);
        return shiftDate;
    }
}
