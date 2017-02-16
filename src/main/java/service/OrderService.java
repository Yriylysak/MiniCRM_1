package service;
import entity.Order;

import java.util.List;

/**
 * Created by Олег on 13.02.2017.
 */
public interface OrderService {
    Long add(Order order);
    List<Order> findAll();

    boolean delete(Long id);
    boolean changeOrder(Order oldOrder, Order newOrder);
    Long findIdOrder(Order order);
    boolean isCreatedOrder(Order order);
}
