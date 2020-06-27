package org.optaplanner.examples.nurserostering.service;

import org.optaplanner.examples.nurserostering.domain.ShiftType;
import org.optaplanner.examples.nurserostering.entity.ShiftTypeEntity;
import org.springframework.stereotype.Service;

@Service
public class ShiftTypeServiceImp implements  ShiftTypeService {
    @Override
    public ShiftType fromEntity(ShiftTypeEntity entity) {
        ShiftType shiftType = new ShiftType();
        shiftType.setId(entity.getId().intValue());
        shiftType.setCode(entity.getCode());
        shiftType.setDescription(entity.getDescription());
        shiftType.setStartTimeString(entity.getStartTimeString());
        shiftType.setEndTimeString(entity.getEndTimeString());
        shiftType.setNight(entity.isNight());
        return shiftType;
    }

    @Override
    public ShiftTypeEntity fromDomain(ShiftType dto) {
        ShiftTypeEntity entity = new ShiftTypeEntity();
        entity.setId((long)dto.getId());
        entity.setDescription(dto.getDescription());
        entity.setCode(dto.getCode());
        entity.setIndex(dto.getIndex());
        entity.setNight(dto.isNight());
        entity.setStartTimeString(dto.getStartTimeString());
        entity.setEndTimeString(dto.getEndTimeString());
        return entity;
    }
}
