package org.optaplanner.examples.nurserostering.service;

import org.optaplanner.examples.nurserostering.domain.Shift;
import org.optaplanner.examples.nurserostering.entity.ShiftEntity;
import org.optaplanner.examples.nurserostering.repo.ShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ShiftServiceImp implements  ShiftService {
    @Autowired
    ShiftRepository repository;

    @Autowired
    ShiftTypeService shiftTypeService;

    @Autowired
    ShiftDateService shiftDateService;

    @Override
    public List<Shift> getAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(e -> fromEntity(e)).collect(Collectors.toList());
    }

    @Override
    public Shift fromEntity(ShiftEntity entity) {
        Shift shift = new Shift();
        shift.setId(entity.getId().intValue());
        shift.setIndex(entity.getIndex());
        shift.setShiftType(shiftTypeService.fromEntity(entity.getShiftTypeEntity()));
        shift.setShiftDate(shiftDateService.fromEntity(entity.getShiftDateEntity()));
        shift.setRequiredEmployeeSize(entity.getRequiredEmployeeSize());
        return shift;
    }

    @Override
    public ShiftEntity fromDomain(Shift dto) {
        ShiftEntity entity = new ShiftEntity();
        entity.setId((long) dto.getId());
        entity.setIndex(dto.getIndex());
        entity.setShiftDateEntity(shiftDateService.fromDomain(dto.getShiftDate()));
        entity.setShiftTypeEntity(shiftTypeService.fromDomain(dto.getShiftType()));
        entity.setRequiredEmployeeSize(dto.getRequiredEmployeeSize());
        return entity;
    }
}
