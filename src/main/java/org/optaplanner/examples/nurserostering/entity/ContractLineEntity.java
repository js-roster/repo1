package org.optaplanner.examples.nurserostering.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.optaplanner.examples.nurserostering.domain.contract.ContractLineType;

import javax.persistence.*;

@Entity
@Table(name = "contract_line")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "cnt_ln_cls", discriminatorType = DiscriminatorType.STRING, length = 50)
@SequenceGenerator(name = "contract_line_seq")
public class ContractLineEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contract_line_seq")
    protected Long id;
    @Enumerated(EnumType.STRING)
    protected ContractLineType contractLineType;

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

    public ContractLineType getContractLineType() {
        return contractLineType;
    }

    public void setContractLineType(ContractLineType contractLineType) {
        this.contractLineType = contractLineType;
    }

    public ContractEntity getContractEntity() {
        return contractEntity;
    }

    public void setContractEntity(ContractEntity contractEntity) {
        this.contractEntity = contractEntity;
    }
}
