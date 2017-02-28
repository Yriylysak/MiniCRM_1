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

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "AMOUNT", nullable = false)
    private Integer amount;

    @Column(name = "ENABLEAMOUNT", nullable = false)
    private Integer amountEnable;

    @Column(name = "PRICE", nullable = false)
    private Double price;

    @Column(name = "NDS", nullable = false)
    private Double nds;
    @Column(name = "PRICENDS", nullable = false)
    private Double priceNDS;

    //@ManyToOne(targetEntity = Ordering.class)
    //@JoinColumn(name = "ORDER_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    private Ordering ordering;

    public GoodsInOrder() {
    }

    public GoodsInOrder(Goods goods, Integer amount, Ordering ordering) {
        this.goods = goods;
        name = goods.getProductName();
        this.amount = amount;
        amountEnable = goods.getAmount();
        price = goods.getPrice();
        nds = goods.getPrice() * 0.2;
        priceNDS = goods.getPrice() * 1.2;
        this.ordering = getOrdering();
        this.ordering = ordering;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getAmountEnable() {
        return amountEnable;
    }

    public void setAmountEnable(Integer amountEnable) {
        this.amountEnable = amountEnable;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getNds() {
        return nds;
    }

    public void setNds(Double nds) {
        this.nds = nds;
    }

    public Double getPriceNDS() {
        return priceNDS;
    }

    public void setPriceNDS(Double priceNDS) {
        this.priceNDS = priceNDS;
    }

    public Ordering getOrdering() {
        return ordering;
    }

    public void setOrdering(Ordering ordering) {
        this.ordering = ordering;
    }

    @Override
    public String toString() {
        return id +
                ". " + goods +
                ". price = " + price +
                ". amount=" + amount +
                ". enable=" + amountEnable;
    }
}
