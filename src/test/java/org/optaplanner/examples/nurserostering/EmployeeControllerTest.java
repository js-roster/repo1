package org.optaplanner.examples.nurserostering;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


import org.mockito.ArgumentMatchers;
import org.optaplanner.examples.nurserostering.controller.EmployeeController;
import org.optaplanner.examples.nurserostering.domain.Employee;
import org.optaplanner.examples.nurserostering.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;



@Tag("unit")
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {
    @MockBean
    EmployeeService employeeService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testAllEmployee() throws Exception {
        List<Employee> employeeList = Arrays.asList(new Employee(), new Employee());

        when(employeeService.getAllEmployee()).thenReturn(employeeList);
        mockMvc.perform(get("/employees"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    public void getEmployeeById() throws Exception {
        Employee employee = new Employee();
        employee.setId(102);
        employee.setName("Tom");

        when(employeeService.getEmployeeById(102)).thenReturn(employee);

        mockMvc.perform(get("/employees/102"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(102)))
                .andExpect(jsonPath("$.name", is("Tom")));
    }

    @Test
    public void postEmployee() throws Exception {
        Employee employee = new Employee();
        ObjectMapper objectMapper = new ObjectMapper();

        when(employeeService.save(ArgumentMatchers.isA(Employee.class))).thenAnswer(a-> {
            employee.setId(101);
            return employee;
        });

        mockMvc.perform(
                post("/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(employee)))
                .andExpect(status().isCreated())
        .andExpect(header().string("Location",endsWith("/employees/101")));
    }

    @Test
    public void deleteEmployeeById() throws Exception {
        mockMvc.perform(delete("/employees/103"))
                .andExpect(status().isAccepted());
    }
}
