package org.optaplanner.examples.nurserostering.repo;

import org.optaplanner.examples.nurserostering.entity.ShiftDateEntity;
import org.springframework.data.repository.CrudRepository;

public interface ShiftDateRepository extends CrudRepository<ShiftDateEntity, Long> {
}
