package util;

import service.*;

/**
 * Created by JL on 13.02.2017.
 */

public class ServiceUtil
{
    private static EmployeeService employeeService;
    private static UserService userService;
    private static ClientService clientService;
    private static GoodsService goodsService;
    private static GoodsInOrderService goodsInOrderService;
    private static OrderingService orderingService;

    public static GoodsInOrderService getGoodsInOrderService() {
        goodsInOrderService = new GoodsInOrderServiceImpl();
        return goodsInOrderService;
    }

    public static OrderingService getOrderingService() {
        orderingService = ApplicationContextFactory.getApplicationContext()
                .getBean(OrderingServiceImpl.class);
        return orderingService;
    }

    public static void setOrderingService(OrderingService orderingService) {
        ServiceUtil.orderingService = orderingService;
    }


    public static GoodsService getGoodsService() {
        goodsService = new GoodsServiceImpl();
        return goodsService;
    }

    public static ClientService getClientService() {
        clientService = ApplicationContextFactory.getApplicationContext()
                .getBean(ClientServiceImpl.class);
        return clientService;
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
