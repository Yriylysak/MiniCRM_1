package service;

import dao.EmployerDao;
import dao.EmployerDaoImpl;
import entity.Employer;

import java.util.LinkedList;
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


    /*метод видаляє з бази співробітника (Employer)
    * для цього у метод треба передати унікальний id
    * повертає true якщо успішно видалили*/
    @Override
    public boolean delete(Long id) {
        Employer empl = employerDao.read(id);
        return employerDao.delete(empl);
    }

    /*метод заміняє дані співробітнтка на нові*/
    @Override
    public boolean changeEmployer(Long id, Employer employer) {
        List<Employer> employers = findAll();
        for(Employer empl : employers) {
            if (empl.getId() == id) {
                empl = employer;
                employerDao.update(empl);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean changePosition(Long id, String position) {
        List<Employer> employers = findAll();
        for(Employer empl : employers) {
            if (empl.getId() == id) {
                empl.setPosition(position);
                employerDao.update(empl);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean changeName(Long id, String name) {
        List<Employer> employers = findAll();
        for(Employer empl : employers) {
            if (empl.getId() == id) {
                empl.setName(name);
                employerDao.update(empl);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean changeSurname(Long id, String surname) {
        List<Employer> employers = findAll();
        for(Employer empl : employers) {
            if (empl.getId() == id) {
                empl.setSureName(surname);
                employerDao.update(empl);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean changeAge(Long id, Integer age) {
        List<Employer> employers = findAll();
        for(Employer empl : employers) {
            if (empl.getId() == id) {
                empl.setAge(age);
                employerDao.update(empl);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean changeSex(Long id, String sex) {
        List<Employer> employers = findAll();
        for(Employer empl : employers) {
            if (empl.getId() == id) {
                empl.setSex(sex);
                employerDao.update(empl);
                return true;
            }
        }
        return false;
    }

    @Override
    public Long findIdEmployer(Employer employer) {
        return employer.getId();
    }

    /*повертає список співробітників, в яких співпадає хоч одне
    * поле типу String з тим,
    * яке ми передали на вхід */
    @Override
    public List<Employer> findBySomeStringParam(String someParam) {
        List<Employer> employers = findAll();
        List<Employer> returnList = new LinkedList<>();

        for(Employer empl : employers) {
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
    public List<Employer> findByAge(Integer minAge, Integer maxAge) {
        List<Employer> employers = findAll();
        List<Employer> returnList = new LinkedList<>();

        for(Employer empl : employers) {
            if ((empl.getAge() >= minAge) && (empl.getAge() <= maxAge)) {
                returnList.add(empl);
            }
        }
        return returnList;
    }
}
