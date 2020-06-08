package org.optaplanner.examples.nurserostering.repo;

import org.optaplanner.examples.nurserostering.entity.ShiftTypeEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ShiftTypeRepository extends CrudRepository<ShiftTypeEntity, Long> {
    @Query("select s from ShiftTypeEntity s")
    List<ShiftTypeEntity> getAll();
}
