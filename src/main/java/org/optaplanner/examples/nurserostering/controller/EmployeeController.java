package org.optaplanner.examples.nurserostering.controller;

import org.optaplanner.examples.nurserostering.domain.Employee;
import org.optaplanner.examples.nurserostering.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public ResponseEntity<Object> getEmployee() {
        return ResponseEntity.ok(this.employeeService.getAllEmployee());
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id ) {

        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @PostMapping("/employees")
    public ResponseEntity<Object> postEmpoyee(@RequestBody Employee employee) {
        Employee result = employeeService.save(employee);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{id}")
                                    .buildAndExpand(result.getId())
                                    .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Object> deleteEmployeeById(@PathVariable int id ) {
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.accepted().build();
    }
}
