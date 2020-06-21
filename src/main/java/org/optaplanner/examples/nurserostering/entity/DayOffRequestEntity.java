package org.optaplanner.examples.nurserostering.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("OFF")
public class DayOffRequestEntity extends DayRequestEntity {

}
