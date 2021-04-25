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

    //遍历所有数据
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


    //  添加员工页面
    @GetMapping("/emp")
    public String toAddpages(Model model) {
        List<Departments> departments = departmentsMapper.selectList(null);
        model.addAttribute("Departments", departments);
        return "emp/add";
    }

    //增加员工接口
    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    public String save(Employees employees) {
        employeesMapper.insert(employees);
        return "redirect:/emps";
    }

    //更改员工
    @GetMapping("/emp/{id}")
    public String toupdateEmp(Model model, @PathVariable("id") int id) {
        Employees employees = employeesMapper.selectById(id);
        model.addAttribute("emp", employees);

        List<Departments> departments = departmentsMapper.selectList(null);
        model.addAttribute("depts", departments);
        return "emp/update";
    }

    //更改员工接口
    @PostMapping("/updateEmp")
    public String updateEmp(Employees employees) {
        employeesMapper.updateById(employees);
        return "redirect:/emps";
    }

    //删除员工
    @GetMapping("/delemp/{id}")
    public String DeleteEmployees(@PathVariable("id") int id) {
        int i = employeesMapper.deleteById(id);
        return "redirect:/emps";
    }
}
