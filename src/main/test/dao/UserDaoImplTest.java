package dao;

import entity.Employee;
import entity.User;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Yura on 12.02.2017.
 */
public class UserDaoImplTest extends Assert
{
    @Test
    public void testCreate()
    {
        // EmployeeDao employeeDao = new EmployeeDaoImpl();
        Employee employee = new Employee();
        UserDao userDao = new UserDaoImpl();
        User user = new User("Name","Surname",employee);
        assertEquals("testCreate",null,userDao.create(null));
        assertNotEquals("testCreate",null , userDao.create(user));

    }
}
