package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.entity.User;

import java.util.List;

/**
 * Created by Comfy on 12.03.2017.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao dao;

    @Override
    public Long add(User user) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void changeClient(User oldUser, User newUser) {

    }

    @Override
    public Long findIdClient(User user) {
        return null;
    }

    @Override
    public boolean isCreatedClient(User user) {
        return false;
    }

    @Override
    public boolean auth(String login, String password) {
        List<User> users = dao.findAll();
        for (User us : users) {
            if (us.getLogin().equals(login)
                    && us.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
