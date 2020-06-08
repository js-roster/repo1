package org.optaplanner.examples.nurserostering;

import org.junit.jupiter.api.Test;
import org.optaplanner.examples.nurserostering.repo.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.is;

@DataJpaTest
public class SkillRepositoryTest {
    @Autowired
    private SkillRepository skillRepository;

    @Test
    public void jpaTest() {
        assertThat(skillRepository, notNullValue());
    }

    @Test
    @Sql("insert_skill.sql")
    public void getAllTest() {
        long cnt = skillRepository.getAll().size();
        assertThat(cnt, is(3L));
    }
}
