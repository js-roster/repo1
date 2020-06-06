package org.optaplanner.examples.nurserostering.service;

import org.optaplanner.examples.nurserostering.domain.Employee;
import org.optaplanner.examples.nurserostering.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployee();
    public Employee save(Employee employee);
    public Employee getEmployeeById(int id);
    public void deleteEmployeeById(int id);
    public Employee fromEntity(EmployeeEntity employeeEntity);
    public EmployeeEntity fromDomain(Employee employee);

}
