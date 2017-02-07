package service;

import dao.UserDao;
import dao.UserDaoImpl;
import entity.User;

import java.util.List;

/**
 * Created by JL on 05.02.2017.
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    public UserServiceImpl() {
        userDao = new UserDaoImpl();
    }

    /*метод додає у базу нового User
    * для цього у метод треба передати об"єкт типу User
    * повертає унікальний id*/
    @Override
    public Long add(User user) {
        if (user != null) {
            Long id = userDao.create(user);
            return id;
        }
        return null;
    }

    /*метод без параметрів, повертає список List<> усіх користувачів (юзерів)*/
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void changePassword(String login, String password) {

    }

    /*метод видаляє з бази user
    * для цього у метод треба передати унікальний id
    * повертає true якщо успішно видалили*/
    @Override
    public boolean delete(Long id) {
        User user = userDao.read(id);
        return userDao.delete(user);
    }
}
