package org.optaplanner.examples.nurserostering;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.optaplanner.examples.nurserostering.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.is;

@Tag("it")
@SpringBootTest
public class EmployeeServiceTest {
    @Autowired
    EmployeeService service;

    @Test
    public void serviceTest() {
        assertThat(service, notNullValue());
    }

    @Test
    public void retrieveAllTest() {
        long cnt = service.getAllEmployee().size();
        assertThat(cnt, is(20L));
    }
}
