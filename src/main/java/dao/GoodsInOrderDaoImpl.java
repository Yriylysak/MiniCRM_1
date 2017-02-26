package dao;

import com.sun.xml.internal.ws.handler.HandlerException;
import entity.GoodsInOrder;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

import java.util.List;

/**
 * Created by julia on 26.02.17.
 */
public class GoodsInOrderDaoImpl implements GoodsInOrderDao {

    private SessionFactory factory;

    public GoodsInOrderDaoImpl() {
        factory = HibernateUtil.getSessionFactory();
    }

    @Override
    public Long create(GoodsInOrder goods) {

            Session session = factory.openSession();
            try {
                session.beginTransaction();
                Long id = (Long) session.save(goods);
                session.getTransaction().commit();
                return id;

            } catch (HandlerException e) {
                session.getTransaction().rollback();
            } finally {
                session.close();
            }

        return null;
    }

    @Override
    public GoodsInOrder read(Long id) {
        List<GoodsInOrder> goodss = findAll();
        for (GoodsInOrder goods : goodss) {
            if(goods.getId() == id) {
                return goods;
            }
        }
        return null;
    }

    @Override
    public boolean update(GoodsInOrder goods) {
        if(goods != null) {
            Session session = factory.openSession();
            try {
                session.beginTransaction();
                session.update(goods);
                session.getTransaction().commit();
                return true;

            } catch (HibernateException e) {
                session.getTransaction().rollback();
            } finally {
                session.close();
            }
        }
        return false;
    }

    @Override
    public boolean delete(GoodsInOrder goods) {
        if(goods != null) {
            Session session = factory.openSession();
            try {
                session.beginTransaction();
                session.delete(goods);
                session.beginTransaction().commit();
                return true;
            } catch (HibernateException e) {
                session.getTransaction().rollback();
            } finally {
                session.close();
            }
        }
        return false;
    }

    @Override
    public List<GoodsInOrder> findAll() {
        return factory.openSession().createCriteria(GoodsInOrder.class).list();
    }
}
