package org.optaplanner.examples.nurserostering.entity;

import org.optaplanner.examples.nurserostering.domain.DayOfWeek;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("WorkBeforeFreeSequencePatternEntity")
public class WorkBeforeFreeSequencePatternEntity extends PatternEntity {
    private DayOfWeek workDayOfWeek; // null means any

    @ManyToOne
    @JoinColumn(name = "shift_type_id")
    private ShiftTypeEntity shiftTypeEntity; // null means any

    private int freeDayLength;

    public DayOfWeek getWorkDayOfWeek() {
        return workDayOfWeek;
    }

    public void setWorkDayOfWeek(DayOfWeek workDayOfWeek) {
        this.workDayOfWeek = workDayOfWeek;
    }

    public int getFreeDayLength() {
        return freeDayLength;
    }

    public void setFreeDayLength(int freeDayLength) {
        this.freeDayLength = freeDayLength;
    }

    public ShiftTypeEntity getShiftTypeEntity() {
        return shiftTypeEntity;
    }

    public void setShiftTypeEntity(ShiftTypeEntity shiftTypeEntity) {
        this.shiftTypeEntity = shiftTypeEntity;
    }
}
