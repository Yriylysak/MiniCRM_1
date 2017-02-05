package dao;

import entity.Employer;

import java.util.List;

/**
 * Created by Comfy on 05.02.2017.
 */
public interface employerDao {
    Long create(Employer empl);
    Employer read(String password);
    boolean update(Employer empl);
    boolean delete(Employer empl);
    List<Employer> findAll();
}
