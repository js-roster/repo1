package org.optaplanner.examples.nurserostering;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.optaplanner.examples.nurserostering.domain.Employee;
import org.optaplanner.examples.nurserostering.domain.NurseRoster;
import org.optaplanner.examples.nurserostering.domain.Shift;
import org.optaplanner.examples.nurserostering.domain.WeekendDefinition;
import org.optaplanner.examples.nurserostering.domain.contract.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

@Tag("it")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAsync
public class IntegrationTest {
    @Autowired
    WebTestClient client;

    @Test
    public void webClientTest() {
        assertThat(client, notNullValue());
    }

    @Test
    public void saveEmployeeTest() {
        Employee employee = new Employee();
        employee.setCode("I009");
        employee.setName("Smith");
        Contract contract  = new Contract();
        contract.setCode("5_working _ay");
        contract.setDescription("5 working day");
        contract.setWeekendDefinition(WeekendDefinition.SATURDAY_SUNDAY);
        employee.setContract(contract);
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

    @Test
    public void getRosterTest() {
        client.get()
                .uri("/roster")
                .exchange()
                .expectStatus().isOk()
                .expectBody(NurseRoster.class);
    }

    @Test
    public void solveRosterTest() throws InterruptedException {
        String id = UUID.randomUUID().toString();
        client.post()
                .uri("/solution/{id}", id)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.code").isNotEmpty();

        client.get()
                .uri("/solution/{id}", id)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.code").isNotEmpty();

    }
}
