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


}
