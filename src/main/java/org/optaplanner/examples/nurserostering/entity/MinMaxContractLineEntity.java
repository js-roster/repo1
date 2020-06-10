package org.optaplanner.examples.nurserostering.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("MinMaxContractLineEntity")
public class MinMaxContractLineEntity extends ContractLineEntity {

    private Boolean minimumEnabled;
    private Integer minimumValue;
    private Integer minimumWeight;

    private Boolean maximumEnabled;
    private Integer maximumValue;
    private Integer maximumWeight;

    public Boolean getMinimumEnabled() {
        return minimumEnabled;
    }

    public void setMinimumEnabled(Boolean minimumEnabled) {
        this.minimumEnabled = minimumEnabled;
    }

    public Integer getMinimumValue() {
        return minimumValue;
    }

    public void setMinimumValue(Integer minimumValue) {
        this.minimumValue = minimumValue;
    }

    public Integer getMinimumWeight() {
        return minimumWeight;
    }

    public void setMinimumWeight(Integer minimumWeight) {
        this.minimumWeight = minimumWeight;
    }

    public Boolean getMaximumEnabled() {
        return maximumEnabled;
    }

    public void setMaximumEnabled(Boolean maximumEnabled) {
        this.maximumEnabled = maximumEnabled;
    }

    public Integer getMaximumValue() {
        return maximumValue;
    }

    public void setMaximumValue(Integer maximumValue) {
        this.maximumValue = maximumValue;
    }

    public Integer getMaximumWeight() {
        return maximumWeight;
    }

    public void setMaximumWeight(Integer maximumWeight) {
        this.maximumWeight = maximumWeight;
    }
}
