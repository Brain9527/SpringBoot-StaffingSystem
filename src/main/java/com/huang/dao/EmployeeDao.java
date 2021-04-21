package com.huang.dao;

import com.huang.pojo.Department;
import com.huang.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//员工dao
@Repository
public class EmployeeDao {

    //模拟数据库
    public static Map<Integer, Employee> employees = null;
    //    主键自增
    private static Integer initId = 106;

    static {
        employees = new HashMap<Integer, Employee>(); //创建一个部门表

        employees.put(101, new Employee(101, "小明", "123456789@qq.com", 0, new Department(101, "教学部")));
        employees.put(102, new Employee(102, "小红", "456722289@qq.com", 1, new Department(102, "市场部")));
        employees.put(103, new Employee(103, "小李", "562711189@qq.com", 0, new Department(103, "教研部")));
        employees.put(104, new Employee(104, "小黑", "345622789@qq.com", 0, new Department(104, "运营部")));
        employees.put(105, new Employee(105, "小六", "156711189@qq.com", 1, new Department(105, "后勤部")));
    }

    //员工有所属的部门
    @Autowired
    private DepartmentDao departmentDao;

    //增加一个员工
    public void save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);

    }

    //查询全部员工信息
    public Collection<Employee> getAll() {
        return employees.values();
    }

    //通过id查询员工
    public Employee getEmployeeById(Integer id) {
        return employees.get(id);
    }

    //通过ID删除员工
    public void delete(Integer id) {
        employees.remove(id);
    }

}
