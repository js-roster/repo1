package org.optaplanner.examples.nurserostering.service;

import org.optaplanner.examples.nurserostering.domain.DayOfWeek;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class DayOfWeekConvertor implements AttributeConverter<DayOfWeek, String> {
    @Override
    public String convertToDatabaseColumn(DayOfWeek attribute) {
        if(attribute == null) return null;
        return attribute.getCode();
    }

    @Override
    public DayOfWeek convertToEntityAttribute(String dbData) {
        if( dbData == null)
        return null;
        return Stream.of(DayOfWeek.values()).filter(d->d.getCode().equals(dbData))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
