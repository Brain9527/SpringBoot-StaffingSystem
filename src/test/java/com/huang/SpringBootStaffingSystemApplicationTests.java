package com.huang;

import com.huang.dao.ConsumerMapper;
import com.huang.dao.DepartmentMapper;
import com.huang.dao.EmployeeMapper;
import com.huang.pojo.Consumer;
import com.huang.pojo.Department;
import com.huang.pojo.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class SpringBootStaffingSystemApplicationTests {
    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private ConsumerMapper consumerMapper;


    //遍历所有部门数据
    @Test
    public void contextLoads() {
        List<Department> departments = departmentMapper.selectList(null);
        departments.forEach(System.out::println);

    }

    //遍历所有人员数据
    @Test
    public void TraverseInformation() {
        List<Employee> employees = employeeMapper.selectList(null);
        employees.forEach(System.out::println);
    }

    //查看所有用户
    @Test
    public void SelectConsumer(){
        List<Consumer> consumers = consumerMapper.selectList(null);
        consumers.forEach(System.out::println);
    }




    //增加部门数据
    @Test
    public void AddDepartments() {
        Department department = new Department();
        department.setId(101);
        department.setDepartmentName("人才部");
        departmentMapper.insert(department);
    }


    //增加人员数据
    @Test
    public void AddEmployees() {
        Employee employee = new Employee();
        employee.setId(104);
        employee.setStaffName("小七");
        employee.setEmail("12123131@qq.com");
        employee.setGender(1);
        employeeMapper.insert(employee);
    }

    //添加用户
    @Test
    public void AddEEEE(){
        Consumer consumer = new Consumer();
        consumer.setUserid(5);
        consumer.setUsername("aadd");
        consumer.setPassword("admin");
        consumerMapper.insert(consumer);
    }

    //根据部门id删除部门数据
    @Test
    public void DeleteDepartments() {
        int i = departmentMapper.deleteById(106);
        System.out.println("删除成功");
    }

    //根据id删除人员数据
    @Test
    public void DeleteEmployees() {
        int i = employeeMapper.deleteById(127);
        System.out.println("删除成功");
    }
    //根据id删除用户数据
    @Test
    public void DeleteUser(){
        int i = consumerMapper.deleteById(1);
        System.out.println("删除成功");

    }


    //修改部门数据
    @Test
    public void UpdateDepartments() {
        Department department = new Department();
        department.setId(105);
        department.setDepartmentName("人才部");
        departmentMapper.updateById(department);
    }

    //修改人员数据
    @Test
    public void UpdateEmployees() {
        Employee employee = new Employee();
        employee.setId(101);
        employee.setStaffName("小非");
        employee.setEmail("12222222@qq.com");
        employee.setGender(1);
        Integer result = employeeMapper.updateById(employee);
        System.out.println("employees:" + result);
    }

    //根据id修改用户数据
    @Test
    public void UpdateConsumer(){
        Consumer consumer = new Consumer();
        consumer.setUserid(2);
        consumer.setUsername("adminadmin");
        consumer.setPassword("12345");
        consumerMapper.updateById(consumer);

        List<Consumer> consumers = consumerMapper.selectList(null);
        consumers.forEach(System.out::println);
    }


    //根据部门id查询部门数据
    @Test
    public void SelectDepartments() {
        Department department = departmentMapper.selectById(101);
        if (department == null) {
            System.out.println("未查询到此id的部门信息");
        } else {
            System.out.println(department);

        }
    }

    //根据人员id查询人员数据
    @Test
    public void selectEmployees() {
        Employee employee = employeeMapper.selectById(104);
        if (employee == null) {
            System.out.println("未查询到此id的人员数据");
        } else {
            System.out.println(employee);
        }
    }

    //根据人员id查询用户数据
    @Test
    public void selectConsumer(){
        Consumer consumer = consumerMapper.selectById(2);
        if (consumer == null){
            System.out.println("未查询到此id的人员数据");
        } else {
            System.out.println(consumer);
        }
    }



}
