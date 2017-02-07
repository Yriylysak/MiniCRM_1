package service;

import entity.Employer;

import java.util.List;

/**
 * Created by JL on 05.02.2017.
 */
public interface EmployerService {
    Long add(Employer employer);
    List<Employer> findAll();
    boolean delete(Long id);

    boolean changeEmployer(Long id, Employer employer);
    boolean changePosition(Long id, String position);
    boolean changeName(Long id, String name);
    boolean changeSurname(Long id, String surname);
    boolean changeAge(Long id, Integer age);
    boolean changeSex(Long id, String sex);

    Long findIdEmployer(Employer employer);
    List<Employer> findBySomeStringParam(String someParam);
    List<Employer> findByAge(Integer ninAge, Integer maxAge);
}
