package org.optaplanner.examples.nurserostering.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "shift")
@SequenceGenerator(name = "shift_seq")
public class ShiftEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shift_seq")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "shift_dte_id")
    private ShiftDateEntity shiftDateEntity;

    @ManyToOne
    @JoinColumn(name = "shift_type_id")
    private ShiftTypeEntity shiftTypeEntity;

    @OneToMany(mappedBy = "shiftEntity")
    @JsonIgnore
    Set<ShiftRequestEntity> shiftRequestEntities;

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
