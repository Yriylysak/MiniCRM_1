package dao;


import entity.Ordering;

import java.util.List;

/***
 * Created by julia on 23.02.17.
 */
public interface OrderingDao {

    Long create(Ordering ordering);
    Ordering read(Long id);
    boolean update(Ordering ordering);
    boolean delete(Ordering ordering);
    List<Ordering> findAll();
}
