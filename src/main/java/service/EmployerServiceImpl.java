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

    @Override
    public Long add(Employer notebook) {
        return null;
    }

    @Override
    public List<Employer> findAll() {
        return null;
    }

    @Override
    public void changePosition(String login, String position) {

    }

    @Override
    public boolean delete(String login) {
        return false;
    }
}
