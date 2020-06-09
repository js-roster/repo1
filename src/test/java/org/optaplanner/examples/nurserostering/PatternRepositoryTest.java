package org.optaplanner.examples.nurserostering;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.optaplanner.examples.nurserostering.entity.FreeBefore2DaysWithAWorkDayPatternEntity;
import org.optaplanner.examples.nurserostering.entity.ShiftType2DaysPatternEntity;
import org.optaplanner.examples.nurserostering.entity.ShiftType3DaysPatternEntity;
import org.optaplanner.examples.nurserostering.entity.WorkBeforeFreeSequencePatternEntity;
import org.optaplanner.examples.nurserostering.repo.PatternRepository;
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
public class PatternRepositoryTest {
    @Autowired
    PatternRepository patternRepository;

    @Test
    public void jpaTest() {
        assertThat(patternRepository, notNullValue());
    }

    @Test
    @SqlGroup({
            @Sql("insert_shift_type.sql"),@Sql("insert_pattern.sql")
    })
    public void findAllTest() {
        long cnt = StreamSupport.stream(patternRepository.findAll().spliterator(), false).count();
        assertThat(cnt, is(4L));

        cnt = StreamSupport.stream(patternRepository.findAll().spliterator(), false)
                .filter(p -> p instanceof FreeBefore2DaysWithAWorkDayPatternEntity).count();
        assertThat(cnt, is(1L));

        cnt = StreamSupport.stream(patternRepository.findAll().spliterator(), false)
                .filter(p -> p instanceof ShiftType2DaysPatternEntity).count();
        assertThat(cnt, is(1L));

        cnt = StreamSupport.stream(patternRepository.findAll().spliterator(), false)
                .filter(p -> p instanceof ShiftType3DaysPatternEntity).count();
        assertThat(cnt, is(1L));

        cnt = StreamSupport.stream(patternRepository.findAll().spliterator(), false)
                .filter(p -> p instanceof WorkBeforeFreeSequencePatternEntity).count();
        assertThat(cnt, is(1L));
    }
}
