package dao;

import entity.Employer;

import java.util.List;

/**
 * Created by JL on 05.02.2017.
 */
public interface EmployerDao {
    Long create(Employer employer);
    Employer read(Long id);
    boolean update(Employer empl);
    boolean delete(Employer empl);
    List<Employer> findAll();
}
