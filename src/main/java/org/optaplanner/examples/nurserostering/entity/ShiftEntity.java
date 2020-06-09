package org.optaplanner.examples.nurserostering.entity;

import javax.persistence.*;

@Entity
@Table(name = "shift")
public class ShiftEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "shift_id")
    private ShiftDateEntity shiftDateEntity;

    @ManyToOne
    @JoinColumn(name = "shift_type_id")
    private ShiftTypeEntity shiftTypeEntity;

    private int index;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ShiftDateEntity getShiftDateEntity() {
        return shiftDateEntity;
    }

    public void setShiftDateEntity(ShiftDateEntity shiftDateEntity) {
        this.shiftDateEntity = shiftDateEntity;
    }

    public ShiftTypeEntity getShiftTypeEntity() {
        return shiftTypeEntity;
    }

    public void setShiftTypeEntity(ShiftTypeEntity shiftTypeEntity) {
        this.shiftTypeEntity = shiftTypeEntity;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
