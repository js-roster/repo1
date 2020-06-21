package org.optaplanner.examples.nurserostering.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "request_shift",uniqueConstraints = {
        @UniqueConstraint(columnNames = {"emp_id", "shift_id"})
})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "on_off", discriminatorType = DiscriminatorType.STRING, length = 5)
@SequenceGenerator(name = "request_shift_seq")
public class ShiftRequestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "request_shift_seq")
    int id;

    @ManyToOne
    @JoinColumn(name = "emp_id")
    @JsonIgnore
    EmployeeEntity employeeEntity;

    @ManyToOne
    @JoinColumn(name = "shift_id")
    ShiftEntity shiftEntity;

    int weight;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EmployeeEntity getEmployeeEntity() {
        return employeeEntity;
    }

    public void setEmployeeEntity(EmployeeEntity employeeEntity) {
        this.employeeEntity = employeeEntity;
    }

    public ShiftEntity getShiftEntity() {
        return shiftEntity;
    }

    public void setShiftEntity(ShiftEntity shiftEntity) {
        this.shiftEntity = shiftEntity;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
