//package dao;
//
//import entity.Employee;
//import org.junit.Assert;
//import org.junit.Test;
//
///**
// * Created by Yura on 12.02.2017.
// */
//public class EmployeeDaoImplTest extends Assert
//{
//    //
//    @Test
//    public void testCreate()
//    {
//        EmployeeDao employeeDao = new EmployeeDaoImpl();
//        Employee employee = new Employee();
//        assertEquals("testCreate",null,employeeDao.create(null));
//        assertNotEquals("testCreate",null,employeeDao.create(employee));
//    }
//
//   @Test
//   public void testRead()
//   {
//       EmployeeDao employeeDao = new EmployeeDaoImpl();
//       assertEquals("testRead",null,employeeDao.read(null));
//       assertNotEquals("testRead",null,employeeDao.read(1L));
//   }
//   @Test
//    public void testUpdate()
//   {
//       EmployeeDao employeeDao = new EmployeeDaoImpl();
//       Employee employee = new Employee("Name","Surname",20,"Men","Eng");
//       employeeDao.create(employee);
//
//       assertEquals("testUpdate",false,employeeDao.update(null));
//       assertNotEquals("testRead",true,employeeDao.update(null));
//       assertEquals("testUpdate",true,employeeDao.update(employee));
//   }
//
//   @Test
//    public void deleteTest()
//   {
//       EmployeeDao employeeDao = new EmployeeDaoImpl();
//       Employee employee = new Employee("Name1","Surname1",20,"Men","Eng");
//       employeeDao.create(employee);
//
//       assertEquals("testDelete",false, employeeDao.delete(null));
//       assertNotEquals("testDelete",true,employeeDao.delete(null));
//
//
//   }
//
//}
