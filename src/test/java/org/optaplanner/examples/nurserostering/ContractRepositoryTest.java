package org.optaplanner.examples.nurserostering;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.optaplanner.examples.nurserostering.entity.ContractEntity;
import org.optaplanner.examples.nurserostering.repo.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import java.util.stream.StreamSupport;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@Tag("unit")
@DataJpaTest
public class ContractRepositoryTest {
    @Autowired
    ContractRepository contractRepository;
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void jpaTest() {
        assertThat(contractRepository, notNullValue());
    }

    @Test
    @SqlGroup({
            @Sql("insert_shift_type.sql"),
            @Sql("insert_pattern.sql"),
            @Sql("insert_contract_line.sql"),
            @Sql("insert_contract.sql")
    })
    public void findAllTest() throws JsonProcessingException {
        long cnt = StreamSupport.stream(contractRepository.findAll().spliterator(), false).count();
        assertThat(cnt, is(1L));
        ContractEntity contractEntity = contractRepository.findById(1L).orElseThrow(IllegalAccessError::new);
        System.out.println("contract entity: " + objectMapper.writeValueAsString(contractEntity));
    }

}
