package web.entity;

import javax.persistence.*;

/**
 * Created by Julia on 06.03.2017.
 */
@Entity
@Table (name = "CLIENT_WEB")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Surname")
    private String surname;

    @Column(name = "Phone")
    private Integer phone;

    @Column(name = "EMail")
    private String email;

    @Column(name = "Address")
    private String address;

    public Client() {
    }

    public Client(String name, String surname, Integer phone) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
    }

    public Client(String name, String surname, Integer phone, String email, String address) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
