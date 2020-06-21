package org.optaplanner.examples.nurserostering.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "skill")
@SequenceGenerator(name = "skill_seq")
public class SkillEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "skill_seq")
    Long id;

    @Column(name="skill_cd", length = 20, nullable = false, unique = true)
    String code;

    @ManyToMany(mappedBy = "requiredSkills")
    @JsonIgnore
    Set<ShiftTypeEntity> required;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Set<ShiftTypeEntity> getRequired() {
        return required;
    }

    public void setRequired(Set<ShiftTypeEntity> required) {
        this.required = required;
    }
}
