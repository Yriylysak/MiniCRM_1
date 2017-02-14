package service;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import entity.Employee;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by JL on 05.02.2017.
 */
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
            employee.setId(id);
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
    public boolean changeEmployer(Employee oldEmployee, Employee newEmployee) {
        if (oldEmployee != null && newEmployee != null) {
            System.out.println("___________________1___________________we are here!!!");
            oldEmployee.setName(newEmployee.getName());
            oldEmployee.setSureName(newEmployee.getSureName());
            oldEmployee.setAge(newEmployee.getAge());
            oldEmployee.setSex(newEmployee.getSex());
            oldEmployee.setPosition(newEmployee.getPosition());
            employeeDao.update(oldEmployee);
            return true;
        }
        return false;
    }

    @Override
    public boolean changePosition(Long id, String position) {
        List<Employee> employees = findAll();
        for(Employee empl : employees) {
            if (empl.getId() == id) {
                empl.setPosition(position);
                employeeDao.update(empl);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean changeName(Long id, String name) {
        List<Employee> employees = findAll();
        for(Employee empl : employees) {
            if (empl.getId() == id) {
                empl.setName(name);
                employeeDao.update(empl);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean changeSurname(Long id, String surname) {
        List<Employee> employees = findAll();
        for(Employee empl : employees) {
            if (empl.getId() == id) {
                empl.setSureName(surname);
                employeeDao.update(empl);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean changeAge(Long id, Integer age) {
        List<Employee> employees = findAll();
        for(Employee empl : employees) {
            if (empl.getId() == id) {
                empl.setAge(age);
                employeeDao.update(empl);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean changeSex(Long id, String sex) {
        List<Employee> employees = findAll();
        for(Employee empl : employees) {
            if (empl.getId() == id) {
                empl.setSex(sex);
                employeeDao.update(empl);
                return true;
            }
        }
        return false;
    }

    @Override
    public Long findIdEmployer(Employee employee) {
        return employee.getId();
    }

    /*повертає список співробітників, в яких співпадає хоч одне
    * поле типу String з тим,
    * яке ми передали на вхід */
    @Override
    public List<Employee> findBySomeStringParam(String someParam) {
        List<Employee> employees = findAll();
        List<Employee> returnList = new LinkedList<>();

        for(Employee empl : employees) {
            if ((empl.getName() == someParam) || (empl.getSureName() == someParam)
                || (empl.getPosition() == someParam) || (empl.getSex() == someParam)) {
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

        for(Employee empl : employees) {
            if ((empl.getAge() >= minAge) && (empl.getAge() <= maxAge)) {
                returnList.add(empl);
            }
        }
        return returnList;
    }

    @Override
    public boolean isCreatedEmployee(Employee employee) {
        List<Employee> employees = findAll();
        for(Employee empl : employees) {
            if (       (empl.getName()).equals(employee.getName())
                    && (empl.getSureName().equals(employee.getSureName()))
                    && (empl.getAge() == employee.getAge())
                    && (empl.getSex().equals(employee.getSex()))
                    && (empl.getPosition().equals(employee.getPosition()))) {
                return true;
            }
        }
        return false;
    }
}
