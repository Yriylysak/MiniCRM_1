package entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Alexandr on 05.02.2017.
 */

@Entity
@Table(name = "USERS")
public class User {
   /* @Id
    @GeneratedValue(strategy = GenerationType.AUTO) */

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASSWORD")
    private String password;

    @OneToOne
    //@JoinColumn(name = "EMPLOYER_ID", referencedColumnName = "ID")
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;

    @Column (name = "DATE")
    private Date date;

    public User(String login, String password, Employee employee) {
        this.login = login;
        this.password = password;
        this.employee = employee;
        date = new Date();
    }
    public User() {}

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public String getLogin() {
        return login;
    }
    public String getPassword() {
        return password;
    }
    public Employee getEmployee() {
        return employee;
    }
    public Date getDate() {
        return date;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    @Override
    public String toString() {
        return getLogin() + " " + getPassword();
    }
}
