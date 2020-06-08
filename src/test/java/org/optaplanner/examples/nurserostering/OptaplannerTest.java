package org.optaplanner.examples.nurserostering;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.optaplanner.examples.nurserostering.domain.DayOfWeek;
import org.optaplanner.examples.nurserostering.domain.ShiftDate;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("unit")
public class OptaplannerTest {
    static ObjectMapper objectMapper;

    @BeforeAll
    public static void setup() {
        objectMapper = new ObjectMapper();
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
