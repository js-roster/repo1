package org.optaplanner.examples.nurserostering.repo;

import org.optaplanner.examples.nurserostering.entity.ShiftRequestEntity;
import org.springframework.data.repository.CrudRepository;

public interface ShiftRequestRepository extends CrudRepository<ShiftRequestEntity, Integer> {
}
