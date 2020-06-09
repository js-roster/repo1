package org.optaplanner.examples.nurserostering;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.optaplanner.examples.nurserostering.entity.ShiftDateEntity;
import org.optaplanner.examples.nurserostering.entity.ShiftEntity;
import org.optaplanner.examples.nurserostering.entity.ShiftTypeEntity;
import org.optaplanner.examples.nurserostering.repo.ShiftDateRepository;
import org.optaplanner.examples.nurserostering.repo.ShiftRepository;
import org.optaplanner.examples.nurserostering.repo.ShiftTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import java.util.stream.StreamSupport;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.is;

@Tag("unit")
@DataJpaTest
public class ShiftRepositoryTest {
    @Autowired
    ShiftRepository shiftRepository;
    @Autowired
    ShiftTypeRepository shiftTypeRepository;
    @Autowired
    ShiftDateRepository shiftDateRepository;

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void jpaTest() {
        assertThat(shiftRepository, notNullValue());
    }

    @Test
    @SqlGroup({
            @Sql("insert_skill.sql"),
            @Sql("insert_shift_type.sql"),
            @Sql("insert_shift_type_skills.sql"),
            @Sql("insert_shift_date.sql")
    })
    public void saveTest() throws JsonProcessingException {
        ShiftDateEntity shiftDateEntity = shiftDateRepository.findById(1L).get();
        ShiftTypeEntity shiftTypeEntity = shiftTypeRepository.findById(1L).get();
        ShiftEntity shiftEntity = new ShiftEntity();
        shiftEntity.setShiftDateEntity(shiftDateEntity);
        shiftEntity.setShiftTypeEntity(shiftTypeEntity);
        shiftEntity.setIndex(1);
        ShiftEntity r = shiftRepository.save(shiftEntity);
        long cnt = StreamSupport.stream(shiftRepository.findAll().spliterator(), false).count();
        assertThat(cnt, is(1L));
    }

    @Test
    @SqlGroup({
            @Sql("insert_skill.sql"),
            @Sql("insert_shift_type.sql"),
            @Sql("insert_shift_type_skills.sql"),
            @Sql("insert_shift_date.sql"),
            @Sql("insert_shift.sql")
    })
    public void findAllTest() throws JsonProcessingException {
        long cnt = StreamSupport.stream(shiftRepository.findAll().spliterator(), false).count();
        assertThat(cnt, is(1L));
        ShiftEntity r = StreamSupport.stream(shiftRepository.findAll().spliterator(), false)
                .findFirst().get();
        System.out.println(objectMapper.writeValueAsString(r));
    }

}
