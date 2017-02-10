package entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Alexandr on 05.02.2017.
 */

@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASSWORD")
    private String password;

    @OneToOne
    @JoinColumn(name = "EMPLOYER_ID", referencedColumnName = "ID")
    private Employer employer;

    @Column (name = "DATE")
    private Date date;

    public User(String login, String password, Employer employer) {
        this.login = login;
        this.password = password;
        this.employer = employer;
        date = new Date();
    }
    public User() {}
    public Long getId() {
        return id;
    }
    public String getLogin() {
        return login;
    }
    public String getPassword() {
        return password;
    }
    public Employer getEmployer() {
        return employer;
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
    public void setEmployer(Employer employer) {
        this.employer = employer;
    }
    @Override
    public String toString() {
        return getLogin() + " " + getPassword();
    }
}
