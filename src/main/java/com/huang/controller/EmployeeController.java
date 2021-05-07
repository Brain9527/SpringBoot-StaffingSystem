package com.huang.controller;

import com.huang.dao.DepartmentsMapper;
import com.huang.dao.EmployeesMapper;
import com.huang.pojo.Departments;
import com.huang.pojo.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    EmployeesMapper employeesMapper;
    @Autowired
    DepartmentsMapper departmentsMapper;

    /**
     * 遍历所有数据
     *
     * @param model 视图模型
     */
    @RequestMapping("/emps")
    public String list(Model model) {
        List<Employees> employees = employeesMapper.selectList(null);
        List<Departments> departments = departmentsMapper.selectList(null);

        HashMap<Integer, String> departmentsMap = new HashMap<>();
        for (Departments department : departments) {
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
    @GetMapping("/emp")
    public String add(Model model) {
        List<Departments> departments = departmentsMapper.selectList(null);
        model.addAttribute("Departments", departments);
        return "emp/add";
    }

    /**
     * 增加员工接口
     *
     * @param employees 员工实体
     */
    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    public String doAdd(Employees employees) {
        employeesMapper.insert(employees);
        return "redirect:/emps";
    }

    /**
     * @param model 视图模型
     * @param id    员工ID
     */
    @GetMapping("/emp/{id}")
    public String update(Model model, @PathVariable("id") int id) {
        Employees employees = employeesMapper.selectById(id);
        if (employees == null) {
            return "redirect:/emps";
        } else {
            model.addAttribute("emp", employees);
            List<Departments> departments = departmentsMapper.selectList(null);
            model.addAttribute("depts", departments);
            return "emp/update";
        }
    }

    /**
     * 更改员工接口
     *
     * @param employees 员工实体
     */
    @PostMapping("/updateEmp")
    public String doUpdate(Employees employees) {
        employeesMapper.updateById(employees);
        return "redirect:/emps";
    }

    /**
     * 删除员工
     *
     * @param id 要删除的员工ID
     */
    @GetMapping("/delemp/{id}")
    public String del(@PathVariable("id") int id) {
        int i = employeesMapper.deleteById(id);
        return "redirect:/emps";
    }
}
