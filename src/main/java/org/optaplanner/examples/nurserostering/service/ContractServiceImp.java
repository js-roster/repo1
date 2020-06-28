package org.optaplanner.examples.nurserostering.service;

import org.optaplanner.examples.nurserostering.domain.contract.Contract;
import org.optaplanner.examples.nurserostering.entity.ContractEntity;
import org.optaplanner.examples.nurserostering.repo.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ContractServiceImp implements ContractService {
    @Autowired
    ContractRepository repository;


    @Override
    public Contract fromEntity(ContractEntity entity) {
        Contract contract = new Contract();
        contract.setId(entity.getId().intValue()) ;
        contract.setCode(entity.getCode());
        contract.setDescription(entity.getDescription());
        contract.setWeekendDefinition(entity.getWeekendDefinition());
        return contract;
    }

    @Override
    public ContractEntity fromDomain(Contract dto) {
        ContractEntity entity = new ContractEntity();
        entity.setId((long)dto.getId());
        entity.setCode(dto.getCode());
        entity.setDescription(dto.getDescription());
        entity.setWeekendDefinition(dto.getWeekendDefinition());
        return entity;
    }
}
