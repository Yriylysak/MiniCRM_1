package entity;

import javax.persistence.*;

/**
 * Created by Олег on 12.02.2017.
 */
@Entity
@Table(name = "GOODS")
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "SURENAME")
    private String sureName;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "AVAILABILITY")
    private Long availability;

}
