package org.optaplanner.examples.nurserostering.service;

import org.optaplanner.examples.nurserostering.domain.contract.Contract;
import org.optaplanner.examples.nurserostering.entity.ContractEntity;

public interface ContractService {
    Contract fromEntity(ContractEntity entity);
    ContractEntity fromDomain(Contract dto);
}
