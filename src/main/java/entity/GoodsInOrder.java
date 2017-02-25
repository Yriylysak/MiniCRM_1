package entity;

import javax.persistence.*;
/**
 * Created by JL on 19.02.2017.
 */
@Entity
@Table(name = "GOODSINORDER")
public class GoodsInOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "GOODS_ID", nullable = false)
    private Goods goods;

    @Column(name = "PRICE", nullable = false)
    private Double price;

    @Column(name = "CLIENTAMOUNT", nullable = false)
    private Integer clienamount;

    @Column(name = "ENABLEAMOUNT", nullable = false)
    private Integer enableamount;



    /*@ManyToOne
    @JoinColumn(name = "ORDER_ID", nullable = false)
    private Order order;
*/

    public GoodsInOrder() {
    }

    public GoodsInOrder(Goods goods, Integer clienamount) {
        this.goods = goods;
        this.price = goods.getPrice();
        this.clienamount = clienamount;
        enableamount = 0;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getClienamount() {
        return clienamount;
    }

    public Integer getEnableamount() {
        return enableamount;
    }

    public void setClienamount(Integer clienamount) {
        this.clienamount = clienamount;
    }

    public void setEnableamount(Integer enableamount) {
        this.enableamount = enableamount;
    }

    @Override
    public String toString() {
        return id +
                ". " + goods +
                ". price = " + price +
                ". clienamount=" + clienamount +
                ". enableamount=" + enableamount;
    }
}
