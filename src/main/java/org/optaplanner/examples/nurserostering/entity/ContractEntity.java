package org.optaplanner.examples.nurserostering.entity;

import org.optaplanner.examples.nurserostering.domain.WeekendDefinition;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "contract")
public class ContractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "cntr_cd", nullable = false, unique = true, length = 30)
    private String code;
    private String description;
    private WeekendDefinition weekendDefinition;

    @OneToMany(mappedBy = "contractEntity")
    List<ContractLineEntity> contractLineEntities;

    @OneToMany(mappedBy = "contractEntity")
    List<PatternEntity> patternEntities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public WeekendDefinition getWeekendDefinition() {
        return weekendDefinition;
    }

    public void setWeekendDefinition(WeekendDefinition weekendDefinition) {
        this.weekendDefinition = weekendDefinition;
    }

    public List<ContractLineEntity> getContractLineEntities() {
        return contractLineEntities;
    }

    public void setContractLineEntities(List<ContractLineEntity> contractLineEntities) {
        this.contractLineEntities = contractLineEntities;
    }

    public List<PatternEntity> getPatternEntities() {
        return patternEntities;
    }

    public void setPatternEntities(List<PatternEntity> patternEntities) {
        this.patternEntities = patternEntities;
    }
}
