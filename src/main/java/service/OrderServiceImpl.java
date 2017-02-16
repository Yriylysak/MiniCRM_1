package service;

import com.sun.org.apache.xpath.internal.operations.Or;
import entity.Order;
import util.DaoUtil;

import java.util.List;

/**
 * Created by Олег on 13.02.2017.
 */
public class OrderServiceImpl implements OrderService{
    @Override
    public Long add(Order order) {
        if(order != null && !isCreatedOrder(order)) {
            Long id = DaoUtil.getOrderDao().create(order);
            return id;
        }
        return null;
    }

    @Override
    public List<Order> findAll() {
        return DaoUtil.getOrderDao().findAll();
    }

    @Override
    public boolean delete(Long id) {
        Order order = DaoUtil.getOrderDao().read(id);
        return DaoUtil.getOrderDao().delete(order);
    }

    @Override
    public boolean changeOrder(Order oldOrder, Order newOrder) {
        if (oldOrder != null && newOrder != null) {
            oldOrder.setStatus(newOrder.getStatus());
            oldOrder.setClient(newOrder.getClient());
            oldOrder.setDate(newOrder.getDate());
            oldOrder.setDateDeadline(newOrder.getDateDeadline());
            oldOrder.setEmployee(newOrder.getEmployee());

            DaoUtil.getOrderDao().update(oldOrder);
            return true;
        }
        return false;
    }

    @Override
    public Long findIdOrder(Order order) {
        if (order != null) {
            List<Order> orders = findAll();
            for (Order ord : orders) {
                if (ord.equals(order)) {
                    return ord.getId();
                }
            }
        }
        return null;
    }

    @Override
    public boolean isCreatedOrder(Order order) {
        List<Order> orders = findAll();
        for(Order ord : orders) {
            if (ord.equals(order)) {
                return true;
            }
        }
        return false;
    }
}
