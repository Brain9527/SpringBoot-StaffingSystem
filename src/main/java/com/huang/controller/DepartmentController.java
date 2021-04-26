package com.huang.controller;

import com.baomidou.mybatisplus.core.injector.methods.DeleteById;
import com.baomidou.mybatisplus.core.injector.methods.Update;
import com.huang.dao.DepartmentsMapper;
import com.huang.dao.EmployeesMapper;
import com.huang.pojo.Departments;
import com.huang.pojo.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@Controller
public class DepartmentController {

    @Autowired
    DepartmentsMapper departmentsMapper;


    //遍历部门
    @RequestMapping("/depts")
    public String list(Model model){
        List<Departments> departments = departmentsMapper.selectList(null);
        model.addAttribute("departments",departments);
        return "dept/list";
    }

    //删除部门
    @RequestMapping("/deldept/{id}")
    public String del(@PathVariable("id") int id){
        departmentsMapper.deleteById(id);
        return "redirect:/depts";
    }

    //添加部门
    @GetMapping("/add")
    public String add(Model model){
        return "dept/add";
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String save2(Departments departments){
        departmentsMapper.insert(departments);
        return "redirect:/depts";
    }

    @GetMapping("/dept/{id}")
    public String toupdateDept(Model model, @PathVariable("id") int id) {
        Departments departments = departmentsMapper.selectById(id);
        model.addAttribute("dept", departments);
        departmentsMapper.updateById(departments);

        return "dept/update";
    }

    @PostMapping("/updateDept")
    public String toupdateDept(Departments departments){

        departmentsMapper.updateById(departments);
        return "redirect:/depts";


    }


}
