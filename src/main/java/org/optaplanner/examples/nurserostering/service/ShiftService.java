package org.optaplanner.examples.nurserostering.service;

import org.optaplanner.examples.nurserostering.domain.Shift;
import org.optaplanner.examples.nurserostering.entity.ShiftEntity;

import java.util.List;

public interface ShiftService {
    List<Shift > getAll();
    Shift fromEntity(ShiftEntity entity) ;
    ShiftEntity fromDomain(Shift dao);
}
