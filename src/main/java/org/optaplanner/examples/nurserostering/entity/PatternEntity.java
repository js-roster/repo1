package org.optaplanner.examples.nurserostering.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pattern")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "pat_class", discriminatorType = DiscriminatorType.STRING, length = 50)
@SequenceGenerator(name = "pattern_seq")
public class PatternEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pattern_seq")
    protected Long id;

    @Column(name = "pat_cd", length = 50)
    protected String code;

    protected int weight;

    @ManyToOne
    @JoinColumn(name = "cntr_id")
    @JsonIgnore
    protected ContractEntity contractEntity;

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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public ContractEntity getContractEntity() {
        return contractEntity;
    }

    public void setContractEntity(ContractEntity contractEntity) {
        this.contractEntity = contractEntity;
    }
}
