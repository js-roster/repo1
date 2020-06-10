package org.optaplanner.examples.nurserostering.repo;

import org.optaplanner.examples.nurserostering.entity.ContractLineEntity;
import org.springframework.data.repository.CrudRepository;

public interface ContractLineRepository extends CrudRepository<ContractLineEntity, Long> {
}
