package org.optaplanner.examples.nurserostering.service;

import org.optaplanner.examples.nurserostering.domain.ShiftDate;
import org.optaplanner.examples.nurserostering.entity.ShiftDateEntity;
import org.springframework.stereotype.Service;

@Service
public class ShiftDateServiceImp implements ShiftDateService {
    @Override
    public ShiftDate fromEntity(ShiftDateEntity entity) {
        ShiftDate shiftDate = new ShiftDate();
        shiftDate.setId(entity.getId().intValue());
        shiftDate.setDateString(entity.getDateString());
        shiftDate.setDayIndex(entity.getDayIndex());
        shiftDate.setDayOfWeek(entity.getDayOfWeek());
        return shiftDate;
    }
}
