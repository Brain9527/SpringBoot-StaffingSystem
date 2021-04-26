package com.huang.controller;

import com.huang.dao.DepartmentMapper;
import com.huang.dao.EmployeeMapper;
import com.huang.pojo.Department;
import com.huang.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/emp")
public class EmployeeController {
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    DepartmentMapper departmentMapper;

    /**
     * 遍历所有数据
     *
     * @param model 视图模型
     */
    @RequestMapping("/")
    public String list(Model model) {
        List<Employee> employees = employeeMapper.selectList(null);
        List<Department> departments = departmentMapper.selectList(null);

        HashMap<Integer, String> departmentsMap = new HashMap<>();
        for (Department department : departments) {
            departmentsMap.put(department.getId(), department.getDepartmentName());
        }

        model.addAttribute("emps", employees);
        model.addAttribute("departmentsMap", departmentsMap);

        return "emp/list";

//        Model->Dao 模型/数据
//        View       视图层
//        Controller 控制器层
    }

    /**
     * 添加员工页面
     *
     * @param model 视图模式
     */
    @GetMapping("/add")
    public String add(Model model) {
        List<Department> departments = departmentMapper.selectList(null);
        model.addAttribute("Departments", departments);
        return "emp/add";
    }

    /**
     * 增加员工接口
     *
     * @param employee 员工实体
     */
    @PostMapping("/add")
    public String doAdd(Employee employee) {
        employeeMapper.insert(employee);
        return "redirect:/emp/";
    }

    /**
     * 更改员工页面
     *
     * @param model 视图模式
     * @param id    要修改的员工ID
     */
    @GetMapping("/{id}")
    public String update(Model model, @PathVariable("id") int id) {
        Employee employee = employeeMapper.selectById(id);
        model.addAttribute("emp", employee);

        List<Department> departments = departmentMapper.selectList(null);
        model.addAttribute("depts", departments);
        return "emp/update";
    }

    /**
     * 更改员工接口
     *
     * @param employee 员工实体
     */
    @PostMapping("/{id}")
    public String doUpdate(Employee employee) {
        employeeMapper.updateById(employee);
        return "redirect:/emp/";
    }

    /**
     * 删除员工
     *
     * @param id 要删除的员工ID
     */
    @GetMapping("/delete/{id}")
    public String del(@PathVariable("id") int id) {
        int i = employeeMapper.deleteById(id);
        return "redirect:/emp/";
    }
}
