package org.optaplanner.examples.nurserostering.entity;

import javax.persistence.*;

@Entity
@Table(name = "pattern")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "pat_class", discriminatorType = DiscriminatorType.STRING, length = 50)
public class PatternEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name = "pat_cd", length = 50)
    protected String code;

    protected int weight;

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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
