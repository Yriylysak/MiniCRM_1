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
    private UserDao userDao;

    @Override
    public Long add(User user) {
        if (user != null && !isCreatedUser(user)) {
            Long id = userDao.create(user);
            return id;
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        User user = userDao.read(id);
        userDao.delete(user);
    }

    @Override
    public void changeUser(User user) {
        userDao.update(user);

    }

    @Override
    public Long findIdUser(User user) {
        if (user != null) {
            List<User> users = findAll();
            for (User us : users) {
                if (us.equals(user)) {
                    return us.getId();
                }
            }
        }
        return null;
    }

    @Override
    public boolean isCreatedUser(User user) {
        List<User> users = findAll();
        for (User us : users) {
            if (us.getLogin().equals(user.getLogin())
                    && us.getPassword().equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean auth(String login, String password) {
        List<User> users = userDao.findAll();
        for (User us : users) {
            if (us.getLogin().equals(login)
                    && us.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
