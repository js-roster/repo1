package org.optaplanner.examples.nurserostering;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.optaplanner.examples.nurserostering.domain.*;
import org.optaplanner.examples.nurserostering.repo.EmployeeRepository;
import org.optaplanner.examples.nurserostering.repo.ShiftRepository;
import org.optaplanner.examples.nurserostering.service.EmployeeService;
import org.optaplanner.examples.nurserostering.service.NurseRosterService;
import org.optaplanner.examples.nurserostering.service.ShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("unit")
@SpringBootTest
public class OptaplannerTest {
    static ObjectMapper objectMapper;

    @Autowired
    NurseRosterService service;

    @BeforeAll
    public static void setup() {
        objectMapper = new ObjectMapper();
    }


    @Test
    public void serviceTest() {
        assertThat(service, notNullValue());
    }

    @Test
    public void solvingTest() throws JsonProcessingException {
        NurseRoster roster = service.getProblem();
        assertThat(roster, notNullValue());
    }

    @Test
    void lambdaExpressions() {
        assertTrue(Stream.of(1, 2, 3)
                //.stream()
                .mapToInt(i -> i)
                .sum() > 5, () -> "Sum should be greater than 5");
    }

    @Test
    public void logTest() throws JsonProcessingException {
        ShiftDate shiftDate = new ShiftDate();
        String objStr = objectMapper.writeValueAsString(shiftDate);
        System.out.println(objStr);
    }

    @Test
    public void dayTest() {
        System.out.println(DayOfWeek.FRIDAY);
        Arrays.stream(DayOfWeek.values())
                .forEach(d -> System.out.println(d.getCode() + ", " + d.ordinal()));
    }
}
