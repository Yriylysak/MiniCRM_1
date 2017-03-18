package service;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import entity.Employee;
import java.util.LinkedList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao employeeDao;

    public EmployeeServiceImpl() {
        employeeDao = new EmployeeDaoImpl();
    }

    /*метод додає у базу нового співробітника (Employee)
    * для цього у метод треба передати об"єкт типу Employee
    * повертає унікальний id*/
    @Override
    public Long add(Employee employee) {
        if (employee != null && !isCreatedEmployee(employee)) {
            Long id = employeeDao.create(employee);
            return id;
        }
        return null;
    }

    /*метод без параметрів, повертає список List<> усіх співробітників*/
    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }


    /*метод видаляє з бази співробітника (Employee)
    * для цього у метод треба передати унікальний id
    * повертає true якщо успішно видалили*/
    @Override
    public boolean delete(Long id) {
        Employee empl = employeeDao.read(id);
        return employeeDao.delete(empl);
    }

    /*метод заміняє дані співробітнтка на нові*/
    @Override
    public boolean changeEmployee(Employee employee) {
        if (employee != null) {
            employeeDao.update(employee);
            return true;
        }
        return false;
    }

    @Override
    public Long findIdEmployee(Employee employee) {
        return employee.getId();
    }

    /*повертає список співробітників, в яких співпадає хоч одне
    * поле типу String з тим,
    * яке ми передали на вхід */
    @Override
    public List<Employee> findBySomeStringParam(String someParam) {
        List<Employee> employees = findAll();
        List<Employee> returnList = new LinkedList<>();

        for (Employee empl : employees) {
            if ((empl.getName().equals(someParam)) || (empl.getSurname().equals(someParam))
                    || (empl.getPosition().toString().equals(someParam))
                    || (empl.getGender().toString().equals(someParam))) {
                returnList.add(empl);
            }
        }
        return returnList;
    }

    /*метод отримує віковий діапазон і повертає
    * всіх співробітників з цього вікового діапазону*/
    @Override
    public List<Employee> findByAge(Integer minAge, Integer maxAge) {
        List<Employee> employees = findAll();
        List<Employee> returnList = new LinkedList<>();

        for (Employee empl : employees) {
            if ((empl.getAge() >= minAge) && (empl.getAge() <= maxAge)) {
                returnList.add(empl);
            }
        }
        return returnList;
    }

    @Override
    public boolean isCreatedEmployee(Employee employee) {
        List<Employee> employees = findAll();
        for (Employee empl : employees) {
            if ((empl.getName()).equals(employee.getName())
                    && (empl.getSurname().equals(employee.getSurname()))
                    && (empl.getAge() == employee.getAge())
                    && (empl.getGender().equals(employee.getGender()))
                    && (empl.getPosition().equals(employee.getPosition()))) {
                return true;
            }
        }
        return false;
    }
}
