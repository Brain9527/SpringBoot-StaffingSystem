package com.huang

import com.huang.dao.ConsumerMapper
import com.huang.dao.DepartmentMapper
import com.huang.dao.EmployeeMapper
import com.huang.pojo.Department
import com.huang.pojo.Employee
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class SpringBootStaffingSystemApplicationTests {
    @Autowired
    private lateinit var departmentMapper: DepartmentMapper

    @Autowired
    private lateinit var employeeMapper: EmployeeMapper

    @Autowired
    private lateinit var consumerMapper: ConsumerMapper

    //遍历所有部门数据
    @Test
    fun selectDepartments() {
        val departments = departmentMapper.selectList(null)
        departments.forEach(::println)
    }

    //遍历所有人员数据
    @Test
    fun selectEmployees() {
        val employees = employeeMapper.selectList(null)
        employees.forEach(::println)
    }

    //查看所有用户
    @Test
    fun selectConsumers() {
        val consumers = consumerMapper.selectList(null)
        consumers.forEach(::println)
    }

    //增加部门数据
    @Test
    fun addDepartment() {
        val department = Department(101, "人才部")
        departmentMapper.insert(department)
    }

    //增加人员数据
    @Test
    fun addEmployee() {
        val employee = Employee(104, "小七", "12123131@qq.com", 1, 0)
        employeeMapper.insert(employee)
    }

    //添加用户
    @Test
    fun addConsumer() {
        val consumer = com.huang.pojo.Consumer(5, "aadd", "admin")
        consumerMapper.insert(consumer)
    }

    //根据部门id删除部门数据
    @Test
    fun deleteDepartment() {
        departmentMapper.deleteById(106)
        println("删除成功")
    }

    //根据id删除人员数据
    @Test
    fun deleteEmployee() {
        val i = employeeMapper.deleteById(127)
        println("删除成功")
    }

    //根据id删除用户数据
    @Test
    fun deleteConsumer() {
        val i = consumerMapper.deleteById(1)
        println("删除成功")
    }

    //修改部门数据
    @Test
    fun updateDepartment() {
        val department = Department(105, "人才部")
        departmentMapper.updateById(department)
    }

    //修改人员数据
    @Test
    fun updateEmployee() {
        val employee = Employee(101, "小非", "12222222@qq.com", 1, 0)
        val result = employeeMapper.updateById(employee)
        println("employees:$result")
    }

    //根据id修改用户数据
    @Test
    fun updateConsumer() {
        val consumer = com.huang.pojo.Consumer(2, "adminadmin", "12345")
        consumerMapper.updateById(consumer)
        val consumers = consumerMapper.selectList(null)
        consumers.forEach(::println)
    }

    //根据部门id查询部门数据
    @Test
    fun getDepartment() {
        val department = departmentMapper.selectById(101)
        if (department == null) {
            println("未查询到此id的部门信息")
        } else {
            println(department)
        }
    }

    //根据人员id查询人员数据
    @Test
    fun getEmployee() {
        val employee = employeeMapper.selectById(104)
        if (employee == null) {
            println("未查询到此id的人员数据")
        } else {
            println(employee)
        }
    }

    //根据人员id查询用户数据
    @Test
    fun getConsumer() {
        val consumer = consumerMapper.selectById(2)
        if (consumer == null) {
            println("未查询到此id的人员数据")
        } else {
            println(consumer)
        }
    }
}