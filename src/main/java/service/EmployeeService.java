package service;

import entity.Employee;
import enumTypes.Gender;
import enumTypes.Position;

import java.util.List;

/**
 * Created by JL on 05.02.2017.
 */
public interface EmployeeService {
    Long add(Employee employee);
    List<Employee> findAll();
    boolean delete(Long id);
    boolean changeEmployee(Employee employee);
    Long findIdEmployee(Employee employee);
    List<Employee> findBySomeStringParam(String someParam);
    List<Employee> findByAge(Integer minAge, Integer maxAge);
    boolean isCreatedEmployee(Employee employee);
}
