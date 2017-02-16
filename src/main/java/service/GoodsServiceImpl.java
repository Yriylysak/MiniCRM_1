package service;

import entity.Goods;
import util.DaoUtil;

import java.util.List;

/**
 * Created by Comfy on 16.02.2017.
 */
public class GoodsServiceImpl  implements GoodsService {
    @Override
    public Long add(Goods goods) {
        if (goods != null) {
            Long id = DaoUtil.getGoodsDao().create(goods);
            return id;
        }
        return null;
    }

    @Override
    public List<Goods> findAll() {
        return DaoUtil.getGoodsDao().findAll();
    }

    @Override
    public boolean delete(Long id) {
        List<Goods> goods = findAll();
        for (Goods gd : goods) {
            if (gd.getId() == id) {
                DaoUtil.getGoodsDao().delete(gd);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean changeGoods(Goods oldGoods, Goods newGoods) {
        if (oldGoods != null && newGoods != null) {
            oldGoods.setAvailability(newGoods.getAvailability());
            oldGoods.setPrice(newGoods.getPrice());
            oldGoods.setProductName(newGoods.getProductName());

            DaoUtil.getGoodsDao().update(oldGoods);
            return true;
        }
        return false;
    }

    @Override
    public Long findIdGoods(Goods goods) {
        if (goods != null) {
            List <Goods> goodsLists = findAll();
            for (Goods gd : goodsLists) {
                if (gd.equals(goods)) {
                    return gd.getId();
                }
            }
        }
        return null;
    }

    @Override
    public boolean isCreatedGoods(Goods goods) {
        if (goods != null) {
            List <Goods> goodsLists = findAll();
            for (Goods gd : goodsLists) {
                if (gd.equals(goods)) {
                    return true;
                }
            }
        }
        return false;
    }
}
