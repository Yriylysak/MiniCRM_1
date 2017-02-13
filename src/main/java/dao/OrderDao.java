package dao;

import entity.Order;
import entity.User;

import java.util.List;

/**
 * Created by Yura on 13.02.2017.
 */
public interface OrderDao
{
    Long create(Order order);
    Order read(Long id);
    boolean update(Order order);
    boolean delete(Order order);
    List<Order> findAll();


}
