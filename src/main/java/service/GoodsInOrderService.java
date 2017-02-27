package service;

import entity.GoodsInOrder;

import java.util.List;

/**
 * Created by Олег on 27.02.2017.
 */
public interface GoodsInOrderService {
    Long add(GoodsInOrder goodsInOrder);
    List<GoodsInOrder> findAll();

    boolean delete(Long id);
    boolean changeGoodsInOrder(GoodsInOrder oldGoodsInOrder, GoodsInOrder newGoodsInOrder);
    Long findIdGoodsInOrder(GoodsInOrder goodsInOrder);
    boolean isCreatedGoods(GoodsInOrder goodsInOrder);

}
