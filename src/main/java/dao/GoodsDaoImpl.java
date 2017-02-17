package dao;

import com.sun.xml.internal.ws.handler.HandlerException;
import entity.Goods;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

import java.util.List;

/**
 * Created by Yura on 13.02.2017.
 */
public class GoodsDaoImpl implements GoodsDao
{
    private SessionFactory factory;

    public GoodsDaoImpl() {factory = HibernateUtil.getSessionFactory();}

    @Override
    public Long create(Goods goods) {
        if(goods != null
                && !(goods.getProductName().isEmpty())
                && (goods.getPrice() > 0)) {
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
        }
        return null;
    }

    @Override
    public Goods read(Long id) {
        List<Goods> goodss = findAll();
        for (Goods goods : goodss) {
            if(goods.getId() == id) {
                return goods;
            }
        }
        return null;
    }

    @Override
    public boolean update(Goods goods) {
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
    public boolean delete(Goods goods) {
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
    public List<Goods> findAll() {
        return factory.openSession().createCriteria(Goods.class).list();
    }
}
