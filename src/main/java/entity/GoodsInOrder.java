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

    @Column(name = "AMOUNT", nullable = false)
    private Integer amount;

    /*@ManyToOne
    @JoinColumn(name = "ORDER_ID", nullable = false)
    private Order order;
*/

    public GoodsInOrder() {
    }

    public GoodsInOrder(Goods goods, Integer amount) {
        this.goods = goods;
        this.price = goods.getPrice();
        this.amount = amount;
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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return  "Товар :  " + goods.getProductName() + ".  Цена = " + price
                + ". Количество  = " + amount + ". Сумма = " + amount * price;

    }
}
