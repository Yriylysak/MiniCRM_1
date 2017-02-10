package dao;

import entity.Employee;

import java.util.List;

/**
 * Created by JL on 05.02.2017.
 */
public interface EmployeeDao {
    Long create(Employee employee);
    Employee read(Long id);
    boolean update(Employee empl);
    boolean delete(Employee empl);
    List<Employee> findAll();
}
