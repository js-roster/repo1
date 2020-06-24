package org.optaplanner.examples.nurserostering;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.optaplanner.examples.nurserostering.entity.RosterParametrizationEntity;
import org.optaplanner.examples.nurserostering.entity.ShiftDateEntity;
import org.optaplanner.examples.nurserostering.repo.RosterParametrizationRepository;
import org.optaplanner.examples.nurserostering.repo.ShiftDateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import java.util.stream.StreamSupport;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isA;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.is;

@Tag("unit")
@DataJpaTest
public class RosterParametrizationRepositoryTest {
    @Autowired
    private RosterParametrizationRepository parametrizationRepository;

    @Autowired
    private ShiftDateRepository dateRepository;

    @Test
    public void jpaTest() {
        assertThat(parametrizationRepository, notNullValue());
        assertThat(dateRepository, notNullValue());
    }

    @Test
    @SqlGroup({
            @Sql("insert_shift_date.sql")
     })
    public void saveTest() {
        parametrizationRepository.findAll();
        ShiftDateEntity dte1 = dateRepository.findById(1L).get();
        ShiftDateEntity dte2 = dateRepository.findById(2L).get();
        RosterParametrizationEntity param = new RosterParametrizationEntity();
        param.setFirstShiftDate(dte1);
        param.setLastShiftDate(dte2);
        param.setPlanningWindowStart(dte1);
        parametrizationRepository.save(param);
        long cnt = StreamSupport.stream(parametrizationRepository.findAll().spliterator(),false).count();
        assertThat(cnt, is(1L));
    }
    @Test
    @SqlGroup({
            @Sql("insert_shift_date.sql"),
            @Sql("insert_roster_parametrization.sql")
    })
    public void findByIdTest() {
        assertThat(parametrizationRepository.findById(1).get(), isA(RosterParametrizationEntity.class));
    }
}
