package org.optaplanner.examples.nurserostering.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="employee")
@SequenceGenerator(name = "employee_seq")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
    Long id;

    @Column(name="emp_nm")
    String name;

    @OneToMany(mappedBy = "employeeEntity")
    @JsonIgnore
    Set<DayRequestEntity> dayRequestEntities;

    @OneToMany(mappedBy = "employeeEntity")
    @JsonIgnore
    Set<ShiftRequestEntity> shiftRequestEntities;


    @Column(name="emp_id",unique = true, nullable = false,length = 50)
    String code;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
