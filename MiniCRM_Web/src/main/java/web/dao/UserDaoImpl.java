package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.entity.User;

import java.util.List;

/**
 * Created  on 12.03.2017.
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory factory;

    @Override
    @Transactional
    public Long create(User user) {
        return (Long) factory.getCurrentSession().save(user);
    }

    @Override
    @Transactional
    public User read(Long id) {
        return (User) factory.getCurrentSession().get("USER", id);
    }

    @Override
    @Transactional
    public void update(User user) {
        factory.getCurrentSession().update(user);
    }

    @Override
    @Transactional
    public void delete(User user) {
        factory.getCurrentSession().delete(user);
    }

    @Override
    @Transactional
    public List<User> findAll() {
        return factory
                .getCurrentSession()
                .createCriteria(User.class)
                .list();
    }
}
