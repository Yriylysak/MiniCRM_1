package entity;

import enumTypes.OrderStatus;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


/**
 * Created by JL on 19.02.2017.
 */
@Entity
@Table (name = "ORDERING")
public class Ordering {
    @Id
    @Column(name = "ORDER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "MANAGER")
    private String manager;

    @Column (name = "CLIENT")
    private String client;

    @Column (name = "DATE_CREATE")
    private Date date;

    @Column (name = "DATE_END")
    private LocalDate dateEnd;

    @Column (name = "ORDER_STATUS")
    @Enumerated
    private OrderStatus orderStatus;

    @Column (name = "AMOUNT")
    private Integer amount;

    @Column (name = "SUMM")
    private Double summ;

    //@Column (name = "GOODS_IN_ORDER")
    //private List<GoodsInOrder> goodsInOrderList;


    public Ordering() {
    }

    public Ordering(String manager, String client,
                    Date date, LocalDate dateEnd,
                    OrderStatus orderStatus,
                    Integer amount, Double summ) {
        this.manager = manager;
        this.client = client;
        this.date = date;
        this.dateEnd = dateEnd;
        this.orderStatus = orderStatus;
        this.amount = amount;
        this.summ = summ;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getSumm() {
        return summ;
    }

    public void setSumm(Double summ) {
        this.summ = summ;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }


    @Override
    public String toString() {
        return "Id: " + id + "  Status: " + orderStatus;
    }
}