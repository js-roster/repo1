package org.optaplanner.examples.nurserostering.repo;

import org.optaplanner.examples.nurserostering.entity.DayRequestEntity;
import org.springframework.data.repository.CrudRepository;

public interface DayRequestRepository extends CrudRepository<DayRequestEntity, Integer> {
}
