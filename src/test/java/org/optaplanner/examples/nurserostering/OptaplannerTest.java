package org.optaplanner.examples.nurserostering;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.optaplanner.examples.nurserostering.domain.DayOfWeek;
import org.optaplanner.examples.nurserostering.domain.NurseRoster;
import org.optaplanner.examples.nurserostering.domain.ShiftDate;
import org.optaplanner.examples.nurserostering.service.NurseRosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


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
    public void solvingTest() throws InterruptedException, ExecutionException {
        String id = "Test";
        NurseRoster roster = service.getProblem();
        assertThat(roster, notNullValue());
        NurseRoster solution = service.solve(id, roster).get();

        assertThat(solution, notNullValue());
        assertThat(solution.getScore().getHardScore(), is(0));
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
