package org.optaplanner.examples.nurserostering.domain;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class ShiftDeserialize extends KeyDeserializer {
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Object deserializeKey(String key, DeserializationContext ctxt) throws IOException {
        if(key == null) return null;
        return objectMapper.readValue(key, Shift.class);
    }
}
