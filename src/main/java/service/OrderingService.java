package service;

import entity.Ordering;

import java.util.List;

/**
 * Created by julia on 23.02.17.
 */
public interface OrderingService {
    Long add(Ordering ordering);
    Ordering read(Long id);
    void delete(Long id);
    void update(Ordering ordering);
    List<Ordering> findAll();

    Long findIdClient(Ordering ordering);
    boolean isCreatedClient(Ordering ordering);

}
