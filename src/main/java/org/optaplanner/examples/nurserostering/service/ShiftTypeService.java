package org.optaplanner.examples.nurserostering.service;

import org.optaplanner.examples.nurserostering.domain.ShiftType;
import org.optaplanner.examples.nurserostering.entity.ShiftTypeEntity;
import org.springframework.stereotype.Service;


public interface ShiftTypeService {
    ShiftType fromEntity(ShiftTypeEntity entity);
    ShiftTypeEntity fromDomain(ShiftType dto);
}
