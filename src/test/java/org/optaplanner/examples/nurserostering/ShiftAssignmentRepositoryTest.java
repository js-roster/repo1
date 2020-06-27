package org.optaplanner.examples.nurserostering;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.optaplanner.examples.nurserostering.domain.DayOfWeek;
import org.optaplanner.examples.nurserostering.entity.*;
import org.optaplanner.examples.nurserostering.repo.EmployeeRepository;
import org.optaplanner.examples.nurserostering.repo.ShiftAssignRepository;
import org.optaplanner.examples.nurserostering.repo.ShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.stream.StreamSupport;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.is;

@Tag("unit")
@DataJpaTest
public class ShiftAssignmentRepositoryTest {
    @Autowired
    ShiftAssignRepository shiftAssignRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ShiftRepository shiftRepository;

    @Test
    public void jpaTest() {
        assertThat(shiftAssignRepository, notNullValue());
        assertThat(employeeRepository, notNullValue());
        assertThat(shiftRepository, notNullValue());
    }

    @Test
    public void saveTest() {
        EmployeeEntity employeeEntity = employeeRepository.findById(31L).get();

        ShiftEntity shiftEntity = shiftRepository.findById(31L).get();

        ShiftAssignmentEntity assignmentEntity = new ShiftAssignmentEntity();
        assignmentEntity.setEmployeeEntity(employeeEntity);
        assignmentEntity.setShiftEntity(shiftEntity);

        shiftAssignRepository.save(assignmentEntity);

        long cnt = StreamSupport.stream(shiftAssignRepository.findAll().spliterator(), false).count();
        assertThat(cnt, is(1L));



    }
}
