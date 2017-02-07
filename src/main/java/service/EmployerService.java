package service;

import entity.Employer;

import java.util.List;

/**
 * Created by JL on 05.02.2017.
 */
public interface EmployerService {
    Long add(Employer employer);
    List<Employer> findAll();
    void changePosition(String  login, String position);
    boolean delete(String login);
}
