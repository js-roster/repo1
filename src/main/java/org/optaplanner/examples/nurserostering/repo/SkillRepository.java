package org.optaplanner.examples.nurserostering.repo;

import org.optaplanner.examples.nurserostering.entity.SkillEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SkillRepository extends CrudRepository<SkillEntity, Long> {
    @Query("select s from SkillEntity s")
    List<SkillEntity> getAll();
}
