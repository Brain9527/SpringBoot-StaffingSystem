package com.huang;

import com.huang.dao.ConsumerMapper;
import com.huang.dao.DepartmentsMapper;
import com.huang.dao.EmployeesMapper;
import com.huang.pojo.Consumer;
import com.huang.pojo.Departments;
import com.huang.pojo.Employees;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class SpringBootStaffingSystemApplicationTests {
    @Autowired
    private DepartmentsMapper departmentsMapper;
    @Autowired
    private EmployeesMapper employeesMapper;
    @Autowired
    private ConsumerMapper consumerMapper;


    //遍历所有部门数据
    @Test
    public void contextLoads() {
        List<Departments> departments = departmentsMapper.selectList(null);
        departments.forEach(System.out::println);

    }

    //遍历所有人员数据
    @Test
    public void TraverseInformation() {
        List<Employees> employees = employeesMapper.selectList(null);
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
        Departments departments = new Departments();
        departments.setId(101);
        departments.setDepartmentName("人才部");
        departmentsMapper.insert(departments);
    }


    //增加人员数据
    @Test
    public void AddEmployees() {
        Employees employees = new Employees();
        employees.setId(104);
        employees.setStaffName("小七");
        employees.setEmail("12123131@qq.com");
        employees.setGender(1);
        employeesMapper.insert(employees);
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
        int i = departmentsMapper.deleteById(106);
        System.out.println("删除成功");
    }

    //根据id删除人员数据
    @Test
    public void DeleteEmployees() {
        int i = employeesMapper.deleteById(127);
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
        Departments departments = new Departments();
        departments.setId(105);
        departments.setDepartmentName("人才部");
        departmentsMapper.updateById(departments);
    }

    //修改人员数据
    @Test
    public void UpdateEmployees() {
        Employees employees = new Employees();
        employees.setId(101);
        employees.setStaffName("小非");
        employees.setEmail("12222222@qq.com");
        employees.setGender(1);
        Integer result = employeesMapper.updateById(employees);
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
        Departments departments = departmentsMapper.selectById(101);
        if (departments == null) {
            System.out.println("未查询到此id的部门信息");
        } else {
            System.out.println(departments);

        }
    }

    //根据人员id查询人员数据
    @Test
    public void selectEmployees() {
        Employees employees = employeesMapper.selectById(104);
        if (employees == null) {
            System.out.println("未查询到此id的人员数据");
        } else {
            System.out.println(employees);
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
