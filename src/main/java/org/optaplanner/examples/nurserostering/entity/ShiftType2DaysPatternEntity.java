package org.optaplanner.examples.nurserostering.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("ShiftType2DaysPatternEntity")
public class ShiftType2DaysPatternEntity extends PatternEntity {

    @ManyToOne
    @JoinColumn(name = "day_idx_0_shift_type_id")
    private ShiftTypeEntity dayIndex0ShiftType;

    @ManyToOne
    @JoinColumn(name = "day_idx_1_shift_type_id")
    private ShiftTypeEntity dayIndex1ShiftType;

}
