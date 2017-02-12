package dao;

import entity.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

import java.util.List;

/****
 * Created by JL on 05.02.2017.
 */

public class EmployeeDaoImpl implements EmployeeDao {
    private SessionFactory factory;

    public EmployeeDaoImpl() {
        factory = HibernateUtil.getSessionFactory();
    }
    @Override
    public Long create(Employee employee) {
        if (employee != null) {
            Session session = factory.openSession();
            try {
                session.beginTransaction();
                Long id = (Long) session.save(employee);
                session.getTransaction().commit();
                return id;
            } catch (HibernateException e) {
                session.getTransaction().rollback();
            }
            session.close();
        }
        return null;
    }
    @Override
    public Employee read(Long id) {
        List<Employee> employees = findAll();
        for(Employee empl : employees) {
            if(empl.getId() == id) {
                return empl;
            }
        }
        return null;
    }

    @Override
    public boolean update(Employee employee)  {
        if (employee != null) {
            List<Employee> employees = findAll();
            for (Employee empl : employees) {
                if (employee.getId() == empl.getId()) {
                    Session session = factory.openSession();
                    try {
                        session.beginTransaction();
                        session.update(employee);
                        session.getTransaction().commit();
                        return true;
                    } catch (HibernateException e) {
                        session.getTransaction().rollback();
                    }
                    session.close();
                }
            }
        }
        return false;
    }

    @Override
    public boolean delete(Employee employee) {
        if (employee != null) {
            List<Employee> employees = findAll();
            for (Employee empl : employees) {
                if (employee.getId() == empl.getId()) {
                    Session session = factory.openSession();
                    try {
                        session.beginTransaction();
                        session.delete(employee);
                        session.getTransaction().commit();
                        return true;
                    } catch (HibernateException e) {
                        session.getTransaction().rollback();
                    }
                    session.close();
                }
            }
        }
        return false;
    }
    @Override
    public List<Employee> findAll() {
        return factory.openSession().createCriteria(Employee.class).list();
    }
}
