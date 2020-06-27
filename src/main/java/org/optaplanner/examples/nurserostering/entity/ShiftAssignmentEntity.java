package org.optaplanner.examples.nurserostering.entity;

import javax.persistence.*;

@Entity
@Table(name ="shift_assignment")
@SequenceGenerator(name = "shift_assignment_seq")
public class ShiftAssignmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shift_assignment_seq")
    Long id;

    @ManyToOne
    @JoinColumn(name = "emp_id")
    EmployeeEntity employeeEntity;

    @ManyToOne
    @JoinColumn(name = "shift_id")
    ShiftEntity shiftEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
