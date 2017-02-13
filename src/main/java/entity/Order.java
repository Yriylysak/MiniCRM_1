package entity;
import enumTypes.OrderStatus;

import javax.persistence.*;
import java.util.Date;

import static java.util.Calendar.DATE;

/**
 * Created by Олег on 12.02.2017.
 */
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    private OrderStatus status;

    @Column(name = "MANAGER")
    private Employee employee;

    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "CLIENT")
    private Client client;

    @Column(name = "DATE_DEADLINE")
    @Temporal(TemporalType.DATE)
    private Date dateDeadline;

    public Order() {
    }

    public Order(OrderStatus status, Employee employee, Client client, Date dateDeadline) {
        this.status = status;
        this.employee = employee;
        this.date = new Date();
        this.client = client;
        this.dateDeadline = dateDeadline;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getDateDeadline() {
        return dateDeadline;
    }

    public void setDateDeadline(Date dateDeadline) {
        this.dateDeadline = dateDeadline;
    }
}
