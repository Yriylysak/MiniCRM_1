package service;

import dao.UserDAO;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Julia on 06.03.2017.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO dao;

    //@Override
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