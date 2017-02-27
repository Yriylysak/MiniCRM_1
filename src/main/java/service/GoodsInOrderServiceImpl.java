package service;

import entity.GoodsInOrder;
import util.DaoUtil;

import java.util.List;

/**
 * Created by Олег on 27.02.2017.
 */
public class GoodsInOrderServiceImpl implements GoodsInOrderService{
    @Override
    public Long add(GoodsInOrder goodsInOrder) {
        if (goodsInOrder != null ) {
            Long id = DaoUtil.getGoodsInOrderDao().create(goodsInOrder);
            return id;
        }
        return null;
    }

    @Override
    public List<GoodsInOrder> findAll() {
        return DaoUtil.getGoodsInOrderDao().findAll();

    }

    @Override
    public boolean delete(Long id) {
        List<GoodsInOrder> goodsInOrders = findAll();
        for (GoodsInOrder gd : goodsInOrders) {
            if (gd.getId() == id) {
                DaoUtil.getGoodsInOrderDao().delete(gd);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean changeGoodsInOrder(GoodsInOrder oldGoodsInOrder, GoodsInOrder newGoodsInOrder) {
        if(oldGoodsInOrder != null && newGoodsInOrder != null) {
            oldGoodsInOrder.setAmount(newGoodsInOrder.getAmount());
            oldGoodsInOrder.setAmountEnable(newGoodsInOrder.getAmountEnable());
            oldGoodsInOrder.setGoods(newGoodsInOrder.getGoods());
            oldGoodsInOrder.setName(newGoodsInOrder.getName());
            oldGoodsInOrder.setNds(newGoodsInOrder.getNds());
            oldGoodsInOrder.setOrdering(newGoodsInOrder.getOrdering());
            oldGoodsInOrder.setPrice(newGoodsInOrder.getPrice());
            oldGoodsInOrder.setPriceNDS(newGoodsInOrder.getPriceNDS());

            DaoUtil.getGoodsInOrderDao().update(oldGoodsInOrder);
            return true;
        }
        return false;

    }

    @Override
    public Long findIdGoodsInOrder(GoodsInOrder goodsInOrder) {
        if (goodsInOrder != null) {
            List <GoodsInOrder> goodsInOrderList = findAll();
            for (GoodsInOrder gd : goodsInOrderList) {
                if (gd.equals(goodsInOrder)) {
                    return gd.getId();
                }
            }
        }
        return null;
    }

    @Override
    public boolean isCreatedGoods(GoodsInOrder goodsInOrder) {
        if (goodsInOrder != null) {
            List <GoodsInOrder> goodsInOrderList = findAll();
            for (GoodsInOrder gd : goodsInOrderList) {
                if (gd.equals(goodsInOrder)) {
                    return true;
                }
            }
        }
        return false;
    }
}
