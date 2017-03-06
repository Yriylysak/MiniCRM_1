package dao;

import entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Julia on 06.03.2017.
 */
@Repository
public class UserDAOImpl implements UserDAO {
    @Autowired
    private SessionFactory factory;


    public Long create(User user) {
        return null;
    }

    public User read(Long id) {
        return null;
    }

    public Boolean update(User user) {
        return null;
    }

    public Boolean delete(User user) {
        return null;
    }

    //@Override
    @Transactional
    public List<User> findAll() {
        return null;
    }
}
