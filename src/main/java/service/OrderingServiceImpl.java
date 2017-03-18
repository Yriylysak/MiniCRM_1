package service;

import dao.ClientDao;
import dao.OrderingDao;
import entity.Ordering;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import util.DaoUtil;

import java.util.List;

/***
 * Created by julia on 23.02.17.
 */
@Service("orderingService")
public class OrderingServiceImpl implements OrderingService {
    @Autowired
    @Qualifier("orderingDao")
    private OrderingDao orderingDao;

    public OrderingDao getOrderingDao() {
        return orderingDao;
    }
    public void setOrderingDao(OrderingDao orderingDao) {
        this.orderingDao = orderingDao;
    }
    public OrderingServiceImpl() {}

    @Override
    public Long add(Ordering ordering) {
        if (ordering != null) {
            Long id = (Long) orderingDao.create(ordering);
            return id;
        }
        return null;
    }

    @Override
    public Ordering read(Long id) {
        return orderingDao.read(id);
    }

    @Override
    public List<Ordering> findAll() {
        return orderingDao.findAll();
    }

    @Override
    public void delete(Long id) {
        Ordering ordering = orderingDao.read(id);
        orderingDao.delete(ordering);
    }

    @Override
    public void update(Ordering ordering) {
        orderingDao.update(ordering);
    }

    @Override
    public Long findIdClient(Ordering ordering) {
        return null;
    }

    @Override
    public boolean isCreatedClient(Ordering ordering) {
        return false;
    }
}
