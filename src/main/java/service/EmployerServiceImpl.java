package service;

import dao.EmployerDao;
import dao.EmployerDaoImpl;
import entity.Employer;

import java.util.List;

/**
 * Created by JL on 05.02.2017.
 */
public class EmployerServiceImpl implements EmployerService {
    private EmployerDao employerDao;
    public EmployerServiceImpl() {
        employerDao = new EmployerDaoImpl();
    }

    /*метод додає у базу нового співробітника (Employer)
    * для цього у метод треба передати об"єкт типу Employer
    * повертає унікальний id*/
    @Override
    public Long add(Employer employer) {
        if (employer != null) {
            Long id = employerDao.create(employer);
            return id;
        }
        return null;
    }

    /*метод без параметрів, повертає список List<> усіх співробітників*/
    @Override
    public List<Employer> findAll() {
        return employerDao.findAll();
    }

    @Override
    public void changePosition(String login, String position) {

    }

    /*метод видаляє з бази співробітника (Employer)
    * для цього у метод треба передати унікальний id
    * повертає true якщо успішно видалили*/
    @Override
    public boolean delete(Long id) {
        Employer empl = employerDao.read(id);
        return employerDao.delete(empl);
    }
}
