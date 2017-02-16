package service;
import entity.Goods;

import java.util.List;

/**
 * Created by JL on 16.02.2017.
 */
public interface GoodsService {
    Long add(Goods goods);
    List<Goods> findAll();

    boolean delete(Long id);
    boolean changeGoods(Goods oldGoods, Goods newGoods);
    Long findIdGoods(Goods goods);
    boolean isCreatedGoods(Goods goods);
}
