package org.optaplanner.examples.nurserostering.service;

import org.optaplanner.examples.nurserostering.domain.Employee;
import org.optaplanner.examples.nurserostering.entity.EmployeeEntity;
import org.optaplanner.examples.nurserostering.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

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
        return employee;
    }

    @Override
    public EmployeeEntity fromDomain(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(Long.valueOf(employee.getId()));
        employeeEntity.setCode(employee.getCode());
        employeeEntity.setName(employee.getName());
        return employeeEntity;
    }
}
