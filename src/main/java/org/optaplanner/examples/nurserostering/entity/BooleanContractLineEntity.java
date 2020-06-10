package org.optaplanner.examples.nurserostering.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("BooleanContractLineEntity")
public class BooleanContractLineEntity extends ContractLineEntity {
    private boolean enabled;
    private int weight;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
