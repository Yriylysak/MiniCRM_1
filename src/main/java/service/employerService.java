package service;

import entity.Employer;

import java.util.List;

/**
 * Created by Comfy on 05.02.2017.
 */
public interface employerService {
    Long add(Employer notebook);
    List<Employer> findAll();
    void changePosition(String  login, String position);
    boolean delete(String login);
}
