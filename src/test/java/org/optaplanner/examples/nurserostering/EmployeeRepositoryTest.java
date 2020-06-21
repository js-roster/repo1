package org.optaplanner.examples.nurserostering;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
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
    @Sql("insert_employee.sql")
    public void getAllTest() {
        List<EmployeeEntity> ems = employeeRepository.getAll();
        assertThat(ems, hasSize(3));
    }

    @Test
    @Sql("insert_employee.sql")
    public void getByWildName() {
        List<EmployeeEntity> ems = employeeRepository.getByWildName("Jim");
        assertThat(ems, hasSize(0));
        ems = employeeRepository.getByWildName("Bill");
        assertThat(ems, hasSize(1));
        ems = employeeRepository.getByWildName("o");
        assertThat(ems, hasSize(2));
    }

    @Test
    public void getByNameTest() {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setName("John");
        employeeEntity.setCode("A001");

        employeeRepository.save(employeeEntity);
        EmployeeEntity r = employeeRepository.getByName("john");
        assertThat(r.getCode(), is("A001"));
        assertThat(r.getName(), is(equalTo("John")));
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
}
