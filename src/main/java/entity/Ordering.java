package entity;

import enumTypes.OrderStatus;

import javax.persistence.*;
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
    private String dateEnd;

    @Column (name = "ORDER_STATUS")
    @Enumerated
    private OrderStatus orderStatus;

    @Column (name = "AMOUNT")
    private Integer amount;

    @Column (name = "SUMM")
    private Double summ;

    @OneToMany(targetEntity = GoodsInOrder.class)
    private List<GoodsInOrder> goodsInOrderList;

/*
   @OneToMany(mappedBy = "ordering", fetch = FetchType.LAZY)
    private Set<GoodsInOrder> goodsInOrderSet;
*/

    public Ordering() {
    }

    public List<GoodsInOrder> getGoodsInOrderList() {
        return goodsInOrderList;
    }

    public void setGoodsInOrderList(List<GoodsInOrder> goodsInOrderList) {
        this.goodsInOrderList = goodsInOrderList;
    }

    public Ordering(String manager, String client,
                    Date date, String dateEnd,
                    OrderStatus orderStatus,
                    Integer amount, Double summ,
                    List<GoodsInOrder> goodsInOrderList) {
        this.manager = manager;
        this.client = client;
        this.date = date;
        this.dateEnd = dateEnd;
        this.orderStatus = orderStatus;
        this.amount = amount;
        this.summ = summ;
        this.goodsInOrderList = goodsInOrderList;

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

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
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
        return id +
                ". status = " + orderStatus +
                ". client = " + client +
                ". date = " + date +
                ". dateEnd = " + dateEnd;
    }
}