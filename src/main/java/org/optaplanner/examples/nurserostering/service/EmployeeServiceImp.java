package org.optaplanner.examples.nurserostering.service;

import org.optaplanner.examples.nurserostering.domain.Employee;
import org.optaplanner.examples.nurserostering.domain.request.DayOffRequest;
import org.optaplanner.examples.nurserostering.domain.request.DayOnRequest;
import org.optaplanner.examples.nurserostering.entity.DayOffRequestEntity;
import org.optaplanner.examples.nurserostering.entity.DayOnRequestEntity;
import org.optaplanner.examples.nurserostering.entity.EmployeeEntity;
import org.optaplanner.examples.nurserostering.repo.ContractRepository;
import org.optaplanner.examples.nurserostering.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Transactional
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DayRequestService dayRequestService;

    @Autowired
    ContractService contractService;

    @Autowired
    ContractRepository contractRepository;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.getAll().stream()
                .map(d -> this.fromEntity(d))
                .collect(Collectors.toList());
    }

    @Override
    public Employee save(Employee employee) {
        return fromEntity(employeeRepository.save(fromDomain(employee)));
    }

    @Override
    public Employee getEmployeeById(int id) {
        return fromEntity(employeeRepository.findById((Long.valueOf(id))).get());
     }

    @Override
    public void deleteEmployeeById(int id) {

    }

    @Override
    public Employee fromEntity(EmployeeEntity employeeEntity) {
        Employee employee = new Employee();
        employee.setId(employeeEntity.getId().intValue());
        employee.setName(employeeEntity.getName());
        employee.setCode(employeeEntity.getCode());
        employee.setContract(contractService.fromEntity(employeeEntity.getContractEntity()));

        employee.setDayOffRequestMap(employeeEntity.getDayRequestEntities().stream()
                .filter(e ->  e instanceof DayOffRequestEntity)
                .map(r ->(dayRequestService.fromEntity((DayOffRequestEntity)r)))
                .collect(Collectors.toMap(DayOffRequest::getShiftDate, Function.identity())));

        employee.setDayOnRequestMap(employeeEntity.getDayRequestEntities().stream()
                .filter(e ->  e instanceof DayOnRequestEntity)
                .map(r ->(dayRequestService.fromEntity((DayOnRequestEntity)r)))
                .collect(Collectors.toMap(DayOnRequest::getShiftDate, Function.identity())));


        return employee;
    }

    @Override
    public EmployeeEntity fromDomain(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(Long.valueOf(employee.getId()));
        employeeEntity.setCode(employee.getCode());
        employeeEntity.setName(employee.getName());
        employeeEntity.setContractEntity(
                contractRepository.save(contractService.fromDomain(employee.getContract())));
        return employeeEntity;
    }
}
