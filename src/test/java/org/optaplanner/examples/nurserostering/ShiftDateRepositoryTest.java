package org.optaplanner.examples.nurserostering;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.optaplanner.examples.nurserostering.entity.ShiftDateEntity;
import org.optaplanner.examples.nurserostering.repo.ShiftDateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.stream.StreamSupport;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.is;

@Tag("unit")
@DataJpaTest
public class ShiftDateRepositoryTest {

    @Autowired
    ShiftDateRepository shiftDateRepository;

    @Test
    public void jpaTest() {
        assertThat(shiftDateRepository, notNullValue());
    }

    @Test
    public void saveTest() {
        ShiftDateEntity shiftDateEntity = new ShiftDateEntity();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
        Date dte = Calendar.getInstance().getTime();
        shiftDateEntity.setDateString(sdf.format(dte));
        shiftDateRepository.save(shiftDateEntity);
        long cnt = StreamSupport.stream(shiftDateRepository.findAll().spliterator(), false).count();
        assertThat(cnt, is(15L));
    }

    @Test
    public void listAll() {
        long cnt = StreamSupport.stream(shiftDateRepository.findAll().spliterator(), false).count();
        assertThat(cnt, is(14L));
    }
}
