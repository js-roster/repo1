package org.optaplanner.examples.nurserostering.repo;

import org.optaplanner.examples.nurserostering.entity.PatternEntity;
import org.springframework.data.repository.CrudRepository;

public interface PatternRepository extends CrudRepository<PatternEntity, Long> {
}
