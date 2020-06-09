package org.optaplanner.examples.nurserostering.entity;

import org.optaplanner.examples.nurserostering.domain.DayOfWeek;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("FreeBefore2DaysWithAWorkDayPatternEntity")
public class FreeBefore2DaysWithAWorkDayPatternEntity extends PatternEntity {
    private DayOfWeek freeDayOfWeek;

    public DayOfWeek getFreeDayOfWeek() {
        return freeDayOfWeek;
    }

    public void setFreeDayOfWeek(DayOfWeek freeDayOfWeek) {
        this.freeDayOfWeek = freeDayOfWeek;
    }
}
