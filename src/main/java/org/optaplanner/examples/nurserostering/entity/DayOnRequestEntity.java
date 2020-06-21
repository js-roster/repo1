package org.optaplanner.examples.nurserostering.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ON")
public class DayOnRequestEntity extends DayRequestEntity {
}
