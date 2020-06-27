package org.optaplanner.examples.nurserostering.repo;

import org.optaplanner.examples.nurserostering.entity.ShiftAssignmentEntity;
import org.springframework.data.repository.CrudRepository;

public interface ShiftAssignRepository extends CrudRepository<ShiftAssignmentEntity, Long> {
}
