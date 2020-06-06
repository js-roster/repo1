package org.optaplanner.examples.nurserostering.repo;

import org.optaplanner.examples.nurserostering.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface EmployeeRepository  extends CrudRepository<EmployeeEntity, Long> {
    @Query("select e from EmployeeEntity e")
    List<EmployeeEntity> getAll();

    @Query("select e from EmployeeEntity e where LOWER(e.name) = LOWER(:name)")
    EmployeeEntity getByName(@Param("name") String names);

    @Query("select e from EmployeeEntity e where LOWER(e.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<EmployeeEntity> getByWildName(@Param("name") String names);
}