package web.dao;


import web.entity.Client;
import web.entity.User;

import java.util.List;

/**
 * Created by Comfy on 12.03.2017.
 */
public interface UserDao {
    Long create(User user);
    User read(Long id);
    void update(User user);
    void delete(User user);
    List<User> findAll();

}
