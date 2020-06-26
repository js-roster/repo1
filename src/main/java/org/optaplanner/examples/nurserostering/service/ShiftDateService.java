package org.optaplanner.examples.nurserostering.service;

import org.optaplanner.examples.nurserostering.domain.ShiftDate;
import org.optaplanner.examples.nurserostering.entity.ShiftDateEntity;

public interface ShiftDateService {
    ShiftDate fromEntity(ShiftDateEntity entity);
    ShiftDateEntity fromDomain(ShiftDate dto);
}
