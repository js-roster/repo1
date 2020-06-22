package org.optaplanner.examples.nurserostering.entity;

import org.optaplanner.examples.nurserostering.entity.ShiftDateEntity;

import javax.persistence.*;

@Entity
@Table(name = "roster_parametrization")
@SequenceGenerator(name ="roster_parametrization_seq")
public class RosterParametrizationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roster_parametrization_seq")
    private int id;

    @ManyToOne
    @JoinColumn(name = "first_shift_date_id")
    private ShiftDateEntity firstShiftDate;
    @ManyToOne
    @JoinColumn(name = "last_shift_date_id")
    private ShiftDateEntity lastShiftDate;

    @ManyToOne
    @JoinColumn(name = "plan_win_start_id")
    private ShiftDateEntity planningWindowStart;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ShiftDateEntity getFirstShiftDate() {
        return firstShiftDate;
    }

    public void setFirstShiftDate(ShiftDateEntity firstShiftDate) {
        this.firstShiftDate = firstShiftDate;
    }

    public ShiftDateEntity getLastShiftDate() {
        return lastShiftDate;
    }

    public void setLastShiftDate(ShiftDateEntity lastShiftDate) {
        this.lastShiftDate = lastShiftDate;
    }

    public ShiftDateEntity getPlanningWindowStart() {
        return planningWindowStart;
    }

    public void setPlanningWindowStart(ShiftDateEntity planningWindowStart) {
        this.planningWindowStart = planningWindowStart;
    }
}
