package org.optaplanner.examples.nurserostering;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.optaplanner.examples.nurserostering.repo.ContractLineRepository;
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
public class ContractLineRepositoryTest {
    @Autowired
    ContractLineRepository contractLineRepository;

    @Test
    public void jpaTest() {
        assertThat(contractLineRepository, notNullValue());
    }

    @Test
    @SqlGroup({
            @Sql("insert_contract_line.sql")
    })
    public void findAllTest() {
        long cnt = StreamSupport.stream(contractLineRepository.findAll().spliterator(), false).count();
        assertThat(cnt, is(2L));
    }
}
