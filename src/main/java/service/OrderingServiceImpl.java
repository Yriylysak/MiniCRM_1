package service;

import entity.Ordering;
import util.DaoUtil;

import java.util.List;

/**
 * Created by julia on 23.02.17.
 */
public class OrderingServiceImpl implements OrderingService {
    @Override
    public Long add(Ordering ordering) {
        if (ordering != null) {
            Long id = (Long) DaoUtil.getOrderingDao().create(ordering);
            return id;
        }
        return null;
    }

    @Override
    public List<Ordering> findAll() {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public boolean changeClient(Ordering oldOrdering, Ordering newOrdering) {
        return false;
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
