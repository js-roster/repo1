package org.optaplanner.examples.nurserostering.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("ShiftType3DaysPatternEntity")
public class ShiftType3DaysPatternEntity extends PatternEntity {
    @ManyToOne
    @JoinColumn(name = "day_idx_0_shift_type_id")
    private ShiftTypeEntity dayIndex0ShiftType;

    @ManyToOne
    @JoinColumn(name = "day_idx_1_shift_type_id")
    private ShiftTypeEntity dayIndex1ShiftType;

    @ManyToOne
    @JoinColumn(name = "day_idx_2_shift_type_id")
    private ShiftTypeEntity dayIndex2ShiftType;

    public ShiftTypeEntity getDayIndex0ShiftType() {
        return dayIndex0ShiftType;
    }

    public void setDayIndex0ShiftType(ShiftTypeEntity dayIndex0ShiftType) {
        this.dayIndex0ShiftType = dayIndex0ShiftType;
    }

    public ShiftTypeEntity getDayIndex1ShiftType() {
        return dayIndex1ShiftType;
    }

    public void setDayIndex1ShiftType(ShiftTypeEntity dayIndex1ShiftType) {
        this.dayIndex1ShiftType = dayIndex1ShiftType;
    }

    public ShiftTypeEntity getDayIndex2ShiftType() {
        return dayIndex2ShiftType;
    }

    public void setDayIndex2ShiftType(ShiftTypeEntity dayIndex2ShiftType) {
        this.dayIndex2ShiftType = dayIndex2ShiftType;
    }
}
