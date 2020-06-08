package org.optaplanner.examples.nurserostering;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.optaplanner.examples.nurserostering.entity.ShiftTypeEntity;
import org.optaplanner.examples.nurserostering.repo.ShiftTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Tag("unit")
@DataJpaTest
public class ShiftTypeRepositoryTest {
    @Autowired
    private ShiftTypeRepository shiftTypeRepository;

    @Test
    public void jpaTest() {
        assertThat(shiftTypeRepository, notNullValue());
    }

    @Test
    @Sql("insert_shift_type.sql")
    public void getAllTest() {
        List<ShiftTypeEntity> stes = shiftTypeRepository.getAll();
        assertThat(stes, hasSize(3));
        long cnt = stes.stream().filter(s -> s.getId() == 1 && s.getIndex() == 1 && s.getCode().equals("Early") && !s.isNight()).count();
        assertThat(cnt, is(1L));
    }

    @Test
    @SqlGroup(
            {@Sql("insert_shift_type.sql"),@Sql("insert_skill.sql"),
            @Sql("insert_shift_type_skills.sql")}
    )
    public void typeSkillTest() {
        long cnt = shiftTypeRepository.findById(1L).get().getRequiredSkills().size();
        assertThat(cnt, is(3L));
    }
}
