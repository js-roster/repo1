package org.optaplanner.examples.nurserostering;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.optaplanner.examples.nurserostering.entity.ContractEntity;
import org.optaplanner.examples.nurserostering.entity.EmployeeEntity;
import org.optaplanner.examples.nurserostering.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Tag("unit")
@DataJpaTest
@EnableTransactionManagement
public class EmployeeRepositoryTest {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void jpaWorks() {
        assertThat(dataSource, notNullValue());
        assertThat(jdbcTemplate, notNullValue());
        assertThat(entityManager, notNullValue());
        assertThat(employeeRepository, notNullValue());

    }

    @Test
    public void getAllTest() {
        List<EmployeeEntity> ems = employeeRepository.getAll();
        assertThat(ems, hasSize(20));
    }

    @Test
    public void getByWildName() {
        List<EmployeeEntity> ems = employeeRepository.getByWildName("Jim");
        assertThat(ems, hasSize(0));
        ems = employeeRepository.getByWildName("Emp 4");
        assertThat(ems, hasSize(10));
        ems = employeeRepository.getByWildName("emp");
        assertThat(ems, hasSize(20));
    }

    @Test
    public void getByNameTest() {
        EmployeeEntity r = employeeRepository.getByName("emp 31");
        assertThat(r.getCode(), is("ID031"));
        assertThat(r.getName(), is(equalTo("Emp 31")));
    }

    @Test
    public void daoExceptionTest() {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        assertThat(employeeEntity.getCode(), is(nullValue()));
        Assertions.assertThrows(DataIntegrityViolationException.class, () -> {
            employeeRepository.save(employeeEntity);
            employeeRepository.findAll();
        });
    }

    @Test
    @SqlGroup({
            @Sql("insert_employee.sql"),
            @Sql("insert_skill.sql"),
            @Sql("insert_skill_proficiency.sql")
    })
    public void employeeSkillTest() {
        EmployeeEntity emp = employeeRepository.findById(1001L).get();
        assertThat(emp.getSkillEntities().size(), is(3));

        EmployeeEntity emp2 = employeeRepository.findById(1002L).get();
        assertThat(emp2.getSkillEntities().size(), is(0));
    }

    @Test
    @SqlGroup({
            @Sql("insert_shift_type.sql"),
            @Sql("insert_pattern.sql"),
            @Sql("insert_contract_line.sql"),
            @Sql("insert_contract.sql"),
            @Sql("insert_employee_contract.sql")
    })
    public void contractTest() {
        EmployeeEntity e1 = employeeRepository.findById(1L).get();
        assertThat(e1.getContractEntity(), isA(ContractEntity.class));
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
    public void shiftRequestTest() {
        EmployeeEntity e1 = employeeRepository.findById(1001L).get();
        assertThat(e1.getShiftRequestEntities().size(), is(1));
    }

    @Test
    @SqlGroup({
            @Sql("insert_employee.sql"),
            @Sql("insert_shift_date.sql"),
            @Sql("insert_day_request.sql")
    })
    public void dayRequestTest() {
        EmployeeEntity e1 = employeeRepository.findById(1001L).get();
        assertThat(e1.getDayRequestEntities().size(), is(1));
        IntStream.rangeClosed(31, 50).boxed()
                .flatMap(i ->
                        Stream.iterate(new int[]{(i - 31) * 2, i, 0}, j -> new int[]{j[0] + 1, j[1], (j[2] + 1) % 2}).limit(2))
                .map(n -> new int[]{n[0], n[2], n[1], n[0]%14})
                .forEach(i ->
                        System.out.println("".format("insert into request_day (id, on_off, weight, emp_id, shift_dte_id ) values(%d, '%s', 100, %d, %d);", 31+i[0], i[1] == 1?"ON":"OFF", i[2],31+i[3])));

    }
}
