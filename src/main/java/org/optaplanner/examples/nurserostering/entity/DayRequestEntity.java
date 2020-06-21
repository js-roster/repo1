package org.optaplanner.examples.nurserostering.entity;

import javax.persistence.*;

@Entity
@Table(name = "request_day",uniqueConstraints = {
        @UniqueConstraint(columnNames = {"shift_dte_id","emp_id"})}
        )
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "on_off", discriminatorType = DiscriminatorType.STRING, length = 5)
@SequenceGenerator(name = "request_day_seq")
public class DayRequestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "request_day_seq")
    int id;

    @ManyToOne
    @JoinColumn(name = "shift_dte_id")
    ShiftDateEntity shiftDateEntity;

    @ManyToOne
    @JoinColumn(name = "emp_id")
    EmployeeEntity employeeEntity;

    int weight;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ShiftDateEntity getShiftDateEntity() {
        return shiftDateEntity;
    }

    public void setShiftDateEntity(ShiftDateEntity shiftDateEntity) {
        this.shiftDateEntity = shiftDateEntity;
    }

    public EmployeeEntity getEmployeeEntity() {
        return employeeEntity;
    }

    public void setEmployeeEntity(EmployeeEntity employeeEntity) {
        this.employeeEntity = employeeEntity;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
