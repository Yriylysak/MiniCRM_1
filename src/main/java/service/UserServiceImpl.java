package service;

import dao.UserDao;
import dao.UserDaoImpl;
import entity.Employee;
import entity.User;

import java.util.List;
import java.util.Random;

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

    /*метод приймає в якості id, старий і новий пароль.
    * якщо id і старий пароль співпадають з даними з бази,
    * тоді старий пароль замінюється на новий*/
    @Override
    public boolean changePassword(Long id, String oldPassword, String newPassword) {
        List<User> users = userDao.findAll();
        for(User us : users) {
            if((us.getId() == id) && (us.getPassword() == oldPassword)) {
                us.setPassword(newPassword);
                userDao.update(us);
                return true;
            }
        }
        return false;
    }

    /*метод видаляє з бази user
    * для цього у метод треба передати унікальний id
    * повертає true якщо успішно видалили*/
    @Override
    public boolean delete(Long id) {
        User user = userDao.read(id);
        return userDao.delete(user);
    }

    /*перевірка чи введений логін і пароль належить адміну*/
    @Override
    public boolean isAdmin(String login, String password) {
        List<User> users = findAll();
        for(User us : users) {
            if((us.getEmployee().getPosition().equals("Admin")) //якщо потрібно, то змінити на "administrator"
                    && (us.getLogin().equals(login))
                    && (us.getPassword().equals(password))) {
                return true;
            }
        }
        return false;
    }

    /*перевірка введені логін і пароль співпадають з даними з бази юзерів*/
    @Override
    public boolean isUser(String login, String password) {
        List<User> users = userDao.findAll();
        for(User us : users) {
            if ( ! (us.getEmployee().getPosition().equals("Admin")) //якщо не Адмін, а юзер з бази
                    && (us.getLogin().equals(login))
                    && (us.getPassword().equals(password))) {
                return true;
            }
        }
        return false;
    }

    /*автогенерація юзера, метод отримує об"єкт типу Employee*/
    @Override
    public User createUser(Employee employee) {
        User user = new User(createLogin(employee.getName(), employee.getSureName()),
                            createPassword(), employee);
        return user;
    }

    /*автогенерація логіна на основі імені і прізвища*/
    @Override
    public String createLogin(String name, String surname) {
        char chars[] = new char[1];
        name.getChars(0, 1, chars, 0);
        String login = new String(chars);
        login += ".";
        login += surname;
        List<User> users = findAll();
        for(User us: users) {
            if (us.getLogin().equals(login)) {
                //тут треба придумати щось для наступного,
                // хто буде з таким же іменем і прізвищем
                login += "2";
            }
        }
        return login;
    }

    // проста автогенерація пароля
    @Override
    public String createPassword() {
        char lowerCase[] = {'a','b','c','d','e','f','g','i','j','k','m','n','o','p','q','r','s','t','w','x','y','z'};
        char upperCase[] = {'A','B','C','D','E','F','G','H','J','K','L','M','N','P','Q','R','S','T','W','X','Y','Z'};
        char numbers[] = {'2','3','4','5','6','7','8','9'};
        char special[] = {'*', '$', '-', '+', '?', '&', '=', '!', '%', '{','}', '/'};

        char chars[] = {special[(int)(Math.random() * 11)],
                        lowerCase[(int)(Math.random() * 21)],
                        upperCase[(int)(Math.random() * 21)],
                        numbers[(int)(Math.random() * 7)],
                        lowerCase[(int)(Math.random() * 21)],
                        numbers[(int)(Math.random() * 7)],
                        upperCase[(int)(Math.random() * 21)],
                        special[(int)(Math.random() * 11)]};

        String password = new String(chars);

        StringBuilder stringBuilderPasswrod = new StringBuilder();
        Random random = new Random();

        while (stringBuilderPasswrod.length() != 8) {
            String strLetter = (String.valueOf((char) random.nextInt(255)));

            if (strLetter.matches("[aA-zZ]") || strLetter.matches("[0-9]")) {
                stringBuilderPasswrod.append(strLetter);
            }
        }

        password.matches("[[aA-zZ]*[2-9]*]");
        // 3 variants of password
        //return password;
        //return stringBuilderPasswrod.toString();
        return "qwerty";
    }

    @Override
    public Long findUser(Employee employee) {
        List<User> users = userDao.findAll();
        for (User us : users) {
            if (us.getEmployee().getId() == (employee.getId())) {
                return us.getId();
            }
        }
        return null;
    }
}
