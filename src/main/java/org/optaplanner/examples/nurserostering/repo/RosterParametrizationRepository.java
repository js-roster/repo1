package org.optaplanner.examples.nurserostering.repo;

import org.optaplanner.examples.nurserostering.entity.RosterParametrizationEntity;
import org.springframework.data.repository.CrudRepository;

public interface RosterParametrizationRepository extends CrudRepository<RosterParametrizationEntity, Integer> {
}
