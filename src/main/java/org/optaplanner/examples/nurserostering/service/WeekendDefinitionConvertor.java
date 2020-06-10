package org.optaplanner.examples.nurserostering.service;

import org.optaplanner.examples.nurserostering.domain.WeekendDefinition;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class WeekendDefinitionConvertor implements AttributeConverter<WeekendDefinition, String> {

    @Override
    public String convertToDatabaseColumn(WeekendDefinition attribute) {
        if(attribute == null) return null;
        return attribute.getCode();
    }

    @Override
    public WeekendDefinition convertToEntityAttribute(String dbData) {
        if(dbData == null) return null;
        return Stream.of(WeekendDefinition.values()).filter(w -> w.getCode().equals(dbData))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}

