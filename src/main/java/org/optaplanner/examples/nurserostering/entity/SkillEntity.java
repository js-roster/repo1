package org.optaplanner.examples.nurserostering.entity;

import javax.persistence.*;

@Entity
@Table(name = "skill")
public class SkillEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name="skill_cd", length = 20, nullable = false, unique = true)
    String code;

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
}
