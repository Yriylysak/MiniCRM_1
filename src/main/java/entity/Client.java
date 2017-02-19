package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Олег on 12.02.2017.
 */
@Entity
@Table(name = "CLIENT")
public class Client {
//
    @Id
    @Column(name = "CLIENT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURENAME")
    private String sureName;

    @Column(name = "AGE")
    private String age;//Integer

    @Column(name = "PHONE")
    private String phone;//Integer

    @Column(name = "EMAIL")
    private String email;

    /*@OneToMany(targetEntity = Order.class, cascade = CascadeType.ALL)
     private List<Order> orderList = new ArrayList<>();
*/
    public Client() {

    }

    public Client(String name, String sureName, String age, String phone, String email) {
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

    public String getAge() {
        return age;
    }

    public String getPhone() {
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

    public void setAge(String age) {
        this.age = age;
    }

    public void setPhone(String phone) {
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
        return  id + ". " + name + " " + sureName
                + ". Телефон : " + phone + ". E-mail : " + email + ".";
    }


}
