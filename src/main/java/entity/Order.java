package entity;
import enumTypes.OrderStatus;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Олег on 12.02.2017.
 */
@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ORDER_ID")
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    private OrderStatus status;

    @ManyToOne
    //@Column(name = "MANAGER")
    @JoinColumn(name = "MANAGER_NAME", referencedColumnName = "NAME")
    private Employee employee;

    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne
    //@Column(name = "CLIENT")
    @JoinColumn(name = "CLIENT_NAME", referencedColumnName = "NAME")
    private Client client;

    @Column(name = "DATE_DEADLINE")
    @Temporal(TemporalType.DATE)
    private Date dateDeadline;

//    // @Column(name = "MANAGER")
//    @ManyToOne
//    @JoinColumn(name = "ORDER_ID", referencedColumnName = "MANAGER_ID")
//    private Employee employee;

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
