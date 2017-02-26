package dao;

import entity.Goods;
import entity.GoodsInOrder;

import java.util.List;

/**
 * Created by julia on 26.02.17.
 */
public interface GoodsInOrderDao {
    Long create(GoodsInOrder goods);
    GoodsInOrder read(Long id);
    boolean update(GoodsInOrder goods);
    boolean delete(GoodsInOrder goods);
    List<GoodsInOrder> findAll();
}
