package entity;

import javax.persistence.*;

/**
 * Created by Comfy on 05.02.2017.
 */

@Entity
@Table(name = "USERS")
public class User {

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASSWORD")
    private String password;

    @OneToOne
    @JoinColumn(name = "EMPLOYER_ID", referencedColumnName = "ID")
    private Employer employer;

    public User(String login, String password, Employer employer) {
        this.login = login;
        this.password = password;
        this.employer = employer;
    }

    public User() {
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


    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

}
