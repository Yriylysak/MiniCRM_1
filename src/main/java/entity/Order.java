package entity;

import enumTypes.OrderStatus;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "ORDER")
public class Order {

    @Id
    @Column (name = "ORDER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "ORDER_STATUS")
    @Enumerated
    private OrderStatus orderStatus;



    @Column (name = "GOODS")
    private String goodsString;

    public Order() {
    }

    public Order(OrderStatus orderStatus, String goodsString) {
        this.orderStatus = orderStatus;
        this.goodsString = goodsString;
    }

    public Long getId() {
        return id;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public String getGoodsString() {
        return goodsString;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setGoodsString(String goodsString) {
        this.goodsString = goodsString;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderStatus=" + orderStatus +
                ", goodsString='" + goodsString + '\'' +
                '}';
    }
}