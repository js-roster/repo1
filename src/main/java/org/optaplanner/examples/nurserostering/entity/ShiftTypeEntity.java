package org.optaplanner.examples.nurserostering.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "shift_type")
public class ShiftTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name="type_cd", length = 20, nullable = false, unique = true)
    private String code;
    @Column(name="type_idx", nullable = false, unique = true, scale = 1, precision = 0)
    private int index;
    @Column(name="start_time")
    private String startTimeString;
    @Column(name="end_time")
    private String endTimeString;
    private boolean night;
    private String description;

    @ManyToMany
    @JoinTable(name = "shift_type_skill_requirement",
            joinColumns = @JoinColumn(name = "shift_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private Set<SkillEntity> requiredSkills;

    public ShiftTypeEntity() {
    }

    public ShiftTypeEntity(Long id, String code, int index, String startTimeString, String endTimeString, boolean night, String description) {
        this.id = id;
        this.code = code;
        this.index = index;
        this.startTimeString = startTimeString;
        this.endTimeString = endTimeString;
        this.night = night;
        this.description = description;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getStartTimeString() {
        return startTimeString;
    }

    public void setStartTimeString(String startTimeString) {
        this.startTimeString = startTimeString;
    }

    public String getEndTimeString() {
        return endTimeString;
    }

    public void setEndTimeString(String endTimeString) {
        this.endTimeString = endTimeString;
    }

    public boolean isNight() {
        return night;
    }

    public void setNight(boolean night) {
        this.night = night;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<SkillEntity> getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(Set<SkillEntity> requiredSkills) {
        this.requiredSkills = requiredSkills;
    }
}
