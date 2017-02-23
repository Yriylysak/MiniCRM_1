package util;

import dao.*;

/***
 * Created by JL on 13.02.2017.
 */
public class DaoUtil {
    private static EmployeeDao employeeDao;
    private static UserDao userDao;
    private static ClientDao clientDao;
    private static OrderDao orderDao;
    private static GoodsDao goodsDao;
    private static OrderingDao orderingDao;

    public DaoUtil() {
    }

    public static OrderingDao getOrderingDao() {
        orderingDao = new OrderingDaoImpl();
        return orderingDao;
    }

    public static EmployeeDao getEmployeeDao() {
        employeeDao = new EmployeeDaoImpl();
        return employeeDao;
    }

    public static UserDao getUserDao() {
        userDao = new UserDaoImpl();
        return userDao;
    }

    public static ClientDao getClientDao() {
        clientDao = new ClientDaoImpl();
        return clientDao;
    }

    public static OrderDao getOrderDao() {
        orderDao = new OrderDaoImpl();
        return orderDao;
    }

    public static GoodsDao getGoodsDao() {
        goodsDao = new GoodsDaoImpl();
        return goodsDao;
    }
}
