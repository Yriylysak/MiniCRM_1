package dao;

import entity.Goods;

import java.util.List;

/**
 * Created by Yura on 13.02.2017.
 */
public interface GoodsDao
{
    Long create(Goods goods);
    Goods read(Long id);
    boolean update(Goods goods);
    boolean delete(Goods goods);
    List<Goods> findAll();

}
