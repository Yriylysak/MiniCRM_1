package entity;

import javax.persistence.*;

/**
 * Created by Олег on 12.02.2017.
 */
@Entity
@Table(name = "CLIENT")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURENAME")
    private String sureName;

    @Column(name = "AGE")
    private Integer age;

    @Column(name = "PHONE")
    private Integer phone;

    @Column(name = "EMAIL")
    private String email;

    public Client() {
    }

    public Client(String name, String sureName, Integer age, Integer phone, String email) {
        this.name = name;
        this.sureName = sureName;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getSureName() {
        return sureName;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sureName='" + sureName + '\'' +
                ", age=" + age +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                '}';
    }
}
