package org.optaplanner.examples.nurserostering.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
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
    Set<DayRequestEntity> dayRequestEntities = new HashSet<DayRequestEntity>();

    @OneToMany(mappedBy = "employeeEntity")
    Set<ShiftRequestEntity> shiftRequestEntities = new HashSet<ShiftRequestEntity>();

    @ManyToMany
    @JoinTable(name = "skill_proficiency",
            joinColumns = @JoinColumn(name = "emp_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"emp_id", "skill_id"})
    )
    Set<SkillEntity> skillEntities;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    ContractEntity contractEntity;

    @OneToMany(mappedBy = "employeeEntity")
    Set<ShiftAssignmentEntity>  shiftAssignmentEntities = new HashSet<ShiftAssignmentEntity>();


    @Column(name="emp_cd",unique = true, nullable = false,length = 50)
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

    public Set<DayRequestEntity> getDayRequestEntities() {
        return dayRequestEntities;
    }

    public void setDayRequestEntities(Set<DayRequestEntity> dayRequestEntities) {
        this.dayRequestEntities = dayRequestEntities;
    }

    public Set<ShiftRequestEntity> getShiftRequestEntities() {
        return shiftRequestEntities;
    }

    public void setShiftRequestEntities(Set<ShiftRequestEntity> shiftRequestEntities) {
        this.shiftRequestEntities = shiftRequestEntities;
    }

    public Set<SkillEntity> getSkillEntities() {
        return skillEntities;
    }

    public void setSkillEntities(Set<SkillEntity> skillEntities) {
        this.skillEntities = skillEntities;
    }

    public ContractEntity getContractEntity() {
        return contractEntity;
    }

    public void setContractEntity(ContractEntity contractEntity) {
        this.contractEntity = contractEntity;
    }

    public Set<ShiftAssignmentEntity> getShiftAssignmentEntities() {
        return shiftAssignmentEntities;
    }

    public void setShiftAssignmentEntities(Set<ShiftAssignmentEntity> shiftAssignmentEntities) {
        this.shiftAssignmentEntities = shiftAssignmentEntities;
    }
}
