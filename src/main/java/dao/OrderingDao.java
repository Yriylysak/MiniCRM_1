package dao;


import entity.Ordering;

import java.util.List;

/***
 * Created by julia on 23.02.17.
 */
public interface OrderingDao {

    Long create(Ordering ordering);
    Ordering read(Long id);
    void update(Ordering ordering);
    void delete(Ordering ordering);
    List<Ordering> findAll();
}
