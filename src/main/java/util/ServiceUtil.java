package util;

import service.*;

/**
 * Created by JL on 13.02.2017.
 */

//factory of Services
public class ServiceUtil
{
    private static EmployeeService employeeService;
    private static UserService userService;
    private static ClientService clientService;
    private static OrderService orderService;
    private static GoodsService goodsService;

    public static OrderingService getOrderingService() {
        return orderingService;
    }

    public static void setOrderingService(OrderingService orderingService) {
        ServiceUtil.orderingService = orderingService;
    }

    private static OrderingService orderingService;

    public static GoodsService getGoodsService() {
        goodsService = new GoodsServiceImpl();
        return goodsService;
    }

    public static ClientService getClientService() {
        clientService = new ClientServiceImpl();
        return clientService;
    }

    public static OrderService getOrderService() {
        orderService = new OrderServiceImpl();
        return orderService;
    }

    public static UserService getUserService() {
        userService = new UserServiceImpl();
        return userService;
    }

    public static EmployeeService getEmployeeService() {
        employeeService = new EmployeeServiceImpl();
        return employeeService;
    }
}
