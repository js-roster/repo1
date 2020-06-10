package org.optaplanner.examples.nurserostering.repo;

import org.optaplanner.examples.nurserostering.entity.ContractEntity;
import org.springframework.data.repository.CrudRepository;

public interface ContractRepository extends CrudRepository<ContractEntity, Long> {
}
