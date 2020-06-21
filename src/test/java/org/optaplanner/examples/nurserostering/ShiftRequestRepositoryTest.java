package org.optaplanner.examples.nurserostering;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.optaplanner.examples.nurserostering.domain.request.ShiftOnRequest;
import org.optaplanner.examples.nurserostering.entity.ShiftOffRequestEntity;
import org.optaplanner.examples.nurserostering.entity.ShiftOnRequestEntity;
import org.optaplanner.examples.nurserostering.entity.ShiftRequestEntity;
import org.optaplanner.examples.nurserostering.repo.ShiftRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Tag("unit")
@DataJpaTest
public class ShiftRequestRepositoryTest {
    @Autowired
    ShiftRequestRepository repository;

    @Test
    public void jpaTest() {
        assertThat(repository, notNullValue());
    }

    @Test
    @SqlGroup({
            @Sql("insert_employee.sql"),
            @Sql("insert_skill.sql"),
            @Sql("insert_shift_type.sql"),
            @Sql("insert_shift_type_skills.sql"),
            @Sql("insert_shift_date.sql"),
            @Sql("insert_shift.sql"),
            @Sql("insert_shift_request.sql")
    })
    public void findByIdTest() {
        ShiftRequestEntity req1 = repository.findById(1).get();
        assertThat(req1.getEmployeeEntity().getName(), is("John"));
        assertThat(req1, isA(ShiftOnRequestEntity.class));

        ShiftRequestEntity req2 = repository.findById(2).get();
        assertThat(req2.getEmployeeEntity().getName(), is("Bill"));
        assertThat(req2, isA(ShiftOffRequestEntity.class));
    }
}
