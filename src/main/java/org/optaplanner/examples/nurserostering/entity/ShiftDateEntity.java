package org.optaplanner.examples.nurserostering.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.optaplanner.examples.nurserostering.domain.DayOfWeek;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "shift_date")
public class ShiftDateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "day_idx")
    private int dayIndex;

    @Column(name = "shift_dte", length = 25, nullable = false)
    private String dateString;

    @Column(length = 25)
    private DayOfWeek dayOfWeek;

    @OneToMany(mappedBy = "shiftDateEntity")
    @JsonIgnore
    Set<ShiftEntity> shiftEntities;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDayIndex() {
        return dayIndex;
    }

    public void setDayIndex(int dayIndex) {
        this.dayIndex = dayIndex;
    }

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Set<ShiftEntity> getShiftEntities() {
        return shiftEntities;
    }

    public void setShiftEntities(Set<ShiftEntity> shiftEntities) {
        this.shiftEntities = shiftEntities;
    }
}
