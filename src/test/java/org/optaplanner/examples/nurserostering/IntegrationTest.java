package org.optaplanner.examples.nurserostering;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.optaplanner.examples.nurserostering.domain.Employee;
import org.optaplanner.examples.nurserostering.domain.Shift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@Tag("it")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {
    @Autowired
    WebTestClient client;

    @Test
    public void saveEmployeeTest() {
        Employee employee = new Employee();
        employee.setCode("I009");
        employee.setName("Smith");
        client.post()
            .uri("/employees")
        .contentType(MediaType.APPLICATION_JSON)
        .bodyValue(employee)
        .exchange()
        .expectStatus().isCreated();
    }

    @Test
    public void findAllShiftTest() {
        client.get()
                .uri("/shift")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Shift.class).hasSize(70);

    }
}
