package service;

import entity.Order;
import entity.Ordering;

import java.util.List;

/**
 * Created by julia on 23.02.17.
 */
public interface OrderingService {
    Long add(Ordering ordering);
    List<Ordering> findAll();

    boolean delete(Long id);
    boolean changeClient(Ordering oldOrdering, Ordering newOrdering);
    Long findIdClient(Ordering ordering);
    boolean isCreatedClient(Ordering ordering);

}
