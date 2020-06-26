package org.optaplanner.examples.nurserostering.service;

import org.optaplanner.examples.nurserostering.domain.request.DayOffRequest;
import org.optaplanner.examples.nurserostering.domain.request.DayOnRequest;
import org.optaplanner.examples.nurserostering.entity.DayOffRequestEntity;
import org.optaplanner.examples.nurserostering.entity.DayOnRequestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DayRequestServiceImp implements  DayRequestService {
    @Autowired
    ShiftDateService shiftDateService;

    @Override
    public DayOffRequest fromEntity(DayOffRequestEntity entity) {
        DayOffRequest dto = new DayOffRequest();
        dto.setShiftDate(shiftDateService.fromEntity(entity.getShiftDateEntity()));
        dto.setWeight(entity.getWeight());
        return dto;
    }

    @Override
    public DayOffRequestEntity fromDomain(DayOffRequest dto) {
        DayOffRequestEntity entity = new DayOffRequestEntity();
        entity.setShiftDateEntity(shiftDateService.fromDomain(dto.getShiftDate()));
        entity.setWeight(dto.getWeight());
        return entity;
    }

    @Override
    public DayOnRequest fromEntity(DayOnRequestEntity entity) {
        DayOnRequest dto = new DayOnRequest();
        dto.setShiftDate(shiftDateService.fromEntity(entity.getShiftDateEntity()));
        dto.setWeight(entity.getWeight());
        return dto;
    }

    @Override
    public DayOnRequestEntity fromDomain(DayOnRequest dto) {
        DayOnRequestEntity entity = new DayOnRequestEntity();
        entity.setShiftDateEntity(shiftDateService.fromDomain(dto.getShiftDate()));
        entity.setWeight(dto.getWeight());
        return entity;
    }
}
