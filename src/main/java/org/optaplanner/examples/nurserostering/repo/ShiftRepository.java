package org.optaplanner.examples.nurserostering.repo;

import org.optaplanner.examples.nurserostering.entity.ShiftEntity;
import org.springframework.data.repository.CrudRepository;

public interface ShiftRepository extends CrudRepository<ShiftEntity, Long> {
}
