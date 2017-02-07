package entity;

import javax.persistence.*;

/**
 * Created by Alexandr on 05.02.2017.
 */
@Entity
@Table(name = "EMPLOYER")
public class Employer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURENAME")
    private String sureName;

    @Column(name = "AGE")
    private Integer age;

    @Column(name = "SEX")
    private String sex;

    @Column(name = "POSITION")
    private String position;


    public Employer(String name, String sureName, Integer age, String sex, String position) {
        this.name = name;
        this.sureName = sureName;
        this.age = age;
        this.sex = sex;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSureName() {
        return sureName;
    }

    public Integer getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public String getPosition() {
        return position;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Employer() {
    }
    @Override
    public String toString() {
        return getName() + " " + getSureName() + " " + getPosition();
    }
}
