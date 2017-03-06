package dao;

import entity.User;

import java.util.List;

/**
 * Created by Julia on 06.03.2017.
 */
public interface UserDAO {
    Long create(User user);
    User read(Long id);
    Boolean update(User user);
    Boolean delete(User user);
    List<User> findAll();
}
