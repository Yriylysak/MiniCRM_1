package entity;

import enumTypes.Gender;
import enumTypes.Position;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by Alexandr on 05.02.2017.
 */
@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    */@Id
    @Column(name = "EMPLOYEE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String sureName;

    @Column(name = "AGE")
    private Integer age;

    @Enumerated(EnumType.ORDINAL)
    private Gender gender;

    @Enumerated(EnumType.ORDINAL)
    private Position position;

    @Column (name = "DATE")
    //@Temporal( ? )
    private Date date;

    @OneToOne
    @JoinColumn(name = "USER_ID")
    private User user;


    public Employee(String name, String sureName, Integer age, Gender gender, Position position) {
        this.name = name;
        this.sureName = sureName;
        this.age = age;
        this.gender = gender;
        this.position = position;
        date = new Date();
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
    public Gender getSex() {
        return gender;
    }
    public Position getPosition() {
        return position;
    }
    public Date getDate() {
        return date;
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
    public void setSex(Gender sex) {
        this.gender = gender;
    }
    public void setPosition(Position position) {
        this.position = position;
    }


    public Gender getGender() {
        return gender;
    }

    public User getUser() {
        return user;
    }

    public void setGender(Gender gender) {

        this.gender = gender;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Employee() {
    }
    @Override
    public String toString() {
        return getName() + " " + getSureName() + " " + getPosition();
    }
}
